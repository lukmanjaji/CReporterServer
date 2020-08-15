/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labafrique.creporter.property;

/**
 *
 * @author Javalove
 */
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories 
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}