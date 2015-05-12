<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/mytaglib.tld" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div class="container">
            <div class="input-append">
                <form method="get" id="form-horizontalId" class="form-horizontal"
                      action="http://localhost:8080/webapp/site/search">
                    <input type="hidden" name="pageNum" value="${page.number+1}"/>
                    <input type="hidden" name="numPerPage" value="${page.size}"/>

                    <p class="text-info">网站搜索引擎,仅提供域名首页的搜索，不提供站内具体页面的搜索，按照域名的访问量降序排序。</p>
                    <center>
                        <input type="text" name="keyword" value="${param.keyword}" placeholder="请输入关键词"
                               style="width: 250px;height: 35px;"/>
                        <input type="submit" class="btn btn-success" value="Search">
                    </center>
                </form>
            </div>
            <c:if test="${not empty page}">
                <div>
                    <p class="text-left">共找到${numFound}条,耗时${qTime}秒.</p>
                    <dl>
                    <c:forEach items="${page.content}" var="site" varStatus="status">
                        <dt class="text-success"><a href="http://${site.url}" target="_blank">${site.sitetitle}</a> </dt>
                        <dd class="text-info"><a href="http://${site.url}" target="_blank">${site.url}</a></dd>
                        <c:if test="${site.sitedesc != 'null'}"><dd>${site.sitedesc}</dd></c:if>
                        <br>
                    </c:forEach>
                        </dl>
                    <center><tags:pageable page="${page}" form="form-horizontalId"/></center>
                </div>
            </c:if>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>