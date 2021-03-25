function CmbSearch(sSearchWord, sfromweb) {
    if (sSearchWord == '' || sSearchWord == null || sSearchWord.trim() == "") {
        alert("关键词不能为空");
        return false
    }
    else if (sSearchWord.length > 50) {
        alert("您输入的检索词超过最大长度50！");
        return false;
    }
    else {
        searchTrack();
        var searchwordwhere = sSearchWord.trim().trssearch().replaceteshustr();
        /*记录搜索关键字*/
        try {
            personalreco.RecordSearchhistoryInSide(searchwordwhere);
        }
        catch (ex) {
        }
        
        if (searchwordwhere == "" || searchwordwhere == null) {
            alert("抱歉，您输入的内容不在查询范围内！");
            return false;
        }
        else if (null != sfromweb && "" != sfromweb) {
            window.open('http://sou.cmbchina.com/search?s=main&q=' + encodeURI(searchwordwhere));
        }
        else {
            window.open('http://sou.cmbchina.com/search?s=main&q=' + encodeURI(searchwordwhere));
        }
    }

}
    
    
 String.prototype.trim = function()
{
    return this.replace(/(^[\s]*)|([\s]*$)/g, "");
}
String.prototype.trssearch = function()
{
    return this.replace(/\s+/g, "+");
}

String.prototype.replaceteshustr = function()
{
    return this.replace(/[@#\$%\^&\*!~'(（\-\/%.。，,?+]+/g, "");
}

function searchTrack()
{
    var objecturl = location.href;
	var columnname = gI18n?dcsEscape(dcsEncode("搜索"),I18NRE):"搜索";
	var okeyword = document.getElementById("SearchWord").value;
	var objectname = gI18n?dcsEscape(dcsEncode(okeyword),I18NRE):okeyword;
	var objecttype = gI18n?dcsEscape(dcsEncode("按钮链接"),I18NRE):"按钮链接";;
	var pagetitle = gI18n?dcsEscape(dcsEncode(document.title),I18NRE):document.title;
	var ip = window.location.hostname;
	var click = 'click';
	
    dcsMultiTrack('DCS.dcssip',ip,'DCS.dcsuri',objecturl,'WT.ti',objectname,'DCSext.wt_click',click, 'DCSext.wt_cname', columnname, 'DCSext.wt_otype', objecttype, 'DCSext.wt.domain', ip, 'DCSext.wt_ptitle', pagetitle);						
}
