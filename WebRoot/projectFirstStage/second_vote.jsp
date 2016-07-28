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
   <title>初选项目（非融资类）表决情况</title>
    <%@ include file="/common/common.jsp" %>
    <link rel="stylesheet" type="text/css" href="${basePath }css/projectform.css" />
<script type="text/javascript" src="${basePath }js/projectforms.js"></script>
    <script>
	function btnSaveOrbtnSubmit(str) {
		//alert(str);
		document.getElementById("typeSubmit").value = str;
		document.secondVote.submit();
	}
	function CalculateResult() {
		document.secondVote.result.value = "";
		var positive = document.secondVote.positiveCount.value;
		var total = document.secondVote.totalCount.value;
		var re = positive > (total * 1.0 / 2);
		if (re == true) {
			document.secondVote.result.value = "通过";
		} else {
			document.secondVote.result.value = "不通过";
		}

		//alert(positive);
	}
	function getProjectVoteResult(re)
   	{
   		
    	if(re=='false')
    		document.secondVote.result.value="不通过";
    	else if(re=='true')
    		document.secondVote.result.value="通过";
    	else
    		document.secondVote.result.value="error";
    	//document.getElementById("st_" + st).innerHTML = str;
   	}
</script>
  </head>
  
  <body>
   <jsp:include page="/common/header.jsp" />
	
	<div class="mainTable">
	
		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>项目管理 &gt;初选项目（非融资类）表决情况</span>
			</div>
		</div>
		
		<div class="itemState">
			<table>
				<tr>
					<td class="title">项目状态：</td>
				<td id="st_0"><script>getProjectStatusByID(${projectVoteInfo.project.proStatus }, 0);</script></td>
				</tr>
				<tr>
					<td class="title">单位名称：</td>
					<td>${projectVoteInfo.project.unitName }</td>
				</tr>
				<tr>
					<td class="title">填报人员：</td>
					<td>${projectVoteInfo.project.user.userName }</td>
				</tr>
				<tr>
					<td class="title">填报日期：</td>
					<td>${projectVoteInfo.paddingTime }</td>
				</tr>
				
			</table>
		</div>
	
		<!-- 原始项目登记表，仅含有填写信息部分，而无查看部分 -->
		<div class="fillTable">			
			<form class="initialTable" action="${basePath }firstvote_insertSecondVoteInfo.action"
				name="secondVote">
				<table>
					<tr>
						<!-- 项目编号 -->
						<td><span >项目编号</span></td>
						<td><input type="text" class="forDate" name="proID" value="${ projectVoteInfo.project.proId} "/></td>
					</tr>
					<tr>
						<!-- 项目名称 -->
						<td><span>项目名称</span></td>
						<td><input type="text" name="proName" class="forText"  value="${ projectVoteInfo.project.proName}"/></td>
					</tr>
					<tr>
						<!-- 表决时间 -->
						<td><span class="forPoint">*&nbsp;</span><span>表决时间</span></td>
						<td><input type="text" name="voteTime" class="forDate getDate" id="dateRecom" value="${projectVoteInfo.voteTime}"/></td>
					</tr>
					<tr>
						<!-- 应到议事会成员人数 -->
						<td><span class="forPoint">*&nbsp;</span><span>应到议事会成员人数</span></td>
						<td><input type="text" name="supposeCount" class="forDate" value="${projectVoteInfo.supposeCount }"></td>
					</tr>
					<tr>
						<!-- 实到议事会成员人数 -->
						<td><span class="forPoint">*&nbsp;</span><span>实到议事会成员人数</span></td>
						<td><input type="text" name="actualCount" class="forDate" value="${projectVoteInfo.supposeCount }"></td>
					</tr>
					<tr>
						<!-- 赞成票数 -->
						<td><span class="forPoint">*&nbsp;</span><span>赞成票数</span></td>
						<td><input type="text" name="positiveCount" class="forDate" onchange="CalculateResult()" value="${ projectVoteInfo.positiveCount}"></td>
					</tr>
					<tr>
						<!-- 反对票数 -->
						<td><span class="forPoint">*&nbsp;</span><span>反对票数</span></td>
						<td><input type="text" name="negativeCount" class="forDate" value="${projectVoteInfo.negativeCount }"></td>
					</tr>
					<tr>
						<!-- 弃权票数 -->
						<td><span class="forPoint">*&nbsp;</span><span>弃权票数</span></td>
						<td><input type="text" name="abstentionCount" class="forDate" value="${ projectVoteInfo.abstentionCount}"></td>
					</tr>
					<tr>
						<!-- 投票总数 -->
						<td><span class="forPoint">*&nbsp;</span><span>投票总数</span></td>
						<td><input type="text" name="totalCount" class="forDate" onchange="CalculateResult()" value="${projectVoteInfo.totalCount }"></td>
					</tr>
					<tr>
						<!-- 表决结果 -->
						<td><span>表决结果</span></td>
						<td><input type="text" name="result" class="forDate" ><script>getProjectVoteResult('${projectVoteInfo.result }');</script></td>
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
						<td colspan="4"><textarea class="forTextarea" rows="5" cols="5" name="tableComment" >${projectVoteInfo.tableComment}</textarea></td>
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
								<input type="hidden" name="typeSubmit" id="typeSubmit" value="" />
								<input type="hidden" name="projectProID" value="${projectVoteInfo.project.proId }"/>
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
