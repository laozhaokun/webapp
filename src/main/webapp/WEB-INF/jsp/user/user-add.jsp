<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <fieldset>
                <legend>Add a user</legend>
                <sf:form method="post" class="form-horizontal" modelAttribute="user">
                    <div class="control-group">
                        <label class="control-label">用户名：</label>

                        <div class="controls">
                            <sf:input path="username"/><sf:errors path="username"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">密码：</label>

                        <div class="controls">
                            <sf:input path="password"/><sf:errors path="password"/>
                        </div>
                    </div>
                    <div class="form-actions">
                        <input type="submit" class="btn btn-success" value="添加用户"/>
                    </div>
                </sf:form>
            </fieldset>
        </div>
    </div>
</div>
    </tiles:putAttribute>
</tiles:insertDefinition>