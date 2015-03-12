package com.stellarcodes.websockets.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

	@MessageMapping(value = "/test")
	@SendTo(value = "/testResult")
	public Object receiveMessage(String message) {
		System.out.println("Message received! => " + message);
		return message;
	}

}
