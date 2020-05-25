package com.zwk.detection;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@MapperScan(value = "com.zwk.detection.dao",annotationClass = Repository.class)
public class DetectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(DetectionApplication.class, args);
    }

}
