package com.goit.projects.restaurant.model.entity;

public class Store {
    private int ingredientId;
    private int quantity;
    private int minRequiredQuantity;

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMinRequiredQuantity() {
        return minRequiredQuantity;
    }

    public void setMinRequiredQuantity(int minRequiredQuantity) {
        this.minRequiredQuantity = minRequiredQuantity;
    }

    @Override
    public String toString() {
        return "Store{" +
                "ingredientId=" + ingredientId +
                ", quantity=" + quantity +
                ", minRequiredQuantity=" + minRequiredQuantity +
                '}';
    }
}
