package com.rednavis.micronaut.employee;

import java.util.Optional;
import javax.inject.Inject;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/employee")
public class EmployeeController {

  @Inject
  private EmployeeRepository repository;

  @Get("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Optional<Employee> findById(Long id) {
    return repository.findById(id);
  }
}