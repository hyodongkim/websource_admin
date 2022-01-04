package com.teachingcash.common.vo;

import java.io.Serializable;

public class PageVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6116610523452276473L;

    /**
     * 검색 설정
     */
    private String searchCondition;
    private String searchCondition2;
    private String searchCondition3;
    private String searchKeyword1;
    private String searchKeyword2;
    private String searchKeyword3;
    private String startDate;
    private String endDate;

    private String table;

    /**
     * 페이징 설정
     */
    private int pageIndex = 1; //현재 페이지
    private int pageUnit = 10; //페이지 개수
    private int pageSize = 10 ; //한 페이지에 정렬될 글 개수
    private int recordCountPerPage = 10;
    private int firstIndex = 1;
    private int lastIndex;

    public String getSearchCondition() {
        return searchCondition;
    }
    public void setSearchCondition(String searchCondition) {
        this.searchCondition = searchCondition;
    }
    public String getSearchCondition2() {
        return searchCondition2;
    }
    public void setSearchCondition2(String searchCondition2) {
        this.searchCondition2 = searchCondition2;
    }
    public String getSearchCondition3() {
        return searchCondition3;
    }
    public void setSearchCondition3(String searchCondition3) {
        this.searchCondition3 = searchCondition3;
    }
    public String getSearchKeyword1() {
        return searchKeyword1;
    }
    public void setSearchKeyword1(String searchKeyword1) {
        this.searchKeyword1 = searchKeyword1;
    }
    public String getSearchKeyword2() {
        return searchKeyword2;
    }
    public void setSearchKeyword2(String searchKeyword2) {
        this.searchKeyword2 = searchKeyword2;
    }
    public String getSearchKeyword3() {
        return searchKeyword3;
    }
    public void setSearchKeyword3(String searchKeyword3) {
        this.searchKeyword3 = searchKeyword3;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getTable() {
        return table;
    }
    public void setTable(String table) {
        this.table = table;
    }
    public int getPageIndex() {
        return pageIndex;
    }
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
    public int getPageUnit() {
        return pageUnit;
    }
    public void setPageUnit(int pageUnit) {
        this.pageUnit = pageUnit;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getRecordCountPerPage() {
        return recordCountPerPage;
    }
    public void setRecordCountPerPage(int recordCountPerPage) {
        this.recordCountPerPage = recordCountPerPage;
    }
    public int getFirstIndex() {
        return firstIndex;
    }
    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }
    public int getLastIndex() {
        return lastIndex;
    }
    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "PageVO [searchCondition=" + searchCondition + ", searchCondition2=" + searchCondition2 + ", searchCondition3=" + searchCondition3 + ", searchKeyword1=" + searchKeyword1 + ", searchKeyword2=" + searchKeyword2 + ", searchKeyword3=" + searchKeyword3 + ", startDate=" + startDate + ", endDate=" + endDate + ", table=" + table
                + ", pageIndex=" + pageIndex + ", pageUnit=" + pageUnit + ", pageSize=" + pageSize + ", recordCountPerPage=" + recordCountPerPage + ", firstIndex=" + firstIndex + ", lastIndex=" + lastIndex + "]";
    }

}

