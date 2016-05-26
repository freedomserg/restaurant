package com.goit.projects.restaurant.model;

import java.util.List;

public interface EmployeeDAO {

    void saveEmployee(Employee newEmployee);

    void removeEmployeeById(int id);

    List<Employee> loadBySurname(String surname);

    Employee loadById(int id);

    List<Employee> findAll();
}
