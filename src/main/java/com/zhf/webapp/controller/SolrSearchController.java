package com.zhf.webapp.controller;

import com.zhf.webapp.model.SiteSearch;
import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by zhaohf on 2015/5/10.
 */
@Controller
@RequestMapping(value = "site")
public class SolrSearchController {
    private final Logger logger = LoggerFactory.getLogger(SolrSearchController.class);

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String searchSites(Model model,
                              @RequestParam(value = "keyword", required = false) String keyword,
                              @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer offset,
                              @RequestParam(value = "numPerPage", required = false,  defaultValue = "10") Integer maxResults) throws Exception{
        if (StringUtils.isBlank(keyword))
            return "/site/site-search";
        HttpSolrServer server = getServer();
        SolrQuery query = new SolrQuery();
        logger.info("搜索关键词是:" + keyword);
        query.setQuery("sitetitle:" + keyword);
        query.set("wt", "json");
        query.setStart(offset);
        query.setRows(maxResults);
        query.addSort("count", SolrQuery.ORDER.desc);
        QueryResponse response = server.query(query);

        model.addAttribute("qTime", response.getQTime()*0.001);
        model.addAttribute("numFound",response.getResults().getNumFound());

        List<SiteSearch> sites = response.getBeans(SiteSearch.class);
        Pageable pageable = new PageRequest(offset, maxResults);
        Page page = new PageImpl(sites, pageable, response.getResults().getNumFound());
        model.addAttribute("page", page);
       return "/site/site-search";
    }

    public HttpSolrServer getServer(){
        String url = "http://192.168.177.131:8080/solr/collection1";
        HttpSolrServer server = new HttpSolrServer(url);
        server.setSoTimeout(3000);
        server.setConnectionTimeout(1000);
        server.setDefaultMaxConnectionsPerHost(1000);
        server.setMaxTotalConnections(10);
        server.setFollowRedirects(false);
        server.setAllowCompression(true);
        server.setMaxRetries(1);
        return server;
    }
}
