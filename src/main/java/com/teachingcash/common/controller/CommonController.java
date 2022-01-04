package com.teachingcash.common.controller;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.service.FileService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;

@Controller
@RequestMapping(value="/")
public class CommonController {

	@Autowired
	FileService fileService;


	@RequestMapping(value = "/imgview.do")
	public void imgVew(FileVO fvo, HttpServletResponse response) throws IOException {
		FileVO imageFile = fileService.selectFile(fvo);

		if(imageFile.getUploadPath().toLowerCase(Locale.ROOT).endsWith("svg")){
			response.setHeader("Content-type", "application/xhtml+xml; charset=UTF-8");
		}

		StringBuffer sb = new StringBuffer("file:");
		String fileName = imageFile.getUploadPath();
		sb.append(fileName);

		URL fileUrl = new URL(sb.toString());

		IOUtils.copy(fileUrl.openStream(), response.getOutputStream());
	}
}
