package io.github.brandonsousa.springbootwebflux.handler;

import io.github.brandonsousa.springbootwebflux.model.Employee;
import io.github.brandonsousa.springbootwebflux.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class EmployeeHandler {
    @Autowired
    private EmployeeRepository repository;


    public Mono<ServerResponse> store(ServerRequest request) {
        Mono<Employee> employee = request.bodyToMono(Employee.class);
        Mono<Employee> saved = employee.flatMap(repository::save);
        return ServerResponse.ok().body(saved, Employee.class);
    }

}
