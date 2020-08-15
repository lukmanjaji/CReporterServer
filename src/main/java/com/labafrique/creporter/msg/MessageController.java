/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labafrique.creporter.msg;

import com.google.gson.Gson;
import com.labafrique.creporter.model.MessagesModel;
import com.labafrique.creporter.repository.MessageRepository;
import com.labafrique.creporter.ws.SocketHandler;
import java.net.URLDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Javalove
 */
@Component
@RestController
@RequestMapping("/creporter/listener")
public class MessageController {
    
    @Autowired
    SocketHandler handler;
    
    @Autowired
    MessageRepository message;
    
    public String getMessages(String code) throws Exception
    {
        return URLDecoder.decode(new Gson().toJson(message.getMessages(code)), "utf-8");
    }
    
    public String saveMessage(String sender, String code, String msg) throws Exception
    {
        MessagesModel toSave = new MessagesModel();
        toSave.setCode(code);
        toSave.setSender(sender);
        toSave.setMessage(msg);
        MessagesModel ms = message.save(toSave);
        return URLDecoder.decode(new Gson().toJson(ms), "utf-8");
    }
    
}
