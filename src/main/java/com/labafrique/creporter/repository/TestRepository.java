/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labafrique.creporter.repository;

import com.labafrique.creporter.model.TestModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Javalove
 */
public interface TestRepository extends CrudRepository<TestModel, Long> {
    
    
    
}
