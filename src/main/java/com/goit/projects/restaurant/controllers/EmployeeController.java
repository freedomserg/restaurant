package com.goit.projects.restaurant.controllers;

import com.goit.projects.restaurant.model.Employee;
import com.goit.projects.restaurant.model.EmployeeDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EmployeeController {

    private EmployeeDAO employeeDAO;

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    public List<Employee> getEmployeesBySurname(String surname) {
        return employeeDAO.loadBySurname(surname);
    }

    @Transactional
    public Employee getEmployeeById(int id) {
        return employeeDAO.loadById(id);
    }

    @Transactional
    public void addEmployee(Employee newEmployee) {
        employeeDAO.saveEmployee(newEmployee);
    }

    @Transactional
    public void deleteEmployeeById(int id) {
        employeeDAO.removeEmployeeById(id);
    }

    @Transactional
    public List<Employee> getAll() {
        return employeeDAO.findAll();
    }
}
