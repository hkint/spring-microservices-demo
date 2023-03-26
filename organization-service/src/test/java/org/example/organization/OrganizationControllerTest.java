package org.example.organization;

import org.example.organization.model.Organization;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {
                "spring.cloud.discovery.enabled=false",
                "spring.cloud.config.discovery.enabled=false"
        }
)
public class OrganizationControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void findAll() {
        Organization[] o = restTemplate.getForObject("/", Organization[].class);
        Assertions.assertTrue(o.length > 0);
    }

    @Test
    void findById() {
        Organization o = restTemplate.getForObject("/{id}", Organization.class, 1);
        Assertions.assertNotNull(o);
        Assertions.assertNotNull(o.getId());
        Assertions.assertEquals(1, o.getId());
    }

    @Test
    void add() {
        Organization o = new Organization("Test", "Test1");
        o = restTemplate.postForObject("/", o, Organization.class);
        Assertions.assertNotNull(o);
        Assertions.assertNotNull(o.getId());
        Assertions.assertEquals(3, o.getId());
    }
}