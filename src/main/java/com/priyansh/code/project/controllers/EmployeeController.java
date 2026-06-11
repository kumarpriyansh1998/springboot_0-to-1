package com.priyansh.code.project.controllers;

import com.priyansh.code.project.dto.employeeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class EmployeeController {

    @GetMapping("/employee/{employeeId}")
    public employeeDto getEmployeeById(@PathVariable String employeeId){
        employeeDto emp = new  employeeDto(employeeId);
        System.out.println(emp.employeeId);
        return emp;
    }

    @GetMapping("/employee")
    public employeeDto getEmployee(@RequestParam(required=false) String employeeId){
        employeeDto emp = new  employeeDto(employeeId);
        System.out.println(emp.employeeId);
        return emp;
    }

}
