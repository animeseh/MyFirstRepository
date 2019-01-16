package com.middleware.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.RestController;
import com.models.Chat;


@RestController
public class ChatController {

	private final SimpMessagingTemplate messagingTemplate;
    
    private List<String> users=new ArrayList<String>();
 
    @Autowired
    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }
     
    @SubscribeMapping("/join/{username}")
    public List<String> join(@DestinationVariable String username){
         
        System.out.println("Newly joined username is "+username);
        if(!users.contains(username))
            users.add(username);
        messagingTemplate.convertAndSend("/topic/join", username);
        return users;
    }
     
    @MessageMapping(value="/chat")
    public void chatRecieved(Chat chat)
    {
        if(chat.getTo().equals("all"))//group chat
        {
            messagingTemplate.convertAndSend("/queue/chats", chat);
        }
        else{//private chat
             
            messagingTemplate.convertAndSend("/queue/chats/"+chat.getTo(), chat);
            messagingTemplate.convertAndSend("/queue/chats/"+chat.getFrom(), chat);
         
             
        }
    }
}
