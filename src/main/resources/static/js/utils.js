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
	}else{
		return year+'-'+month+'-'+date+' '+ hours+':'+minutes+':'+seconds;
	}
}
//时间获取
function getDate(type){
	//time = time.replace(/-/g,"/");
	var Time = new Date();
	var year = Time.getFullYear();    //获取完整的年份(4位,1970-????)
	var month = Time.getMonth()+1 >=10? Time.getMonth()+1 : "0" + (Time.getMonth()+1)  ;       //获取当前月份(0-11,0代表1月)
	var date = Time.getDate()>=10 ? Time.getDate() : "0" + Time.getDate();        //获取当前日(1-31)
	//myDate.getDay();         //获取当前星期X(0-6,0代表星期天)
	//myDate.getTime();        //获取当前时间(从1970.1.1开始的毫秒数)
	var hours =  Time.getHours()>=10?Time.getHours():"0"+Time.getHours();       //获取当前小时数(0-23)
	var minutes =  Time.getMinutes()>=10 ? Time.getMinutes():"0"+Time.getMinutes();     //获取当前分钟数(0-59)
	var seconds =  Time.getSeconds()>=10 ? Time.getSeconds():"0"+Time.getSeconds();     //获取当前秒数(0-59)
	var retArr = "";
	if (type.length != undefined && type.length > 0) {
      for (var i = 0; i < type.length; i++) {
        if (type[i] === "Y") retArr += year;
        if (type[i] === "M") retArr += "-" + month;
        if (type[i] === "D") retArr += "-" + date;
        if (type[i] === "h") retArr += " " + hours;
        if (type[i] === "m") retArr += ":" + minutes;
        if (type[i] === "s") retArr += ":" + seconds;
      };
      return retArr;
    }else{
      return year + "-" + month + "-" + date + " " + hours + ":" + minutes + ":" + seconds;
    };
};

//时间减
function minusTime(time,day,type){
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
		var retArr = "";
		if (type.length != undefined && type.length > 0) {
	      for (var i = 0; i < type.length; i++) {
	        if (type[i] === "Y") retArr += year;
	        if (type[i] === "M") retArr += "-" + month;
	        if (type[i] === "D") retArr += "-" + date;
	        if (type[i] === "h") retArr += " " + hours;
	        if (type[i] === "m") retArr += ":" + minutes;
	        if (type[i] === "s") retArr += ":" + seconds;
	      };
	      return retArr;
	    }else{
	      return year + "-" + month + "-" + date + " " + hours + ":" + minutes + ":" + seconds;
	    };
	}else{
		console.error("error:utils.js function minusTime time parameter error");
	}
};

//时间传入时间字符，串减天数
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
		}else if(type=="thisYear"){
			return year;
		}else{
			return year+'-'+month+'-'+date+' '+ hours+':'+minutes+':'+seconds;
		};
		
	}
}

/*时间传入字符串时间，减小时数
	time 时间，
	hour 小时，
	type 类型，
	isRandom 是否随机分秒
 */
function getMinusHour(time,hour,type,isRandom){
	time = time.replace(/-/g,"/");
	var Time = new Date(time);
	if(Time!=undefined){
		var t = new Date(Time.getTime()-(1000*60*60*hour));
		var year = t.getFullYear();    //获取完整的年份(4位,1970-????)
		var month = t.getMonth()+1 >=10? t.getMonth()+1 : "0" + (t.getMonth()+1)  ;       //获取当前月份(0-11,0代表1月)
		var date = t.getDate()>=10 ? t.getDate() : "0" + t.getDate();        //获取当前日(1-31)
		// myDate.getDay();         //获取当前星期X(0-6,0代表星期天)
		// myDate.getTime();        //获取当前时间(从1970.1.1开始的毫秒数)
		var hours =  t.getHours()>=10?t.getHours():"0"+t.getHours();       //获取当前小时数(0-23)
		var minutes =  t.getMinutes()>=10 ? t.getMinutes():"0"+t.getMinutes();     //获取当前分钟数(0-59)
		var seconds =  t.getSeconds()>=10 ? t.getSeconds():"0"+t.getSeconds();     //获取当前秒数(0-59)
		
		/*var t2 = new Date(t.getTime()-(1000*60*30));
		var year2 = t2.getFullYear();    //获取完整的年份(4位,1970-????)
		var month2 = t2.getMonth()+1 >=10? t2.getMonth()+1 : "0" + (t2.getMonth()+1)  ;       //获取当前月份(0-11,0代表1月)
		var date2 = t2.getDate()>=10 ? t2.getDate() : "0" + t2.getDate();        //获取当前日(1-31)
		// myDate.getDay();         //获取当前星期X(0-6,0代表星期天)
		// myDate.getTime();        //获取当前时间(从1970.1.1开始的毫秒数)
		var hours2 =  t2.getHours()>=10 ? t2.getHours():"0" + t2.getHours();       //获取当前小时数(0-23)
		var minutes2 =  t2.getMinutes()>=10 ? t2.getMinutes():"0" + t2.getMinutes();     //获取当前分钟数(0-59)
		var seconds2 =  t2.getSeconds()>=10 ? t2.getSeconds():"0" + t2.getSeconds();     //获取当前秒数(0-59)*/
		
		if(isRandom){
			minutes = 0; seconds = 0;
			var ms = getRandom(0,60),ss = getRandom(0,60);
			minutes = (ms>=10) ? (ms):('0'+ms);
			seconds = (ss>=10) ? (ss):('0'+ss);
		};
		if(type=="year"){
			return year+'-'+month+'-'+date;
		}else if(type=="hour"){
			return hours+':'+minutes+':'+seconds;
		}else if(type=="minute"){
			//console.log('minute\r\nyear:'+year+"\r\nmonth:"+month+"\r\ndate:"+date+"\r\nhours:"+hours+"\r\nminutes:"+minutes);
			return year+'-'+month+'-'+date+' '+hours+':'+minutes;
		}else if(type=="thisYear"){
			return year;
		}else{
			return year+'-'+month+'-'+date+' '+ hours+':'+minutes+':'+seconds;
		}
	}
}


/*时间传入字符串时间，减小时数
	time 时间，
	minute 分钟，
	type 类型，
	isRandom 是否随机分秒
 */
function plusMinute(time,minute,type){
	time = time.replace(/-/g,"/");
	var Time = new Date(time);
	if(Time!=undefined){
		var t = new Date(Time.getTime()+(1000*60*minute));
		var year = t.getFullYear();    //获取完整的年份(4位,1970-????)
		var month = t.getMonth()+1 >=10? t.getMonth()+1 : "0" + (t.getMonth()+1)  ;       //获取当前月份(0-11,0代表1月)
		var date = t.getDate()>=10 ? t.getDate() : "0" + t.getDate();        //获取当前日(1-31)
		//myDate.getDay();         //获取当前星期X(0-6,0代表星期天)
		//myDate.getTime();        //获取当前时间(从1970.1.1开始的毫秒数)
		var hours =  t.getHours()>=10?t.getHours():"0"+t.getHours();       //获取当前小时数(0-23)
		var minutes =  t.getMinutes()>=10 ? t.getMinutes():"0"+t.getMinutes();     //获取当前分钟数(0-59)
		var seconds =  t.getSeconds()>=10 ? t.getSeconds():"0"+t.getSeconds();     //获取当前秒数(0-59)
		/*if(isRandom){
			//minutes = 0; 
			seconds = 0;
			var ms = getRandom(0,60),ss = getRandom(0,60);
			//minutes = (ms>=10) ? (ms):('0'+ms);
			seconds = (ss>=10) ? (ss):('0'+ss);
		};*/
		var retArr = "";
		if (type.length != undefined && type.length > 0) {
	      for (var i = 0; i < type.length; i++) {
	        if (type[i] === "Y") retArr += year;
	        if (type[i] === "M") retArr += "-" + month;
	        if (type[i] === "D") retArr += "-" + date;
	        if (type[i] === "h") retArr += " " + hours;
	        if (type[i] === "m") retArr += ":" + minutes;
	        if (type[i] === "s") retArr += ":" + seconds;
	      };
	      return retArr;
	    }else{
	      return year + "-" + month + "-" + date + " " + hours + ":" + minutes + ":" + seconds;
	    };
		
		/*if(type=="year"){
			return year+'-'+month+'-'+date;
		}else if(type=="hour"){
			return hours+':'+minutes+':'+seconds;
		}else if(type=="minute"){
			return year+'-'+month+'-'+date+' '+hours+':'+minutes;
		}else if(type=="thisYear"){
			return year;
		}else if(type=="ms"){
			return minutes+':'+seconds;
		}else{
			return year+'-'+month+'-'+date+' '+ hours+':'+minutes+':'+seconds;
		}*/
	}
}

//格式重组
function getFormat(time,type){
	if(time!=undefined){
		time = time.replace(/-/g,"/");
		var Time = new Date(time);
		if(Time!=undefined){
			//var t = new Date(Time.getTime()+(1000*60*minute));
			var year = Time.getFullYear();    //获取完整的年份(4位,1970-????)
			var month = Time.getMonth()+1 >=10? Time.getMonth()+1 : "0" + (Time.getMonth()+1)  ;       //获取当前月份(0-11,0代表1月)
			var date = Time.getDate()>=10 ? Time.getDate() : "0" + Time.getDate();        //获取当前日(1-31)
			var hours = Time.getHours()>=10? Time.getHours():"0"+Time.getHours();       //获取当前小时数(0-23)
			var minutes = Time.getMinutes()>=10 ? Time.getMinutes():"0"+Time.getMinutes();     //获取当前分钟数(0-59)
			var seconds = Time.getSeconds()>=10 ? Time.getSeconds():"0"+Time.getSeconds();     //获取当前秒数(0-59)
			var retArr = "";
			if (type.length != undefined && type.length > 0) {
		      for (var i = 0; i < type.length; i++) {
		        if (type[i] === "Y") retArr += year;
		        if (type[i] === "M") retArr += "-" + month;
		        if (type[i] === "D") retArr += "-" + date;
		        if (type[i] === "h") retArr += " " + hours;
		        if (type[i] === "m") retArr += ":" + minutes;
		        if (type[i] === "s") retArr += ":" + seconds;
		      };
		      return retArr;
		    }else{
		      return year + "-" + month + "-" + date + " " + hours + ":" + minutes + ":" + seconds;
		    };
		}else console.log("错误的格式！");   
	}else{
		console.error("错误的日期传入!");
		return;
	};
}
//时间比较
function format(plaStartTime,planEndTime,relTime){
	if(plaStartTime!=undefined && planEndTime!=undefined && relTime!=undefined){
		//console.log(plaStartTime+","+planEndTime+","+relTime);
		plaStartTime = plaStartTime.replace(/-/g,"/");
		var Time1 = new Date(plaStartTime);
		
		planEndTime = planEndTime.replace(/-/g,"/");
		var Time2 = new Date(planEndTime);
		
		relTime = relTime.replace(/-/g,"/");
		var Time3 = new Date(relTime);
		
		if(Time1!=undefined && Time2!=undefined && Time3!=undefined){
			if (Time1 <= Time3 && Time3 <= Time2){
				return true;
			}else{
				return false;
			};
		}else{
			console.error("时间错误！");
			return;
		};
	}else{
		console.error("错误的日期传入!");
		return;
	};
}




//取窗口可视范围的高度
function getClientHeight(){
  	var clientHeight=0;
  	if(document.body.clientHeight&&document.documentElement.clientHeight){
  		var clientHeight = (document.body.clientHeight<document.documentElement.clientHeight)?document.body.clientHeight:document.documentElement.clientHeight;
  	}else{
  		var clientHeight = (document.body.clientHeight>document.documentElement.clientHeight)?document.body.clientHeight:document.documentElement.clientHeight;
  	}
  //return clientHeight;
	if (window.innerHeight)
		winHeight = window.innerHeight;
	else if ((document.body) && (document.body.clientHeight))
		winHeight = document.body.clientHeight;
	return winHeight;
}
/* 生成随机数 */
function getRandom(min,max){
	if(max>=1,min<max){
		return Math.floor(Math.random()*(max-min+1)+min);
	}else{
		alert("参数错误!");
	};
};

/* 生成随机数小数 */
function getRandomFloat(min,max){
	if(max<1,min<max){
		var ran = (Math.random()).toFixed(2);
		while(ran > max){
			ran = (Math.random()).toFixed(2);
			if(ran <= max){
				break;
			};
		};
		//console.log("thisRandomFloat(min:"+min+",max:"+max+")返回:"+ran);
		return ran ; 
	}else{
		alert("最大数不可大于1!");
	};
	/*var mamin = (max-min+1);
	var multiply = (ran*mamin)+min;
	var ret = multiply.toFixed(2);
	console.log("thisRandomFloat(min:"+min+",max:"+max+",random:"+ran+",加："+mamin+",乘："+multiply+",返回:"+ret);
	return ret ; */
};

/* 加减随机 */
function getRandomCount(one,two){
	var count = ["+","-","*","/"],str = one +'',random = getRandom(0,1),arr = [],ret = 0;
	str += count[random] + two+'';
	//console.log(str);
	arr = str.split("+");
	if(arr != undefined && arr.length == 2){
		var thisOne = parseFloat(arr[0]),thisTwo = parseFloat(arr[1]);
		ret = (thisOne + thisTwo);
		//console.log("this+++"+thisOne+"："+thisTwo+"="+ret);
		return ret;
	};
	arr = str.split("-");//console.log(arr);
	if(arr != undefined && arr.length == 2){
		var thisOne = parseFloat(arr[0]),thisTwo = parseFloat(arr[1]);
		ret = (thisOne - thisTwo);
		//console.log("this---"+thisOne+"："+thisTwo+"="+ret);
		return ret;
	};
	arr = str.split("*");//console.log(arr);
	if(arr != undefined && arr.length == 2){
		var thisOne = parseFloat(arr[0]),thisTwo = parseFloat(arr[1]);
		ret = (thisOne * thisTwo);
		//console.log("this***"+thisOne+"："+thisTwo+"="+ret);
		return ret;
	};
	arr = str.split("/");//console.log(arr);
	if(arr != undefined && arr.length == 2){
		var thisOne = parseFloat(arr[0]),thisTwo = parseFloat(arr[1]);
		ret = (thisOne / thisTwo);
		//console.log("this///"+thisOne+"："+thisTwo+"="+ret);
		return ret;
	};
}


function splitUrl(url){
	var data = url.split("?");
	if(data.length>1){
		var da = data[1].split("&");
		if(da.length>1){
			var parameter = {};
			for(var i=0;i<da.length;i++){
				var d = da[i].split("=");
				var name = d[0];
				parameter[name] = d[1];
				//parameter.name = d[1];
			}
			//alert(JSON.stringify(parameter));
			addCookie('parameter',JSON.stringify(parameter),1);
		}else{
			var d = data[1].split("=");
			var name = d[0];
			var parameter = {[name]:d[1]};
			//alert(JSON.stringify(parameter));
			addCookie('parameter',JSON.stringify(parameter),1);
		};
	};
	return data[0];
}


//设置Cookie
function addCookie(name,value,expireHours){
    var cookieString=name+"="+escape(value);
    //判断是否设置过期时间
    if(expireHours>0){
        var date=new Date();
        date.setTime(date.getTime+expireHours*60*60*1000);
        cookieString=cookieString+"; expire ="+date.toGMTString();
    }
    //alert(cookieString);
    document.cookie=cookieString;
}

//获取Cookie
function getCookie(name){
	var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
	if(arr=document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
   /* var strCookie=document.cookie;
    var arrCookie=strCookie.split("; ");
    for(var i=0;i<arrCookie.length;i++){
       var arr=arrCookie[i].split("=");
       if(arr[0]==name)return arr[1];
    }
    return "";*/
}


function utils($) {
    var $=$;
    /**
     * 
     * @param cols  数组类型   格式['序号','姓名','地址']
     * @Param colsFiled     格式{'序号':'id','姓名':'name','地址':'address'}
     * @param data  数组类型   格式[{'id':1,'name':张三,'address':成都},{'id':2,'name':李四,'address':成都}]
     * @returns
     */
    this.createExcle=function (cols,colsFiled,data){

        var table = $('<table></table>');
        var th = $('<tr></tr>');

        var index = 0;

        for(var i = 0; i < data.length; i++){

            var tr = $('<tr></tr>');
            var values = data[i];

            for(var j = 0; j < cols.length; j++){

                var fliedName = cols[j];
                var flied = colsFiled[fliedName];
                var value = values[flied];
                var td = $('<td></td>');
                td.html(value);

                if(index == 0){
                    var tdTh = $('<td></td>');
                    tdTh.html(fliedName);
                    th.append(tdTh);
                }

                tr.append(td);
            }
            if(index == 0){
                table.append(th);
            }
            table.append(tr);
            index++;
        }
        table.attr('id','datatab');
        table.attr("style", "display: none");
        table.appendTo('body');
        method5('datatab');
        datatab.remove();
        function method5(tableid) {  
            
            var idTmr;
            
            var tableToExcel = (function() {  
                var uri = 'data:application/vnd.ms-excel;base64,',  
                template = '<html><head><meta charset="UTF-8"></head><body><table>{table}</table></body></html>',  
                base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) },  
                format = function(s, c) {  
                    return s.replace(/{(\w+)}/g,  
                            function(m, p) { return c[p]; }) }  
                return function(table, name) {  
                    if (!table.nodeType) table = document.getElementById(table)  
                    var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML}  
                    window.location.href = uri + base64(format(template, ctx))  
                }  
            })()

            if(getExplorer()=='ie')  
            {  
                var curTbl = document.getElementById(tableid);  
                var oXL = new ActiveXObject("Excel.Application");  
                var oWB = oXL.Workbooks.Add();  
                var xlsheet = oWB.Worksheets(1);  
                var sel = document.body.createTextRange();  
                sel.moveToElementText(curTbl);  
                sel.select();  
                sel.execCommand("Copy");  
                xlsheet.Paste();  
                oXL.Visible = true;  

                try {  
                    var fname = oXL.Application.GetSaveAsFilename("Excel.xls", "Excel Spreadsheets (*.xls), *.xls");  
                } catch (e) {  
                    print("Nested catch caught " + e);  
                } finally {  
                    oWB.SaveAs(fname);  
                    oWB.Close(savechanges = false);  
                    oXL.Quit();  
                    oXL = null;  
                    idTmr = window.setInterval("Cleanup();", 1);  
                }  

            }  
            else  
            {  
                tableToExcel(tableid)  
            }

            function Cleanup() {  
                window.clearInterval(idTmr);  
                CollectGarbage();  
            }
            
            function  getExplorer() {  
                var explorer = window.navigator.userAgent ;  
                //ie  
                if (explorer.indexOf("MSIE") >= 0) {  
                    return 'ie';  
                }  
                //firefox  
                else if (explorer.indexOf("Firefox") >= 0) {  
                    return 'Firefox';  
                }  
                //Chrome  
                else if(explorer.indexOf("Chrome") >= 0){  
                    return 'Chrome';  
                }  
                //Opera  
                else if(explorer.indexOf("Opera") >= 0){  
                    return 'Opera';  
                }  
                //Safari  
                else if(explorer.indexOf("Safari") >= 0){  
                    return 'Safari';  
                }  
            }
        } 
    }
}
