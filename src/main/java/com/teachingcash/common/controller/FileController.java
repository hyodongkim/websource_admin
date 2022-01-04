package com.teachingcash.common.controller;

import com.teachingcash.common.vo.FileVO;
import com.teachingcash.saadmin.service.FileService;
import com.teachingcash.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;


@Controller
@RequestMapping(value="/util")
public class FileController {

	@Autowired
	FileService fileService;

	@RequestMapping(value = "/download.do")
	public void fileDownload (@RequestParam int id, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		System.out.println("fileDownload................");
//		if (!Utils.checkReferer(request)) return;
		FileVO fileVO = new FileVO();
		fileVO.setId(id);
		fileVO = fileService.selectFile(fileVO);

		FileUtils.download(fileVO, request, response);
	}
}
