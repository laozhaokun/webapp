<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--<form method="post">--%>
<%--用户名：<input type="text" name="username"/><br/>--%>
<%--密码：<input type="password" name="password"/><br/>--%>
<%--<input type="submit" value="登录" />--%>
<%--</form>--%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div class="signinboxborder">
            <div class="signinbox">
                <div class="signintitle">
                    <span>请登录</span>
                </div>

                <div class="signformbox">
                    <form method="post">
                        <div class="alert alert-warning" style="display: none" id="error_info">
                            <i class="fa fa-exclamation-circle"></i> <span id="info_text">您输入的用户名或密码错误</span>
                        </div>

                        <div class="input-group input-group-lg"><span class="input-group-addon"><i
                                class="fa fa-user"></i>
                </span>
                            <input type="text" class="form-control" placeholder="请输入用户名" id="inputPhone"
                                   name="username"/>
                        </div>

                        <div class="input-group input-group-lg"><span class="input-group-addon"><i
                                class="fa fa-unlock-alt"></i>
                </span>
                            <input type="password" class="form-control" placeholder="请输入登录密码" id="inputPassword"
                                   name="password" onpaste="return false" onselectstart="return false"/>
                        </div>
                        <div class="input-group input-group-lg">
                            <a type="submit" id="button_login" class="btn btn-lg btn-success" onclick="do_login()"
                               data-loading-text="正在登录">登录系统</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>