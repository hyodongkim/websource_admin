package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.vo.SurveyAnswersVO;
import com.teachingcash.saadmin.vo.SurveyExamplesVO;
import com.teachingcash.saadmin.vo.SurveyQuestionsVO;
import com.teachingcash.saadmin.vo.SurveyVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SurveyService {

    SurveyVO selectSurvey(int id);
    List<Object> listSurvey(SurveyVO surveyVO);
    int selectCntSurvey(SurveyVO surveyVO);
    int bothSurvey(SurveyVO surveyVO);
    int deleteSurvey(SurveyVO surveyVO);
    List<SurveyQuestionsVO> selectSurveysQuestions(int surveys_id);
    List<SurveyExamplesVO> selectSurveysExamples(int surveys_question_id);
    List<SurveyAnswersVO> getPercentResult(String surveys_questions_id);
    List<String> selectSubjectiveAnswer(String surveys_questions_id);
    int toggleSurvey(String is_show);
}
