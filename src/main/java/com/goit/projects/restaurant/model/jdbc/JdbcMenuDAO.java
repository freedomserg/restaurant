package com.goit.projects.restaurant.model.jdbc;

import com.goit.projects.restaurant.model.entity.Dish;
import com.goit.projects.restaurant.model.entity.Menu;
import com.goit.projects.restaurant.model.dao.MenuDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class JdbcMenuDAO implements MenuDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveMenu(Menu newMenu) {
        String query = "INSERT INTO menu (menu_name) VALUES (?)";
        jdbcTemplate.update(query, newMenu.getMenu_name());
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeById(int id) {
        String query = "DELETE FROM menu WHERE menu_id = ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeByName(String name) {
        String query = "DELETE FROM menu WHERE menu_name = ?";
        jdbcTemplate.update(query, name);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addDishTo(String menuName, String dishName) {
        String query = "INSERT INTO menu_dish (menu_id, dish_id) VALUES (" +
                                "(" +
                                "   SELECT menu.menu_id FROM menu WHERE menu.menu_name = ?" +
                                ")," +
                                "(" +
                                "   SELECT dish.dish_id FROM dish WHERE dish.dish_name = ?" +
                                ")" +
                            ")";
        jdbcTemplate.update(query, menuName, dishName);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeDishFrom(String menuName, String dishName) {
        String query = "DELETE FROM menu_dish " +
                            "WHERE menu_dish.menu_id = " +
                                    "(" +
                                    "   SELECT menu.menu_id FROM menu WHERE menu.menu_name = ?" +
                                    ")" +
                                "AND menu_dish.dish_id = " +
                                    "(" +
                                    "   SELECT dish.dish_id FROM dish WHERE dish.dish_name = ?" +
                                    ")";
        jdbcTemplate.update(query, menuName, dishName);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Menu loadByName(String name) {
        String query = "SELECT * FROM menu WHERE menu_name = ?";
        return jdbcTemplate.queryForObject(query, new MenuRowMapper(), name);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Menu loadById(int id) {
        String query = "SELECT * FROM menu WHERE menu_id = ?";
        return jdbcTemplate.queryForObject(query, new MenuRowMapper(), id);
    }

    @Override
    public List<Dish> loadDishesByMenuName(String menuName) {
        String query = "SELECT * FROM dish " +
                            "WHERE dish.dish_id IN (" +
                                "SELECT dish_id FROM menu_dish " +
                                    "INNER JOIN menu " +
                                        "ON menu_dish.menu_id = menu.menu_id " +
                                            "AND menu.menu_name = ?" +
                            ")";
        return jdbcTemplate.query(query, new DishRowMapper(), menuName);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Menu> findAll() {
        String query = "SELECT * FROM menu";
        return jdbcTemplate.query(query, new MenuRowMapper());
    }
}
