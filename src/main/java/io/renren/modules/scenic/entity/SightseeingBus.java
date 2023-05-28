package io.renren.modules.scenic.entity;

public class SightseeingBus extends AttractionsDecorator{

    Attractions attractions;

    @Override
    public String getScenicDescription() {
        return attractions.getScenicDescription() + ",观光车";
    }

    @Override
    public double getPrice() {
        return attractions.getPrice() + 20.0;
    }

    public SightseeingBus(Attractions attractions){
        this.attractions = attractions;
    }
}
