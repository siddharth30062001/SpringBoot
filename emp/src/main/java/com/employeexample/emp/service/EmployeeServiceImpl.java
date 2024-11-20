package com.employeexample.emp.service;

import com.employeexample.emp.dto.RequestDTO;
import com.employeexample.emp.entity.Employee;
import com.employeexample.emp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    //dependency injection using constructor
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public RequestDTO addEmployee(RequestDTO requestDTO) {
        Employee emp=new Employee(requestDTO);
        return  mapToDTO(employeeRepository.save(emp));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
    }

    @Override
    public Employee updateEmployee(int id, Employee emp) {
        Employee employee= getEmployeeById(id);
        employee.setName(emp.getName());
        employee.setAge(emp.getAge());
        employee.setCity(emp.getCity());
        employee.setSalary(emp.getSalary());

        return employeeRepository.save(employee);

    }

    public void deleteEmployeeById(int id){

        Employee employee=getEmployeeById(id);

        employeeRepository.deleteById(employee.getId());
    }

    public RequestDTO mapToDTO(Employee employee){
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setName(employee.getName());
        requestDTO.setSalary(employee.getSalary());
        requestDTO.setAge(employee.getAge());
        requestDTO.setCity(employee.getCity());
        return requestDTO;
    }
}
