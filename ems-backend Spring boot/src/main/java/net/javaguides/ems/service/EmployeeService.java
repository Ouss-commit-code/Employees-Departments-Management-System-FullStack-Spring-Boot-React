
package net.javaguides.ems.service;

import java.util.List;
import net.javaguides.ems.dto.EmployeeDto;


public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    
   EmployeeDto getEmployeeById(Long employeeId);
   
    List<EmployeeDto> getAllEmployees();
    
    //update Employee
    EmployeeDto updateEmployee(Long employeeId , EmployeeDto updatedEmployee);
    
    //delete employee
    void deleteEmployee(Long employeeId);
    
    
}
