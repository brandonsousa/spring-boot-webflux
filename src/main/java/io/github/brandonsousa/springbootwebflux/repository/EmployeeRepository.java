package io.github.brandonsousa.springbootwebflux.repository;

import io.github.brandonsousa.springbootwebflux.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, UUID> {
}
