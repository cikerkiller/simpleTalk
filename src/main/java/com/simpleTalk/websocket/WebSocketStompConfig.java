package com.simpleTalk.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig extends AbstractWebSocketMessageBrokerConfigurer{

	@Override
	public void registerStompEndpoints(StompEndpointRegistry stompendpointregistry) {
		stompendpointregistry.addEndpoint("/marcopilo").withSockJS();
	}

	@Override
	public void configureClientInboundChannel(ChannelRegistration channelregistration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureClientOutboundChannel(ChannelRegistration channelregistration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry messagebrokerregistry) {
		//使能够在topic和user两个域上向客户端发送消息
		messagebrokerregistry.enableSimpleBroker("/topic","/user");  
		//这句表示客户端向服务端发送时的主题上面需要加"/app"作为前缀； 
		messagebrokerregistry.setApplicationDestinationPrefixes("/app"); 
		//这句表示给指定用户发送（一对一）的主题前缀是“/user/”;  
		messagebrokerregistry.setUserDestinationPrefix("/user/");  
	}

}
