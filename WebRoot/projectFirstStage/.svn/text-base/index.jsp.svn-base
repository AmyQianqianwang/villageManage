<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
				<span>项目管理 &gt; 管理菜单</span>
			</div>
		</div>
		
		<div class="formCol">
			<div class="grid_left">
				<a href="${basePath }project_projectInfoList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">原始项目登记情况</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid">
				<a href="${basePath }firstvote_firstVoteInfoList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">原始项目表决情况</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid">
				<a href="${basePath }fundsbuget_fundsBugetInfoList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">初选项目实施计划及资金预算情况</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid_right">
				<a href="${basePath }edition_completeEditionList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">初选项目议事会修改完善情况</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid_left">
				<a href="${basePath }firstvote_SecondMeltVoteInfoList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">初选融资项目表决情况</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid">
				<a href="${basePath }firstvote_SecondVoteInfoList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">初选非融资项目表决情况</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid">
				<a href="${basePath }reportCheck_CountyCheckInfoList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">初选项目区（市）县申报情况</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			<div class="grid_right">
				<a href="${basePath }reportCheck_CompanyCheckInfoList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">初选项目市小城投公司初审情况</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
				<div class="grid_left">
				<a href="${basePath }reportCheck_CityCheckInfoList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">初选项目市级申报情况</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			
			
			<div class="grid">
				<a href="${basePath }projectSecondStage/index.jsp" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">项目实施与监察</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div><!-- end forSN -->
			
			<div class="grid">
				<a href="${basePath}comment_list.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">项目评议（公共服务类）</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			
			<div class="grid_right">
				<a href="${basePath}accept_list.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">项目验收（基础建设类）</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
			
			<div class="grid_left">
				<a href="${basePath}testEva_list.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">项目评测</div>
					<span class="caption fade-caption">
						<h3></h3>
						<p></p>
					</span>
				</div>
				</a>
			</div>
		</div>
	</div><!-- end mianTable -->
	<jsp:include page="/common/footer.jsp" />
  </body>
</html>
