var mapSrc =" http://api.map.baidu.com/api?v=2.0&ak=v8dTyTptogWwr2X1ITAifANYHLfrABTL";

// 组织机构的接口
var organize = '';
function get_organize(){
    /*$.get('/manage/home/getData/get',{"action":"/auth/organization/queryAll"}, function(res){
        if(res.error){
            return;
        } else {
            organize = res.data;
            console.log('获取组织结构',organize);
        }
    }, 'json').done(function(){
        add_organize();
    });*/
}

// 添加组织结构  向#menuTree 添加结构树
function add_organize(){
    //console.log('添加组织结构',organize);
    var html='';
        html += '<div class="all" >'+
                    '<span class="bloc" data-blocId="1" onclick="choose_organ(this)"> <img src="/static/images/close.png" class="right"> <img src="/static/images/file.png"> '+organize.top+'</span>'+
                    '<div class="area">';
            $.each(organize.items,function(k,area){
                    html+=  '<span data-areaId='+area.id+' onclick="choose_organ(this)">  <img src="/static/images/close.png" class="right"> <img src="/static/images/file.png"> '+area.oName+'</span>'+
                            '<div class="group">';
                            $.each(area.groupInfo,function(k,group){
                                html+='<span data-groupId='+group.id+' onclick="choose_organ(this)"> <img src="/static/images/file.png"> '+group.oName+'</span>';
                                
                            });
                                
                    html+=  '</div>';
                    });    
                            

        html += '</div>';

    $("#menuTree").html(html);
    choose_organ( $('.bloc') );
}


// 组织结构点击事件
var tree_conditions={}; //全局变量  选中的公司 区域 小组 的id
function choose_organ(obj){ //console.log('点击');
	$("#menuTree span").removeClass('active').find('.right').attr('src','static/images/close.png');
	$(obj).addClass('active');
	$(obj).find(".right").attr('src','static/images/close_hover.png');
    $(obj).toggleClass('open');
    $(obj).next('div').slideToggle();
    tree_conditions.blocId = $(obj).attr('data-blocId')?$(obj).attr('data-blocId'):'';
    tree_conditions.companyId = $(obj).attr('data-companyId')?$(obj).attr('data-companyId'):'';
    tree_conditions.areaId = $(obj).attr('data-areaId')?$(obj).attr('data-areaId'):'';
    tree_conditions.groupId = $(obj).attr('data-groupId')?$(obj).attr('data-groupId'):''; 
}


//获取时间函数  type=year 返回年月日 type=hour 返回时分秒  type为空 返回年月日时分秒
function getTime(type){
	var myDate = new Date();
	myDate.getYear();        //获取当前年份(2位)
	var year = myDate.getFullYear();    //获取完整的年份(4位,1970-????)
	var month = myDate.getMonth()+1 >=10? myDate.getMonth()+1 : "0" + (myDate.getMonth()+1)  ;       //获取当前月份(0-11,0代表1月)
	var date = myDate.getDate()>=10 ? myDate.getDate() : "0" + myDate.getDate();        //获取当前日(1-31)
	// myDate.getDay();         //获取当前星期X(0-6,0代表星期天)
	// myDate.getTime();        //获取当前时间(从1970.1.1开始的毫秒数)
	var hours =  myDate.getHours()>=10?myDate.getHours():"0"+myDate.getHours();       //获取当前小时数(0-23)
	var minutes =  myDate.getMinutes()>=10 ? myDate.getMinutes():"0"+myDate.getMinutes();     //获取当前分钟数(0-59)
	var seconds =  myDate.getSeconds()>=10 ? myDate.getSeconds():"0"+myDate.getSeconds();     //获取当前秒数(0-59)
	// myDate.getMilliseconds();    //获取当前毫秒数(0-999)
	// myDate.toLocaleDateString();     //获取当前日期
	// var mytime=myDate.toLocaleTimeString();     //获取当前时间
	// myDate.toLocaleString( );        //获取日期与时间
	if(type=="year"){
		return year+'-'+month+'-'+date;
	}else if(type=="hour"){
		return hours+':'+minutes+':'+seconds;
	}else if(type=="thisYear"){
		return year;
	}else{
		return year+'-'+month+'-'+date+' '+ hours+':'+minutes+':'+seconds;
	}
}
//时间减传入时间字符串天数
function getMinusTime(time,day,type){
	time = time.replace(/-/g,"/");
	var Time = new Date(time);
	if(Time!=undefined){
		var t = new Date(Time.getTime()-(1000*60*60*24*day));
		var year = t.getFullYear();    //获取完整的年份(4位,1970-????)
		var month = t.getMonth()+1 >=10? t.getMonth()+1 : "0" + (t.getMonth()+1)  ;       //获取当前月份(0-11,0代表1月)
		var date = t.getDate()>=10 ? t.getDate() : "0" + t.getDate();        //获取当前日(1-31)
		// myDate.getDay();         //获取当前星期X(0-6,0代表星期天)
		// myDate.getTime();        //获取当前时间(从1970.1.1开始的毫秒数)
		var hours =  t.getHours()>=10?t.getHours():"0"+t.getHours();       //获取当前小时数(0-23)
		var minutes =  t.getMinutes()>=10 ? t.getMinutes():"0"+t.getMinutes();     //获取当前分钟数(0-59)
		var seconds =  t.getSeconds()>=10 ? t.getSeconds():"0"+t.getSeconds();     //获取当前秒数(0-59)
		if(type=="year"){
			return year+'-'+month+'-'+date;
		}else if(type=="hour"){
			return hours+':'+minutes+':'+seconds;
		}else{
			return year+'-'+month+'-'+date+' '+ hours+':'+minutes+':'+seconds;
		}
	}
}


// 字符串和时间戳的转换 time2stamp date为时间戳（1425553097）或者字符串 （2015-03-05 17:59:00.0）
function time2stamp(date){
	if(parseInt(date)<9999999 ){ //字符串转时间戳
		date = date.substring(0,19);    
		date = date.replace(/-/g,'/'); 
		var timestamp = new Date(date).getTime();
		return timestamp;
	}else{//时间戳转字符串
		var d = new Date(date );    //根据时间戳生成的时间对象
		var year =  d.getFullYear() ;
		var mon  =  (d.getMonth() + 1) > 9 ?d.getMonth() + 1 : "0"+(d.getMonth() + 1);
		var day  =  d.getDate()>9?d.getDate():"0"+d.getDate();
		var hour =  d.getHours()>9?d.getHours():"0"+d.getHours();
		var min  =  d.getMinutes()>9?d.getMinutes():"0"+d.getMinutes() ;       
		var sen  =  d.getSeconds()>9?d.getSeconds():"0"+d.getSeconds();          
		return year +'-'+mon +'-'+day+' '+hour+':'+min+':'+sen;
	}
}



// 设置地图样式
function setting_style(map){
	// 地图样式
	// console.log("设置地图样式",map);
	if(map){
		map.setMapStyle({
		  styleJson: [
	          {
                    "featureType": "road",
                    "elementType": "all",
                    "stylers": {
                              "color": "#f9d5c6"
                    }
	          },
	          {
                    "featureType": "highway",
                    "elementType": "all",
                    "stylers": {
                              "color": "#f8dac7"
                    }
	          },
	          {
                    "featureType": "all",
                    "elementType": "labels.text.fill",
                    "stylers": {
                              "color": "#8f8f8f",
                              "lightness": -14
                    }
	          },
              {
                    "featureType": "railway",
                    "elementType": "all",
                    "stylers": {
                              "color": "#898989"
                    }
                },
	          {
                    "featureType": "arterial",
                    "elementType": "all",
                    "stylers": {
                              "color": "#f3baaa"
                    }
	          },
	          {
                    "featureType": "water",
                    "elementType": "geometry",
                    "stylers": {
                              "color": "#75cff0",
                              "lightness": 6
                    }
	          },
	          {
                    "featureType": "manmade",
                    "elementType": "all",
                    "stylers": {
                              "color": "#e7f4fe"
                    }
	          },
	          {
                    "featureType": "green",
                    "elementType": "all",
                    "stylers": {
                              "color": "#c4f0ad"
                    }
	          },
	          {
                    "featureType": "poi",
                    "elementType": "all",
                    "stylers": {
                              "color": "#e7f4fe"
                    }
	          },
	          {
                    "featureType": "all",
                    "elementType": "labels.text.fill",
                    "stylers": {
                              "color": "#888888",
                              "lightness": -14
                    }
	          },
	          {
                    "featureType": "highway",
                    "elementType": "geometry.fill",
                    "stylers": {
                              "color": "#eeac9b",
                              "lightness": -3,
                              "saturation": 22
                    }
	          },
	          {
                    "featureType": "local",
                    "elementType": "geometry",
                    "stylers": {
                              "color": "#ffffff",
                              "lightness": -3,
                              "saturation": 22
                    }
	          },
	            {
                    "featureType": "land",
                    "elementType": "all",
                    "stylers": {
                              "color": "#f4f8fe"
                    }
	          }
		]
		});
	}	
}

/**
* JS分页
* total 总数 page 当前页 size 每页数量 func 页面调用函数 shows 显示数量 parsent 父级选择器
*/
function pagination(func, total, size, page, shows ,parent){
    // console.log(func, total, size, page, shows ,parent);
    var pages = Math.ceil(total / size);
    var start = Math.max(page - shows, 1);
    var end = Math.min(page + shows, pages);
    var data = '';
    //console.log('分页',func);
    // 返回第一页
    if(start > 1){
        data += '<li><a href="javascript:'+func+'(1)">&laquo;</a></li>';
    }
    for(i = start; i <= end; i++){
        if(i == page){
            data += '<li class="active"><a class="curpage">'+i+'</a></li>';
        } else {
            data += '<li><a href="javascript:'+func+'('+i+')">'+i+'</a></li>';
        }        
    }
    // 返回最后页
    if(end < pages){
        data += '<li><a href="javascript:'+func+'('+pages+')">&raquo;</a></li>';
    }

    if(pages==1){
        $(parent +' .pagination').hide();
    }else{
    	$(parent +' .pagination').show();
    }
    $(parent +' .pagination').html(data);
     // console.log('分页',data);
}



// 获取url里的参数 name为 key值 返回value
function GetQueryString(name){
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null){
    	return  unescape(r[2]); 
    }else{
    	return null;
    }
}

 // table里悬停的菜单按钮
function setting_table_menu(){
    var menu = $(".table tr .menu");
    if(menu){
        $.each(menu,function(k,v){
            var top = parseInt( $(v).css('top') ); 
            $(v).css('top',top+40);
        });
        // console.log( $('.menu')[0].clientWidth );

        $(".table tr .menu").css('left',( $('.table').width()-$('.menu').width() )/2  );
    }
   
}

//列表里 全选 
function check_all(obj){
    //console.log($(obj).prop('checked'));
    if( !$(obj).prop('checked') ){
        $(obj).parents('table').find('input').prop('checked',false); 
    }else{
        $(obj).parents('table').find('input').prop('checked',true); 
    }  
}
//列表里 单选
function check_some(obj){
    var len = $(obj).parents('tbody').find('input').size(); 
    var check_len = $(obj).parents('tbody').find('input:checked').size();
    //console.log(len , check_len);
    if(len == check_len ){
        $('thead input').prop('checked',true);
    }else{
        $('thead input').prop('checked',false);
    }
}

// 获取cookie
function getcookie(objname){//获取指定名称的cookie的值
    var arrstr = document.cookie.split("; ");
    for(var i = 0;i < arrstr.length;i ++){
    var temp = arrstr[i].split("=");
    if(temp[0] == objname) return unescape(temp[1]);
    }
}
var level = '0'//JSON.parse(getcookie('member')).level;

$(function(){
	// 时间选择插件的左右按钮
	$(".table-condensed .prev i,.table-condensed .next i").removeClass();
	$(".table-condensed .next i").addClass('fa fa-chevron-right ');
	$(".table-condensed .prev i").addClass('fa fa-chevron-left ');
   
    setting_table_menu();
    /*$('#time').datetimepicker({
        format: 'yyyy-mm-dd',language:'zh-CN',autoclose:1,minView:2
    });*/
    $('#time').val( getTime('year') );
    //获取组织结构
    get_organize();
});

