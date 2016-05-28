package com.goit.projects.restaurant;

import com.goit.projects.restaurant.controllers.DishController;
import com.goit.projects.restaurant.controllers.EmployeeController;
import com.goit.projects.restaurant.controllers.FoodCategoryController;
import com.goit.projects.restaurant.controllers.IngredientController;
import com.goit.projects.restaurant.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Bootstrap {

    private EmployeeController employeeController;
    private FoodCategoryController foodCategoryController;
    private IngredientController ingredientController;
    private DishController dishController;

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setFoodCategoryController(FoodCategoryController foodCategoryController) {
        this.foodCategoryController = foodCategoryController;
    }

    public void setIngredientController(IngredientController ingredientController) {
        this.ingredientController = ingredientController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public static void main(String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Bootstrap bootstrap = context.getBean("bootstrap", Bootstrap.class);
        bootstrap.execute();

    }

    private void execute() {

    }
}
