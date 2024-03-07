package com.example.tasks.TrackerSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tasks {

    private String ID;
    private String title;
    private String description;
    private boolean status;

}
