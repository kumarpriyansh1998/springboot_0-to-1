package com.priyansh.code.project.dto;

import java.time.LocalDate;
import java.util.Date;

public class employeeDto {
    public String employeeId;
    public boolean isActive;
    public LocalDate date;

    public employeeDto(String employeeId){
        this.employeeId = employeeId;
        this.isActive = true;
        this.date = LocalDate.now();
    }

}
