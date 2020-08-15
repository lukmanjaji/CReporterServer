/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labafrique.creporter.service;

import com.labafrique.creporter.controller.CommentsController;
import com.labafrique.creporter.controller.ReportController;
import com.labafrique.creporter.repository.CommentsRepository;
import com.labafrique.creporter.repository.ReportRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Javalove
 */
@Service
public class DataService {
    
    @Autowired
    ReportController control;
    
    @Autowired
    CommentsController comments;
    
    @Autowired
    ReportRepository report;
    
    @Autowired
    CommentsRepository comms;
    
    public List getCases()
    {
        return report.findAllCases();
    }
    
    public String getText()
    {
        return "this is test";
    }
    
}
