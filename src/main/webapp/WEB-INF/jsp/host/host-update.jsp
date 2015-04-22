<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div class="container-fluid" style="width:800px; margin:0 auto;">
            <div class="row-fluid">
                <div class="span12">
                    <fieldset>
                        <legend>Add a user</legend>
                        <sf:form method="post" class="form-horizontal" modelAttribute="host">
                            <div class="control-group">
                                <label class="control-label">域名：</label>

                                <div class="controls">
                                    <sf:input path="host"/><sf:errors path="host"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">添加日期：</label>

                                <div class="controls">
                                    <sf:input path="add_date" readonly="true"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">备注：</label>

                                <div class="controls">
                                    <sf:textarea path="message" class="form-control" rows ="2" placeholder="添加说明"/>
                                </div>
                            </div>
                            <div class="form-actions">
                                <input type="submit" class="btn btn-success" value="修改域名"/>
                            </div>
                        </sf:form>
                    </fieldset>
                </div>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>