package io.github.brandonsousa.springbootwebflux.config;

import io.github.brandonsousa.springbootwebflux.handler.EmployeeHandler;
import io.github.brandonsousa.springbootwebflux.model.Employee;
import io.github.brandonsousa.springbootwebflux.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {
    @Bean
    @RouterOperations({@RouterOperation(path = "/employee/", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST, beanClass = EmployeeService.class, beanMethod = "createEmployee", operation = @Operation(operationId = "insertEmployee", responses = {@ApiResponse(responseCode = "201", description = "Employee created", content = @Content(schema = @Schema(implementation = Employee.class))), @ApiResponse(responseCode = "400", description = "Invalid Employee details supplied")}, requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = Employee.class)))))})
    RouterFunction<ServerResponse> routerFunctionEmployeeDetailByEmployeeIdRouter(EmployeeHandler employeeHandler) {
        return RouterFunctions.route(RequestPredicates.POST("/employee/"), employeeHandler::store);
    }
}
