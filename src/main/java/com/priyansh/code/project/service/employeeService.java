package com.priyansh.code.project.service;


import com.priyansh.code.project.Entity.employeeEntity;
import com.priyansh.code.project.Repository.employeeRepository;
import com.priyansh.code.project.dto.employeeDto;
import org.modelmapper.ModelMapper;
//import org.springframework.data.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class employeeService {

    private final employeeRepository empRepo;
    private final ModelMapper mapper;


    public employeeService(employeeRepository empRepo,ModelMapper mapper){
        this.empRepo = empRepo;
        this.mapper = mapper;
    }





    public Optional<employeeDto> getEmployeeById(Long id){
        Optional<employeeEntity> empEnt = empRepo.findById(id);
        return empEnt.map(emp->mapper.map(emp,employeeDto.class));
    }

    public void saveEmployee(employeeDto empDto){
//        Optional<employeeEntity> empEnt = empRepo.findById(id);
        employeeEntity empEnt = mapper.map(empDto,employeeEntity.class);
        empRepo.save(empEnt);
    }

    public List<employeeDto> getAllEmployee(){
        List<employeeEntity> emp = empRepo.findAll();
        List<employeeDto> elist =  emp.stream().map(employeeEntity -> mapper.map(employeeEntity,employeeDto.class)).collect(Collectors.toList());
        return elist;
    }

    public void saveOrUpdate(Long id, employeeDto empDto) {
        employeeEntity empent = mapper.map(empDto,employeeEntity.class);
        empent.setId(id);
        empRepo.save(empent);

    }

    public void delete(Long id) {
        empRepo.deleteById(id);
    }

    public employeeDto updateDetail(Long employeeId, Map<String,Object> updates){
        boolean emp_repo = empRepo.existsById(employeeId);
        if(!emp_repo) return null;
        else{
            employeeEntity empEnt = empRepo.findById(employeeId).get();
            updates.forEach((k,v)->{
                Field field = ReflectionUtils.findField(employeeEntity.class,k);
                if(field !=null) {
                    field.setAccessible(true);
                    if(field.getType().equals(Long.class) && v instanceof Integer){
                        v = ((Integer) v).longValue();
                    }
                    ReflectionUtils.setField(field, empEnt, v);
                }
            });
            empRepo.save(empEnt);
            return mapper.map(empEnt,employeeDto.class);
        }




    }
}
