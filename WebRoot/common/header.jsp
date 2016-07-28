<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>

	<div class="headerTable">
		<div class="headerTableTop">
			<div class="inheaderTableTop">
				欢迎进入成都市村级公共服务和社会管理项目管理系统...
				&nbsp;&nbsp;&nbsp;&nbsp;
				|&nbsp;&nbsp;&nbsp;&nbsp;
				<c:if test="${empty sessionScope.US }">
					<a href="${basePath }login.jsp" class="tableTop">登录</a>
				</c:if>
				<c:if test="${!empty sessionScope.US }">
					欢迎您：<a href="${basePath }index.action" class="tableTop"> ${sessionScope.US.userName }</a>
					<a href="${basePath }user_Logout.action" class="tableTop">注销</a>
				</c:if>
			</div>			
		</div>
		<div class="headerTableLogo">
			<div class="headerTableLogoImg">
				<a href="${basePath }index.jsp"><img src="${basePath }images/logo.png"/></a>
			</div>
			<div class="headerTableLocation">
				<c:if test="${!empty US }">
				<span>${US.location.cityName }${US.location.countryName }${US.location.townName }${US.location.villageName }</span>
				</c:if>
				<c:if test="${empty US }">
					<span>成都市村级公共服务和社会管理项目管理系统</span>
				</c:if>
			</div>
		</div>
		<div class="headerTableNav">
			<div class="inheaderTableNav">
				<a href="${basePath }index.action" class="everyNav">首页</a>
				<a href="${basePath }projectFirstStage/index.jsp" class="everyNav">项目管理</a>
				<a href="${basePath }projectc_cancelList.action" class="everyNav">项目取消</a>
				<a href="${basePath }record_list.action" class="everyNav">档案管理</a>
				<a href="${basePath }s_search.action" class="everyNav">分类查询</a>
				<a href="${basePath }projectForms/index.jsp" class="everyNav">统计报表</a>
				<a href="${basePath}user_userList.action" class="everyNav">用户管理</a>
				<a href="${basePath}blog.action" class="everyNav">系统日志</a>
			</div>
		</div>
	</div><!-- end header -->