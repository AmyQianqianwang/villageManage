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
     <title>初选项目（融资类）申报情况</title>
    <%@ include file="/common/common.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath }css/projectform.css" />
<script type="text/javascript" src="${basePath }js/projectforms.js"></script>
     <script>
	function btnSaveOrbtnSubmit(str) {
		//alert(str);
		document.getElementById("typeSubmit").value = str;
		document.check.submit();
	}
	
</script>
  </head>
  
  <body>
    
	<jsp:include page="/common/header.jsp" />
	
	<div class="mainTable">
	
		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>项目管理 &gt; 初选项目（融资类）申报情况</span>
			</div>
		</div>
		
		<div class="itemState">
			<table>
				<tr>
					<td class="title">项目状态：</td>
				<td id="st_0"><script>getProjectStatusByID(${rcInfo.project.proStatus }, 0);</script></td>
				</tr>
				<tr>
					<td class="title">单位名称：</td>
					<td>${rcInfo.project.unitName }</td>
				</tr>
				<tr>
					<td class="title">填报人员：</td>
					<td>${rcInfo.project.user.userName }</td>
				</tr>
				<tr>
					<td class="title">填报日期：</td>
				<td>${rcInfo.paddingTime }</td>
				</tr>
				
			</table>
		</div>
	
		<!-- 原始项目登记表，仅含有填写信息部分，而无查看部分 -->
		<div class="fillTable">			
			<form class="initialTable" action="${basePath }reportCheck_insertCheckInfo.action"
				name="check">
				<table>
					<tr>
						<!-- 项目编号 -->
						<td><span >项目编号</span></td>
						<td><input type="text" class="forDate" name="proID" value="${rcInfo.project.proId }"/></td>
					</tr>
					<tr>
						<!-- 项目名称 -->
						<td><span>项目名称</span></td>
						<td><input type="text" name="proName" class="forText" value="${rcInfo.project.proName }"/></td>
					</tr>
					<tr>
						<!-- 登记时间为当前时间（默认值） -->
						<td><span>项目登记时间</span></td>
						<td><input type="text" name="recTime" class="forDate" value="${rcInfo.project.recTime}"/></td>
					</tr>
					<tr>
						<!-- 项目类别 -->
						<td><span>项目类别</span></td>
						<td><input type="text" name="proType" class="forText" value="${rcInfo.project.proType }"/></td>
					</tr>
					<tr>
						<!-- 项目种类 -->
						<td><span>项目种类</span></td>
						<td><input type="text" name="proKind" class="forText" value="${rcInfo.project.proKind }" /></td>
					</tr>
					<tr>
						<!-- 项目内容 -->
						<td><span>项目内容</span></td>
						<td><textarea class="forTextarea" name="proText" rows="5" cols="5" >${rcInfo.project.proContext }</textarea></td>
					</tr>
 					<tr>
						<!--项目来源 -->
						<td><span>项目来源 </span></td>
						<td><input type="text" name="proSourse" class="forText" value="${rcInfo.project.proSource }"/></td>
					</tr>
					<tr>
						<!-- 建议户数 -->
						<td><span>建议户数</span></td>
						<td><input type="text" class="forDate" name="familyCount" value="${rcInfo.project.familyCount }"/></td>
					</tr>
					<tr>
						<!-- 项目推荐时间 -->
						<td><span>项目推荐时间</span></td>
						<td><input type="text" id="dateRecom" class="forDate" name="electTime" value="${rcInfo.project.electTime }"/></td>
					</tr>
					<tr>
						<!-- 项目计划完成时间 -->
						<td><span>项目计划完成时间</span></td>
						<td><input type="text" id="dateFin" class="forDate" name="planEndTime" value="${rcInfo.project.planEndTime }"/></td>
					</tr>
					<tr>
						<!-- 项目实施方法 -->
						<td><span>项目实施方法</span></td>
						<td><input type="text" name="impleMethod" class="forText" value="${rcInfo.project.impleMethod}"/></td>
					</tr>
					<tr>
						<!-- 实施计划 -->
						<td><span>实施计划</span></td>
						<td><textarea class="forTextarea" name="implePlan" rows="5" cols="5" >${ipfbInfo.implePlan }</textarea></td>
					</tr>
				<tr>
						<!-- 专项资金 -->
						<td><span class="forPoint">*&nbsp;</span><span>专项资金（万元）</span></td>
						<td><input type="text" name="specialFund" class="forDate" value="${ipfbInfo.specialFund }"/></td>
					</tr>
					
					<tr>
						<!-- 自有资金-->
						<td><span class="forPoint">*&nbsp;</span><span>自有资金（万元）</span></td>
						<td><input type="text" name="selfFund" class="forDate" value="${ipfbInfo.selfFund }"/></td>
					</tr>
					
					<tr>
						<!-- 融资资金-->
						<td><span class="forPoint">*&nbsp;</span><span>融资资金（万元）</span></td>
						<td><input type="text" name="meltFund" class="forDate" value="${ipfbInfo.meltFund }"/></td>
					</tr>
					
					<tr>
						<!-- 其他资金-->
						<td><span class="forPoint">*&nbsp;</span><span>其他资金（万元）</span></td>
						<td><input type="text" name="otherFund" class="forDate" value="${ipfbInfo.otherFund }"/></td>
					</tr>
					<tr>
						<!-- 资金预算总额-->
						<td><span class="forPoint">*&nbsp;</span><span>资金预算总额</span></td>
						<td><input type="text" name="totalFund" class="forDate" value="${ipfbInfo.totalFund }"/></td>
					</tr>
					<tr>
						<!-- 备注 -->
						<td><span>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</span></td>
						<td colspan="4"><textarea class="forTextarea" rows="5" cols="5" name="bugetTableComment" >${ipfbInfo.tableComment }</textarea></td>
					</tr>
					<tr>
						<!-- 区县审核小组意见-->
						<td><span class="forPoint">*&nbsp;</span><span>区县审核小组意见</span></td>
						<td><input type="text" name="countryCheckResult" class="forText" value="${rcInfo.countryCheckResult }"/></td>
					</tr>
					<tr>
						<!-- 市小城投公司初审意见-->
						<td><span class="forPoint">*&nbsp;</span><span>市小城投公司初审意见</span></td>
						<td><input type="text" name="companyCheckResult" class="forText" value="${rcInfo.companyCheckResult }"/></td>
					</tr>
					<tr>
						<!-- 市统筹委复核意见-->
						<td><span class="forPoint">*&nbsp;</span><span>市统筹委复核意见</span></td>
						<td><input type="text" name="cityCheckResult" class="forText" value="${rcInfo.cityCheckResult }"/></td>
					</tr>
					<tr>
						<!-- 申报结果-->
						<td><span>申报结果</span></td>
						<td>
						<select class="forSelect"
							name="checkResult" id="ITClass" >
								<option value="">---请选择---</option>
								<option value="通过">通过</option>
								<option value="不通过">不通过</option>
						</select>
						</td>
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
						<td colspan="4"><textarea class="forTextarea" rows="5" cols="5" name="tableComment"  >${rcInfo.tableComment }</textarea></td>
					</tr>
					<tr>
						<td colspan="2" class="forPoint">注：保存后，继续编辑；提交后，不能再最任何更改</td>
					</tr>
					<tr>
						<td colspan="5">
							<center>
							<input type="button" name="btnSave"  class="forBtn" value="保存" onclick="javascript:btnSaveOrbtnSubmit('sa');"/> 
								<input type="reset" id="reset"	class="forBtn" value="重置" /> 
								<input type="button" name="btnSubmit"  class="forBtn" value="提交" onclick="javascript:btnSaveOrbtnSubmit('su');"/>
								<input type="button" name="btnBack"  class="forBtn" value="驳回" onclick="javascript:btnSaveOrbtnSubmit('sb');"/>
								<input type="hidden" name="typeSubmit" id="typeSubmit" value="" />
								<input type="hidden" name="projectProID" value="${rcInfo.project.proId }"/>
							</center>
						</td>
					</tr>
				</table>
			</form>
		</div><!-- end fillTable -->	
	</div><!-- end mianTable -->
	
	
	<jsp:include page="/common/footer.jsp" />
	<script>
		function init(status) {
			if(status==6)
			{
				document.check.countryCheckResult.readOnly=false;
				document.check.companyCheckResult.readOnly=true;
				document.check.cityCheckResult.readOnly=true;
				document.check.checkResult.disabled=true;
			}
			else if(status==7)
			{
				document.check.countryCheckResult.readOnly=true;
				document.check.companyCheckResult.readOnly=false;
				document.check.cityCheckResult.readOnly=true;
				document.check.checkResult.disabled=true;
			}
			else if(status==8)
			{
				document.check.countryCheckResult.readOnly=true;
				document.check.companyCheckResult.readOnly=true;
				document.check.cityCheckResult.readOnly=false;
				document.check.checkResult.disabled=false;
			}
			
		}
		init(${rcInfo.project.proStatus});
	</script>
</body>
  </body>
</html>
