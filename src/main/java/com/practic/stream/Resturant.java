package com.practic.stream;

public class Resturant {


    private long id;
    private String name;
    private String city;
    private double estimated_cost;
    private double user_rating;

    public Resturant() {

    }



    @Override
    public String toString() {
        return "Resturant{" +
                "city='" + city + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", estimated_cost=" + estimated_cost +
                ", user_rating=" + user_rating +
                '}';
    }

    public double getEstimated_cost() {
        return estimated_cost;
    }

    public void setEstimated_cost(double estimated_cost) {
        this.estimated_cost = estimated_cost;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUser_rating() {
        return user_rating;
    }

    public void setUser_rating(double user_rating) {
        this.user_rating = user_rating;
    }


}
