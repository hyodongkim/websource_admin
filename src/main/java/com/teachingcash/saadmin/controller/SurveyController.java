package com.teachingcash.saadmin.controller;

import com.teachingcash.common.vo.PageVO;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.saadmin.service.SurveyService;
import com.teachingcash.saadmin.vo.SurveyAnswersVO;
import com.teachingcash.saadmin.vo.SurveyExamplesVO;
import com.teachingcash.saadmin.vo.SurveyQuestionsVO;
import com.teachingcash.saadmin.vo.SurveyVO;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/")
public class SurveyController {
    private static final Logger logger = LoggerFactory.getLogger(SurveyController.class);

    @Autowired
    SurveyService surveyService;

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/surveyList.do", method = RequestMethod.GET)
    public String surveyList(ModelMap model, HttpServletRequest request, PageVO pageVO, SurveyVO surveyVO) {

        int start = (pageVO.getPageIndex() -1) * 10;

        if(surveyVO == null){
            surveyVO = new SurveyVO();
        }
        surveyVO.setStart(start);
        surveyVO.setLimit(10);
        int total = surveyService.selectCntSurvey(surveyVO);
        List list = surveyService.listSurvey(surveyVO);

        model.addAttribute("list", list);

        PaginationInfo pageInfo = new PaginationInfo();
        pageInfo.setCurrentPageNo(pageVO.getPageIndex());
        pageInfo.setRecordCountPerPage(pageVO.getPageUnit());
        pageInfo.setPageSize(pageVO.getPageSize());
        pageInfo.setTotalRecordCount(total);

        model.addAttribute("paginationInfo", pageInfo);

        model.addAttribute("surveyVO", surveyVO);

        return "/admin/survey_list";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteSurveyAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String deleteSurveyAction(HttpServletRequest request, SurveyVO surveyVO, HttpSession session){

        int result = surveyService.deleteSurvey(surveyVO);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }

    @RequestMapping(value = "/surveyBoth.do", method = RequestMethod.GET)
    public String surveyBoth(ModelMap model, HttpServletRequest request, SurveyVO pSurveyVO, HttpSession session){
        SurveyVO surveyVO = new SurveyVO();

        if(pSurveyVO.getId() > 0){
            surveyVO = surveyService.selectSurvey(pSurveyVO.getId());
        }
        model.addAttribute("item", surveyVO);

        //설문 결과 표시
        List<SurveyQuestionsVO> surveyQuestionsVOS = surveyService.selectSurveysQuestions(surveyVO.getId());

        System.out.println("surveyQuestionsVOS....................");
        System.out.println(surveyQuestionsVOS);

        List<SurveyQuestionsVO> surveyQuestionsVOS1 = new ArrayList<SurveyQuestionsVO>();
        for (int i=0; i<surveyQuestionsVOS.size(); i++){
            SurveyQuestionsVO surveyQuestionsVO = surveyQuestionsVOS.get(i);
            List<SurveyAnswersVO> surveyAnswersVOS = surveyService.getPercentResult(new Integer(surveyQuestionsVO.getId()).toString());
            surveyQuestionsVO.setSurveyAnswersVOS(surveyAnswersVOS);
            surveyQuestionsVOS1.add(surveyQuestionsVO);
        }
        model.addAttribute("surveyQuestionsVOS1", surveyQuestionsVOS1);

        System.out.println("surveyQuestionsVOS1.............................");
        System.out.println(surveyQuestionsVOS1);

        return "/admin/survey_both";
    }

    @RequestMapping(value = "/surveyBoth.do", method = RequestMethod.POST)
    public String surveyBoth (ModelMap model, HttpServletRequest request, SurveyVO surveyVO) throws Exception {

        System.out.println("surveyVO...................");
        System.out.println(surveyVO.getSurveyQuestionsVOS());

        int result = surveyService.bothSurvey(surveyVO);

        if (result > 0) {
            model.addAttribute("redirectUrl", "surveyList.do");

            if (surveyVO.getId() > 0) {
                model.addAttribute("alertMsg", "설문을 성공적으로 수정했습니다.");
            } else {
                model.addAttribute("alertMsg", "설문을 성공적으로 등록했습니다.");
            }
        } else {
            model.addAttribute("alertMsg", "설문 등록에 실패했습니다.");
        }



        return "common/alert";
    }

    @RequestMapping(value = "/surveyPopup.do", method = RequestMethod.GET)
    public String surveyPopup(ModelMap model, SurveyQuestionsVO surveyQuestionsVO) {

        List<String> list = surveyService.selectSubjectiveAnswer(new Integer(surveyQuestionsVO.getId()).toString());
        model.addAttribute("list", list);

        return "/admin/survey_popup";
    }

    @ResponseBody
    @RequestMapping(value = "/surveyToggle.do", produces = "text/html; charset=UTF-8", method = RequestMethod.GET)
    public String surveyToggle(HttpServletRequest request, String is_show){

        int result = surveyService.toggleSurvey(is_show);
        if(result > 0) {
            return "SUCCESS";
        }else{
            return "오류가 발생했습니다.";
        }
    }
}
