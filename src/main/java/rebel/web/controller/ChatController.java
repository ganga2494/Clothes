package rebel.web.controller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rebel.web.model.Message;
import rebel.web.model.OutputMessage;

@RestController
public class ChatController {

	@RequestMapping("/chat/info")
	@MessageMapping("/chat")
	  @SendTo("/topic/message")
	  public OutputMessage sendMessage(Message message) {
		//message.setMessage(message.getMessage()+((UserDetails)session.getAttribute("user")).getFullname());
	    return new OutputMessage(message, new Date());
	  }

}
