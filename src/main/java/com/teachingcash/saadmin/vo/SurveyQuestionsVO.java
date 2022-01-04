package com.teachingcash.saadmin.vo;

import java.util.List;

public class SurveyQuestionsVO {
    private int id;
    private int surveys_id;
    private int no;
    private String question;
    private String is_multi_answer;

    private List<SurveyExamplesVO> surveyExamplesVOList;
    private List<SurveyAnswersVO> surveyAnswersVOS;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSurveys_id() {
        return surveys_id;
    }

    public void setSurveys_id(int surveys_id) {
        this.surveys_id = surveys_id;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getIs_multi_answer() {
        return is_multi_answer;
    }

    public void setIs_multi_answer(String is_multi_answer) {
        this.is_multi_answer = is_multi_answer;
    }

    public List<SurveyExamplesVO> getSurveyExamplesVOList() {
        return surveyExamplesVOList;
    }

    public void setSurveyExamplesVOList(List<SurveyExamplesVO> surveyExamplesVOList) {
        this.surveyExamplesVOList = surveyExamplesVOList;
    }

    public List<SurveyAnswersVO> getSurveyAnswersVOS() {
        return surveyAnswersVOS;
    }

    public void setSurveyAnswersVOS(List<SurveyAnswersVO> surveyAnswersVOS) {
        this.surveyAnswersVOS = surveyAnswersVOS;
    }
}
