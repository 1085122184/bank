
function PDA_download() {
    open('http://www.cmbchina.com/PDAbank/PDADownload.htm', 'PDAWin', 'menubar=no,toolbar=no,location=no,directories=no,scrollbars=no,status=no,resizable=no,top=0,left=100,width=266,height=441');
}

function hbwindows() {
    open('https://pbsz.ebank.cmbchina.com/CmbBank_GenShell/UI/GenShellPC/Login/Login.aspx', 'newhb', 'menubar=no,toolbar=no,location=no,directories=no,scrollbars=yes,status=yes,resizable=yes');
}

function ifinwindows() {
    open('https://pbsz.ebank.cmbchina.com/CmbBank_GenShell/UI/GenShellPC/NetBankAcc/Login.aspx', 'newifin', 'menubar=no,toolbar=no,location=no,directories=no,scrollbars=yes,status=yes,resizable=yes');
}

function creditcardlogin() {
    open('https://pbsz.ebank.cmbchina.com/CmbBank_GenShell/UI/GenShellPC/Login/Login.aspx?LoginType=C', 'creditcard', 'menubar=no,toolbar=no,location=no,directories=no,scrollbars=yes,status=yes,resizable=yes');
}

function EWallet() {
    open('http://www.cmbchina.com/cmbpb/v36/pb.htm', 'EWallet', 'menubar=no,toolbar=no,location=no,directories=no,status=yes,resizable=no,scrollbars=no,width=600,height=400,top=60,left=100');
}


function OpenFirm() {
    open('https://ebank.sz1.cmbchina.com/EB10/EBServer?Command=5001&ClientID=0&PRID=LOGINPREVIEW', 'NewWindow', 'menubar=no,toolbar=no,location=no,directories=no,status=yes,scrollbars=0,resizable=0');
}
 
function applySchedule() {
    open('https://pbsz.ebank.cmbchina.com/CmbBank_CreditCard/UI/CreditCardPC/CreditCard/na_QuerySchedule.aspx', 'Schedule', 'menubar=no,toolbar=no,location=no,directories=no,scrollbars=yes,status=yes,resizable=yes');
}

function EnforceCardProtocol() {
    open('https://pbsz.ebank.cmbchina.com/CmbBank_CreditCard/UI/CreditCardPC/CreditCard/cs_ProOfActivate.aspx', 'EnforceCardProtocol', 'menubar=no,toolbar=no,location=no,directories=no,scrollbars=yes,status=yes,resizable=yes');
}

function OpenAllinonecardApply() {
    open('https://pbsz.ebank.cmbchina.com/CmbBank_PB/UI/PBPC/DebitCard_CustomerService/cs_TotalTaskOpenAccNoLoginPro1.aspx', 'NewWindow', 'menubar=no,toolbar=no,location=no,directories=no,status=yes,scrollbars=0,resizable=0,width=850,height=530');
}

function OpenAllinonecardQuery(){
    open('https://pbsz.ebank.cmbchina.com/CmbBank_PB/UI/PBPC/DebitCard_CustomerService/cs_TotalTaskSMSValidation.aspx', 'NewWindow', 'menubar=no,toolbar=no,location=no,directories=no,status=yes,scrollbars=0,resizable=0,width=850,height=530');
}

//ICS 
var icsWnd = null;
var switchWnd = null;
function fLoginICS() {
    var nWinLeft = (screen.width - 600) / 2;
    var nWinTop = (screen.height - 400) / 2;
    if (icsWnd != null)
        icsWnd.close();
    icsWnd = window.open('https://link.cmbchina.com/onlineservice/onlineservice.ashx');
}