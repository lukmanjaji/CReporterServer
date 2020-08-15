 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labafrique.creporter.controller;

import com.google.gson.Gson;
import com.labafrique.creporter.model.TestModel;
import com.labafrique.creporter.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Javalove
 */
@RestController
@RequestMapping("/creporter")
public class Controller {
    
    @Autowired
    TestRepository test;
    
    @GetMapping(path="/test")
    public String test()
    {
        return "testing server";
    }
    
    @PostMapping(path="/save")
    public String save(@RequestParam("first") String first, @RequestParam("last") String last)
    {
        TestModel tm = new TestModel();
        tm.setFirstname(first);
        tm.setLastname(last);
        test.save(tm);
        return "saved";
    }
    
    @GetMapping(path = "/load")
    public String load()
    {
        return new Gson().toJson(test.findAll());
    }
    
}
