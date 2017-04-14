$(function(){
	/*题目选中*/
	$('.dati_p2').click(function(e) {
		$(this).addClass('curr').siblings().removeClass('curr');
	});
	
	/*ul高度*/
	var h=$(window).height();
	$('.dati').height(h-266);
	
	/*弹框*/
	$('.know').click(function(e) {
		$(this).parents('.fixed').hide();
	});
	
	
	/*循环获取值*/
	$('.dati li').each(function(index, element) {
	    var checked = [];
		$(this).find('.dati_p2').click(function(){
			checked.push($(this).find("input:radio:checked").val());
			console.log(checked);
		});   
	});
	
})
