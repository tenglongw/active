// 服务器IP地址
var SeverIp = 'http://192.168.1.100:8080/active/exam/';

// 从服务器获取到的题库
var SeverTopicData = null;
var openId = 'yangyue';

// 用户评级
var UserRate = ['差','差','较差','一般','良','优秀']

// 提交到服务器的答案
var GoSeverAnswerData = {
	Answer:[],
	ScoringDbject:{
		infantNurse:0,
		puerperaNurse:0,
		newbornNurse:0,
		lactagogue:0,
		nutrition:0,
	}
};


// 题库类型
var  AnswerType = {
	1:'婴幼儿护理',
	2:'产妇护理',
	3:'新生儿护理',
	4:'催乳',
	5:'营养',
}





function AddAlertCon() {
	$('body').append('<div id="AlertCon"><span></span></div>');
	$('#myPerformanceCon').load('popUpWindows.html');
}

AddAlertCon();

function AlertConFun(string) {
	$('#AlertCon').find('span').text(string);
	$('#AlertCon').show();

	setTimeout(function() {
		$('#AlertCon').hide();
	},2000)

}


// AlertConFun('yangyue');