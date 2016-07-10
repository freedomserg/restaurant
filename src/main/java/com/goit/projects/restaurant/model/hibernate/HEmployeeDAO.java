package com.goit.projects.restaurant.model.hibernate;

import com.goit.projects.restaurant.model.dao.EmployeeDAO;
import com.goit.projects.restaurant.model.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

public class HEmployeeDAO implements EmployeeDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveEmployee(Employee newEmployee) {
        sessionFactory.getCurrentSession().save(newEmployee);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeEmployeeById(int id) {
        Employee employee = sessionFactory.getCurrentSession().load(Employee.class, id);
        if (employee != null) {
            sessionFactory.getCurrentSession().delete(employee);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Employee> loadBySurname(String surname) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery
                ("SELECT e FROM Employee e WHERE e.surname like :surname");
        query.setParameter("surname", surname);
        return query.getResultList();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Employee loadById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.load(Employee.class, id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT e FROM Employee e").list();
    }
}
