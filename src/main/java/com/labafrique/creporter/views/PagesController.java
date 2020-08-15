/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labafrique.creporter.views;

import com.labafrique.creporter.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Javalove
 */
@Controller
public class PagesController {
    
    @Autowired
    DataService data;
    
    @GetMapping(path = "/creporter")
    public String welcome()
    {
        return "mapper";
    }
    
    @GetMapping(path = "/creporter/admin/")
    public String admin()
    {
        return "blank";
    }
    
    @GetMapping(path = "/summary")
    public String sum()
    {
        return "summary";
    }
    
    @GetMapping(path = "/test")
    public String hesllo()
    {
        return "test";
    }
    
    @GetMapping(path = "/map")
    public String mapview()
    {
        return "map";
    }

    @GetMapping(path = "/mapframe")
    public String mapframe()
    {
        return "mapframe";
    }
    
    @GetMapping(path = "/gridframe")
    public String gridf()
    {
        return "gridframe";
    }
    @GetMapping(path = "/casemap")
    public String casem()
    {
        return "casemap";
    }
    
    @GetMapping(path = "/grid")
    public String grid(ModelMap model)
    {
        model.put("data", data.getCases());
        model.put("test", "its working oooo");
        return "grid";
    }
    
   
    
}
