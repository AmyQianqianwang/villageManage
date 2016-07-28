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
    <title>��Ŀ����</title>
    <%@ include file="/common/common.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath }css/projectform.css" />
  </head>
  
  <body>
   <jsp:include page="/common/header.jsp" />
	<div class="mainTable">
	
		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>��Ŀ���� &gt; ��Ŀʵʩ����</span>
			</div>
		</div>
		
		<div class="formCol">
			<div class="grid_left">
				<a href="${basePath }implement_getList.action" style="overflow: hidden; text-decoration: none;">
				<div class="box">
					<div class="txt">ʵʩ�׶���Ŀ�б�</div>
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
					<div class="txt">��������Ŀ�б�</div>
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
					<div class="txt">ֱ��ʵʩ����Ŀ�б�</div>
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
					<div class="txt">��ѡ����Ŀ�б�</div>
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
					<div class="txt">�Խ�����Ŀ�б�</div>
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
					<div class="txt">���ȼල�������б�</div>
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
					<div class="txt">�ʽ�ල�������б�</div>
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
