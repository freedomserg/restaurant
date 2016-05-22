package com.goit.projects.restaurant.model;

import java.util.List;

public interface DishDAO {

    void addDish(Dish newDish);

    void removeDish(Dish dish);

    Dish loadByName(String dishName);

    List<Dish> findAll();
}
