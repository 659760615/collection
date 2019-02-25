$(function(){
   //点击每日违规停留与每月违规停留选项卡显示相应内容
    console.log( $('.content_head span').html() );
    $('.content_head span').click(function(){
        $('#selAll').prop('checked',false);
        $(this).addClass('active');
        $('.content_head span').not($(this)).removeClass('active');
        //var con;
        if($(this).text()=='每日违规停留' || $(this).text()=='每日脱岗统计' || $(this).text()=='每日考核' || $(this).text()=='每日设备异常')
        {
            //con={'typeVal':0,date:$('#time').val()};
            $('.orbit').html('轨迹');
            con.roleId = '';
            con.attendance= "";   
            con.outOfWorkArea="";
            con.illegalStay="";
            con.notWearingWatch= "";
            con.date = $('#time').val();
            con.fullName = $('#ename').val();

            con.typeVal=0;
            $('#preday').text('前一天');
            $('#nexday').text('后一天');
            $('#today').text('当天');
            $('#time').datetimepicker('remove');
            $('#time').datetimepicker({
                format: 'yyyy-mm-dd',language:'zh-CN',autoclose:1,minView:2
            });
            var myDate = new Date();
            var year = myDate.getFullYear();    //获取完整的年份(4位,1970-????)
            var month = myDate.getMonth()+1;       //获取当前月份(0-11,0代表1月)
            var day = myDate.getDate();
            if(day<10){
                day = "0"+day;
            }
            if(month<10){
                month = "0" + month;
            }
            $('#time').val(year+"-"+month+"-"+day);
            con.date=$('#time').val();

        }else{
            $('.orbit').html('详情');
            con.roleId = '';
            con.attendance= "";   
            con.outOfWorkArea="";
            con.illegalStay="";
            con.notWearingWatch= "";
            con.date = $('#time').val();
            con.fullName = $('#ename').val();

            con.typeVal=1;
            $('#preday').text('前一月');
            $('#nexday').text('后一月');
            $('#today').text('当月');
            $('#time').datetimepicker('remove');
            $('#time').datetimepicker({
                format: 'yyyy-mm',minView:3,startView:3,language:'zh-CN',autoclose:1
            });
            var myDate = new Date();
            var year = myDate.getFullYear();    //获取完整的年份(4位,1970-????)
            var month = myDate.getMonth()+1;       //获取当前月份(0-11,0代表1月)
            $('#time').val(year+"-"+month);
            $('#time').datetimepicker({
                format: 'yyyy-mm-dd',
                language:'zh-CN',
                autoclose:1,
                minView:0
            });
            con.date=$('#time').val();
        }
        console.log(con);
        //setCon(con);
        show(1);
    });
    //前一天
});

//判断当前选项卡确定type
// function cardIs(){
//     if($('.content_head span.active').text()=='每日违规停留' || $('.content_head span.active').text()=='每日脱岗统计' || $('.content_head span.active').text()=='每日考核' || $('.content_head span.active').text()=='每日设备异常'){
//         var type=0;
//         return type;
//     }else{
//         var type=1;
//         return type;
//     }
// }

//遍历角色类型
/*$.get('/manage/home/getData/get',{
    'action':'/roles/query'
},function(res){
    $('#role ul').empty();
    res=JSON.parse(res);
    for(row in res.data){
        $('#role ul').append("<li style='width:100%;text-align: center;'data-target='#detail' rid="+res.data[row].id+">"+res.data[row].name+"</li>");
    }
    $('#role ul').prepend("<li class='text-center'>全部</li>");
});*/


//搜索
$('.search_box .search_over').click(function(){
    //var type=cardIs();
    //var date=$('#time').val();
    //var con={'typeVal':type,'date':date,'fullName':name};
    // console.log(con); 
    con.roleId = '';
    con.attendance= "";   
    con.outOfWorkArea="";
    con.illegalStay="";
    con.notWearingWatch= "";
    con.date = $('#time').val();
    con.fullName = $('#ename').val();

    setCon(con);
    show(1);
});


//时间改变时自动出现数据
$('#time').change(function(){

    con.roleId = '';
    con.attendance= "";   
    con.outOfWorkArea="";
    con.illegalStay="";
    con.notWearingWatch= "";
    con.date = $('#time').val();
    con.fullName = $('#ename').val();

    setCon(con);
    show(1);

});

//根据角色类型筛选
$('body').on('click','#role li',function(){
    //var num=$(".pagination li.active").text();
    con.roleId = '';
    con.attendance= "";   
    con.outOfWorkArea="";
    con.illegalStay="";
    con.notWearingWatch= "";
    con.date = $('#time').val();
    con.fullName = $('#ename').val();

    con.roleId=$(this).attr('rid');
    //con.date=$('#time').val();
    show(1);
});

// 导出excel文件
function checkOut(con){
    /*$.post('/manage/home/getData/post',con, 
        function(res){
              var a = document.createElement('a');    
              a.setAttribute('href', res.data);
              a.setAttribute('download', "");  
              a.setAttribute('style', 'display:none');    
              a.setAttribute('target', '_blank');    
              document.body.appendChild(a);  
              a.click();  
              a.parentNode.removeChild(a);   

    }, 'json');*/   
}


//初始化时间插件
function initTime(){
    $('#time').datetimepicker({
        format: 'yyyy-mm-dd',language:'zh-CN',autoclose:1,minView:2
    });
    var myDate = new Date();
    var year = myDate.getFullYear();    //获取完整的年份(4位,1970-????)
    var month = myDate.getMonth()+1;       //获取当前月份(0-11,0代表1月)
    var day = myDate.getDate();
    if(day<10){
        day = "0"+day;
    }
    if(month<10){
        month = "0" + month;
    }
    $('#time').val(year+"-"+month+"-"+day);  
}
/*.orderNum span,.up,.down
.orderLen span,.up,.down*/



//点击累计次数按照次数排序
$('.orderNum>div').click(function(){
    $('.orderNum .order p,.orderNum .order div').toggleClass('active');
    //var type=cardIs();
    if($('.order p').hasClass('active')){
        //var con={'typeVal':type,'date':$('#time').val(),'num':'asc'};
        con.lth = '';

        con.num = "asc";
        setCon(con);
        show(1);
        return;
    }else if($('.orderNum .order div').hasClass('active')){
        //var con={'typeVal':type,'date':$('#time').val(),'num':'desc'};

        con.lth = '';

        con.num = "desc";
        setCon(con);
        show(1);
    }
});


//点击累计时间按照时间排序
$('.orderLen>div').click(function(){
    $('.orderLen .order p,.orderLen .order div').toggleClass('active');
    //var type=cardIs();
    if($('.order p').hasClass('active')){
        //var con={'typeVal':type,'date':$('#time').val(),'lth':'asc'};
        con.num ='';

        con.lth = "asc";
        setCon(con);
        show(1);
        return;
    }else if($('.orderLen .order div').hasClass('active')){
        //var con={'typeVal':type,'date':$('#time').val(),'lth':'desc'};
        con.num ='';

        con.lth = "desc";
        setCon(con);
        show(1);
    }
});



