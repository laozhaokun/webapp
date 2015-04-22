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
            <div class="input-append">
                <form method="get" class="form-horizontal">
                    <p class="text-info">网站流量来源、去向搜索(不包括直接访问)，日期暂为20150417，默认最多取15个关联网址。</p>
                    <center>
                            <%--<input type="text" placeholder="日期格式:YYYYMMDD" style="width: 100px;height:30px;"/>--%>
                        <input type="text" id="url_value" placeholder="请输入域名或IP" style="width: 250px;height: 35px;"/>
                        <input type="button" class="btn btn-success" id="search" value="Search">
                    </center>
                </form>
            </div>
            <div class="chart-content">
                <div class="search-bar-chart" id="search-bar-chart-from" style="float: left">
                </div>
                <div class="search-bar-chart" id="search-bar-chart-to" style="float: right">
                </div>
                <div style="clear:both;"></div>
                <hr>
                <div class="search-bar-chart" id="search-bar-chart-kw-count" style="float: left">
                </div>
                <div class="search-bar-chart" id="search-bar-chart-kw-engine" style="float: right">
                </div>
            </div>
            <script>
                var host_pattern = new RegExp("^([a-zA-Z0-9]([a-zA-Z0-9\-]{0,61}[a-zA-Z0-9])?\.)+[a-zA-Z]{2,6}$");
                var ip_pattern = new RegExp("^(2[0-5]{2}|2[0-4][0-9]|1?[0-9]{1,2}).(2[0-5]{2}|2[0-4][0-9]|1?[0-9]{1,2}).(2[0-5]{2}|2[0-4][0-9]|1?[0-9]{1,2}).(2[0-5]{2}|2[0-4][0-9]|1?[0-9]{1,2})$");
                $(document).ready(function () {
                    $("#search").click(function () {
                        var url_value = $.trim($("#url_value").val());
                        if (url_value == "") {
                            alert("域名不能为空！");
                            return false;
                        } else if (!host_pattern.test(url_value) && !ip_pattern.test(url_value)) {
                            alert("域名或IP格式错误！");
                            return false;
                        }
                        $('#spinner').show();
                        var url = "http://localhost:8080/webapp/api?url=" + url_value;
                        var url2 = "http://localhost:8080/webapp/api2?ref=" + url_value;
                        var url3 = "http://localhost:8080/webapp/api3?url=" + url_value;
                        var url4 = "http://localhost:8080/webapp/api4?url=" + url_value;
//                        ref来源
                        d3.json(url, function (dataset) {
                            if (dataset.length == 0) {
                                $("#search-bar-chart-from").html("<center><h2>流量(来源)无数据！</h2></center>");
                            } else {
                                $("#search-bar-chart-from").html("<center><h2>流量(来源)前" + dataset.length + "个网址: </h2></center>");
                            }
                            //Width and height
                            var w = 400;
                            var h = 500;
                            var wx = d3.scale.linear()
                                    .domain([0, d3.max(dataset, function (d) {
                                        return d.count;
                                    })])
                                    .range([0, w]);
                            d3.select("#search-bar-chart-from").select("svg").remove()
                            //Create SVG element
                            var svg = d3.select("#search-bar-chart-from")
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
                                        return i + 1 + "\t" + d.count + "\t" + d.ref;
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
//                                     url去向
                        d3.json(url2, function (dataset) {
                            if (dataset.length == 0) {
                                $("#search-bar-chart-to").html("<center><h2>流量(去向)无数据！</h2></center>");
                            } else {
                                $("#search-bar-chart-to").html("<center><h2>流量(去向)前" + dataset.length + "个网址: </h2></center>");
                            }
                            //Width and height
                            var w = 400;
                            var h = 500;
                            var wx = d3.scale.linear()
                                    .domain([0, d3.max(dataset, function (d) {
                                        return d.count;
                                    })])
                                    .range([0, w]);

                            d3.select("#search-bar-chart-to").select("svg").remove()
                            //Create SVG element
                            var svg = d3.select("#search-bar-chart-to")
                                    .append("svg")
                                    .attr("width", w)
                                    .attr("height", h);
                            svg.selectAll("rect")
                                    .data(dataset)
                                    .enter()
                                    .append("rect")
                                    .attr("x", 10)
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
                                        return i + 1 + "\t" + d.count + "\t" + d.ref;
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
//来源关键词
                        d3.json(url3, function (dataset) {
                            if (dataset.length == 0) {
                                $("#search-bar-chart-kw-count").html("<center><h2>关键词来源无数据！</h2></center>");
                            } else {
                                $("#search-bar-chart-kw-count").html("<center><h2>关键词来源前" + dataset.length + "个: </h2></center>");
                            }
                            //Width and height
                            var w = 400;
                            var h = 500;
                            var wx = d3.scale.linear()
                                    .domain([0, d3.max(dataset, function (d) {
                                        return d.count;
                                    })])
                                    .range([0, w]);

                            d3.select("#search-bar-chart-kw-count").select("svg").remove()
                            //Create SVG element
                            var svg = d3.select("#search-bar-chart-kw-count")
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
                                        return i + 1 + "\t" + d.count + "\t" + d.kw;
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
//搜索引擎来源
                        d3.json(url4, function (dataset) {
                            if (dataset.length == 0) {
                                $("#search-bar-chart-kw-engine").html("<center><h2>搜索引擎来源无数据！</h2></center>");
                            } else {
                                $("#search-bar-chart-kw-engine").html("<center><h2>搜索引擎来源前" + dataset.length + "个: </h2></center>");
                            }
                            //Width and height
                            var w = 400;
                            var h = 500;
                            var wx = d3.scale.linear()
                                    .domain([0, d3.max(dataset, function (d) {
                                        return d.count;
                                    })])
                                    .range([0, w]);

                            d3.select("#search-bar-chart-kw-engine").select("svg").remove()
                            //Create SVG element
                            var svg = d3.select("#search-bar-chart-kw-engine")
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
                                        return i + 1 + "\t" + d.count + "\t" + d.ref;
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
                });

            </script>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>