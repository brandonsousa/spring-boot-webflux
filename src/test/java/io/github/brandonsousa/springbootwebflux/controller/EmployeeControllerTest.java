package io.github.brandonsousa.springbootwebflux.controller;

import io.github.brandonsousa.springbootwebflux.model.Employee;
import io.github.brandonsousa.springbootwebflux.repository.EmployeeRepository;
import io.github.brandonsousa.springbootwebflux.rest.controller.EmployeeController;
import io.github.brandonsousa.springbootwebflux.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import java.util.UUID;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = EmployeeController.class)
@Import(EmployeeService.class)
public class EmployeeControllerTest {
    @MockBean
    private EmployeeRepository employeeRepository;
    @Autowired
    private WebTestClient webClient;

    @Test
    void storeEmployee() {
        Employee employee = new Employee();
        employee.setUuid(UUID.randomUUID());
        employee.setFirstName("Brandon");
        employee.setLastName("Sousa");
        employee.setEmail("brandon@email.com");
        employee.setSalary(100000L);
        Mockito.when(employeeRepository.save(employee)).thenReturn(Mono.just(employee));
        webClient
                .post()
                .uri("/employee/")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(employee))
                .exchange()
                .expectStatus().isCreated();
        Mockito.verify(employeeRepository, Mockito.times(1)).save(employee);
    }
}
