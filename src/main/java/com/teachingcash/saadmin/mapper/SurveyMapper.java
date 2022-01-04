package com.teachingcash.saadmin.mapper;

import com.teachingcash.saadmin.vo.SurveyAnswersVO;
import com.teachingcash.saadmin.vo.SurveyExamplesVO;
import com.teachingcash.saadmin.vo.SurveyQuestionsVO;
import com.teachingcash.saadmin.vo.SurveyVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;

@Mapper("surveyMapper")
public interface SurveyMapper {
    SurveyVO selectSurvey(int survey_id);
    List<Object> listSurvey(SurveyVO surveyVO);
    List<SurveyExamplesVO> selectSurveysExamples(int surveys_question_id);
    List<SurveyQuestionsVO> selectSurveysQuestions(int surveys_id);
    int selectCntSurvey(SurveyVO surveyVO);
    int insertSurvey(SurveyVO surveyVO);
    int deleteSurvey(SurveyVO surveyVO);
    int deleteSurveyExample(int surveys_questions_id);
    int deleteSurveyQuestion(int surveys_id);
    int insertSurveyExample(SurveyExamplesVO surveyExamplesVO);
    int insertSurveyQuestion(SurveyQuestionsVO surveyQuestionsVO);
    int updateSurvey(SurveyVO surveyVO);
    int getMaxPkSurvey();
    int getMaxPkSurveyQuestions();
    List<SurveyAnswersVO> getPercentResult(String surveys_questions_id);
    List<String> selectSubjectiveAnswer(String surveys_questions_id);
    int toggleSurvey(String is_show);
}
