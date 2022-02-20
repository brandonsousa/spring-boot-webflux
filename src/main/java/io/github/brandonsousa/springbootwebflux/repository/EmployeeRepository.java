package io.github.brandonsousa.springbootwebflux.repository;

import io.github.brandonsousa.springbootwebflux.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, UUID> {
    Mono<Employee> findByEmail(String email);

    Flux<Employee> findByFirstName(String firstName);

    Flux<Employee> findByLastName(String lastName);
}
