<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--<div id="navbar" class="navbar bavbar-default">--%>
<%--<ul class="nav nav-pills">--%>
<%--<li class="active"><a href="#">Home</a></li>--%>
<%--<li><a href="<%=basePath%>user/users">User</a></li>--%>
<%--<li><a href="<%=basePath%>host/hosts">HOST</a></li>--%>
<%--</ul>--%>
<%--</div>--%>

<header class="container">
    <div class="row">
        <div class="toprightbox col-md-5 col-sm-6 pull-right hidden-xs">
            <p class="text-right">
                <a class="btn btn-info" href="<%=basePath%>user/login" target="_blank">登录</a></p>
        </div>
    </div>
</header>
<nav class="navbar  navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1"><span class="sr-only">下拉菜单</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></button>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="<%=basePath%>">首页</a></li>
                <li><a href="<%=basePath%>user/users">用户管理</a></li>
                <li><a href="<%=basePath%>host/hosts">域名管理</a></li>
                <li><a href="<%=basePath%>index">指数</a></li>
            </ul>
        </div>
    </div>
</nav>