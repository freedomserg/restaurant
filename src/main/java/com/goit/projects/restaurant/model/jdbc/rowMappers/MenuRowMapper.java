package com.goit.projects.restaurant.model.jdbc.rowMappers;

import com.goit.projects.restaurant.model.entity.Menu;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuRowMapper implements RowMapper<Menu> {

    @Override
    public Menu mapRow(ResultSet resultSet, int i) throws SQLException {
        Menu menu = new Menu();
        menu.setMenu_id(resultSet.getInt("menu_id"));
        menu.setMenu_name(resultSet.getString("menu_name"));
        return menu;
    }
}
