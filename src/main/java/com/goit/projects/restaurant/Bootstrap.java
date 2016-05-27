package com.goit.projects.restaurant;

import com.goit.projects.restaurant.controllers.EmployeeController;
import com.goit.projects.restaurant.controllers.FoodCategoryController;
import com.goit.projects.restaurant.controllers.IngredientController;
import com.goit.projects.restaurant.model.Employee;
import com.goit.projects.restaurant.model.EmployeeDAO;
import com.goit.projects.restaurant.model.FoodCategory;
import com.goit.projects.restaurant.model.Ingredient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Bootstrap {

    private EmployeeController employeeController;
    private FoodCategoryController foodCategoryController;
    private IngredientController ingredientController;

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setFoodCategoryController(FoodCategoryController foodCategoryController) {
        this.foodCategoryController = foodCategoryController;
    }

    public void setIngredientController(IngredientController ingredientController) {
        this.ingredientController = ingredientController;
    }

    public static void main(String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Bootstrap bootstrap = context.getBean("bootstrap", Bootstrap.class);
        bootstrap.execute();

    }

    private void execute() {
        Ingredient item = new Ingredient();
        item.setIngredient_name("potato");

        ingredientController.addIngredient(item);
        System.out.println(ingredientController.getByName("potato"));
        System.out.println(ingredientController.getAll());

        ingredientController.deleteById(21);
        System.out.println(ingredientController.getAll());
    }
}
