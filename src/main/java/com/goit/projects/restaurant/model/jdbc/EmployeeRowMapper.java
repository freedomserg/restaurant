package com.goit.projects.restaurant.model.jdbc;

import com.goit.projects.restaurant.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployee_id(resultSet.getInt("employee_id"));
        employee.setName(resultSet.getString("name"));
        employee.setSurname(resultSet.getString("surname"));
        employee.setBirthday(new Date(resultSet.getDate("birthday").getTime()));
        employee.setCell(resultSet.getString("cell"));
        employee.setPosition(resultSet.getString("position"));
        employee.setSalary(resultSet.getDouble("salary"));
        return employee;
    }
}