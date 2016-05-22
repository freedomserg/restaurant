package com.goit.projects.restaurant.model;

import java.util.List;

public interface MenuDAO {

    void addMenu(Menu newMenu);

    void removeMenu(Menu menu);

    void addDishTo(Menu menu, Dish newDish);

    void removeDishFrom(Menu menu, Dish dish);

    Dish loadByName(String menuName);

    List<Menu> findAll();
}
