package com.server.nata_service.services;

import com.server.nata_service.dto.EmployeeDTO;
import com.server.nata_service.entities.Employee;
import com.server.nata_service.repositories.EmployeeRepository;
import com.server.nata_service.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employee;
    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAll(Pageable pageable){
        Page<Employee> employee1 = employee.findAll(pageable);
        return employee1.map(x -> new EmployeeDTO(x));
    }

    @Transactional(readOnly = true)
    public EmployeeDTO findById(Long id){
        Employee employee1 = employee.findById(id).orElseThrow(()->new ResourceNotFoundException("Recurso nao encontrado"));
        return new EmployeeDTO(employee1);
    }
}
