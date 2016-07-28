<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>初选项目议事会修改完善情况</title>
<%@ include file="/common/common.jsp"%>
<link rel="stylesheet" type="text/css" href="${basePath }css/projectform.css" />
<script type="text/javascript" src="${basePath }js/projectforms.js"></script>

</head>

<body>

	<jsp:include page="/common/header.jsp" />

	<div class="mainTable">

		<div class="tableName">
			<div class="triangle-left"></div>
			<div class="headerTableName">
				<span>项目管理 &gt; 初选项目议事会修改完善情况</span>
			</div>
		</div>

		<div class="itemState">
			<table>
				<tr>
					<td class="title">项目状态：</td>
					<td id="st_0"><script>getProjectStatusByID(${ceInfo.project.proStatus }, 0);</script></td>
				</tr>
				<tr>
					<td class="title">单位名称：</td>
					<td>${ceInfo.project.unitName }</td>
				</tr>
				<tr>
					<td class="title">填报人员：</td>
					<td>${ceInfo.project.user.userName }</td>
				</tr>
				<tr>
					<td class="title">填报日期：</td>
					<td>${ceInfo.paddingTime}</td>
				</tr>

			</table>
		</div>

		<!-- 原始项目登记表，仅含有填写信息部分，而无查看部分 -->
		<div class="fillTable">
			<form class="initialTable"
				action="${basePath }edition_insertCompleteEditionInfo.action"
				name="edition">
				<table>
					<tr>
						<!-- 项目编号 -->
						<td><span>项目编号</span>
						</td>
						<td><input type="text" class="forDate" name="proID" value="${ ceInfo.project.proId}" />
						</td>
					</tr>
					<tr>
						<!-- 项目名称 -->
						<td><span class="forPoint">*&nbsp;</span><span>项目名称</span>
						</td>
						<td><input type="text" name="proName" class="forText" value="${ ceInfo.project.proName}" />
						</td>
					</tr>
					<tr>
						<!-- 是否需要完善-->
						<td><span class="forPoint">*&nbsp;</span><span>是否需要完善</span>
						</td>
						<td><input type="radio" value="有" name="ifedition" id="needEditionY"
							checked="checked" class="forRadio" onclick="ifNeedEdition('Y')" /><span
							class="forLabel">是</span><input type="radio" value="无"
							name="ifedition" class="forRadio" onclick="ifNeedEdition('N')" id="needEditionN"/><span
							class="forLabel">否</span>
						
						</td>
					</tr>
					
					<tr>
						<!-- 修改内容 -->
						<td><span class="forPoint">*&nbsp;</span><span>修改内容</span>
						</td>
						<td><textarea class="forTextarea" name="editContext" rows="5"
								cols="5" >${ceInfo.editContext} </textarea>
						</td>
					</tr>
					<tr>
						<!-- 是否进入表决-->
						<td><span class="forPoint">*&nbsp;</span><span>是否进入表决</span>
						</td>
						<td><input type="radio" value="有" name="ifvote" id="ifvoteY"
							checked="checked" class="forRadio" onclick="ifGoIntoVote('Y')" /><span
							class="forLabel">是</span><input type="radio" value="无"
							name="ifvote" class="forRadio" onclick="ifGoIntoVote('N')" id="ifvoteN" /><span
							class="forLabel" >否</span>
						
						</td>
					</tr>
					<tr>
						<!-- 附件 -->
						<td><span>附&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件</span>
						</td>
						<td><input type="button" class="forUpload" value="上传"
							name="attachment" /></td>
					</tr>
					<tr>
						<td></td>
						<td>放置上传的附件</td>
					</tr>
					<tr>
						<!-- 备注 -->
						<td><span>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</span>
						</td>
						<td colspan="4"><textarea class="forTextarea" rows="5"
								cols="5" name="tableComment" >${ceInfo.tableComment}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="forPoint">注：保存后，继续编辑；提交后，不能再最任何更改</td>
					</tr>
					<tr>
						<td colspan="5">
							<center>
								<input type="button" name="btnSave"
									onclick="javascript:btnSaveOrbtnSubmit('sa');" class="forBtn"
									value="保存" /> <input type="reset" id="reset" class="forBtn"
									value="重置" /> <input type="button" name="btn"
									onclick="javascript:btnSaveOrbtnSubmit('su');" class="forBtn"
									value="提交" /> <input type="hidden" name="typeSubmit"
									id="typeSubmit" value="" /> <input type="hidden"
									name="goIntoVote" id="goIntoVote" value="" /> 
									<input type="hidden" name="projectProID" value="${ceInfo.project.proId }"/>
									<!-- <input type="hidden"
									name="ifEdition" value="" /> -->
							</center></td>
					</tr>
				</table>
			</form>
		</div>
		<!-- end fillTable -->
	</div>
	<!-- end mianTable -->


	<jsp:include page="/common/footer.jsp" />
	<script>
	function btnSaveOrbtnSubmit(str) {
		//alert(str);
		document.getElementById("typeSubmit").value = str;
		document.edition.submit();
	}
	function ifNeedEdition(str) {
		if (str == "Y") {
			document.edition.editContext.disabled = false;
		//	document.edition.ifEdition.value = "true";
		}
		else if(str=="true")
			document.getElementById("needEditionY").checked=true;
		else if(str=="false")
			document.getElementById("needEditionN").checked=true;
		else if (str == "N") {
			document.edition.editContext.disabled = true;
		//	document.edition.ifEdition.value = "false";
		}

	}
	function ifGoIntoVote(str) {
		
		if (str == "Y")
			document.edition.goIntoVote.value = "true";
		else if (str == "N")
			document.edition.goIntoVote.value = "false";
		else if(str=="true")
		{
			//alert(str);
			document.getElementById("ifvoteY").checked=true;
			document.edition.goIntoVote.value = "true";
		}
		else if(str=="false"){
			document.getElementById("ifvoteN").checked=true;
			document.edition.goIntoVote.value = "false";
		}
		else
			alert("error!");
	}
  	ifGoIntoVote('${ceInfo.goIntoVote}');
	ifNeedEdition('${ceInfo.needEdit}');
</script>
</body>
</body>
</html>
