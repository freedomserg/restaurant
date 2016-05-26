package com.goit.projects.restaurant.model;

import java.util.List;

public interface FoodCategoryDAO {

    void saveCategory(FoodCategory newCategory);

    void removeCategory(FoodCategory category);

    FoodCategory loadByName(String name);

    List<FoodCategory> findAll();
}
