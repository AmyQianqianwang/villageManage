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
   <title>初选项目实施计划及资金预算情况录入</title>
    <%@ include file="/common/common.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath }css/projectform.css" />
	<script type="text/javascript" src="${basePath }js/projectforms.js"></script>
    <script>
     function btnSaveOrbtnSubmit(str) {
		//alert(str);
		document.getElementById("typeSubmit").value = str;
		document.fundsbuget.submit();
	}
	function calculateTotalFund()
	{
		var specialFund=document.fundsbuget.specialFund.value*1;
		var selfFund=document.fundsbuget.selfFund.value*1;
		//alert(selfFund);
		var	meltFund=document.fundsbuget.meltFund.value*1;
		var otherFund=document.fundsbuget.otherFund.value*1;
		document.fundsbuget.totalFund.value=specialFund+selfFund+meltFund+otherFund;
		//alert(specialFund);
	}
	function changeSelfStatus(str)
	{
		if(str=="selfY")
			//document.fundsbuget.selfFund.readOnly=false;
			document.fundsbuget.selfFund.disabled=false;
		else
			//document.fundsbuget.selfFund.readOnly=true;
			document.fundsbuget.selfFund.disabled=true;
	}
	function changeMeltStatus(str)
	{
		if(str=="Y")
			//document.fundsbuget.selfFund.readOnly=false;
			document.fundsbuget.meltFund.disabled=false;
		else
			//document.fundsbuget.selfFund.readOnly=true;
			document.fundsbuget.meltFund.disabled=true;
	}
	function changeOtherStatus(str)
	{
		if(str=="Y")
			//document.fundsbuget.selfFund.readOnly=false;
			document.fundsbuget.otherFund.disabled=false;
		else
			//document.fundsbuget.selfFund.readOnly=true;
			document.fundsbuget.otherFund.disabled=true;
	}
    </script>
    
  </head>
  
  <body>
   <jsp:include page="/common/header.jsp" />
	
	<div class="mainTable">
	
		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>项目管理 &gt;初选项目实施计划及资金预算情况</span>
			</div>
		</div>
		
		<div class="itemState">
			<table>
				<tr>
					<td class="title">项目状态：</td>
					<td id="st_0"><script>getProjectStatusByID(${ipfbInfo.project.proStatus }, 0);</script></td>
				</tr>
				<tr>
					<td class="title">单位名称：</td>
					<td>${ipfbInfo.project.unitName }</td>
				</tr>
				<tr>
					<td class="title">填报人员：</td>
					<td>${ipfbInfo.project.user.userName }</td>
				</tr>
				<tr>
					<td class="title">填报日期：</td>
					<td>${ipfbInfo.paddingTime }</td>
				</tr>
				
			</table>
		</div>
	
		<!-- 初选项目实施计划及资金预算情况表，仅含有填写信息部分，而无查看部分 -->
		<div class="fillTable">			
			<form class="initialTable" action="${basePath}fundsbuget_insertFundsBugetInfo.action" name="fundsbuget">
				<table>
					<tr>
						<!-- 项目编号 -->
						<td><span >项目编号</span></td>
						<td><input type="text" class="forDate" name="proID" value="${ipfbInfo.project.proId }"/></td>
					</tr>
					<tr>
						<!-- 项目名称 -->
						<td><span>项目名称</span></td>
						<td><input type="text" name="proName" class="forText" value="${ipfbInfo.project.proName }" /></td>
					</tr>
						<tr>
						<!-- 实施方法 -->
						<td><span>实施方法</span></td>
						<td><input type="text" name="impleMethod" class="forText" value="${ipfbInfo.project.impleMethod }"/></td>
					</tr>
					<tr>
						<!-- 实施计划 -->
						<td><span class="forPoint">*&nbsp;</span><span>实施计划</span></td>
						<td><textarea class="forTextarea" rows="6" cols="6" name="implePlan" >${ipfbInfo.implePlan}</textarea></td>
					</tr>
					<tr>
						<!-- 专项资金 -->
						<td><span class="forPoint">*&nbsp;</span><span>专项资金（万元）</span></td>
						<td><input type="text" name="specialFund" class="forDate"  onchange="calculateTotalFund()" value="${ipfbInfo.specialFund }"/></td>
					</tr>
					<tr>
						<!-- 自有资金 -->
						<td><span class="forPoint">*&nbsp;</span><span>自由资金</span></td>
						<td><input type="radio" value="有" name="ifSelfFund" checked="checked" class="forRadio" onclick="changeSelfStatus('selfY')"/><span class="forLabel">有</span><input type="radio" value="无" name="ifSelfFund" class="forRadio" onclick="changeSelfStatus('selfN')"/><span class="forLabel">无</span></td>
					</tr>
					<tr>
						<!-- 自有资金-->
						<td><span class="forPoint">*&nbsp;</span><span>自有资金（万元）</span></td>
						<td><input type="text" name="selfFund" class="forDate" onchange="calculateTotalFund()" value="${ipfbInfo.selfFund }"/></td>
					</tr>
					<tr>
						<!-- 融资资金 -->
						<td><span class="forPoint">*&nbsp;</span><span>融资资金</span></td>
						<td><input type="radio" value="有" name="ifMeltFund" checked="checked" class="forRadio" onclick="changeMeltStatus('Y')"/><span class="forLabel">有</span><input type="radio" value="无" name="ifMeltFund" class="forRadio" onclick="changeMeltStatus('N')"/><span class="forLabel">无</span></td>
					</tr>
					<tr>
						<!-- 融资资金-->
						<td><span class="forPoint">*&nbsp;</span><span>融资资金（万元）</span></td>
						<td><input type="text" name="meltFund" class="forDate" onchange="calculateTotalFund()" value="${ipfbInfo.meltFund }"/></td>
					</tr>
					<tr>
						<!-- 融资还款年限 -->
						<td><span class="forPoint">*&nbsp;</span><span>融资还款年限</span></td>
						<td><input type="text" name="maturities" class="forDate" value="${ipfbInfo.maturities }"/></td>
					</tr>
						<tr>
						<!-- 其他资金-->
						<td><span class="forPoint">*&nbsp;</span><span>其他资金</span></td>
						<td><input type="radio" value="有" name="ifOtherFund" checked="checked" class="forRadio" onclick="changeOtherStatus('Y')"/><span class="forLabel">有</span><input type="radio" value="无" name="ifOtherFund" class="forRadio" onclick="changeOtherStatus('N')"/><span class="forLabel" >无</span></td>
					</tr>
					<tr>
						<!-- 其他资金-->
						<td><span class="forPoint">*&nbsp;</span><span>其他资金（万元）</span></td>
						<td><input type="text" name="otherFund" class="forDate" onchange="calculateTotalFund()" value="${ipfbInfo.otherFund }"/></td>
					</tr>
					<tr>
						<!-- 资金预算总额-->
						<td><span class="forPoint">*&nbsp;</span><span>资金预算总额</span></td>
						<td><input type="text" name="totalFund" class="forDate" readOnly="readOnly" value="${ipfbInfo.totalFund }"/></td>
					</tr>
				
					<tr>
						<!-- 附件 -->
						<td><span>附&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件</span></td>
						<td>
							<input type="button" class="forUpload" value="上传" name="attachment"/>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>放置上传的附件</td>
					</tr>
					<tr>
						<!-- 备注 -->
						<td><span>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</span></td>
						<td colspan="4"><textarea class="forTextarea" rows="5" cols="5" name="tableComment" >${ipfbInfo.tableComment }</textarea></td>
					</tr>
					<tr>
						<td colspan="2" class="forPoint">注：保存后，继续编辑；提交后，不能再最任何更改</td>
					</tr>
					<tr>
						<td colspan="5">
							<center>
							<input type="button" name="btnSave"  class="forBtn" value="保存" onclick="javascript:btnSaveOrbtnSubmit('sa');" />
							<input type="reset" id="reset" class="forBtn" value="重置" />
							<input type="button" name="btnSubmit"  class="forBtn" value="提交" onclick="javascript:btnSaveOrbtnSubmit('su');" />
							<input type="hidden" name="typeSubmit" id="typeSubmit" value="" />
							<input type="hidden" name="projectProID" value="${ipfbInfo.project.proId }"/>
							</center>
						</td>
					</tr>
				</table>
			</form>
		</div><!-- end fillTable -->	
	</div><!-- end mianTable -->
	
	
	<jsp:include page="/common/footer.jsp" />
  </body>
</html>
