package com.goit.projects.restaurant;

import com.goit.projects.restaurant.controllers.EmployeeController;
import com.goit.projects.restaurant.model.Employee;
import com.goit.projects.restaurant.model.EmployeeDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Bootstrap {

    private EmployeeController employeeController;

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public static void main(String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Bootstrap bootstrap = context.getBean("bootstrap", Bootstrap.class);
        bootstrap.execute();

    }

    private void execute() {
        Employee employee = new Employee();
        employee.setName("Rick");
        employee.setSurname("Morgan");
        employee.setSalary(12000);
        employee.setPosition("guard");
        employee.setCell("1234500");
        employee.setBirthday(new Date(new GregorianCalendar(1985, 5, 10).getTimeInMillis()));
        employeeController.addEmployee(employee);

//        List<Employee> employees = employeeController.getEmployeesBySurname("Morgan");
//        for (Employee empl : employees) {
//            System.out.println(empl);
//        }

        //System.out.println(employeeController.getEmployeeById(11));
        //employeeController.deleteEmployeeById(11);
        //System.out.println(employeeController.getEmployeeById(11));

        List<Employee> employees2 = employeeController.getAll();
        for (Employee empl : employees2) {
            System.out.println(empl);
        }

    }
}
