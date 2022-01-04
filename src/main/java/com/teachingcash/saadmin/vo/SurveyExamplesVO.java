package com.teachingcash.saadmin.vo;

public class SurveyExamplesVO {
    private int id;
    private int surveys_questions_id;
    private String answer_text;
    private String type;
    private String order_by;

    private String result_percent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSurveys_questions_id() {
        return surveys_questions_id;
    }

    public void setSurveys_questions_id(int surveys_questions_id) {
        this.surveys_questions_id = surveys_questions_id;
    }

    public String getAnswer_text() {
        return answer_text;
    }

    public void setAnswer_text(String answer_text) {
        this.answer_text = answer_text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrder_by() {
        return order_by;
    }

    public void setOrder_by(String order_by) {
        this.order_by = order_by;
    }

    public String getResult_percent() {
        return result_percent;
    }

    public void setResult_percent(String result_percent) {
        this.result_percent = result_percent;
    }
}
