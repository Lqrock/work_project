package com.temporary.workforce.management.dto;

import lombok.Data;

import java.sql.Time;

@Data
public class TimeSheetDTO {

    private int id;

    private String jobType;

    private String startingTime;

    private String finishingTime;

    private int pauseTime;

    private String projectName;
}
