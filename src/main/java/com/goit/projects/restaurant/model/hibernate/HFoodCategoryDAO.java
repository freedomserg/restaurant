package com.goit.projects.restaurant.model.hibernate;

import com.goit.projects.restaurant.model.dao.FoodCategoryDAO;
import com.goit.projects.restaurant.model.entity.FoodCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

public class HFoodCategoryDAO implements FoodCategoryDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveCategory(FoodCategory newCategory) {

    }

    @Override
    public void removeCategoryById(int id) {

    }

    @Override
    public void removeCategoryByName(String name) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public FoodCategory loadByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery
                ("SELECT c FROM FoodCategory c WHERE c.category_name like :name");
        query.setParameter("name", name);
        return (FoodCategory) query.getSingleResult();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public FoodCategory loadById(int id) {
        return sessionFactory.getCurrentSession().load(FoodCategory.class, id);
    }

    @Override
    public List<FoodCategory> findAll() {
        return null;
    }
}
