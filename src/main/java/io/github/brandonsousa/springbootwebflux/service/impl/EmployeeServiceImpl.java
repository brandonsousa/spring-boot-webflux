package io.github.brandonsousa.springbootwebflux.service.impl;


import io.github.brandonsousa.springbootwebflux.model.Employee;
import io.github.brandonsousa.springbootwebflux.repository.EmployeeRepository;
import io.github.brandonsousa.springbootwebflux.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Flux<Employee> index() {
        return employeeRepository.findAll();
    }

    @Override
    public Mono<Employee> store(Employee employee) {
        return save(employee);
    }

    @Override
    public Mono<Employee> showById(UUID id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Mono<Employee> showByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public Flux<Employee> showByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    @Override
    public Flux<Employee> showByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    @Override
    public Mono<Employee> update(Employee employee) {
        return save(employee);
    }

    @Override
    public Mono<Void> delete(UUID id) {
        return employeeRepository.deleteById(id);
    }


    private Mono<Employee> save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
