package org.example.department;

import org.example.department.model.Department;
import org.example.department.repository.DepartmentRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.util.Assert;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartmentRepositoryTest {

    private static final DepartmentRepository repository = new DepartmentRepository();

    @Test
    @Order(1)
    void add() {
        Department department = new Department(1L, "Test");
        department = repository.add(department);
        Assert.notNull(department, "Department is null.");
        Assert.isTrue(department.getId() == 1L, "Department bad id.");
    }

    @Test
    @Order(2)
    void findById() {
        Department department = repository.findById(1L);
        Assert.notNull(department, "Department is null.");
        Assert.isTrue(department.getId() == 1L, "Department bad id.");
    }

    @Test
    @Order(3)
    void findAll() {
        List<Department> departments = repository.findAll();
        Assert.notNull(departments, "Department list is null.");
        Assert.isTrue(departments.size() > 0, "Department list is empty.");
    }

    @Test
    @Order(4)
    void findByOrganization() {
        List<Department> departments = repository.findByOrganization(1L);
        Assert.notNull(departments, "Department list is null.");
        Assert.isTrue(departments.size() > 0, "Department list is empty.");
    }
}