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
    <title>编辑用户</title>
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
				<span>用户管理 &gt;<a href="${basePath }user_userList.action">用户列表</a>&gt;编辑用户</span>
			</div>
		</div>
		
		
		<div class="forTableSC" id="fss" style="background: lavender;">
			<%--新增表格--%>
			<form action="${basePath }user_editUser.action" method="post">
				<table style="width: 600px; margin: 0 auto; border: 0px solid #ddd; background-color: #fff; margin-top: 10px; margin-bottom: 10px;">
					<tr>
						<td><span class="forPoint">*&nbsp;</span><span>用户名</span>
						</td>
						<td><input type="text" class="forText" name="username" value="${user.userName }" />
						</td>
					</tr>
					<tr>
						<td><span class="forPoint">*&nbsp;</span><span>管辖范围</span>
						</td>
						<td style="text-align: left;">
							<select stype="float: left;" name="usercity">
								<option value="510100000000">成都市</option>
							</select>
							<select stype="float: left;" name="usercountry">
								<option value="510124000000">郫县</option>
							</select>
							<select stype="float: left;" name="usertown">
								<option value="510124102000">犀浦镇</option>
							</select>
							<select stype="float: left;" name="uservillage">
								<option value="510124102003">犀和社区居委会</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><span class="forPoint">*&nbsp;</span><span>用户密码</span>
						</td>
						<td><input type="password" name="password" class="forText" value="${user.userPwd }" />
						</td>
					</tr>
					<tr>
						<td><span class="forPoint">*&nbsp;</span><span>确认密码</span>
						</td>
						<td><input type="password" name="passwordagain" class="forText" value="${user.userPwd }" />
						</td>
					</tr>
					<tr>
						<td><span class="forPoint">*&nbsp;</span><span>用户类型</span>
						</td>
						<td>
							<select class="forSelect" name="usertype">
								<option value="1">系统管理员</option>
								<option value="2">村或社区工作人员</option>
								<option value="3">村（社区）监事会成员</option>
								<option value="4">区县审核人员</option>
								<option value="5">市小城投公司人员</option>
								<option value="6">市统筹委人员</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><span class="forPoint">*&nbsp;</span><span>所在单位</span>
						</td>
						<td><input type="text" name="useroffice" class="forText" value="${user.office }" />
						</td>
					</tr>
					<tr>
						<td><span class="forPoint">*&nbsp;</span><span>用户状态</span>
						</td>
						<td>
							<select class="forSelect" name="userstate">
								<option value="1">有效用户</option>
								<option value="0">无效用户</option>
							</select>
						</td>
					</tr>
					<c:if test="${!empty error }">
						<tr>
							<td colspan="2" style="text-align:center;">
								<span class="forPoint">*&nbsp;${error }</span>
							</td>
						</tr>
					</c:if>
					<tr>
						<td colspan="5">
							<center>
								<input name="id" type="hidden" value="${id }" />
								<input type="reset" name="btnReset" id="reset" class="forBtn"
									value="重置" /> 
								<input type="submit" name="btnSubmit" class="forBtn" value="提交" />
							</center></td>
					</tr>
				</table>
			</form>
		</div><!-- end forTableSC -->
		
	</div><!-- end mianTable -->
	<jsp:include page="/common/footer.jsp" />
	<script type="text/javascript" src="${basePath }js/tool.js"></script>
	<script>
		function init(){
			$("select[name=usertype] option[value='${user.userType }']").attr("selected","selected");
			$("select[name=userstate] option[value='${user.userState }']").attr("selected","selected");
		}
		init();
	</script>
</body>
</html>