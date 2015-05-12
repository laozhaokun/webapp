#spider
* 用于爬网站域名的信息，需要给定一个文件作为输入，文件中有一列需要是网址。
* 这里爬的信息包括：标题和描述。
* 爬到的结果用于加入solr索引，以便执行搜索。
***
## 打包:
mvn package
## Usage:
java -jar xx.jar file_input_path url_column_index size_of_threads