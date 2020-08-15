/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labafrique.creporter.repository;

import com.labafrique.creporter.model.CommentsModel;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Javalove
 */
public interface CommentsRepository extends CrudRepository<CommentsModel, Long> {
    
    @Query(value = "select * from comments where code=?1", nativeQuery=true)
    public List<CommentsModel> getCommentsForCase(String code);
    
}
