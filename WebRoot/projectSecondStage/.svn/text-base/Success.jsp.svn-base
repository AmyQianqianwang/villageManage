<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div
		style="background-color: #FFCFCD; height: 84px; line-height: 84px; border: 1px solid #CC7777; padding: 15px 0 15px 15px;">
		<div style="float: left; margin-left: 25px; line-height: 64px;">
			<img style="float:left; line-height: 64px;" src="${basePath }images/system/error.png" border="0" width="64px" height="64px" />
			<span>操作成功，您可以</span>
			<a href="javascript:;" onclick="javascript:history.go(-1);" title="返回">
				<span style="font-size: 25px;">返回上一页</span>
			</a>
			<span>或</span>
			<a href="${basePath }index.jsp" title="回主页">
				<span style="font-size: 25px;">回主页</span>
			</a>
			<a herf="${basePath }projectSecondStage/index.jsp" title="">
				<span style="font-size: 25px;">回项目实施与监查首页</span>
			</a>
		</div>
	</div>
</body>
</html>
