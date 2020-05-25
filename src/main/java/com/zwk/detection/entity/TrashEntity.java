package com.zwk.detection.entity;

import java.io.Serializable;

public class TrashEntity implements Serializable {
    private Long id;
    private String name;
    private String name_CN;
    private Integer classification_id;
    private String classification;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_CN() {
        return name_CN;
    }

    public void setName_CN(String name_CN) {
        this.name_CN = name_CN;
    }

    public Integer getClassification_id() {
        return classification_id;
    }

    public void setClassification_id(Integer classification_id) {
        this.classification_id = classification_id;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
