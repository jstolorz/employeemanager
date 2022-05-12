package com.bluesoft.employeemanager.service;

import com.bluesoft.employeemanager.exception.UserNotFoundException;
import com.bluesoft.employeemanager.model.Employee;
import com.bluesoft.employeemanager.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
class EmployeeService {

    private final EmployeeRepository employeeRepository;

    EmployeeService(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id \" + id + \" was not found"));
    }

    public void deleteEmployee(long id){
        employeeRepository.deleteEmployeeById(id);
    }

}
