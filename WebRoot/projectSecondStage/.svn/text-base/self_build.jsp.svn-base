<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.hwadee.orm.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);

Project project=(Project)request.getAttribute("PROJECT");
Selfbuildinfo sbi=(Selfbuildinfo)request.getAttribute("INSTANCE");
String editable=(String)request.getAttribute("EDITABLE");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>自建情况</title>
    <%@ include file="/common/common.jsp" %>
  </head>
  
  <body>
    <jsp:include page="/common/header.jsp" />
    <div class="mainTable">
	
		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>项目管理 &gt; <a style="text-decoration: none;" href="${basePath }projectSecondStage/index.jsp"> 项目实施与监察</a> &gt;自建情况</span>
			</div>
		</div>
		
		<div class="itemState">
			<table>
				<tr>
					<td class="title">项目状态：</td>
					<td>项目实施阶段</td>
				</tr>
				<tr>
					<td class="title">单位名称：</td>
					<td>四川省成都市华迪实训公司集团xxxxxxxxxxxx</td>
				</tr>
				<tr>
					<td class="title">填报人员：</td>
					<td>张三</td>
				</tr>
				<tr>
					<td class="title">填报日期：</td>
					<td>2014-7-14</td>
				</tr>
				
			</table>
		</div>
	
		<!-- 原始项目登记表，仅含有填写信息部分，而无查看部分 -->
		<div class="fillTable">			
			<form name='infoForm' class="initialTable" action="" method="post">
				<table>
					<tr>
						<!-- 项目编号 -->
						<td><span >项目编号</span></td>
						<td><%=project.getProId() %></td>
					</tr>
					<tr>
						<!-- 项目名称 -->
						<td><span>项目名称</span></td>
						<td><%=project.getProName() %></td>
					</tr>
					<tr>
						<!-- 项目负责人 -->
						<td><span class="forPoint">*&nbsp;</span><span>项目负责人</span></td>
						<td><input type="text" name="sbprojectLeaderName" class="forText"
									value="${sbi.sbprojectLeaderName }"/></td>
					</tr>
					<tr>
						<!-- 项目负责人联系电话 -->
						<td><span class="forPoint">*&nbsp;</span><span>联系电话</span></td>
						<td><input type="text" name="sbprojectLeaderTel" class="forText"
									value="${sbi.sbprojectLeaderTel }"></td>
					</tr>
					<tr>
						<!-- 材料采购员 -->
						<td><span class="forPoint">*&nbsp;</span><span>材料采购员</span></td>
						<td><input type="text" name="sbmaterialsPurchaseName" class="forText"
									value="${sbi.sbmaterialsPurchaseName }"></td>
					</tr>
					<tr>
						<!-- 材料采购员联系电话 -->
						<td><span class="forPoint">*&nbsp;</span><span>联系电话</span></td>
						<td><input type="text" name="sbmaterialsPurchaseTel" class="forText"
									value="${sbi.sbmaterialsPurchaseTel }"></td>
					</tr>
					<tr>
						<!-- 附件 -->
						<td><span>附&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件</span></td>
						<td>
							<input type="button" class="forUpload" value="上传"/>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>放置上传的附件</td>
					</tr>
					<tr>
						<!-- 备注 -->
						<td><span>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</span></td>
						<td colspan="4"><textarea class="forTextarea" rows="5" cols="5"
													name="tableComment" value='${csi.tableComment }'></textarea></td>
					</tr>
					<%if(editable.equals("true")){%>
						<tr>
							<td colspan="2" class="forPoint">注：保存后，继续编辑；提交后，不能再最任何更改</td>
						</tr>
						<tr>
							<td colspan="5">
								<center>
									<input type="button" name="btnSave"
											onclick="javascript:doSubmit(false);" class="forBtn"
											value="保存" /> 
									<input type="reset" id="reset" class="forBtn"
											value="重置" /> 
									<input type="button" name="btn"
											onclick="javascript:doSubmit(true);" class="forBtn"
											value="提交" />
									<input type="hidden" name="proID" value='${project.proId }'/> 
								</center>
							</td>
						</tr>
					<%} %>
				</table>
			</form>
		</div><!-- end fillTable -->	
	</div><!-- end mianTable -->
	<script>
	function doSubmit(bool) {
		var formX=document.infoForm;
		if(bool)
			{
			formX.action="${basePath }implement_commitSBInfo.action";
			}
		else{
			formX.action="${basePath }implement_saveSBInfo.action";
			}
		formX.submit();
	}
	</script>
	
	<jsp:include page="/common/footer.jsp" />
  </body>
</html>