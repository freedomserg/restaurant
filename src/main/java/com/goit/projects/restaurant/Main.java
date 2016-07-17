package com.goit.projects.restaurant;

import com.goit.projects.restaurant.controllers.HEmployeeController;
import com.goit.projects.restaurant.controllers.HOrderController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    private HEmployeeController hEmployeeController;
    private HOrderController hOrderController;

    public void sethEmployeeController(HEmployeeController hEmployeeController) {
        this.hEmployeeController = hEmployeeController;
    }

    public void sethOrderController(HOrderController hOrderController) {
        this.hOrderController = hOrderController;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-contextH.xml",
                "hibernate-context.xml");
        Main main = applicationContext.getBean("main", Main.class);
        main.start();
    }

    private void start() {
        hOrderController.printOrders();

    }
}
