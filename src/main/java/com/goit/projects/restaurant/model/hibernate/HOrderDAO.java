package com.goit.projects.restaurant.model.hibernate;

import com.goit.projects.restaurant.exceptions.HRestaurantException;
import com.goit.projects.restaurant.model.dao.OrderDAO;
import com.goit.projects.restaurant.model.entity.Dish;
import com.goit.projects.restaurant.model.entity.Order;
import com.goit.projects.restaurant.model.entity.OrderState;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

public class HOrderDAO implements OrderDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveOrder(Order newOrder) {
        sessionFactory.getCurrentSession().save(newOrder);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addDishTo(int orderId, String dishName, int dishQuantity) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeDishFrom(int orderId, String dishName) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void setNewDishQuantity(int orderId, String dishName, int newQuantity) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeOrder(int orderId) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void closeOrder(int orderId) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Dish> loadDishesByOrderId(int orderId) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Order> findOpened() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery
                ("SELECT o FROM Order o WHERE o.state like :state");
        query.setParameter("state", OrderState.OPENED);
        return query.getResultList();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Order> findClosed() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery
                ("SELECT o FROM Order o WHERE o.state like :state");
        query.setParameter("state", OrderState.CLOSED);
        return query.getResultList();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Order> findAll() {
        return sessionFactory.getCurrentSession().createQuery("SELECT o FROM Order o").list();
    }
}
