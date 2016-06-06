package com.goit.projects.restaurant.controllers;

import com.goit.projects.restaurant.model.dao.CookedDishHistoryDAO;
import com.goit.projects.restaurant.model.entity.CookedDish;
import com.goit.projects.restaurant.model.jdbc.JdbcCookedDishHistoryDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public class CookedDishHistoryController {

    private CookedDishHistoryDAO cookedDishHistoryDAO;

    public void setCookedDishHistoryDAO(CookedDishHistoryDAO cookedDishHistoryDAO) {
        this.cookedDishHistoryDAO = cookedDishHistoryDAO;
    }

    @Transactional
    public void addCookedDish(CookedDish newCookedDish) {
        cookedDishHistoryDAO.saveCookedDish(newCookedDish);
    }

    @Transactional
    public List<CookedDish> getByDate(Date preparationDate) {
        return cookedDishHistoryDAO.findByDate(preparationDate);
    }

    @Transactional
    public List<CookedDish> getAll() {
        return cookedDishHistoryDAO.findAll();
    }
}
