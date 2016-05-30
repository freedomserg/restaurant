package com.goit.projects.restaurant;

import com.goit.projects.restaurant.controllers.*;
import com.goit.projects.restaurant.model.entity.Ingredient;
import com.goit.projects.restaurant.model.entity.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class Bootstrap {

    private EmployeeController employeeController;
    private FoodCategoryController foodCategoryController;
    private IngredientController ingredientController;
    private DishController dishController;
    private MenuController menuController;
    private OrderController orderController;

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

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public static void main(String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Bootstrap bootstrap = context.getBean("bootstrap", Bootstrap.class);
        bootstrap.execute();

    }

    private void execute() {
    }
}
