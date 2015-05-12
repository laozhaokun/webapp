<%--
把下面这行添加到需要分页的页面
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
--%>
<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="form" type="java.lang.String" %>
<%@ attribute name="page" type="org.springframework.data.domain.Page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
<%--
  <input type="hidden" name="pageNum" value="${page.number+1}" />
  <input type="hidden" name="numPerPage" value="${page.size}" />
--%>
function searchForm(formId, pageNum){
  $("input[name=pageNum]", $("#"+formId)).val(pageNum);
  $("#" + formId).submit();
}
</script>
<c:if test="${not empty page && not empty form}">
  <a href="javascript:void(0)" onclick="searchForm('${form}',1)">上一页</a>
  <a href="javascript:void(0)" onclick="searchForm('${form}',2)">下一页</a>
</c:if>