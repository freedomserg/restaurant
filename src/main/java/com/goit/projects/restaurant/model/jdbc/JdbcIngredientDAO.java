package com.goit.projects.restaurant.model.jdbc;

import com.goit.projects.restaurant.model.entity.Ingredient;
import com.goit.projects.restaurant.model.dao.IngredientDAO;
import com.goit.projects.restaurant.model.jdbc.rowMappers.IngredientRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class JdbcIngredientDAO implements IngredientDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveIngredient(Ingredient newIngredient) {
        String query = "INSERT INTO ingredient (ingredient_name) VALUES (?)";
        jdbcTemplate.update(query, newIngredient.getIngredient_name());
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeById(int id) {
        String query = "DELETE FROM ingredient WHERE ingredient_id = ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeByName(String name) {
        String query = "DELETE FROM ingredient WHERE ingredient_name = ?";
        jdbcTemplate.update(query, name);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Ingredient loadById(int id) {
        String query = "SELECT * FROM ingredient WHERE ingredient_id = ?";
        return jdbcTemplate.queryForObject(query, new IngredientRowMapper(), id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Ingredient loadByName(String name) {
        String query = "SELECT * FROM ingredient WHERE ingredient_name = ?";
        return jdbcTemplate.queryForObject(query, new IngredientRowMapper(), name);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Ingredient> findAll() {
        String query = "SELECT * FROM ingredient";
        return jdbcTemplate.query(query, new IngredientRowMapper());
    }
}
