package com.teachingcash.web;

import com.teachingcash.saadmin.service.PartnerService;
import com.teachingcash.saadmin.vo.PartnerVO;
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
public class WebPartnerController {
    private static final Logger logger = LoggerFactory.getLogger(WebPartnerController.class);

    @Autowired
    PartnerService partnerService;

    @ResponseBody
    @RequestMapping(value = "/partnerAction.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
    public String partnerAction(HttpServletRequest request, PartnerVO partnerVO, HttpSession session){
        /*
        아이디, 비밀번호 필수체크
         */
        if(partnerVO.getName() == null || partnerVO.getName().equals("")){
            return "alert.0003";
        }
        if(partnerVO.getName_last() == null || partnerVO.getName_last().equals("")){
            return "alert.0004";
        }
        if(partnerVO.getEmail() == null || partnerVO.getEmail().equals("")){
            return "alert.0006";
        }
        if(partnerVO.getPosition() == null || partnerVO.getPosition().equals("")){
            return "alert.0025";
        }
        if(partnerVO.getCountry() == null || partnerVO.getCountry().equals("")){
            return "alert.0007";
        }
        if(partnerVO.getPhone() == null || partnerVO.getPhone().equals("")){
            return "alert.0008";
        }
        if(partnerVO.getCompany_name() == null || partnerVO.getCompany_name().equals("")){
            return "alert.0026";
        }
        if(partnerVO.getIndustry() == null || partnerVO.getIndustry().equals("")){
            return "alert.0005";
        }

        /*
        어드민 로그에 기록을 남김
         */
        String ip = request.getHeader("X-FORWARDED-FOR");
        if (ip == null)
            ip = request.getRemoteAddr();
        partnerVO.setIp(ip);
        partnerService.insertPartner(partnerVO);

        MailVO mailVO = new MailVO();
        mailVO.setSubject("[파트너 문의접수]"+partnerVO.getName()+"/"+partnerVO.getEmail());
        mailVO.setContent(makeVOtoTable(partnerVO));
        mailVO.setToEmail("mangotwins2007@gmail.com");
        Mailer.sendMail(mailVO);

        return "SUCCESS";
    }



    private String makeVOtoTable(PartnerVO partnerVO){

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("마켓팅 동의여부", partnerVO.getIs_agree());
        map.put("이름", partnerVO.getName());
        map.put("성", partnerVO.getName_last());
        map.put("이메일", partnerVO.getEmail());
        map.put("국가", partnerVO.getCountry());
        map.put("전화번호", partnerVO.getPhone());
        map.put("회사 이름", partnerVO.getCompany_name());
        map.put("산업", partnerVO.getIndustry());
        map.put("파트너 타입", partnerVO.getPartner_type());
        map.put("아이피", partnerVO.getIp());
        map.put("등록일시", partnerVO.getReg_timestamp());

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