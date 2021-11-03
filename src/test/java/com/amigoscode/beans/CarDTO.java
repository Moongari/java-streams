package com.amigoscode.beans;

public class CarDTO {

    private final Integer id;
    private final Double price;


    public CarDTO(Integer id, Double price) {
        this.id = id;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }


}
