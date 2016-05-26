package com.goit.projects.restaurant.model.jdbc;

import com.goit.projects.restaurant.model.Employee;
import com.goit.projects.restaurant.model.EmployeeDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public class JdbcEmployeeDAO implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveEmployee(Employee newEmployee) {
        String query = "INSERT INTO employee (name, surname, birthday, cell," +
                "position, salary) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, newEmployee.getName(), newEmployee.getSurname(),
                new Date(newEmployee.getBirthday().getTime()), newEmployee.getCell(),
                newEmployee.getPosition(), newEmployee.getSalary());
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeEmployeeById(int id) {
        String query = "DELETE FROM employee WHERE employee_id = ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Employee> loadBySurname(String surname) {
        String query = "SELECT * FROM employee WHERE surname = ?";
        return jdbcTemplate.query(query, new EmployeeRowMapper(), surname);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Employee loadById(int id) {
        String query = "SELECT * FROM employee WHERE employee_id = ?";
        return jdbcTemplate.queryForObject(query, new EmployeeRowMapper(), id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Employee> findAll() {
        String query = "SELECT * FROM employee";
        return jdbcTemplate.query(query, new EmployeeRowMapper());
    }
}
