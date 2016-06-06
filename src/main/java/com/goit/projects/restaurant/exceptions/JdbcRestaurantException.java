package com.goit.projects.restaurant.exceptions;

public class JdbcRestaurantException extends RuntimeException {

    public JdbcRestaurantException(String message) {
        super(message);
    }
}
