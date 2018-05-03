<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <spring:url value="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js" var="sockJs"/>  
    <script src="${sockJs}"></script>  
 <spring:url value="https://cdn.bootcss.com/stomp.js/2.2.0/stomp.min.js" var="stompjs"/>  
    <script src="${stompjs}"></script>  
</head>
<body>
	<h1>this is a index page</h1>
</body>
</html>