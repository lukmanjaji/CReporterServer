/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labafrique.creporter.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author Javalove
 */
@Entity
@Table(name = "reports")
public class ReportModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    
    @Column(name = "rtype")
    private String rtype; 
    
    @Column(name = "created_at", updatable=false)
    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "details")
    private String details;
    
    @Column(name = "case_location")
    private String caseLocation;
    
    @Column(name = "user_location")
    private String userLocation;
    
    @Column(name = "code")
    private String code;
    
    @Column(name = "audio")
    private String audio;
    
    @Column(name = "video")
    private String video;
    
    @Column(name = "photo")
    private String photo;
    
    @Column(name = "sender")
    private String sender;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "thumb")
    private int thumb;
    
    @Column(name = "status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public int getThumb() {
        return thumb;
    }

    public void setThumb(int thumb) {
        this.thumb = thumb;
    }
    
    

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
    

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }
    
    
    

    
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCaseLocation() {
        return caseLocation;
    }

    public void setCaseLocation(String caseLocation) {
        this.caseLocation = caseLocation;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }
    
}
