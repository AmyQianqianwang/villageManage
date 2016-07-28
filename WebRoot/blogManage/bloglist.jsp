<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>访问日志</title>
    <%@ include file="/common/common.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath }css/projectform.css" />
    <script type="text/javascript" src="${basePath }js/projectforms.js"></script>
  </head>
  
  <body>
	<jsp:include page="/common/header.jsp" />
	<div class="mainTable">
	
		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>访问日志&gt; 日志列表</span>
			</div>
		</div>
		
		<div class="forSN">
			<div class="inforSN">
				<form action="${basePath }blog.action" method="post">
					<label class="tipText">关键字：</label>
					<input type="text" name="keyword" class="forSearchText" />
					<input type="submit" class="forSearch" value="查询" />
				</form>
			</div><!-- end inforSN -->
		</div><!-- end forSN -->
		
		<div class="forTableSC" id="fss">
		
			<table id="userTable" align="center">
				<tr style="background: #ddd; height: 25px;">
					<td>序号</td>
					<td>用户</td>
					<td>操作</td>
					<td>时间</td>
				</tr>
				<c:if test="${empty itemList}">
					<tr>
						<td colspan="4">暂无数据</td>
					</tr>
				</c:if>
				<c:if test="${!empty itemList}">
					<c:forEach items="${itemList}" var="blog" varStatus="s">
						<tr class="dataTable">
							<td>${(nowPage-1)*(intPageSize)+s.count}</td>
							<td>${blog.user.userName }</td>
							<td>${blog.opName }</td>
							<td><fmt:formatDate value="${blog.opTime }" pattern="HH:mm  yyyy/MM/dd" /></td>
						</tr>
					</c:forEach>
				</c:if>
				<tr class="dataTableFoot">
					<td height="25" colspan="4">
						<form id="PageForm" action="${basePath}blog.action" method="post">
							<input type="hidden" name="jumpPage" id="jumpPage"
								value="${nowPage}" /> <input type="hidden" name="keyword"
								value="${keyword}" />
						</form> 共有[${intRowCount}]条消息，共[${intPageCount}]页，[${intPageSize
						}条/页]，当前第[${nowPage}]页 &nbsp; <a href="javascript:gotoPage('1')">首页</a>&nbsp;
						<c:if test="${nowPage > 1}">
							<a HREF="javascript:gotoPage('${nowPage - 1}')">上一页</a>
						</c:if> <span id="jumpPageSpan"></span>&nbsp; <c:if
							test="${nowPage < intPageCount}">
							<a HREF="javascript:gotoPage('${nowPage + 1}')">下一页</a>&nbsp;
						</c:if> <a HREF="javascript:gotoPage('${intPageCount}')">尾页</a>&nbsp; 转到 <SELECT
						id="selectPage" onchange="gotoPage(this.value);">
							<c:forEach begin="1" end="${intPageCount}" var="j">
								<c:if test="${j==nowPage}">
									<option value="${j}" selected="selected">${j}</option>
								</c:if>
								<c:if test="${j!=nowPage}">
									<option value="${j}">${j}</option>
								</c:if>
							</c:forEach>
					</SELECT> 页</td>
				</tr>
			</table>
		</div><!-- end forTableSC -->
		
	</div><!-- end mianTable -->
	<jsp:include page="/common/footer.jsp" />
	<script type="text/javascript" src="${basePath }js/tool.js"></script>
	<script>
		function deleteproject(id){
			if(confirm('确定取消吗？')){
				window.location.href='${basePath }'+"projectc_cancel.action?id=" + id;
			}
		}
	</script>
</body>
</html>