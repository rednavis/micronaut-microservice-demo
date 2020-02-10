package com.rednavis.micronaut.employee;

import java.util.Optional;

public interface EmployeeService {

  Employee save(Employee employee);

  Employee update(Employee employee);

  Optional<Employee> findById(Long id);

  void deleteById(Long id);
}