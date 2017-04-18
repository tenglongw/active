$(function() {
	// body...

	function GetMyPerformance() {
		// body...
		$.ajax({
			url: SeverIp+'getExamInfo?openid='+openId,
			type: 'GET',
			dataType: 'JSON',
		})
		.done(function(data) {
			console.log("success");
			console.log(data);
			if (data.status == 1) {
				addAnswerList(data.data.questionList);
				SetMyAnswer(data.data.userRate);

			}
		})
		.fail(function() {
			console.log("error");
		})
		.always(function() {
			console.log("complete");
		});
		
	}
	GetMyPerformance()


	function SetMyAnswer(data) {
		var SetMyAnswer = $('#SetMyAnswer');
		var html = '<P class="test_num"><span>考生：</span><i>'+data.userName+'</i></P>'+
            '<P class="test_num"><span>产妇护理</span><i>'+UserRate[parseInt(data.puerperaNurse)]+'</i></P>'+
            '<P class="test_num"><span>婴幼儿护理</span><i>'+UserRate[parseInt(data.infantNurse)]+'</i></P>'+
            '<P class="test_num"><span>营养知识</span><i>'+UserRate[parseInt(data.nutrition)]+'</i></P>'+
            '<P class="test_num"><span>新生儿护理</span><i>'+UserRate[parseInt(data.newbornNurse)]+'</i></P>'+
            '<P class="test_num"><span>催乳知识</span><i>'+UserRate[parseInt(data.lactagogue)]+'</i></P>'+
            '<div class="clear"></div>';
            SetMyAnswer.html(html);
	}


	function addAnswerList(data) {
	 	var html = '';
	 	var Con = $('#addAnswerList');
	 	for (var i = 0; i < data.length; i++) {
	 		html += '<li data-name="question">'+
			            '<P class="dati_p1"><span>【试题'+(i+1)+'】</span>'+data[i].name+'</P>'+
			            '<div class="clear"></div>'+
			            '<div class="dati_d1">'+ AnswerList(data[i].qAnswers,data[i].isAnswerCorrect,data[i].answerId)+'</div>'+
			        '</li>';
	 	}
	 	Con.html(html);
	 	function AnswerList(AnswerList,isAnswerCorrect,answerId) {
	 		var html = '';
	 		for (var i = 0; i < AnswerList.length; i++) {
	 			html += '<P class="dati_p2 '+isUsveTrue(AnswerList[i].id,answerId)+'"><label><i>'+AnswerList[i].option+'</i><span>'+AnswerList[i].name+'</span></label>'+isSystemTrue(AnswerList[i].isCorrect ,isAnswerCorrect)+'</P>';
	 		}
	 		return html;
	 		function isUsveTrue(UsveTrue,answerId){
	 			if (UsveTrue == answerId) {
	 				return 'curr';
	 			}else{
	 				return ' ';
	 			}
	 		}
	 		function isSystemTrue(SystemTrue,isAnswerCorrect){
	 			if (isAnswerCorrect != 'Y') {
	 				if (SystemTrue == 'Y') {
		 				return '<span class="rig">正确答案</span>';
		 			}else{
		 				return ' ';
		 			}
	 			}else{
					return ' ';
	 			}
	 		}
	 	}
	 } 
})