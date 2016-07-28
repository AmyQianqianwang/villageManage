<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>项目管理</title>
    <%@ include file="/common/common.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath }css/projectform.css" />
  </head>
  
  <body>
   <jsp:include page="/common/header.jsp" />
	<div class="mainTable">
	
		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>项目管理 &gt; 项目实施与监查</span>
			</div>
		</div>
		
		<div class="formCol">
			<div class="grid_left">
				<a href="${basePath }implement_getList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">实施阶段项目列表</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid">
				<a href="${basePath }implement_getJCList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">竞岗类项目列表</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid">
				<a href="${basePath }implement_getDEList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">直接实施类项目列表</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid_right">
				<a href="${basePath }implement_getCSList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">比选类项目列表</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid_left">
				<a href="${basePath }implement_getSBList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">自建类项目列表</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid">
				<a href="${basePath }check_getPSList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">进度监督检查情况列表</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid">
				<a href="${basePath }check_getFSList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">资金监督检查情况列表</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div><!-- end forSN -->
		</div>
	</div><!-- end mianTable -->
	<jsp:include page="/common/footer.jsp" />
  </body>
</html>
