package com.goit.projects.restaurant.model;

import java.util.List;

public interface EmployeeDAO {

    void addEmployee(Employee newEmployee);

    void removeEmployee(Employee employee);

    Employee loadBySurname(String surname);

    List<Employee> findAll();
}
