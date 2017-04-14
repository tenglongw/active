// JavaScript Document
/*
 * loadmore.js
 * 加载更多
 *
 * @time 2016-4-18 17:40:25
 * @author 飞鸿影~
 * @email jiancaigege@163.com
 * 可以传的参数默认有：size,scroll 可以自定义
 * */

;(function(w,$){
    
    var loadmore = { 
        /*单页加载更多 通用方法
         * 
         * @param callback 回调方法
         * @param config 自定义参数
         * */
        get : function(callback, config){
            var config = config ? config : {}; /*防止未传参数报错*/

            var counter = 0; /*计数器*/
            var pageStart = 0;
            var pageSize = config.size ? config.size : 10;

            /*默认通过点击加载更多*/
            $(document).on('click', '.query_more', function(){
                counter ++;
                pageStart = counter * pageSize;
                
                callback && callback(config, pageStart, pageSize);
            });
            
            /*通过自动监听滚动事件加载更多,可选支持*/
            config.isEnd = false; /*结束标志*/
            config.isAjax = false; /*防止滚动过快，服务端没来得及响应造成多次请求*/
            $(window).scroll(function(){
                
                /*是否开启滚动加载*/
                if(!config.scroll){
                    return;
                }
                
                /*滚动加载时如果已经没有更多的数据了、正在发生请求时，不能继续进行*/
                if(config.isEnd == true || config.isAjax == true){
                    return;
                }
                
                /*当滚动到最底部以上100像素时， 加载新内容*/
                if ($(document).height() - $(this).scrollTop() - $(this).height()<100){
                    counter ++;
                    pageStart = counter * pageSize;
                    
                    callback && callback(config, pageStart, pageSize);
                }
            });

            /*第一次自动加载*/
            callback && callback(config, pageStart, pageSize);
        },
            
    }

    $.loadmore = loadmore;
})(window, window.jQuery || window.Zepto);

$.loadmore.get(getData, {
    scroll: true,  //默认是false,是否支持滚动加载
    size:7,  //默认是10
    flag: 1, //自定义参数，可选，示例里没有用到
});

function getData(config, offset,size){

    config.isAjax = true;
    $.ajax({
        type: 'GET',
        url: '../json/blog.xml',
        dataType: 'json',
        success: function(reponse){
        
            config.isAjax = false;

            var data = reponse.list;
            var sum = reponse.list.length;
            
            var result = '';
            
            /************业务逻辑块：实现拼接html内容并append到页面*****************/
            
            //console.log(offset , size, sum);
            
            /*如果剩下的记录数不够分页，就让分页数取剩下的记录数
            * 例如分页数是5，只剩2条，则只取2条
            *
            * 实际MySQL查询时不写这个
            */
            if(sum - offset < size ){
                size = sum - offset;
            }

            
            /*使用for循环模拟SQL里的limit(offset,size)*/
            for(var i=offset; i< (offset+size); i++){
                result +='<div class="weui_media_box weui_media_text">'+
                        '<a href="'+ data[i].url +'" target="_blank"><h4 class="weui_media_title">'+ data[i].title +'</h4></a>'+
                        '<p class="weui_media_desc">'+ data[i].desc +'</p>'+
                    '</div>';
            }

            $('.js-blog-list').append(result);
            
            /*******************************************/
            
            /*隐藏more*/
            if ( (offset + size) >= sum){
                $(".js-load-more").hide();
                config.isEnd = true; /*停止滚动加载请求*/
                //提示没有了
            }else{
                $(".js-load-more").show();
            }
        },
        error: function(xhr, type){
            alert('Ajax error!');
        }
    });
}