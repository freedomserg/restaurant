package com.goit.projects.restaurant.model.dao;

import com.goit.projects.restaurant.model.entity.CookedDish;

import java.util.Date;
import java.util.List;

public interface CookedDishHistoryDAO {

    void saveCookedDish(CookedDish newCookedDish);

    List<CookedDish> findByDate(Date preparationDate);

    List<CookedDish> findAll();
}
