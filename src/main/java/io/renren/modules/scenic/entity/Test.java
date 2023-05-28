package io.renren.modules.scenic.entity;

public class Test {

    public static void main(String[] args) {
        Attractions attractions = new Dinner(new Hotel(new SightseeingBus(new AttractionsEntity(1, "七彩云南欢乐世界", 1, "七彩云南欢乐世界",2, 1, 98.0))));
        System.out.println(attractions.getScenicDescription());
        System.out.println(attractions.getPrice());
    }
}
