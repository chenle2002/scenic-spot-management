package io.renren.modules.scenic.entity;

public class Hotel extends AttractionsDecorator {
    Attractions attractions;

    @Override
    public String getScenicDescription() {
        return attractions.getScenicDescription() + ",豪华酒店";
    }
    @Override
    public double getPrice() {
        return attractions.getPrice() + 199.0;
    }
    public Hotel(Attractions attractions){
        this.attractions = attractions;
    }
}
