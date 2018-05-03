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
 <script type="text/javascript">
 
 	var Message={
 			senderId 	:	'hf',

 		   	receiverId 	: 	'4214124',

 		    content 	: 	'efrgdfgsgf',

 		    type 		: 	'1'	
 	}
 
 var userId="hf";
 
 	var url='http://'+window.location.host+'/simpleTalk/marcopilo';
 	var sock=new SockJS(url);
 	var stomp =Stomp.over(sock);
 	var payload=JSON.stringify(Message);
 	stomp.connect({},function(frame){
 		/* stomp.send('/app/hello',{},payload);
 		stomp.subscribe('/topic/hello', function(message){  
 	        var json = JSON.stringify(message);
 	        alert("json"+json);
 	    });   */
 		stomp.send('/app/back_server',{},payload);
 		stomp.subscribe('/user/' + Message.senderId + '/simple_send', function(message){  
 			var messageEntity = JSON.stringify(message);
 	        alert("messageEntity"+message.body);
 	    });  
 	});
 </script>
</body>
</html>