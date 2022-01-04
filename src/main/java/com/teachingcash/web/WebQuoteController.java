package com.teachingcash.web;

import com.teachingcash.saadmin.service.QuoteService;
import com.teachingcash.saadmin.vo.QuoteVO;
import com.teachingcash.util.MailVO;
import com.teachingcash.util.Mailer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/web")
public class WebQuoteController {
    private static final Logger logger = LoggerFactory.getLogger(WebQuoteController.class);

    @Autowired
    QuoteService quoteService;

    @ResponseBody
    @RequestMapping(value = "/quoteAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String quoteAction(HttpServletRequest request, QuoteVO quoteVO, HttpSession session){

        /*
        아이디, 비밀번호 필수체크
         */
        if(quoteVO.getName() == null || quoteVO.getName().equals("")){
            return "alert.0012";
        }
        if(quoteVO.getEmail() == null || quoteVO.getEmail().equals("")){
            return "alert.0006";
        }
        if(quoteVO.getCountry() == null || quoteVO.getCountry().equals("")){
            return "alert.0007";
        }
        if(quoteVO.getPlatform() == null || quoteVO.getPlatform().equals("")){
            return "alert.0013";
        }
        if(quoteVO.getInitial_cost() == null || quoteVO.getInitial_cost().equals("")){
            return "alert.0014";
        }
        if(quoteVO.getUse_area() == null || quoteVO.getUse_area().equals("")){
            return "alert.0015";
        }
        if(quoteVO.getActive_user_num() == null || quoteVO.getActive_user_num().equals("")){
            return "alert.0016";
        }
        if(quoteVO.getMax_concurrent_users() == null || quoteVO.getMax_concurrent_users().equals("")){
            return "alert.0017";
        }
        if(quoteVO.getService_num() == null || quoteVO.getService_num().equals("")){
            return "alert.0018";
        }
        if(quoteVO.getApp_num() == null || quoteVO.getApp_num().equals("")){
            return "alert.0019";
        }
        

        /*
        어드민 로그에 기록을 남김
         */
        String ip = request.getHeader("X-FORWARDED-FOR");
        if (ip == null)
            ip = request.getRemoteAddr();
        quoteVO.setIp(ip);
        quoteService.insertQuote(quoteVO);

        MailVO mailVO = new MailVO();
        mailVO.setSubject("[견적요청 문의접수]"+quoteVO.getName()+"/"+quoteVO.getEmail());
        mailVO.setContent(makeVOtoTable(quoteVO));
        mailVO.setToEmail("mangotwins2007@gmail.com");
        Mailer.sendMail(mailVO);

        return "SUCCESS";
    }

    private String makeVOtoTable(QuoteVO quoteVO){

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("마켓팅 동의여부", quoteVO.getIs_agree());
        map.put("이름(회사명)", quoteVO.getName());
        map.put("이메일", quoteVO.getEmail());
        map.put("국가", quoteVO.getCountry());
        map.put("플랫폼", quoteVO.getPlatform());
        map.put("초기(기본)비용", quoteVO.getInitial_cost());
        map.put("사용 면적", quoteVO.getUse_area());
        map.put("실제 사용자수", quoteVO.getActive_user_num());
        map.put("최대 동시 접속자수", quoteVO.getMax_concurrent_users());
        map.put("서비스 영역(지도)수", quoteVO.getService_num());
        map.put("필요 앱 개수", quoteVO.getApp_num());
        map.put("접속 아이피", quoteVO.getIp());
        map.put("등록 일시", quoteVO.getReg_timestamp());

        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<table border='1' cellspacing='0' cellpadding='10'>");

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if(entry.getValue() == null){
                continue;
            }
            htmlBuilder.append(String.format("<tr><td>%s</td><td>%s</td></tr>",
                    entry.getKey(), entry.getValue()));
        }

        htmlBuilder.append("</table>");

        String html = htmlBuilder.toString();
        return html;
    }
}