/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labafrique.creporter.controller;

import com.google.gson.Gson;
import com.labafrique.creporter.model.CommentsModel;
import com.labafrique.creporter.repository.CommentsRepository;
//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Javalove
 */
@RestController
@RequestMapping("/creporter/listener")
public class CommentsController {
    
    @Autowired
    CommentsRepository comments;
    
    @PostMapping(path = "/saveComment")
    public String saveComment(@RequestParam("user") String user, @RequestParam("code") String code, @RequestParam("comment") String comment)
    {
        String result = "";
        CommentsModel model = new CommentsModel();
        model.setCode(code);
        model.setComment(comment);
        model.setUser(user);
        comments.save(model);
        return getComments(code);
    }
    
    @GetMapping(path = "/getComments/{code:.+}")
    public String getComments(@PathVariable String code)
    {
        return new Gson().toJson(comments.getCommentsForCase(code));
    }
    
    
    
}
