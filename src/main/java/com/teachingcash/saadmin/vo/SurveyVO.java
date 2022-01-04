package com.teachingcash.saadmin.vo;

import java.util.List;

public class SurveyVO {
    private int id;
    private String survey_title;
    private String duration;
    private String benefit;
    private String introduction;
    private String date_start;
    private String date_end;
    private String is_multi_answers;
    private String reg_datetime;
    private String is_show;

    private List<SurveyQuestionsVO> surveyQuestionsVOS;

    private int start;
    private int limit;

    private int deleteFileSeq;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurvey_title() {
        return survey_title;
    }

    public void setSurvey_title(String survey_title) {
        this.survey_title = survey_title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIs_multi_answers() {
        return is_multi_answers;
    }

    public void setIs_multi_answers(String is_multi_answers) {
        this.is_multi_answers = is_multi_answers;
    }

    public String getReg_datetime() {
        return reg_datetime;
    }

    public void setReg_datetime(String reg_datetime) {
        this.reg_datetime = reg_datetime;
    }

    public List<SurveyQuestionsVO> getSurveyQuestionsVOS() {
        return surveyQuestionsVOS;
    }

    public void setSurveyQuestionsVOS(List<SurveyQuestionsVO> surveyQuestionsVOS) {
        this.surveyQuestionsVOS = surveyQuestionsVOS;
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

    public int getDeleteFileSeq() {
        return deleteFileSeq;
    }

    public void setDeleteFileSeq(int deleteFileSeq) {
        this.deleteFileSeq = deleteFileSeq;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public String getIs_show() {
        return is_show;
    }

    public void setIs_show(String is_show) {
        this.is_show = is_show;
    }
}
