<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首次环境搭建</title>
  <script type='text/javascript' src='${pageContext.request.contextPath }/dwr/engine.js'></script>
  <script type='text/javascript' src='${pageContext.request.contextPath }/dwr/util.js'></script>
  <script type='text/javascript' src='${pageContext.request.contextPath }/dwr/interface/Push.js'></script>
  <script type='text/javascript' src='${pageContext.request.contextPath }/dwr/interface/DemoTest.js'></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function(){
		
		 var userId = '${userinfo.id}';
		 DemoTest.onPageLoad(userId);
	     
	    $("#button").click(function(){
	    	var msg = $("#msg").val();
	    	var id = $("#id").val();
	    	DemoTest.sendMsg(id,"showMessage",msg);
	    });
	});
	//推送信息
	function showMessage(msg){
		alert(msg);
	}
</script>
</head>
<body>

	<textarea style="WIDTH: 350px" rows="10" name="text"></textarea>
	 id： <input type="text" id="id">
	 消息： <input type="text" id="msg"/>
	<button onclick="send();">发送</button> 
</body>
</html>