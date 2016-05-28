package com.goit.projects.restaurant.model.dao;

import com.goit.projects.restaurant.model.entity.FoodCategory;

import java.util.List;

public interface FoodCategoryDAO {

    void saveCategory(FoodCategory newCategory);

    void removeCategoryById(int id);

    void removeCategoryByName(String name);

    FoodCategory loadByName(String name);

    FoodCategory loadById(int id);

    List<FoodCategory> findAll();
}
