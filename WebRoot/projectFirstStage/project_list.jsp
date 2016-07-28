<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>原始项目登记情况</title>
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
				<span>项目管理 &gt; <a style="text-decoration: none;" href="${basePath }projectFirstStage/index.jsp"> 管理菜单</a> &gt; 原始项目登记情况</span>
			</div>
		</div>

		<div class="forSNNN">
			<input type="button" id="button_bar" style="width:100px;" name="button_bar" value="新建" onclick="javascript:window.location.href='${basePath }project_newProjectInfo.action'" />
		</div><!-- end forSN -->

		<div class="forTableSC" id="fss">
		
			<table id="dataTable" align="center">
				<tr>
					<td>序号</td>
					<td>项目名称</td>
					<td>登记时间</td>
					<td>项目类别</td>
					<td>项目种类</td>
					<td>项目来源</td>
					<td>推举时间</td>
					<td>计划完成时间</td>
					<td>实施方法</td>
					<td>项目状态</td>
					<td>操作</td>
				</tr>
				<c:if test="${empty itemList}">
					<tr>
						<td colspan="11">暂无数据</td>
					</tr>
				</c:if>
				<c:if test="${!empty itemList}">
				<form name="projectList"  action="${basePath }project_showProjectInfo.action" method="post">
						<c:forEach items="${itemList}" var="project" varStatus="s">
						<tr>
							<td>${(nowPage-1)*(intPageSize)+s.count}</td>
							<td>${project.proName}</td>
							<td> <fmt:formatDate value="${project.recTime }" pattern="yyyy年MM月dd日" /></td>
							<td>${project.proType }</td>
							<td>${project.proKind }</td>
							<td>${project.proSource }</td>
							<td><fmt:formatDate value="${project.electTime }" pattern="yyyy年MM月dd日" /></td>
							<td><fmt:formatDate value="${project.planEndTime }" pattern="yyyy年MM月dd日" /></td>
							<td>${project.impleMethod }</td>
							<td id="st_${(nowPage-1)*(intPageSize)+s.count}"><script>getProjectStatusByID(${project.proStatus }, ${(nowPage-1)*(intPageSize)+s.count});</script></td>
							<td>
							<!-- <a href="${basePath }project_insertProjectInfo.action"text-decoration: none;">修改</a> -->
							<input type="submit" value="编辑" name="btnSubmit">
							<input type="hidden" name="proID" value="${project.proId}"/>
							</td>
						</tr>
					</c:forEach>
				</form>
				
				</c:if>
				
				<tr class="dataTableFoot">
					<td height="25" colspan="11">
						<form id="PageForm" action="${basePath}projectforms_projectVoteInfoList.action" method="post">
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
  </body>
</html>
