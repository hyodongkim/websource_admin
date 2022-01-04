package com.teachingcash.saadmin.vo;

import java.util.List;

public class Rental_productVO {

    private int id;
    private String product_name;
    private String maker;
    private String apply_link;
    private String model;
    private String category;
    private String delivery_type;
    private String ownership;
    private String specification;
    private String approval;
    private String sales;
    private String seller_code;
    private String maker_code;
    private String sell_start_date;
    private String sell_end_date;
    private String one_time_payment;

    private List<SalesConditionVO> salesConditionVOS;
    private List<LastMonthVO> lastMonthVOS;

    private String category_name;


    private String card_company;
    private String card_name;
    private String annual_fee_domestic_only;
    private String annual_fee_overseas;
    private String issue_apply_tel;
    private String issue_apply;
    private String issue_apply_url;
    private String product_announcement;
    private String product_announcement_note;
    private String shipping_info;
    private String shipping_info_note;
    private String refund_info;
    private String refund_info_note;
    private String minor_purchase;
    private String counseling_telephone;
    private String company_name;
    private String president;
    private String location;
    private String contact;
    private String brn;
    private String reg_datetime;

    private int start;
    private int limit;

    private String search_cat_name;
    private String search_product_name;
    private String search_maker;
    private String search_model;
    private String search_seller_code;
    private String search_maker_code;

    private int deleteFileSeq1;
    private int deleteFileSeq2;
    private int deleteFileSeq3;
    private int deleteFileSeq4;
    private int deleteFileSeq5;

    private String files_id1;
    private String original_name1;
    private String upload_path1;
    private String files_id2;
    private String original_name2;
    private String upload_path2;
    private String files_id3;
    private String original_name3;
    private String upload_path3;
    private String files_id4;
    private String original_name4;
    private String upload_path4;
    private String files_id5;
    private String original_name5;
    private String upload_path5;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getApply_link() {
        return apply_link;
    }

    public void setApply_link(String apply_link) {
        this.apply_link = apply_link;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDelivery_type() {
        return delivery_type;
    }

    public void setDelivery_type(String delivery_type) {
        this.delivery_type = delivery_type;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getSeller_code() {
        return seller_code;
    }

    public void setSeller_code(String seller_code) {
        this.seller_code = seller_code;
    }

    public String getMaker_code() {
        return maker_code;
    }

    public void setMaker_code(String maker_code) {
        this.maker_code = maker_code;
    }

    public String getSell_start_date() {
        return sell_start_date;
    }

    public void setSell_start_date(String sell_start_date) {
        this.sell_start_date = sell_start_date;
    }

    public String getSell_end_date() {
        return sell_end_date;
    }

    public void setSell_end_date(String sell_end_date) {
        this.sell_end_date = sell_end_date;
    }

    public String getOne_time_payment() {
        return one_time_payment;
    }

    public void setOne_time_payment(String one_time_payment) {
        this.one_time_payment = one_time_payment;
    }

    public List<SalesConditionVO> getSalesConditionVOS() {
        return salesConditionVOS;
    }

    public void setSalesConditionVOS(List<SalesConditionVO> salesConditionVOS) {
        this.salesConditionVOS = salesConditionVOS;
    }

    public List<LastMonthVO> getLastMonthVOS() {
        return lastMonthVOS;
    }

    public void setLastMonthVOS(List<LastMonthVO> lastMonthVOS) {
        this.lastMonthVOS = lastMonthVOS;
    }

    public String getCard_company() {
        return card_company;
    }

    public void setCard_company(String card_company) {
        this.card_company = card_company;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public String getAnnual_fee_domestic_only() {
        return annual_fee_domestic_only;
    }

    public void setAnnual_fee_domestic_only(String annual_fee_domestic_only) {
        this.annual_fee_domestic_only = annual_fee_domestic_only;
    }

    public String getAnnual_fee_overseas() {
        return annual_fee_overseas;
    }

    public void setAnnual_fee_overseas(String annual_fee_overseas) {
        this.annual_fee_overseas = annual_fee_overseas;
    }

    public String getIssue_apply_tel() {
        return issue_apply_tel;
    }

    public void setIssue_apply_tel(String issue_apply_tel) {
        this.issue_apply_tel = issue_apply_tel;
    }

    public String getIssue_apply() {
        return issue_apply;
    }

    public void setIssue_apply(String issue_apply) {
        this.issue_apply = issue_apply;
    }

    public String getIssue_apply_url() {
        return issue_apply_url;
    }

    public void setIssue_apply_url(String issue_apply_url) {
        this.issue_apply_url = issue_apply_url;
    }

    public String getProduct_announcement() {
        return product_announcement;
    }

    public void setProduct_announcement(String product_announcement) {
        this.product_announcement = product_announcement;
    }

    public String getProduct_announcement_note() {
        return product_announcement_note;
    }

    public void setProduct_announcement_note(String product_announcement_note) {
        this.product_announcement_note = product_announcement_note;
    }

    public String getShipping_info() {
        return shipping_info;
    }

    public void setShipping_info(String shipping_info) {
        this.shipping_info = shipping_info;
    }

    public String getShipping_info_note() {
        return shipping_info_note;
    }

    public void setShipping_info_note(String shipping_info_note) {
        this.shipping_info_note = shipping_info_note;
    }

    public String getRefund_info() {
        return refund_info;
    }

    public void setRefund_info(String refund_info) {
        this.refund_info = refund_info;
    }

    public String getRefund_info_note() {
        return refund_info_note;
    }

    public void setRefund_info_note(String refund_info_note) {
        this.refund_info_note = refund_info_note;
    }

    public String getMinor_purchase() {
        return minor_purchase;
    }

    public void setMinor_purchase(String minor_purchase) {
        this.minor_purchase = minor_purchase;
    }

    public String getCounseling_telephone() {
        return counseling_telephone;
    }

    public void setCounseling_telephone(String counseling_telephone) {
        this.counseling_telephone = counseling_telephone;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBrn() {
        return brn;
    }

    public void setBrn(String brn) {
        this.brn = brn;
    }

    public String getReg_datetime() {
        return reg_datetime;
    }

    public void setReg_datetime(String reg_datetime) {
        this.reg_datetime = reg_datetime;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSearch_cat_name() {
        return search_cat_name;
    }

    public void setSearch_cat_name(String search_cat_name) {
        this.search_cat_name = search_cat_name;
    }

    public String getSearch_product_name() {
        return search_product_name;
    }

    public void setSearch_product_name(String search_product_name) {
        this.search_product_name = search_product_name;
    }

    public String getSearch_maker() {
        return search_maker;
    }

    public void setSearch_maker(String search_maker) {
        this.search_maker = search_maker;
    }

    public String getSearch_model() {
        return search_model;
    }

    public void setSearch_model(String search_model) {
        this.search_model = search_model;
    }

    public String getSearch_seller_code() {
        return search_seller_code;
    }

    public void setSearch_seller_code(String search_seller_code) {
        this.search_seller_code = search_seller_code;
    }

    public String getSearch_maker_code() {
        return search_maker_code;
    }

    public void setSearch_maker_code(String search_maker_code) {
        this.search_maker_code = search_maker_code;
    }

    public int getDeleteFileSeq1() {
        return deleteFileSeq1;
    }

    public void setDeleteFileSeq1(int deleteFileSeq1) {
        this.deleteFileSeq1 = deleteFileSeq1;
    }

    public int getDeleteFileSeq2() {
        return deleteFileSeq2;
    }

    public void setDeleteFileSeq2(int deleteFileSeq2) {
        this.deleteFileSeq2 = deleteFileSeq2;
    }

    public int getDeleteFileSeq3() {
        return deleteFileSeq3;
    }

    public void setDeleteFileSeq3(int deleteFileSeq3) {
        this.deleteFileSeq3 = deleteFileSeq3;
    }

    public int getDeleteFileSeq4() {
        return deleteFileSeq4;
    }

    public void setDeleteFileSeq4(int deleteFileSeq4) {
        this.deleteFileSeq4 = deleteFileSeq4;
    }

    public int getDeleteFileSeq5() {
        return deleteFileSeq5;
    }

    public void setDeleteFileSeq5(int deleteFileSeq5) {
        this.deleteFileSeq5 = deleteFileSeq5;
    }

    public String getFiles_id1() {
        return files_id1;
    }

    public void setFiles_id1(String files_id1) {
        this.files_id1 = files_id1;
    }

    public String getOriginal_name1() {
        return original_name1;
    }

    public void setOriginal_name1(String original_name1) {
        this.original_name1 = original_name1;
    }

    public String getUpload_path1() {
        return upload_path1;
    }

    public void setUpload_path1(String upload_path1) {
        this.upload_path1 = upload_path1;
    }

    public String getFiles_id2() {
        return files_id2;
    }

    public void setFiles_id2(String files_id2) {
        this.files_id2 = files_id2;
    }

    public String getOriginal_name2() {
        return original_name2;
    }

    public void setOriginal_name2(String original_name2) {
        this.original_name2 = original_name2;
    }

    public String getUpload_path2() {
        return upload_path2;
    }

    public void setUpload_path2(String upload_path2) {
        this.upload_path2 = upload_path2;
    }

    public String getFiles_id3() {
        return files_id3;
    }

    public void setFiles_id3(String files_id3) {
        this.files_id3 = files_id3;
    }

    public String getOriginal_name3() {
        return original_name3;
    }

    public void setOriginal_name3(String original_name3) {
        this.original_name3 = original_name3;
    }

    public String getUpload_path3() {
        return upload_path3;
    }

    public void setUpload_path3(String upload_path3) {
        this.upload_path3 = upload_path3;
    }

    public String getFiles_id4() {
        return files_id4;
    }

    public void setFiles_id4(String files_id4) {
        this.files_id4 = files_id4;
    }

    public String getOriginal_name4() {
        return original_name4;
    }

    public void setOriginal_name4(String original_name4) {
        this.original_name4 = original_name4;
    }

    public String getUpload_path4() {
        return upload_path4;
    }

    public void setUpload_path4(String upload_path4) {
        this.upload_path4 = upload_path4;
    }

    public String getFiles_id5() {
        return files_id5;
    }

    public void setFiles_id5(String files_id5) {
        this.files_id5 = files_id5;
    }

    public String getOriginal_name5() {
        return original_name5;
    }

    public void setOriginal_name5(String original_name5) {
        this.original_name5 = original_name5;
    }

    public String getUpload_path5() {
        return upload_path5;
    }

    public void setUpload_path5(String upload_path5) {
        this.upload_path5 = upload_path5;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
