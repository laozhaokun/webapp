<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sf" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/mytaglib.tld" %>
<tiles:insertDefinition name="defaultTemplate">
  <tiles:putAttribute name="body">
    <div class="container">
      <p class="text-info">手机使用量排行榜，日期暂为20150417，按照ad,ip,ua,cookie 进行group by。</p>
    <div class="chart-content">
      <div id="phone-chart" style="width:800px; margin:0 auto;"></div>
      </div>
    </div>
    <script>
      $(document).ready(function(){
        $('#spinner').show();
        var url = "http://localhost:8080/webapp/api5?day=20150417";
        d3.json(url,function(dataset){
          if(dataset.length == 0){
            $("#phone-chart").html("<center><h2>手机品牌使用情况无数据！</h2></center>");
          } else{
            $("#phone-chart").html("<center><h2>手机品牌使用情况排行榜单：</h2></center>");
          }
          //Width and height
          var w = 800;
          var h = 1800;
          var wx = d3.scale.linear()
                  .domain([0, d3.max(dataset, function (d) {
                    return d.count;
                  })])
                  .range([0, w]);
          //Create SVG element
          var svg = d3.select("#phone-chart")
                  .append("svg")
                  .attr("width", w)
                  .attr("height", h);
          svg.selectAll("rect")
                  .data(dataset)
                  .enter()
                  .append("rect")
                  .attr("x", 25)
                  .attr("y", function (d, i) {
                    return i * 30;
                  })
                  .attr("width", function (d) {
                    return wx(d.count);
                  })
                  .attr("height", 28)
                  .style("fill", "#BF3EFF")
                  .on("mouseover", function (d, i) {
                    d3.select(this).style("fill", "#ADFF2F")
                  })
                  .on("mouseout", function (d, i) {
                    d3.select(this).style("fill", "#BF3EFF")
                  })
          ;
          svg.selectAll("text")
                  .data(dataset)
                  .enter()
                  .append("text")
                  .text(function (d, i) {
                    return i + 1 + "\t" + d.count + "\t" + d.brand;
                  })
                  .attr("x", 10)
                  .attr("y", function (d, i) {
                    return i * 30 + 20;
                  })
                  .style("text-align", "left")
                  .attr("font-size", 16)
                  .style("fill", "#0000FF");
          $("#spinner").hide();
        });
      });
    </script>
    </tiles:putAttribute>
  </tiles:insertDefinition>