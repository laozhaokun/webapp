<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/mytaglib.tld"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div class="container">
            <a class="btn btn-info" href="<c:url value='add'/>">添加用户</a>
            <div class="well">
                <strong>用户列表</strong>
            </div>
            <div class="col-xs-12">
                <table class="table table-striped table-bordered table-hover">
                    <thead class="thin-border-bottom">
                    <th>Index</th>
                    <th>UserName</th>
                    <th>Password</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="user" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${user.username}</td>
                            <td>${user.password}</td>
                            <td><a href="<c:url value='user/update/${user.id}' />">Edit</a></td>
                            <td><a href="<c:url value='user/delete/${user.id}' />">Delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <tag:paginate max="15" offset="${offset}" count="${count}"
                              uri="/webapp/user/users" next="&raquo;" previous="&laquo;"/>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
