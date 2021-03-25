function AutoDivHeight(left, right) {
    if (left != null && right != null) {
        if (left.clientHeight < right.clientHeight) {
            left.style.minHeight = right.clientHeight + "px";
            if(window.ActiveXObject) 
            {
                var browser=navigator.appName 
                var b_version=navigator.appVersion 
                var version=b_version.split(";"); 
                var trim_Version=version[1].replace(/[ ]/g,""); 
                if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE6.0") 
                {
                  left.style.height = right.clientHeight + "px";
                }
            }
            else{
                             left.style.minHeight = right.clientHeight + "px";
            }
        }
        else {
            right.style.height = left.clientHeight + "px";
        }
    }
}

function openCont(URL) {
    window.open(URL, '', 'menubar=no,toolbar=no,location=no,directories=no,status=no,resizable=yes,scrollbars=yes,width=640,height=410,top=100,left=40');
}

function getQuery(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
}

function createXMLHttp()
{
    if(window.ActiveXObject)
    {
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
    else if(window.XMLHttpRequest)
    {
        return new XMLHttpRequest();
    }
}


function showShopCity(selecteditem)
{
    try
    {
	var xmlhttp = createXMLHttp();
	xmlhttp.open("GET", "/Common/ajaxinfo.aspx?type=area&r="+Math.random(), false);
	xmlhttp.send(null);			
	var strRtn = xmlhttp.responseText;					
	var strAry = strRtn.split(";");
	document.write("<select class='kuang' id='DropCity' name='select' onchange='getsftype();'>");
	document.write("<option value='' selected>所在城市</option>");
    for (i = 0; i < strAry.length - 1; i++)
    {    
        if(strAry[i] != selecteditem)                		
	        document.write("<OPTION value='"+strAry[i]+"'>"+strAry[i]+"</OPTION>");	
	    else
	        document.write("<OPTION value='"+strAry[i]+"' selected='selected'>"+strAry[i]+"</OPTION>");		 	
    }
	
	document.write("</select>");
	}
	catch(e)
	{
	}
}


function getsftype(selectedItem)
{
    try
    {
    var city = document.getElementById("DropCity");
    
    var select = document.getElementById("DropType");
	while (select.options.length)
	{
		select.remove(0);
	}
	var topoption  = new Option('商户类别','');
	select.options.add(topoption);
	
    if(city.value == '')
      return;
      
	var xmlhttp = createXMLHttp();
	xmlhttp.open("GET", "/Common/ajaxinfo.aspx?type=shoptype&city=" + encodeURI(city.value) + "&r=" + Math.random(), false);
	xmlhttp.send(null);
	var strRtn = xmlhttp.responseText;					
	var strAry = strRtn.split(";");
	
	for (i = 0; i < strAry.length - 1; i++)
	{
		var oOption  = new Option(strAry[i],strAry[i]);
		select.options.add(oOption);
		if(selectedItem == oOption.value)
		   oOption.setAttribute("selected","selected");
	}
	}
	catch(e)
	{
	}
}


function getShopInfo()
{
	var city = document.getElementById("DropCity").value;
	var type = document.getElementById("DropType").value;
	var url = "/Personal/Sunflower/SunflowerShopDetail.aspx?city="+escape(city)+"&type="+escape(type);
	open(url);
}

function getSunfInfo()
{
	var city = document.getElementById("DropCity").value;
	var type = document.getElementById("DropType").value;
	var url = "/Personal/Sunflower/SunflowerShopDetail.aspx?city="+escape(city)+"&type="+escape(type);
	location.href = url;
}

/*城市列表函数开始*/
function showCityList(element)
{   	
    var CityDiv = document.getElementById("CityDiv");
    
	CityDiv.style.display = 'block';         	
	var offsetTop = element.offsetTop; 
    var offsetLeft = element.offsetLeft; 
    var offsetWidth = element.offsetWidth; 
    var offsetHeight = element.offsetHeight; 
    while( element = element.offsetParent ) 
    { 
        offsetTop += element.offsetTop; 
        offsetLeft += element.offsetLeft; 
    }         
   if(identifyBrowser != "ie")
   {
    CityDiv.style.left = (offsetLeft-222) + "px";
	CityDiv.style.top = (offsetTop+15) + "px";
   }
   else{
   CityDiv.style.left = offsetLeft-222;
	CityDiv.style.top = offsetTop+15;
   }
	
	var IfrShadow = document.getElementById("IfrShadow");
    IfrShadow.style.width = CityDiv.offsetWidth;
    IfrShadow.style.height = CityDiv.offsetHeight;
    IfrShadow.style.top = CityDiv.style.top;
    IfrShadow.style.left = CityDiv.style.left;
    IfrShadow.style.zIndex = 999;
    IfrShadow.style.display = 'block';
}

function hideCityList()
{
    var CityDiv = document.getElementById("CityDiv");
	CityDiv.style.display = 'none';
	var IfrShadow = document.getElementById("IfrShadow");
	IfrShadow.style.display='none';
}

function ShowCityDiv()
{
    var CityDiv = document.getElementById("CityDiv");
    CityDiv.style.display='block';
    var IfrShadow = document.getElementById("IfrShadow");
    IfrShadow.style.display='block';
}

var identifyBrowser=function()
{
var cBrowser;
if (window.navigator.userAgent.indexOf("Safari")>=0 && navigator.userAgent.toLowerCase().indexOf("version") >= 0)
{
cBrowser = "safari";
} else if (window.navigator.userAgent.indexOf("Chrome")>=0) {
    cBrowser = "chrome";
} else if (navigator.userAgent.toLowerCase().indexOf('msie')>=0) {
    cBrowser = "ie";
} else if (navigator.userAgent.toLowerCase().indexOf('firefox')>=0) {
    cBrowser = "firefox"; 
} else if (navigator.userAgent.toLowerCase().indexOf('opera')>=0) {
    cBrowser = "opera";
} 
return cBrowser;
}


/*城市列表函数结束*/

function ShowPageInfo(url,width,height) {
    ShowWin(url,width,height);
}

function ShowPageInfoNew(name, url, width, height) {
    layer.open({
        type: 2,
        title: name,
        maxmin: true, //是否允许最小最大化
        shadeClose: false, //点击遮罩不关闭层
        area: [width+'px', height+'px'],
        content: url
    });
}

/**********************
*弹出层的网页
**********************/
function ShowWin(url,width,height) {
    //var eSrc = (document.all) ? window.event.srcElement : arguments[1];
    var shield = document.createElement("DIV");
    shield.id = "shield";
    shield.style.position = "absolute";
    shield.style.left = "0px";
    shield.style.top = "0px";
    shield.style.width = document.body.clientWidth + "px"; //"100%";

    shield.style.height = document.body.scrollHeight+"px";
    shield.style.background = "#333";
    shield.style.textAlign = "center";
    shield.style.zIndex = "10000";
    shield.style.filter = "alpha(opacity=50)";
    shield.style.opacity = 0.5;
    var alertFram = document.createElement("DIV");
    alertFram.id = "alertFram";
    alertFram.style.position = "absolute";
    alertFram.style.left = (document.body.clientWidth - width) / 2 + "px";
    alertFram.style.top = "20%";
    alertFram.style.marginLeft = "-0px";
    var scrollTop = GetScrollTop();
    alertFram.style.marginTop = -45 + scrollTop + "px";
    alertFram.style.width = width + "px";
    alertFram.style.height = height + "px";
    alertFram.style.background = "#ccc";
    alertFram.style.textAlign = "center";
    alertFram.style.lineHeight = "90%";
    alertFram.style.zIndex = "10001";
    strHtml = "<ul style=\"list-style:none;margin:0px;padding:0px;width:100%\">\n";
    strHtml += " <li style=\"background:#D3D3D3;text-align:left;padding-left:20px;margin:0;padding:0;font-size:14px;font-weight:bold;height:25px;line-height:25px;border:1px solid #A40B06;\"><span style=\"float:left;margin-left:8px;\"><FONT color=\"#fff\"></FONT></span>\n";
    strHtml += " <span style=\"height:25px;line-height:25px;float:right;margin-right:8px;margin-top:3px;\"><input style=\"border:1px solid #666;cursor:pointer;\" type=\"button\" value=\" X \" id=\"do_OK\" onclick=\"doOk()\" /></span></li>\n";
    strHtml += " <li style=\"background:#fff;text-align:center;font-size:14px;border:1px solid #A40B06;border-top:none;margin:0;padding:0;\"><iframe height=500px width=100% scrolling=\"auto\" frameborder=\"0\" marginheight=\"0\" marginwidth=\"0\" src=" + url + "></iframe></li>\n";
     strHtml += "</ul>\n";
    alertFram.innerHTML = strHtml;
    document.body.appendChild(alertFram);
    document.body.appendChild(shield);
 
    this.doOk = function() {
        //alertFram.style.display = "none";
        //shield.style.display = "none";
        document.body.removeChild(alertFram);
        document.body.removeChild(shield);
        //eSrc.focus();
        document.body.onselectstart = function() { return true; }
        document.body.oncontextmenu = function() { return true; }
    }

    //eSrc.blur();
    document.body.onselectstart = function() { return false; }
    document.body.oncontextmenu = function() { return false; }
    window.onscroll = function() {
        setTimeout(function() {
        if (document.getElementById("alertFram")) {
            var scrollTop = GetScrollTop();
            document.getElementById("alertFram").style.marginTop = -45 + scrollTop + "px";
            }
        }, 50);
    }
}

function GetScrollTop() {
    return ie ? IeTrueBody().scrollTop : window.pageYOffset;
}

var w3c = (document.getElementById) ? true : false;
var agt = navigator.userAgent.toLowerCase();
var ie = ((agt.indexOf("msie") != -1) && (agt.indexOf("opera") == -1) && (agt.indexOf("omniweb") == -1));
function IeTrueBody() {
    return (document.compatMode && document.compatMode != "BackCompat") ? document.documentElement : document.body;
}
