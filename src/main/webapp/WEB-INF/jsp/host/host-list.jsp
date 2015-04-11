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
            <a class="btn btn-info" href="<c:url value='host/add'/>">添加域名</a>

            <div class="well">
                <strong>域名列表</strong>
            </div>
            <div class="col-xs-12">
                <table class="table table-striped table-bordered table-hover">
                    <thead class="thin-border-bottom">
                    <th>Index</th>
                    <th>域名</th>
                    <th>标记</th>
                    <th>添加日期</th>
                    <th>删除日期</th>
                    <th>备注</th>
                    <th>编辑</th>
                    <th>删除</th>
                    <th>完全删除</th>
                    </thead>
                    <tbody>
                    <c:forEach items="${hosts}" var="item" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${item.host}</td>
                            <td>${item.flag}</td>
                            <td>${item.add_date}</td>
                            <td>${item.delete_date}</td>
                            <td>${item.message}</td>
                            <td><a href="<c:url value='host/update/${item.id}' />">Edit</a></td>
                            <td><a href="<c:url value='host/delete/${item.id}' />">Delete</a></td>
                            <td><a href="<c:url value='host/delete_real/${item.id}' />">Delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <tag:paginate max="15" offset="${offset}" count="${count}"
                              uri="/webapp/host/hosts" next="&raquo;" previous="&laquo;"/>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
