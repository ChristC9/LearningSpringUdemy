package com.chriscode.employeeproject.rest;



import com.chriscode.employeeproject.entity.Employee;
import com.chriscode.employeeproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmpService){
        this.employeeService = theEmpService;
    }

    @GetMapping("employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("employees/{emp_id}")
    public Employee getEmpbyId(@PathVariable int emp_id){

        Employee emp = employeeService.findById(emp_id);

        if (emp == null){
            throw  new RuntimeException("Employee id "+ emp_id + "Not Found!");
        }

        return emp;

    }

    @PostMapping("employees")
    public Employee addEmp(@RequestBody  Employee emp){


//        emp.setId(0);
        Employee empData = employeeService.save(emp);
        System.out.println(emp);
        return  empData;

    }

    @PutMapping("employees")
    public Employee updateEmp(@RequestBody Employee emp){

       Employee empData = employeeService.save(emp);

       return  empData;

    }

//    Request body parameter deleting

    @DeleteMapping("employees")
    public ResponseEntity<String> deleteEmp(@RequestBody Employee emp){

        try {
            employeeService.deletebyId(emp.getId());
            return new ResponseEntity<>(
                    "Id "+ emp.getId() + " is deleted successfully",
                    HttpStatus.OK
            );
        }catch (Exception e){

//            ResponseEntity.notFound();

            return new ResponseEntity<String>(
                    "Id "+ emp.getId() +" Not Found!",
                    HttpStatus.NOT_FOUND
            );

        }


    }

    // PathVariable parameter deleting
    
    @DeleteMapping("/employees/{emp_id}")
    public String deleteById(@PathVariable int emp_id){

        Employee emp = employeeService.findById(emp_id);

        if (emp == null) {
            throw new RuntimeException("Employee Id " + emp_id + " Not Found");
        }
        employeeService.deletebyId(emp_id);

        return "Employee id "+ emp_id + " is deleted";
    }

}
