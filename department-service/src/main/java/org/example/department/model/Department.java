package org.example.department.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Department {

    public Department(Long organizationId, String name) {
        this.organizationId = organizationId;
        this.name = name;
    }

    private Long id;
    private Long organizationId;
    private String name;
    private List<Employee> employees = new ArrayList<>();
}