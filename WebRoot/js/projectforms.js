	function getProjectStatusByID(id, st) {
    	var str = "";
    	if (id <= 0) {
    		str = "暂停状态";
    	}else{
    		switch (id) {
	    	case 1:
	    		str = "原始项目未提交";
	    		break;
	    	case 2:
	    		str = "原始项目未表决";
	    		break;
	    	case 3:
	    		str = "初选项目未实施计划";
	    		break;
	    	case 4:
	    		str = "初选项目未议事完善";
	    		break;
	    	case 5:
	    		str = "初选项目未表决";
	    		break;
	    	case 6:
	    		str = "初选项目区县未申报";
	    		break;
	    	case 7:
	    		str = "初选项目城投未审核";
	    		break;
	    	case 8:
	    		str = "初选项目市级未申报";
	    		break;
	    	case 9:
	    		str = "初选项目实施（竞岗、实施、比选、自建）";
	    		break;
	    	case 10:
	    		str = "项目进度监督";
	    		break;
	    	case 11:
	    		str = "项目经费监督";
	    		break;
	    	case 12:
	    		str = "项目评议/验收";
	    		break;
	    	case 13:
	    		str = "项目评测";
	    		break;
	    	case 14:
	    		str = "项目完成且通过";
	    		break;
	    	case 15:
	    		str = "项目完成未通过";
	    		break;
	    	case 16:
	    		str = "项目中途取消";
	    		break;
	    	default:
	    		str = "";
	    	}
    	}
    	document.getElementById("st_" + st).innerHTML = str;
    	document.getElementById("st_" + st).setAttribute("title", str);
    }
	
	function getUserTypeByID(id, stt){
    	switch (id) {
	    	case 1:
	    		str = "系统管理员";
	    		break;
	    	case 2:
	    		str = "村或社区工作人员";
	    		break;
	    	case 3:
	    		str = "村（社区）监事会成员";
	    		break;
	    	case 4:
	    		str = "区县审核人员";
	    		break;
	    	case 5:
	    		str = "市小城投公司人员";
	    		break;
	    	case 6:
	    		str = "市统筹委人员";
	    		break;
	    	default:
	    		str = "";
	    }
    	document.getElementById("stt_" + stt).innerHTML = str;
	}