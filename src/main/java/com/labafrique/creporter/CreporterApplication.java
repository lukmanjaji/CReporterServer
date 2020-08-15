package com.labafrique.creporter;

import com.labafrique.creporter.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;



@EnableConfigurationProperties({
		FileStorageProperties.class
})
@SpringBootApplication
public class CreporterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreporterApplication.class, args);
	}
        
        
        
}
