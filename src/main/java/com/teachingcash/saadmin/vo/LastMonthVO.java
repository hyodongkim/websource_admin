package com.teachingcash.saadmin.vo;

public class LastMonthVO {
    private int id;
    private int rental_product_id;
    private String usage_amount;
    private String discount_amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRental_product_id() {
        return rental_product_id;
    }

    public void setRental_product_id(int rental_product_id) {
        this.rental_product_id = rental_product_id;
    }

    public String getUsage_amount() {
        return usage_amount;
    }

    public void setUsage_amount(String usage_amount) {
        this.usage_amount = usage_amount;
    }

    public String getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(String discount_amount) {
        this.discount_amount = discount_amount;
    }
}
