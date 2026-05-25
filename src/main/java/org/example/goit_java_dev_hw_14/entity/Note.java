package org.example.goit_java_dev_hw_14.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Note {
    private long id;
    private String title;
    private String content;
}