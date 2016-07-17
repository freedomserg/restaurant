package com.goit.projects.restaurant.model.hibernate;

import com.goit.projects.restaurant.model.dao.DishDAO;
import com.goit.projects.restaurant.model.entity.Dish;
import com.goit.projects.restaurant.model.entity.Ingredient;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HDishDAO implements DishDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveDish(Dish newDish) {
        sessionFactory.getCurrentSession().save(newDish);
    }

    @Override
    public void removeDishById(int id) {

    }

    @Override
    public void removeDishByName(String name) {

    }

    @Override
    public Dish loadByName(String dishName) {
        return null;
    }

    @Override
    public Dish loadById(int id) {
        return null;
    }

    @Override
    public List<Ingredient> loadIngredientsByDishName(String dishName) {
        return null;
    }

    @Override
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("SELECT d FROM Dish d").list();
    }
}
