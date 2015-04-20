package com.zhf;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.concurrent.*;


/**
 * Hello world!
 */
public class App implements Runnable {
    private final String url;
    private final int index;

    public App(String url, int index) {
        this.url = url;
        this.index = index;
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            System.err.println("Usage:java -jar xx.jar file_input_path url_column_index size_of_threads");
        }
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(100);
        int nThreads = Integer.parseInt(args[2]);
        // NOTE: you want the min and max thread numbers here to be the same value
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, queue);
        // we need our RejectedExecutionHandler to block if the queue is full
        threadPool.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                try {
                    // this will block the producer until there's room in the queue
                    executor.getQueue().put(r);
                } catch (InterruptedException e) {
                    throw new RejectedExecutionException("Unexpected InterruptedException", e);
                }
            }
        });

        // now read in the urls
        LineIterator it = FileUtils.lineIterator(new File(args[0]));
        while (it.hasNext()) {
            String line = it.nextLine();
            // submit them to the thread-pool.  this may block.
            threadPool.submit(new App(line, Integer.parseInt(args[1])));
        }
        // after we submit we have to shutdown the pool
        threadPool.shutdown();
        // wait for them to complete
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

    public static String getMetaTag(Document document, String attr) {
        Elements elements = document.select("meta[name=" + attr + "]");
        for (Element element : elements) {
            String s = element.attr("content");
            if (s != null) return s;
        }
        elements = document.select("meta[property=" + attr + "]");
        for (Element element : elements) {
            String s = element.attr("content");
            if (s != null) return s;
        }
        return null;
    }

    public void run() {
        int errorcode = 0;
        Document doc = null;
        try {
            String real_url = url.split("\t")[index];
            if (!real_url.startsWith("http"))
                real_url = "http://" + real_url;
            doc = Jsoup.connect(real_url)
                    .timeout(50000)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 "
                            + "(KHTML, like Gecko) Chrome/34.0.1847.131 Safari/537.36")
                    .get();
        } catch (Exception e) {
        } finally {
            if (errorcode != 1) {
                String title = doc.getElementsByTag("title").text();
                String description = getMetaTag(doc, "description");
                System.out.println(url + "\t" + title + "\t" + description);
            }
        }
    }
}
