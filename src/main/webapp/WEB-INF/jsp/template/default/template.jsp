<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCHTML html>
<head>
    <title>Default tiles template</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/css/font-awesome.min.css"/> " rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/css/zhf.css"/> " rel="stylesheet" type="text/css"/>
    <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/js/d3.min.js"/>" ></script>
</head>
<body>
<tiles:insertAttribute name="header"/>
<div id="spinner" class="spinner" style="display: none">
    <!--from http://ajaxload.info/-->
    <center><p><img id="img-spinner" src="<c:url value="/resources/image/ajax-loader.gif"/>" alt="Loading"/>正在查询,请稍候...</p></center>
</div>
<tiles:insertAttribute name="body"/>
<tiles:insertAttribute name="footer"/>
</body>
</html>