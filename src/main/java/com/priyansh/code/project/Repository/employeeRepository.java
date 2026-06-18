package com.priyansh.code.project.Repository;

import com.priyansh.code.project.Entity.employeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface employeeRepository extends JpaRepository<employeeEntity, Long> {


}
