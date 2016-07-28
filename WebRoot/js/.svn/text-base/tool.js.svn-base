function gotoPage(pagenum){
	var Oform = document.getElementById("PageForm");
	Oform.jumpPage.value = pagenum;
	Oform.submit();
	return false;
}
/**
 * 动态加载出List页面下部的翻页超链接
 * @return 返回超链接的HTML代码，在引用页面直接加入即可。 
 */
function jumpPageSpan(page, totalPages) {
	var strSelect = "";
	for ( var i = -3; i < 3; i++) {
		var temop = page + i;
		if (temop > 0 && temop < totalPages && i != 0)
			strSelect = strSelect
					+ "&nbsp;<a href=\"javascript:gotoPage(\'"+temop+"\')\">"
					+ "[" + temop + "]" + "</a>"
		if (i == 0)
			strSelect = strSelect + "&nbsp;[" + temop + "]";
	}
	return strSelect;
}

// 打印界面
function printit(MyDiv)
{
	if (confirm('确定打印吗？')) {
		var newstr = document.getElementById(MyDiv).innerHTML;
		var oldstr = document.body.innerHTML;
		document.body.innerHTML = newstr;
		window.print();
		document.body.innerHTML = oldstr;
		return false;
	}
}


