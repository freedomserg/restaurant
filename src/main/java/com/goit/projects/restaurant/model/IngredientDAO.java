package com.goit.projects.restaurant.model;

import java.util.List;

public interface IngredientDAO {

    void saveIngredient(Ingredient newIngredient);

    void removeById(int id);

    void removeByName(String name);

    Ingredient loadById(int id);

    Ingredient loadByName(String name);

    List<Ingredient> findAll();
}
