package com.teachingcash.saadmin.vo;

public class SurveyAnswersVO {
    private int id;
    private int members_id;
    private int surveys_id;
    private int surveys_questions_id;
    private int surveys_examples_id;
    private String subjective_answer;
    private String response_datetime;

    private String answer_select;
    private String result_percent;
    private String answer_text;
    private String text_answer;
    private String answer_cnt;
    private String total_answer_cnt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMembers_id() {
        return members_id;
    }

    public void setMembers_id(int members_id) {
        this.members_id = members_id;
    }

    public int getSurveys_id() {
        return surveys_id;
    }

    public void setSurveys_id(int surveys_id) {
        this.surveys_id = surveys_id;
    }

    public int getSurveys_questions_id() {
        return surveys_questions_id;
    }

    public void setSurveys_questions_id(int surveys_questions_id) {
        this.surveys_questions_id = surveys_questions_id;
    }

    public int getSurveys_examples_id() {
        return surveys_examples_id;
    }

    public void setSurveys_examples_id(int surveys_examples_id) {
        this.surveys_examples_id = surveys_examples_id;
    }

    public String getSubjective_answer() {
        return subjective_answer;
    }

    public void setSubjective_answer(String subjective_answer) {
        this.subjective_answer = subjective_answer;
    }

    public String getResponse_datetime() {
        return response_datetime;
    }

    public void setResponse_datetime(String response_datetime) {
        this.response_datetime = response_datetime;
    }

    public String getAnswer_select() {
        return answer_select;
    }

    public void setAnswer_select(String answer_select) {
        this.answer_select = answer_select;
    }

    public String getResult_percent() {
        return result_percent;
    }

    public void setResult_percent(String result_percent) {
        this.result_percent = result_percent;
    }

    public String getAnswer_text() {
        return answer_text;
    }

    public void setAnswer_text(String answer_text) {
        this.answer_text = answer_text;
    }

    public String getText_answer() {
        return text_answer;
    }

    public void setText_answer(String text_answer) {
        this.text_answer = text_answer;
    }

    public String getAnswer_cnt() {
        return answer_cnt;
    }

    public void setAnswer_cnt(String answer_cnt) {
        this.answer_cnt = answer_cnt;
    }

    public String getTotal_answer_cnt() {
        return total_answer_cnt;
    }

    public void setTotal_answer_cnt(String total_answer_cnt) {
        this.total_answer_cnt = total_answer_cnt;
    }
}
