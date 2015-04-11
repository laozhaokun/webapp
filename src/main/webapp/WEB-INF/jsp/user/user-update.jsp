<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <sf:form method="post" modelAttribute="user">
            用户名：<sf:input path="username"/><sf:errors path="username"/><br>
            密码：<sf:input path="password"/><sf:errors path="password"/><br>
            <input type="submit" value="修改用户"/>
        </sf:form>
    </tiles:putAttribute>
</tiles:insertDefinition>