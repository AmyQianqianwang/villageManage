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
    <title>用户列表</title>
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
				<span>用户管理 &gt; 用户列表</span>
			</div>
		</div>
		
		<div class="forSN">
			<div class="inforSN">
				<form action="${basePath }user_userList.action">
					<label class="tipText">关键字：</label>
					<input type="text" name="keyword" class="forSearchText" />
					<input type="submit" class="forSearch" value="查询" />
					<input type="button" class="forAdd" value="新增用户" onclick="javascript:window.location.href='${basePath}user/user_add.jsp'" />
				</form>
			</div><!-- end inforSN -->
		</div><!-- end forSN -->
		
		<div class="forTableSC" id="fss">
		
			<table id="userTable" align="center">
				<tr style="background: #ddd; height: 25px;">
					<td>序号</td>
					<td>用户名</td>
					<td>用户类型</td>
					<td>管理区域</td>
					<td>所在单位</td>
					<td>用户状态</td>
					<td>编辑</td>
					<td>删除</td>
				</tr>
				<c:if test="${empty itemList}">
					<tr>
						<td colspan="7">暂无数据</td>
					</tr>
				</c:if>
				<c:if test="${!empty itemList}">
					<c:forEach items="${itemList}" var="user" varStatus="s">
						<tr class="dataTable">
							<td>${(nowPage-1)*(intPageSize)+s.count}</td>
							<td>${user.userName}</td>
							<td id="stt_${(nowPage-1)*(intPageSize)+s.count }"><script >getUserTypeByID(${user.userType }, ${(nowPage-1)*(intPageSize)+s.count });</script> </td>
							<td>${user.location.countryName }${user.location.townName }${user.location.villageName }</td>
							<td>${user.office }</td>
							<td>
								<c:if test="${user.userState }">
									有效用户
								</c:if>
								<c:if test="${!user.userState }">
									无效用户
								</c:if>
							</td>
							<td><a href="${basePath }user_toEditUser.action?id=${user.userId}">编辑</a></td>
							<td><a href="javascript:deleteuser('${user.userId}');">删除</a></td>
						</tr>
					</c:forEach>
				</c:if>
				<tr class="dataTableFoot">
					<td height="25" colspan="10">
						<form id="PageForm" action="${basePath}user_userList.action" method="post">
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
		function deleteuser(id){
			if(confirm('确定删除吗？')){
				window.location.href='${basePath }'+"user_deleteUser.action?id=" + id;
			}
		}
	</script>
</body>
</html>