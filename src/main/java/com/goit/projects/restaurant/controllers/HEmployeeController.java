package com.goit.projects.restaurant.controllers;

import com.goit.projects.restaurant.model.dao.EmployeeDAO;
import com.goit.projects.restaurant.model.entity.Employee;
import com.goit.projects.restaurant.model.entity.Waiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public class HEmployeeController {

    private EmployeeDAO employeeDAO;
    public Logger logger = LoggerFactory.getLogger(HEmployeeController.class);

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    public void createEmployee() {
        Waiter waiter = new Waiter();
        waiter.setName("Jacob");
        waiter.setSurname("Jason");
        waiter.setBirthday(new Date((new GregorianCalendar(1980, 5, 11)).getTimeInMillis()));
        waiter.setCell("3-3-44");
        waiter.setPosition("waiter");
        waiter.setSalary(12000);

        Set<Employee> employees = new HashSet<>(employeeDAO.findAll());
        if (!employees.contains(waiter)) {
            employeeDAO.saveEmployee(waiter);
        }
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

    @Transactional
    public Employee getById(int id) {
        return employeeDAO.loadById(id);
    }

    @Transactional
    public void printEmployees() {
        logger.info("Employess: ");
        getAll().forEach(System.out::println);
    }
}
