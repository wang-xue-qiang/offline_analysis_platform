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
<title>测试页面2</title>
<script type="text/javascript" src="${pageScope.basePath}/js/analytics.js"></script>
</head>
<body>
	测试页面2
	<br/>
	<label>orderid: 123456</label><br>
	<label>orderName: 测试订单123456</label><br/>
	<label>currencyAmount: 524.01</label><br/>
	<label>currencyType: RMB</label><br/>
	<label>paymentType: alipay</label><br/>
	<button onclick="__AE__.onChargeRequest('123456','测试订单123456',524.01,'RMB','alipay')">触发chargeRequest事件</button><br/>
	跳转到:
	<a href="${pageScope.basePath}/demo.jsp">demo</a>
	<a href="${pageScope.basePath}/demo2.jsp">demo2</a>
	<a href="${pageScope.basePath}/demo3.jsp">demo3</a>
	<a href="${pageScope.basePath}/demo4.jsp">demo4</a>
</body>
</html>