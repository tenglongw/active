$(function(){

	var topicList = $('#topicList');

	var SubmitAnswerBot = $('#SubmitAnswerBot');





	/*题目选中*/
	function topicActive() {
		$('.dati_p2').click(function(e) {
			$(this).addClass('curr').siblings().removeClass('curr');
			$(this).parents('li').attr('data-active','yes');

		});

	}

	// topicActive();


	/*ul高度*/
	function UlHeightFun() {
		var WinHeight=$(window).height();
		$('.dati').height(WinHeight-266);

	}
	UlHeightFun()

	/*弹框*/
	function pop_upFun() {
		$('.know').click(function(e) {
			$(this).parents('.fixed').hide();
		});
	}
	pop_upFun();



//   从服务器获取到的题库
	function GetTopicAjaxFun() {
		$.ajax({
			url: SeverIp+'getExamQuestion',
			type: 'GET',
			dataType: 'JSON',
		})
		.done(function(data) {
			console.log("success");
			console.log(data);
			if (data.status) {
				addTopicFUn(data.data);
			}
			
		})
		.fail(function() {
			console.log("error");
		})
		.always(function() {
			console.log("complete");
		});
	}


GetTopicAjaxFun() ;

//   从服务器获取到的题库 end


//  添加题库到列表

	function addTopicFUn(data) {
		var Con = $('#topicList');
		var html = '';

		for (var i = 0; i < data.length; i++) {
			html += ' <li data-id="'+data[i].id+'" data-type="'+data[i].questionTypeId+'">'+
			'<P class="dati_p1"><span>【试题'+(i+1)+'】</span>'+data[i].name+'</P>'+
			'<div class="clear"></div>'+
			'<div class="dati_d1">'+addTopicListFun(data[i].qAnswers,data[i].id)+' </div>'+
			'</li>';

		}

		Con.html(html);
		topicActive();


		function addTopicListFun(qAnswers,topicID){
			var numerical = ['A','B','C','D','E']
			var html = ''

			if (qAnswers) {
				for (var i = 0; i < qAnswers.length; i++) {
					html += '<P class="dati_p2"><label><input name="topicID'+topicID+'" value="'+qAnswers[i].option+'" data-id="'+qAnswers[i].id+'" data-Correct="'+qAnswers[i].isCorrect+'" type="radio"><i>'+qAnswers[i].option+'</i><span>'+qAnswers[i].name+'</span></label></P>'
				}

				return html;
			}



		}

	}

//  添加题库到列表 end




	// 获取答案
	function GetTheAnswer(userName,userPhone) {
		var topicLi  = topicList.find('li');
		GoSeverAnswerData.ScoringDbject.userName = userName;
		GoSeverAnswerData.ScoringDbject.phone = userPhone;
		GoSeverAnswerData.ScoringDbject.openid = openId;


		for (var i = 0; i < topicLi.length; i++) {
			var Answers = IsAnswer(topicLi.eq(i));
			GoSeverAnswerData.Answer.push({
				questionId: topicLi.eq(i).attr('data-id'),
				questionTypeId: topicLi.eq(i).attr('data-type'),
				value: Answers.id,
				questionAnswserOption: Answers.Answer,
				isCorrect: Answers.isCorrect,
				openid:openId
			})
		}

		// console.log(GoSeverAnswerData);
		ScoringDbjectFun(GoSeverAnswerData.Answer);




		function IsAnswer(list) {
			// body...
			
			var inputs = list.find('input');
			var ind = false;
			var id = false;
			var isCorrect = 'N';
			for (var i = 0; i < inputs.length; i++) {
				if (inputs[i].checked) {
					// console.log(true);
					 console.log($(inputs[i]).val());
					ind = $(inputs[i]).val();
					id = $(inputs[i]).attr('data-id');

					if ($(inputs[i]).attr('data-correct') == 'Y') {
						isCorrect = 'Y';
					}else{
						isCorrect = 'N';
					}

				}
			}
			return {Answer:ind,id:id,isCorrect};

		}

		
	}


	// 提交答案 


	// 分数计算

	function ScoringDbjectFun(data) {
		var gratet = ['infantNurse','puerperaNurse','newbornNurse','lactagogue','nutrition']
		for (var i = 0; i < data.length; i++) {
			if (data[i].isCorrect == 'Y'){

				GoSeverAnswerData.ScoringDbject[gratet[parseInt(data[i].questionTypeId)-1]]++;
			}
		}

		console.log(GoSeverAnswerData);

		SubmitTheAnswer(GoSeverAnswerData);

	}

	// SubmitTheAnswer

	function SubmitTheAnswer(GoSeverAnswerData) {
		$.ajax({
			url: SeverIp+'saveExamQuestion',
			type: 'POST',
			dataType: 'JSON',
			contentType:'application/json;charset=UTF-8',
			data: JSON.stringify(GoSeverAnswerData)
		})
		.done(function() {
			console.log("success");
		})
		.fail(function(e) {
			console.log("error");
			console.log(e);
		})
		.always(function() {
			console.log("complete");
		});
		
	}





  SubmitAnswerBot.click(function(event) {
  	/* Act on the event */
  	GoSeverAnswerData.Answer = [];

  	var userName = $('#userName').val();
  	var userPhone =  $('#userPhone').val();
  	var AnswerLength = topicList.find('li[data-active=yes]');
  	console.log(userName.length)
  	console.log(userPhone.length)

  	if (userName.length < 2 ) {
  		AlertConFun('请正确填写的姓名！')
  		return ;
  	}else if (userPhone.length < 11) {
  		$('#userPhone').val('');

  		AlertConFun('请正确填写的手机号码！')
  		return ;
  	}else if ( AnswerLength.length <10) {
  		AlertConFun('答题数量不得少于10题！')
  		return ;
  	}else{
  		GetTheAnswer(userName,userPhone);
  	}

  	// if (userName.length >= 2 && userName != '' && userPhone.length == 11 && userPhone != ''&& AnswerLength.length >=10) {

  	// 	GetTheAnswer(userName,userPhone);

  	// }else{
  	// 	AlertConFun('不能提交')
  	// }


  });




	// 提交答案 ，获取答案 end


})
