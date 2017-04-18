$(function() {
	// body...

	function TestAndSistersAjaxFun(){
		$.ajax({
			url: SeverIp+'getSistersRate?openid='+openId,
			type: 'GET',
			dataType: 'JSON',
		})
		.done(function(data) {
			console.log("success");
			console.log(data);
			if (data.status == 1) {
				SetMtinfo(data.data);
				addTestAuntFun(data.data.userRateList)

			}
		})
		.fail(function() {
			console.log("error");
		})
		.always(function() {
			console.log("complete");
		});
	}

	TestAndSistersAjaxFun();


	function SetMtinfo(data){
		var html = '<P class="test_tit">你成功邀请'+data.total+'位姐妹</P><P class="test_num"><span>排名：</span><i>'+data.ranking+'</i></P>'
		$('#MyPaiMing').html(html);
	}


	function addTestAuntFun(data){
		var html ='';
		for (var i = 0; i < data.length; i++) {
			html += '<li>'+
			        	'<P class="test_num"><span>姐妹：</span><i>'+data[i].userName+'</i></P>'+
			            '<P class="test_num"><span>产妇护理</span><i>'+UserRate[parseInt(data[i].puerperaNurse)]+'</i></P>'+
			            '<P class="test_num"><span>婴幼儿护理</span><i>'+UserRate[parseInt(data[i].infantNurse)]+'</i></P>'+
			            '<P class="test_num"><span>营养知识</span><i>'+UserRate[parseInt(data[i].nutrition)]+'</i></P>'+
			            '<P class="test_num"><span>新生儿护理</span><i>'+UserRate[parseInt(data[i].newbornNurse)]+'</i></P>'+
			            '<P class="test_num"><span>催乳知识</span><i>'+UserRate[parseInt(data[i].lactagogue)]+'</i></P>'+
			            '<div class="clear"></div>'+
			        '</li>';
		}
		$('#testAunt').html(html);

	}
})