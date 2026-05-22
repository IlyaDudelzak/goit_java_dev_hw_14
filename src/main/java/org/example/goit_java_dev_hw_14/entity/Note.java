package org.example.goit_java_dev_hw_14.entity;

import lombok.Data;

@Data
public class Note {
    private long id;
    private String title;
    private String content;
}