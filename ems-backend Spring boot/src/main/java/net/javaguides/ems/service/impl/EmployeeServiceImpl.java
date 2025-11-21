
package net.javaguides.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.exception.RessourceNotFoundException;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.EmployeeRepository;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    
    private final EmployeeRepository employeeRepository;
    
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> 
                        new RessourceNotFoundException("Employee doesnt exists with given id : " +employeeId));
       
       return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    //update employee
    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RessourceNotFoundException("Employee doesnt exists wit given Id :" +employeeId));
        
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee updatedEmployeeObj = employeeRepository.save(employee);
        
        
        
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    //delete employee
    @Override
    public void deleteEmployee(Long employeeId) {
        
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RessourceNotFoundException("Employee doesnt exists wit given Id :" +employeeId));
            employeeRepository.deleteById(employeeId);
        
        
    }
    
}
