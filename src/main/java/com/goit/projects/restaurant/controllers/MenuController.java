package com.goit.projects.restaurant.controllers;

import com.goit.projects.restaurant.model.entity.Dish;
import com.goit.projects.restaurant.model.entity.Menu;
import com.goit.projects.restaurant.model.dao.MenuDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MenuController {

    private MenuDAO menuDAO;

    public void setMenuDAO(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    @Transactional
    public void addMenu(Menu newMenu) {
        menuDAO.saveMenu(newMenu);
    }

    @Transactional
    public void deleteById(int id) {
        menuDAO.removeById(id);
    }

    @Transactional
    public void deleteByName(String name) {
        menuDAO.removeByName(name);
    }

    @Transactional
    public void putDishTo(String menuName, String dishName) {
        menuDAO.addDishTo(menuName, dishName);
    }

    @Transactional
    public void deleteDishFrom(String menuName, String dishName) {
        menuDAO.removeDishFrom(menuName, dishName);
    }

    @Transactional
    public Menu getByName(String name) {
        return menuDAO.loadByName(name);
    }

    @Transactional
    public Menu getById(int id) {
        return menuDAO.loadById(id);
    }

    @Transactional
    public void getDishesByMenuName(String menuName) {
        List<Dish> dishes = menuDAO.loadDishesByMenuName(menuName);
        System.out.println(menuName + ":");
        dishes.forEach(System.out::println);
    }

    @Transactional
    public List<Menu> getAll() {
        return menuDAO.findAll();
    }


}
