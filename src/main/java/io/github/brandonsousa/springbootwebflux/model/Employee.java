package io.github.brandonsousa.springbootwebflux.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
public class Employee {
    @Id
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;
    private long salary;
}
