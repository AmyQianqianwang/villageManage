/**
 * 	满足每一个Table在取值上的要求
*/

/*
 * 	原始登记表 initialTable
 * 	傻眼儿了吧！select中还有一个value属性；我擦
 */
$(document).ready(function(){
	
	/*	
	 * 	使所有select的第一个option无法选择，即“---请选择---”不可选	
	 */
	var selectLen = $("select").length;
	for(var i=0;i<selectLen;i++){
//		$("select").find("option:first").attr("disabled",true);
	}
	
	
	/*
	 * 	"*"标记处必须填写，否则保存 提交按钮被禁用		其中"*"的name="keypoint";
	 * 	blur()失败--日期选择时，即使是blur了，也没法对按钮解禁
	 */
	$("form :input").change(function(){
		var objKeyPoint = document.getElementsByName("keypoint");
		var inputLen = objKeyPoint.length;
		var objBtn = document.getElementsByName("btn");
		var btnLen = objBtn.length;
		var tmpKeyPoint = 1;
		for(var j=0;j<inputLen;j++){
			if(objKeyPoint[j].value == ""){
				tmpKeyPoint = 0;
				break;
			}
		}
		if(tmpKeyPoint == 1){
			for(var k=0;k<btnLen;k++){
				objBtn[k].disabled = false;
			}
		}
	});
	
	/*
	 * 	点击 重置 按钮后，保存 和 提交 按钮被禁用
	 */
	$("#reset").click(function(){
		var objBtn = document.getElementsByName("btn");
		var btnLen = objBtn.length;
		for(var t=0;t<btnLen;t++){
			objBtn[t].disabled = true;
		}
	});
	
	/*
	 *	原始项目登记 initialTable（完成）
	 *	若项目类别选择“基础建设类”，则此处自动选择项为“比选/自建”；
	 *	若项目类别选择“公共服务类”，则此处自动选择项为“竞岗/直接实施”。
	 */
	$("#ITClass").change(function(){		
		var strITClass = $("#ITClass option:selected").val();
		var objITDoWay = document.getElementById("ITDoWay");
		objITDoWay.value = strITClass;			
	});
	
	
	/*
	 * 	原始项目表决 initialVoteTable 
	 * 	人数的判断（前台 or 后台）
	 */
	
	
	/*
	 * 	初选项目实施计划及资金预算情况 budgetTable 
	 * 	“自有资金”、“融资情况”、“其他”根据实际情况选择“是/否”
	 *	若选择“否”则后续填写金额栏不呈现填写状态，若选择“是”则完成填写后续栏目
	 *	$(":input:radio")--$("form :input")--important
	 *	case后的字符串只能用‘’，不能用“”
	 */
	/*	判定是否隐藏；显示后由于可填写，所以需要对text进行清空	*/
	function YNCheck(is,name){
		if(is == "yes"){					
			$(".yes"+name).show(500);
		}else if(is == "no"){
			$("#Input"+name).val("");
			$(".yes"+name).hide(500);			
		}
	}
	
	$(":input:radio").click(function(){
		var id = this.id;
		var tmpId = id.split("_");
/*
		for(var i=0;i<3;i++){
			YNCheck(tmpId[0],tmpId[1]);
		} //也可实现效果，但个人感觉这样不好，因为每点击一次就会触发三次，个人感觉下面效率更高
*/
		switch(tmpId[1]){  //判定是三个单选中的哪一个
			case 'selfMoney':				//初选项目实施计划及资金预算情况 budgetTable
				YNCheck(tmpId[0],tmpId[1]);
				break;
			case 'getMoney':				//初选项目实施计划及资金预算情况 budgetTable
				YNCheck(tmpId[0],tmpId[1]);
				break;
			case 'otherMoney':				//初选项目实施计划及资金预算情况 budgetTable
				YNCheck(tmpId[0],tmpId[1]);
				break;
			case 'modify':					//初选项目议事会修改完善情况modifyTable
				YNCheck(tmpId[0],tmpId[1]);
				break;
		}
	});
	
	
	/*
	 * 	实施项目经费使用监督检查情况 moneyCheckTable
	 * 	
	 */	
	var trNo = 4;
	$("#btnAdd").click(function(){
		//alert("ok");
		var newTR = document.getElementById("addInfo").insertRow(document.getElementById("addInfo").rows.length);
		var newNoTD = newTR.insertCell(0);
		newNoTD.innerHTML = "<span>" + trNo + "</span>";
		var newTimeTD = newTR.insertCell(1);
		newTimeTD.innerHTML = "<input name='time' type='text' class='addInput' />";
		var newUsedTD = newTR.insertCell(2);
		newUsedTD.innerHTML = "<input name='used' type='text' class='addInput'   />";
		var newLastTD = newTR.insertCell(3);
		newLastTD.innerHTML = "<input name='last' type='text' class='addInput'    />";
		trNo ++;
	});
		    	
});

/*
 * 	首页
 */

/*
 * 	for banner
 */

/*
 *	1.$(selector).text(content);
 *	2.$(selector).fadeOut(speed, callback);
 *	3.$(selector).fadeIn();
 *	4.setTimeout():只执行一次；setInterval():循环执行；
*/

$(document).ready(function(){
	var timer;
    var picLength= $(".img_list li img").length;
    var index=0;
    var title=["夏天","成都美食攻略","春意","春意","美食"];
    var $content=title[index];
    $("#mask h1").text($content);
    function switchPic(){
		$(".img_list li img").eq(index).fadeOut();
        $(".img_list li img").eq(index+1).fadeIn();
        $("#img_page li").eq(index).css({ "background-color":"#094c06"});
        $("#img_page li").eq(index+1).css({"background-color":"#41c266"});//表示对应的图片下的小点
        index++;
        if(index==picLength){
            index=0;
            $(".img_list li img").eq(0).fadeIn();
            $("#img_page li").eq(0).css({ "background-color":"#41c266"});
        }
        $content=title[index];
        //console.log(index);//不懂唉~？
        $("#mask h1").text($content);
    };
			
    $(".img_list li img").eq(0).show(); //控制页面加载完成后，第一张图片的展示;
    $("#img_page li").eq(0).css({ "background-color":"#41c266"});
			
    $("#img_page li").mouseover(function(){
		index=$(this).index(); //index()方法返回指定元素相对于其他指定元素的 index 位置;$(selector).index()
        $(".img_list li img").hide(); //隐藏所有图片
        $(".img_list").find("img").eq(index).fadeIn();
		$("#img_page li").css({ "background-color":"#094c06"});
        $("#img_page li").eq(index).css({ "background-color":"#41c266"});
        $("#mask h1").text(title[index]);
    });
			
    $("#banner").hover(function(){
		clearInterval(timer);
    },function(){
        timer=setInterval(switchPic,2000);
	});
			
	$("#prev").click(function(){
		if(index==0){index=picLength;}
        $(".img_list li img").hide();
		$(".img_list").find("img").eq(index-1).fadeIn();//find();
		$("#img_page li").css({ "background-color":"#094c06"});
		$("#img_page li").eq(index-1).css({ "background-color":"#41c266"});
		var $content=title[index-1];
		$("#mask h1").text($content);
        index--;
	});
    $("#next").click(function(){
        $(".img_list li img").hide();
		$(".img_list").find("img").eq(index+1).fadeIn();
		$("#img_page li").css({ "background-color":"#094c06"});
		$("#img_page li").eq(index+1).css({ "background-color":"#41c266"});
		index++;
		if(index==picLength){
            index=0;
			$(".img_list li img").eq(0).fadeIn();
			$("#img_page li").eq(0).css({ "background-color":"#41c266"});
        }
        var $content=title[index];
		$("#mask h1").text($content);
    });
	
    timer=setInterval(switchPic,2000);
});

/*
 * 	街道下拉效果
 */

$(document).ready(function(){
	$(".tr_td").hover(function(e){
    	var ID = this.id;
    	$div1 = $("#"+ID);
    	$div2 = $("#info_"+ID);
    	$div2.stop();
    	$div2.slideDown(500);
    }, function(e){
    	if(!isOrContains($div2, e.relatedTarget)){
    		$div2.stop();
    		$div2.slideUp(500);
        }
    });
    $(".everyTrInfo").bind("mouseleave", function(e){    	
    	if(!isOrContains($div1, e.relatedTarget)){
    		$(this).slideUp(500);
        }
    });
    function isOrContains(elem1, elem2){
    	var $elem1 = elem1.jQuery ? elem1 : $(elem1);
        var $elem2 = elem2.jQuery ? elem2 : $(elem2);
        return ($elem1.is($elem2) || $elem1.has($elem2).length !== 0) ? true : false;
    }
  
});


/*
 * 	text中的value的隐藏域显示
 */
$(document).ready(function(){
	$(".searchTxt").focus(function(){
    	with (event.srcElement)
        if (value == defaultValue) value = "";		
	}).blur(function(){
    	with (event.srcElement)
        if (value == "") value = defaultValue;    /* 实现文本框中的value的显示和消失 */
	});
});