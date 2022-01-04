package com.teachingcash.saadmin.service;

import com.teachingcash.saadmin.mapper.FileMapper;
import com.teachingcash.saadmin.mapper.SurveyMapper;
import com.teachingcash.saadmin.vo.SurveyAnswersVO;
import com.teachingcash.saadmin.vo.SurveyExamplesVO;
import com.teachingcash.saadmin.vo.SurveyQuestionsVO;
import com.teachingcash.saadmin.vo.SurveyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyService{


    @Autowired
    FileMapper fileMapper;

    @Autowired
    SurveyMapper surveyMapper;

    @Override
    public SurveyVO selectSurvey(int id){
        List<SurveyQuestionsVO> surveyQuestionsVOS = surveyMapper.selectSurveysQuestions(id);
        for (int i=0; i<surveyQuestionsVOS.size(); i++){
            SurveyQuestionsVO surveyQuestionsVO = (SurveyQuestionsVO) surveyQuestionsVOS.get(i);
            int surveys_quetions_id = surveyQuestionsVO.getId();
            List<SurveyExamplesVO> surveyExamplesVOList = surveyMapper.selectSurveysExamples(surveys_quetions_id);
            surveyQuestionsVO.setSurveyExamplesVOList(surveyExamplesVOList);
        }

        SurveyVO surveyVO = surveyMapper.selectSurvey(id);
        surveyVO.setSurveyQuestionsVOS(surveyQuestionsVOS);

        return surveyVO;
    }
    @Override
    public List<Object> listSurvey(SurveyVO surveyVO){
        return this.surveyMapper.listSurvey(surveyVO);
    }
    @Override
    public int selectCntSurvey(SurveyVO surveyVO){
        return this.surveyMapper.selectCntSurvey(surveyVO);
    }
    @Override
    public int bothSurvey(SurveyVO surveyVO){
        int result = 0;

        if(surveyVO.getId() > 0) {
            List<SurveyQuestionsVO> surveyQuestionsVOS = surveyVO.getSurveyQuestionsVOS();
            for (int i=0; i<surveyQuestionsVOS.size(); i++){
                int surveys_questions_id = surveyQuestionsVOS.get(i).getId();
                surveyMapper.deleteSurveyExample(surveys_questions_id);
            }
            surveyMapper.deleteSurveyQuestion(surveyVO.getId());

            for (int i=0; i<surveyQuestionsVOS.size(); i++){
                SurveyQuestionsVO surveyQuestionsVO = surveyQuestionsVOS.get(i);
                surveyQuestionsVO.setSurveys_id(surveyVO.getId());
                surveyMapper.insertSurveyQuestion(surveyQuestionsVO);
                int surveys_questions_id = surveyMapper.getMaxPkSurveyQuestions();

                List<SurveyExamplesVO> surveyExamplesVOList = surveyQuestionsVO.getSurveyExamplesVOList();
                for (int j=0; j<surveyExamplesVOList.size(); j++){
                    SurveyExamplesVO surveyExamplesVO = surveyExamplesVOList.get(j);
                    surveyExamplesVO.setSurveys_questions_id(surveys_questions_id);
                    surveyMapper.insertSurveyExample(surveyExamplesVO);
                }
            }
            result = surveyMapper.updateSurvey(surveyVO);
        }else{

            result = surveyMapper.insertSurvey(surveyVO);
            int maxSurveyPK = surveyMapper.getMaxPkSurvey();
            surveyVO.setId(maxSurveyPK);

            List<SurveyQuestionsVO> surveyQuestionsVOS = surveyVO.getSurveyQuestionsVOS();
            for (int i=0; i<surveyQuestionsVOS.size(); i++){
                SurveyQuestionsVO surveyQuestionsVO = surveyQuestionsVOS.get(i);
                surveyQuestionsVO.setSurveys_id(surveyVO.getId());
                surveyMapper.insertSurveyQuestion(surveyQuestionsVO);
                surveyQuestionsVO.setId(surveyMapper.getMaxPkSurveyQuestions());

                List<SurveyExamplesVO> surveyExamplesVOList = surveyQuestionsVO.getSurveyExamplesVOList();
                for (int j=0; j<surveyExamplesVOList.size(); j++){
                    SurveyExamplesVO surveyExamplesVO = surveyExamplesVOList.get(j);
                    surveyExamplesVO.setSurveys_questions_id(surveyQuestionsVO.getId());
                    surveyMapper.insertSurveyExample(surveyExamplesVO);
                }
            }
        }
        return result;
    }

    @Override
    public int deleteSurvey(SurveyVO surveyVO){
        return this.surveyMapper.deleteSurvey(surveyVO);
    }

    @Override
    public List<SurveyQuestionsVO> selectSurveysQuestions(int surveys_id){ return this.surveyMapper.selectSurveysQuestions(surveys_id);}

    @Override
    public List<SurveyExamplesVO> selectSurveysExamples(int surveys_question_id){ return this.surveyMapper.selectSurveysExamples(surveys_question_id);}

    @Override
    public List<SurveyAnswersVO> getPercentResult(String surveys_questions_id){ return this.surveyMapper.getPercentResult(surveys_questions_id);}

    @Override
    public List<String> selectSubjectiveAnswer(String surveys_questions_id) { return this.surveyMapper.selectSubjectiveAnswer(surveys_questions_id);}

    @Override
    public int toggleSurvey(String is_show){ return this.surveyMapper.toggleSurvey(is_show);}
}
