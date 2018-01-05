<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
 	<meta http-equiv="pragma" content="no-cache">
 	<meta http-equiv="cache-control" content="no-cache">
	 <meta http-equiv="expires" content="0">    
 	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
 	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
    <form action="${pageContext.request.contextPath }/LoginServlet" method="post">
	     id:<input type="text" name="id" /><br />
	     name:<input type="text" name="name" /><br />
	     <input type="submit" value="Login" />
    </form>
  </body>
</html>
