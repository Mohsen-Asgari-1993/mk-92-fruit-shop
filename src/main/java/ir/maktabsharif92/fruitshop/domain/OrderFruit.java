package ir.maktabsharif92.fruitshop.domain;

import ir.maktabsharif92.fruitshop.base.domain.Entity;
import ir.maktabsharif92.fruitshop.domain.enumeration.WeightUnit;

public class OrderFruit extends Entity {

    private Fruit fruit;

    private Integer weightUnitAmount;

    private String name;

    private WeightUnit weightUnit;

    private Integer weight;

    private Long price;

    private Long linedPrice;

    private Long totalPrice;

    public OrderFruit() {
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Integer getWeightUnitAmount() {
        return weightUnitAmount;
    }

    public void setWeightUnitAmount(Integer weightUnitAmount) {
        this.weightUnitAmount = weightUnitAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getLinedPrice() {
        return linedPrice;
    }

    public void setLinedPrice(Long linedPrice) {
        this.linedPrice = linedPrice;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
