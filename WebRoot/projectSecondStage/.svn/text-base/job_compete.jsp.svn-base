<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.hwadee.orm.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);

Project project=(Project)request.getAttribute("PROJECT");
Jobcompetitioninfo jci=(Jobcompetitioninfo)request.getAttribute("INSTANCE");
String editable=(String)request.getAttribute("EDITABLE");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>竞岗情况</title>
    <%@ include file="/common/common.jsp" %>
  </head>
  
  <body>
    <jsp:include page="/common/header.jsp" />
    <div class="mainTable">
	
		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>项目管理 &gt; <a style="text-decoration: none;" href="${basePath }projectSecondStage/index.jsp"> 项目实施与监察</a> &gt;竞岗情况</span>
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
	
		<!-- 竞岗情况表，仅含有填写信息部分，而无查看部分 -->
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
						<!-- 岗位名称-->
						<td><span class="forPoint">*&nbsp;</span><span>岗位名称</span></td>
						<td><input type="text" name="jobName" class="forText"
									value="${jci.jobName }"/></td>
					</tr>
					<tr>
						<!-- 岗位工资 -->
						<td><span class="forPoint">*&nbsp;</span><span>岗位工资</span></td>
						<td><input type="text" name="jobPay" class="forText"
									value="${jci.jobPay }"/></td>
					</tr>
					<tr>
						<!-- 岗位描述 -->
						<td><span class="forPoint">*&nbsp;</span><span>岗位描述</span></td>
						<td><input type="text" name="jobDescription" class="forText"
									value="${jci.jobDescription }"/></td>
					</tr>
					<tr>
						<!-- 岗位要求 -->
						<td><span class="forPoint">*&nbsp;</span><span>岗位要求</span></td>
						<td><input type="text" name="jobRequirement" class="forText"
									value="${jci.jobRequirement }"></td>
					</tr>
					<tr>
						<!-- 竞岗人 -->
						<td><span class="forPoint">*&nbsp;</span><span>竞岗人</span></td>
						<td><input type="text" name="peopleName" class="forText"
									value="${jci.peopleName }"></td>
					</tr>
					<tr>
						<!-- 竞岗日期-->
						<td><span class="forPoint">*&nbsp;</span><span>竞岗日期</span></td>
						<td><input type="text" name="competitionTime" class="forDate"
									value="${jci.competitionTime }"></td>
					</tr>
					<tr>
						<!-- 竞岗结果 -->
						<td><span class="forPoint">*&nbsp;</span><span>竞岗结果</span></td>
						<td><input type="text" name="competitionResult" class="forText" 
									value="${jci.competitionResult }"></td>
					</tr>
					<tr>
						<!-- 合同金额 -->
						<td><span class="forPoint">*&nbsp;</span><span>合同金额</span></td>
						<td><input type="text" name="contractFunds" class="forText" 
									value="${jci.contractFunds }"></td>
					</tr>
					<tr>
						<!-- 监事会审核意见-->
						<td><span class="forPoint">*&nbsp;</span><span>监事会审核意见</span></td>
						<td><input type="text" name="jcicheckResult" class="forText" 
									value="${jci.jcicheckResult }"></td>
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
													name="tableComment" value='${jci.tableComment }'></textarea></td>
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
			formX.action="${basePath }implement_commitJCInfo.action";
			}
		else{
			formX.action="${basePath }implement_saveJCInfo.action";
			}
		formX.submit();
	}
	</script>
	
	<jsp:include page="/common/footer.jsp" />
  </body>
</html>