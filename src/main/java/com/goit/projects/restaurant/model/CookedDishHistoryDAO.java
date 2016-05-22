package com.goit.projects.restaurant.model;

import java.util.Date;
import java.util.List;

public interface CookedDishHistoryDAO {

    void addCookedDish(CookedDish newCookedDish);

    List<CookedDish> findByDate(Date preparationDate);

    List<CookedDish> findAll();
}
