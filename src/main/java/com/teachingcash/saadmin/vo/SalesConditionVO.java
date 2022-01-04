package com.teachingcash.saadmin.vo;

public class SalesConditionVO {

    private int id;
    private int rental_product_id;
    private String commitment_terms;
    private String price;

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

    public String getCommitment_terms() {
        return commitment_terms;
    }

    public void setCommitment_terms(String commitment_terms) {
        this.commitment_terms = commitment_terms;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
