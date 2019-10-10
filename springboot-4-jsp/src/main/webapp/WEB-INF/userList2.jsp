<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>您好Springboot</title>
</head>
<body>
	<table id="userTable" border="1px" width="65%" align="center">
		<thead>
		<tr>
			<td colspan="6" align="center"><h3>学生信息</h3></td>
		</tr>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th></th>
		</tr>
		</thead>
		<tbody id=tbodyId />
	</table>
<script src="dist/js/jquery.min.js"></script> <!--static下面的路径的资源,引入进去后不需要写static  -->
<script type="text/javascript">
// 第一种方式:原始方式 
/* 	$(function(){
	$.ajax({
	type:"get",
	url:"http://localhost:8090/findAll",
	dataType:"json",
	success:function(result){
		$.each(result,function(index,user){ // index:索引, user是遍历result处理后的数据 
				var id=user.id;
				var name=user.name;
				var age=user.age;
				var sex=user.sex;
				var tr="<tr align='center'><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td><td>"+sex+"</td></tr>";
				$("#userTable").append(tr);
		});		
	}
	});
}); */
//第二种方式:封装js函数
	/*2.使用$.getJSON获取数据*/
	$.getJSON("http://localhost:8090/findAll",function(result){
			var trs = getUserTrs(result);
			$("#userTable").append(trs);
		});
	//封装js函数 
	function getUserTrs(result){
		var tr="";
		$.each(result,function(index,user){
			var id=user.id;
			var name=user.name;
			var age=user.age;
			var sex=user.sex;
			tr += "<tr align='center'><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td><td>"+sex+"</td></tr>"
		});
			return tr;
	}
//第三种方式:动吧模仿  
/*    $(function(){
	   	doQueryObjects();
   });
   //send request 
   //getJSON底层会  向服务端发送异步请求
   //服务端结果响应到客户端以后  会调用function(result){}函数
   function doQueryObjects(){
	 	const url="/findAll";
	 	$.getJSON(url,function(result){
		 	// console.log(result);
		 	// alert("你 好");
	 		doSetTableBodyRows(result)
		});
   }
   //将日志记录呈现在tbody中
   function doSetTableBodyRows(result){
	   var tBody=$("#tbodyId");
	   tBody.empty();
	   for(var i=0;i<result.length;i++){
		   var tr=$("<tr></tr>");
		   var tds=doCreateTds(result[i]);
		   tr.append(tds);
		   tBody.append(tr);
	   }
   }
   function doCreateTds(result){
	   var tds="<td>"+result.id+"</td>"+
		   	 "<td>"+result.name+"</td>"+
		     "<td>"+result.age+"</td>"+
		     "<td>"+result.sex+"</td>";
            return tds;
   } */
</script>
</body>
</html>