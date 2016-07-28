//全局变量
var g_num = 1;
var path;
function funClick() {
	path = document.getElementById("path" + g_num);
	path.click();
}
function addAttach() {
	var cont = document.getElementById("attach").innerHTML;
	var temp = path.value;
	var sub = temp.substring(temp.lastIndexOf("\\") + 1);	
	g_num++;
	cont += "<div style='color:#0000ff;'>" + sub + "</div>";
	document.getElementById("attach").innerHTML = cont;
	
	var file = document.createElement("input");
    file.setAttribute("type","file");
    file.setAttribute("id","path"+g_num);
    file.setAttribute("name","file");
    file.setAttribute("onchange","javascript:addAttach();");
    file.setAttribute("style","display:none;");
    
    document.getElementById("upload").appendChild(file);
}