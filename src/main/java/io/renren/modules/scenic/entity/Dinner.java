package io.renren.modules.scenic.entity;

public class Dinner extends AttractionsDecorator{
    Attractions attractions;

    @Override
    public String getScenicDescription() {
        return attractions.getScenicDescription() + ",晚餐";
    }

    @Override
    public double getPrice() {
        return attractions.getPrice() + 59.0;
    }

    public Dinner(Attractions attractions){
        this.attractions = attractions;
    }
}
