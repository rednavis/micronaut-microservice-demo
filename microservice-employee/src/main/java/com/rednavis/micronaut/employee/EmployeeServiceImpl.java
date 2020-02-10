package com.rednavis.micronaut.employee;

import java.util.Optional;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

  @Inject
  private EmployeeRepository employeeRepository;

  @Override
  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public Employee update(Employee employee) {
    return employeeRepository.update(employee);
  }

  @Override
  public Optional<Employee> findById(Long id) {
    return employeeRepository.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    employeeRepository.deleteById(id);
  }
}
