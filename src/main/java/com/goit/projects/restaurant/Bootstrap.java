package com.goit.projects.restaurant;

import com.goit.projects.restaurant.controllers.EmployeeController;
import com.goit.projects.restaurant.controllers.FoodCategoryController;
import com.goit.projects.restaurant.model.Employee;
import com.goit.projects.restaurant.model.EmployeeDAO;
import com.goit.projects.restaurant.model.FoodCategory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Bootstrap {

    private EmployeeController employeeController;
    private FoodCategoryController foodCategoryController;

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setFoodCategoryController(FoodCategoryController foodCategoryController) {
        this.foodCategoryController = foodCategoryController;
    }

    public static void main(String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Bootstrap bootstrap = context.getBean("bootstrap", Bootstrap.class);
        bootstrap.execute();

    }

    private void execute() {
        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setCategory_name("beer");

        foodCategoryController.addCategory(foodCategory);


    }
}
