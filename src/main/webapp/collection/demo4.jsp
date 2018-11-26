<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% 
	String path = request.getContextPath(); 
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/collection"; 
	pageContext.setAttribute("basePath", basePath);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试页面4</title>
<script type="text/javascript">
(function(){
	var _aelog_ = _aelog_ || window._aelog_ || [];
	// 设置_aelog_相关属性
	_aelog_.push(["memberId","gerryliu"]);
	window._aelog_ = _aelog_;
	(function(){
	    var aejs = document.createElement('script');
	    aejs.type = 'text/javascript';
	    aejs.async = true;
	    aejs.src = '${pageScope.basePath}/js/analytics.js';
	    var script = document.getElementsByTagName('script')[0];
	    script.parentNode.insertBefore(aejs, script);
	})();
})();
</script>
</head>
<body>
	测试页面4<br/>
	在本页面设置memberid为gerryliu<br/>
	跳转到:
	<a href="${pageScope.basePath}/demo.jsp">demo</a>
	<a href="${pageScope.basePath}/demo2.jsp">demo2</a>
	<a href="${pageScope.basePath}/demo3.jsp">demo3</a>
	<a href="${pageScope.basePath}/demo4.jsp">demo4</a>
</body>
</html>