package com.goit.projects.restaurant.controllers;

import com.goit.projects.restaurant.model.dao.EmployeeDAO;
import com.goit.projects.restaurant.model.entity.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class HEmployeeController {

    private EmployeeDAO employeeDAO;

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    public void createEmployee() {
        Employee employee = new Employee();
        employee.setEmployee_id(10);
        employee.setName("Jacob");
        employee.setSurname("Jason");
        employee.setBirthday(new Date((new GregorianCalendar(1980, 5, 11)).getTimeInMillis()));
        employee.setCell("3-3-44");
        employee.setPosition("waiter");
        employee.setSalary(11000);

        employeeDAO.saveEmployee(employee);
    }

    @Transactional
    public void removeEmployeeById(int id) {
        employeeDAO.removeEmployeeById(id);
    }

    @Transactional
    public List<Employee> getAll() {
        return employeeDAO.findAll();
    }

    @Transactional
    public List<Employee> getBySurname(String surname) {
        return employeeDAO.loadBySurname(surname);
    }
}
