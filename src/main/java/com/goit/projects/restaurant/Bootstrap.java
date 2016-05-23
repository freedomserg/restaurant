package com.goit.projects.restaurant;

import com.goit.projects.restaurant.model.Employee;
import com.goit.projects.restaurant.model.EmployeeDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Bootstrap {

    private EmployeeDAO employeeDAO;

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public static void main(String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Bootstrap bootstrap = context.getBean("bootstrap", Bootstrap.class);
        bootstrap.execute();

    }

    private void execute() {
        List<Employee> employees = employeeDAO.loadBySurname("Deere");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }
}
