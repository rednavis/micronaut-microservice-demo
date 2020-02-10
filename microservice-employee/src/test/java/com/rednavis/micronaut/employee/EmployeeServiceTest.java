package com.rednavis.micronaut.employee;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
public class EmployeeServiceTest {

  @Inject
  private EmployeeService employeeService;

  @Test
  public void shouldTestMainMethods() {
    Employee newEmployee = employeeService.save(Employee.builder()
        .name("test")
        .age(20)
        .build());
    assertEquals(newEmployee, employeeService.findById(newEmployee.getId()).orElse(null));

    newEmployee.setAge(30);
    employeeService.update(newEmployee);
    assertEquals(newEmployee, employeeService.findById(newEmployee.getId()).orElse(null));

    employeeService.deleteById(newEmployee.getId());
    assertNull(employeeService.findById(newEmployee.getId()).orElse(null));
  }
}