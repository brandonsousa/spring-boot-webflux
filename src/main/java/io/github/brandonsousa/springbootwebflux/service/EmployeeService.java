package io.github.brandonsousa.springbootwebflux.service;

import io.github.brandonsousa.springbootwebflux.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface EmployeeService {
    Flux<Employee> index();

    Mono<Employee> store(Employee employee);

    Mono<Employee> showById(UUID id);

    Mono<Employee> showByEmail(String email);

    Flux<Employee> showByFirstName(String firstName);

    Flux<Employee> showByLastName(String lastName);

    Mono<Employee> update(Employee employee);

    Mono<Void> delete(UUID id);
}
