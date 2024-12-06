package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.dto.RequestDTO;
import com.example.EmployeeManagement.dto.ResponseDTO;
import com.example.EmployeeManagement.exception.CustomException;
import com.example.EmployeeManagement.model.Address;
import com.example.EmployeeManagement.model.Employee;
import com.example.EmployeeManagement.model.Laptop;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    public RequestDTO addEmployeeData(RequestDTO requestDTO) {
        Employee employee=new Employee(requestDTO);

        List<Address> addresses = requestDTO.getAddress();
        addresses.forEach(address -> address.setEmployee(employee));
        employee.setAddress(addresses);

        Laptop laptop=requestDTO.getLaptop();
        laptop.setEmployee(employee);
        employee.setLaptop(laptop);
        return MapToDTO(employeeRepository.save(employee));
    }

    @Override
    public List<ResponseDTO> getAllEmployees() {

        return employeeRepository.findAll().stream().map((emp)->new ResponseDTO(emp.getId(), emp.getFName(), emp.getLName(), emp.getSalary(), emp.getProfilePic(), emp.getDepartment(),emp.getDoj(),emp.getGender(),emp.getNotes()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEmployeeById(int id) {
        Employee emp=getEmployee(id);
        employeeRepository.deleteById(emp.getId());
    }

    //To check employee is present or not
    public Employee getEmployee(int id){
         return employeeRepository.findById(id).orElseThrow(()-> new CustomException("Id not found"));
    }

    @Override
    public ResponseDTO getEmployeeById(int id) {
        //return employeeRepository.findById(id).orElseThrow(()-> new CustomException("Id not found"));

        return employeeRepository.findById(id).map(emp->new ResponseDTO(emp.getId(), emp.getFName(), emp.getLName(), emp.getSalary(), emp.getProfilePic(), emp.getDepartment(),emp.getDoj(),emp.getGender(),emp.getNotes())).orElseThrow(()-> new CustomException("Id not found"));
    }

    @Override
    public RequestDTO updateEmployeeById(int id, RequestDTO requestDTO) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new CustomException("Id not found"));
        employee.setFName(requestDTO.getFName());
        employee.setLName(requestDTO.getLName());
        employee.setSalary(requestDTO.getSalary());
        employee.setProfilePic(requestDTO.getProfilePic());
        employee.setDepartment(requestDTO.getDepartment());
        employee.setDoj(requestDTO.getDoj());
        employee.setNotes(requestDTO.getNotes());
        employee.setGender(requestDTO.getGender());


        return MapToDTO(employeeRepository.save(employee));


    }

    private RequestDTO MapToDTO(Employee employee) {

         RequestDTO requestDTO=new RequestDTO();
         requestDTO.setProfilePic(employee.getProfilePic());
         requestDTO.setNotes(employee.getNotes());
         requestDTO.setFName(employee.getFName());
         requestDTO.setLName(employee.getLName());
         requestDTO.setDoj(employee.getDoj());
         requestDTO.setId(employee.getId());
         requestDTO.setDepartment(employee.getDepartment());
         requestDTO.setGender(employee.getGender());
         requestDTO.setSalary(employee.getSalary());
         requestDTO.setDepartments(employee.getDepartments());
         requestDTO.setAddress(employee.getAddress());
         requestDTO.setLaptop(employee.getLaptop());

         return requestDTO;
    }
}
