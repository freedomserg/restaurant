package com.goit.projects.restaurant.model;

import java.util.List;

public interface DishDAO {

    void saveDish(Dish newDish);

    void removeDishById(int id);

    void removeDishByName(String name);

    Dish loadByName(String dishName);

    Dish loadById(int id);

    List<Dish> findAll();
}
