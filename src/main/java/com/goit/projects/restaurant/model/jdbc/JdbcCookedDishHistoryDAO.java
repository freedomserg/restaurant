package com.goit.projects.restaurant.model.jdbc;

import com.goit.projects.restaurant.model.dao.CookedDishHistoryDAO;
import com.goit.projects.restaurant.model.entity.CookedDish;
import com.goit.projects.restaurant.model.jdbc.rowMappers.CookedDishRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public class JdbcCookedDishHistoryDAO implements CookedDishHistoryDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveCookedDish(CookedDish newCookedDish) {
        String query = "INSERT INTO cooked_dishes (dish_id, cook_id, order_id, preparation_date) " +
                            "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(query, newCookedDish.getDish_id(), newCookedDish.getCook_id(),
                newCookedDish.getOrder_id(), new java.sql.Date(newCookedDish.getPreparation_date().getTime()));
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<CookedDish> findByDate(Date preparationDate) {
        String query = "SELECT * FROM cooked_dishes " +
                            "WHERE preparation_date = ?";
        return jdbcTemplate.query(query, new CookedDishRowMapper(), new java.sql.Date(preparationDate.getTime()));
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<CookedDish> findAll() {
        String query = "SELECT * FROM cooked_dishes";
        return jdbcTemplate.query(query, new CookedDishRowMapper());
    }
}
