package com.stellarcodes.websockets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InitController {

	@Autowired
	SimpMessagingTemplate template;

	@RequestMapping(value = "/")
	public String gotoHomePage() {
		return "index";
	}

	@RequestMapping(value = "/greet")
	@ResponseBody
	public void greetAllSubscritions() {
		template.convertAndSend("/testResult", "Welcome!");
	}

	@RequestMapping(value = "/pushtrade", method = RequestMethod.POST)
	@ResponseBody
	public void pushTradeMessage(@RequestParam("message") String message) {
		template.convertAndSend("/topic/trade-updates", message);
	}
}
