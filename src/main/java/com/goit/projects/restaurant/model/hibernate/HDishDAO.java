package com.goit.projects.restaurant.model.hibernate;

import com.goit.projects.restaurant.model.dao.DishDAO;
import com.goit.projects.restaurant.model.entity.Dish;
import com.goit.projects.restaurant.model.entity.Ingredient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

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
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeDishById(int id) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeDishByName(String name) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Dish loadByName(String dishName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery
                ("SELECT d FROM Dish d WHERE d.dish_name like :name");
        query.setParameter("name", dishName);
        return (Dish) query.getSingleResult();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Dish loadById(int id) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Ingredient> loadIngredientsByDishName(String dishName) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("SELECT d FROM Dish d").list();
    }
}
