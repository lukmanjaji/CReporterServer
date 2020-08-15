/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labafrique.creporter.repository;

import com.labafrique.creporter.model.MessagesModel;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Lukman
 */
public interface MessageRepository extends CrudRepository<MessagesModel, Long>  {
    
    @Query(value = "select * from admin_msg where code= ?1", nativeQuery=true)
    List<MessagesModel> getMessages(String code);
    
    
}
