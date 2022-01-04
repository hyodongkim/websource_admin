package com.teachingcash.saadmin.vo;

public class RentalLastmonth {
    private int id;
    private int rental_id;
    private String performance;
    private String dc_price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getDc_price() {
        return dc_price;
    }

    public void setDc_price(String dc_price) {
        this.dc_price = dc_price;
    }
}
