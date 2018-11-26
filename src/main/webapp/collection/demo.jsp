<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% 
	String path = request.getContextPath(); 
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/collection"; 
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试页面1</title>
<script type="text/javascript" src="${pageScope.basePath}/js/analytics.js"></script>
</head>
<body>
	测试页面1<br/>
	跳转到:
	<a href="${pageScope.basePath}/demo.jsp">demo</a>
	<a href="${pageScope.basePath}/demo2.jsp">demo2</a>
	<a href="${pageScope.basePath}/demo3.jsp">demo3</a>
	<a href="${pageScope.basePath}/demo4.jsp">demo4</a>
</body>
</html>