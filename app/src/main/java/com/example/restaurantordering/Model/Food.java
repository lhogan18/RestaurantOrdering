package com.example.restaurantordering.Model;

public class Food {
    private String Name, Description, Price, Discount, MenuID;

    public Food(){

    }

    public Food(String name, String description, String price, String discount, String menuID){
        Name = name;
        Description = description;
        Price = price;
        Discount = discount;
        MenuID = menuID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getMenuID() {
        return MenuID;
    }

    public void setMenuID(String menuID) {
        MenuID = menuID;
    }
}
