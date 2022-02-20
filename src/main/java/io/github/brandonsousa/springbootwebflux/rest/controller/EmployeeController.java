package io.github.brandonsousa.springbootwebflux.rest.controller;

import io.github.brandonsousa.springbootwebflux.model.Employee;
import io.github.brandonsousa.springbootwebflux.rest.dto.EmployeeStoreDTO;
import io.github.brandonsousa.springbootwebflux.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Mono<Employee>> store(@RequestBody @Valid EmployeeStoreDTO employee) {
        Employee e = new Employee();
        BeanUtils.copyProperties(employee, e);
        Mono<Employee> employeeMono = employeeService.store(e);
        HttpStatus status = employeeMono != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<Mono<Employee>>(employeeMono, status);
    }
}
