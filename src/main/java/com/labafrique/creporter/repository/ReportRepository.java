/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labafrique.creporter.repository;

import com.labafrique.creporter.model.ReportModel;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Javalove
 */
@Component
public interface ReportRepository extends CrudRepository<ReportModel, Long> {
    
    
    @Query(value = "SELECT * FROM reports where details LIKE %:keyword% order by (id) desc", nativeQuery = true)
    List<ReportModel> search(@Param("keyword") String keyword);
    
    @Query(value = "SELECT * from reports where rtype = ?1 and id > ?2 order by (id) desc", nativeQuery = true)
    List<ReportModel> findByCaseType(String type, int x);
    
    @Query(value = "SELECT * from reports where rtype = 'cor' order by (id) desc", nativeQuery = true)
    List<ReportModel> findAllCases();
    
    @Query(value = "SELECT * from reports where rtype =  ?1 and  email=?2 || phone=?3", nativeQuery = true)
    List<ReportModel> getSent(String sender, String email, String phone, String rtype);
    
    @Query(value = "SELECT thumb from reports where code =  ?1", nativeQuery = true)
    int getVoteCount(String code);
    
    @Transactional
    @Modifying
    @Query(value = "update reports set thumb = thumb + 1 where code = ?1", nativeQuery = true)
    void ThumbUp(String code);
    
    @Query(value = "select count (id) from reports", nativeQuery = true)
    int countReports();
    
    
}
