package com.teachingcash.common.controller;


import com.teachingcash.common.Config;
import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping (value = "/editor")
public class SmartEditorController {

	@Autowired
	Config config;

	@Autowired
	FileService fileService;

	@RequestMapping(value = "/uploadForEditor.do", method = RequestMethod.POST)
	public String uploadForEditor (@RequestParam(value = "Filedata") MultipartFile file, HttpServletRequest request) {
		//if (!Utils.checkReferer(request)) return null;

		String fileTemp = "";
		String callback = request.getParameter("callback");
		String callback_func = request.getParameter("callback_func");
		String return3 = "";

		String category = "se";
		String originName = file.getOriginalFilename();
		long fileSize = file.getSize();

		try {
			fileTemp = FileUtils.fileUpload(file, request, "se");
            String uploadPath = config.getUploadPath() + category +"/" + fileTemp;

			return3 += "&bNewLine=true";
            return3 += "&sFileName=" + fileTemp;
            return3 += "&sFileURL=" + uploadPath;

            //에디터 이미지 띄우기 위헤 DB에 정보 저장
            FileVO fvo = new FileVO(0, category, originName, fileTemp, fileSize, uploadPath);
            fileService.insertFile(fvo);

		} catch (Exception e) {
	        return3 = "&errstr=error";
		}

		return "redirect:/" + callback + "?callback_func=" + callback_func + return3;
	}
}
