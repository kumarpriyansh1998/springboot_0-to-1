package com.priyansh.code.project.controllers;

import com.priyansh.code.project.Entity.employeeEntity;
import com.priyansh.code.project.dto.employeeDto;
import com.priyansh.code.project.service.employeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final employeeService empService;

    public EmployeeController(employeeService empService){
        this.empService = empService;
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<employeeDto> getEmployeeInfo(@PathVariable Long employeeId){
        Optional<employeeDto> empdto =  empService.getEmployeeById(employeeId);
        return empdto.map(e->ResponseEntity.ok(e)).orElse(ResponseEntity.notFound().build());
    }

//notFound    @GetMapping("/employee")
//    public ResponseEntity<employeeDto> getEmployee(@RequestParam(required=true) Long Id){
//        return empService.getEmployeeById(Id);
//    }

    @PostMapping("/employee/save")
    public void saveEmployee(@RequestBody @Valid employeeDto empEnt){
        empService.saveEmployee(empEnt);
    }

    @GetMapping("/employee/getAll")
    public List<employeeDto> getAllEmployee(){
        List<employeeDto> edto =  empService.getAllEmployee();
        return edto;
    }

    @PutMapping("/employee/save/{Id}")
    public void saveOrUpdate(@PathVariable Long Id,@RequestBody employeeDto empDto){
        empService.saveOrUpdate(Id, empDto);
    }

    @DeleteMapping("/employee/delete/{id}")
    public void deleteEmployee(@PathVariable Long id){
        empService.delete(id);
    }

    @PatchMapping("employee/{employeeId}")
    public employeeDto patchEmployeeDetail(@PathVariable Long employeeId, @RequestBody Map<String, Object> updates){
        return empService.updateDetail(employeeId,updates);

    }


}
