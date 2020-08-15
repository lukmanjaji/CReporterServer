/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labafrique.creporter.ws;

import com.google.gson.Gson;
import com.labafrique.creporter.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class RestBean {
    
    @Autowired
    private ReportRepository report;
    
    public RestBean()
    {
        //report.findByCaseType("cor", 0);
    }
    
    public String testBean()
    {
        return new Gson().toJson(report.findByCaseType("cor", 20));
    }
    
}
