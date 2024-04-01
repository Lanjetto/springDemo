package com.nexign.springMessageSender.model;

public class Destination implements DestinationInterface{
    private String city;

    public Destination(String city) {
        this.city = city;
    }

    public Destination() {
        this.city = "St.Peterburg";
    }
    @Override
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
