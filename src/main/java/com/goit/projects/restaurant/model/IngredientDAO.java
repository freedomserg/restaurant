package com.goit.projects.restaurant.model;

import java.util.List;

public interface IngredientDAO {

    void saveIngredient(Ingredient newIngredient);

    void removeIngredient(Ingredient ingredient);

    Ingredient loadByName(String name);

    List<Ingredient> findAll();
}
