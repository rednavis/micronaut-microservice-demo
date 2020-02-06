package com.rednavis.micronaut.employee;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
public class EmployeeRepositoryTest {

  @Inject
  EmployeeRepository employeeRepository;

  @Test
  public void shouldTestCrudMethods() {
    Optional<Employee> employee =  employeeRepository.findById(1L);
    assertNotNull(employee.orElse(null));
    employeeRepository.deleteById(1L);
    employee =  employeeRepository.findById(1L);
    assertNull(employee.orElse(null));
  }
}
