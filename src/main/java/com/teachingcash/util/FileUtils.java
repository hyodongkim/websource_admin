package com.teachingcash.util;

import com.teachingcash.common.Config;
import com.teachingcash.common.vo.FileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class FileUtils {

    @Autowired
    static Config config;

	// 일반파일 업로드
    public static String fileUpload(MultipartFile file, HttpServletRequest request, String uploadDir) {
    	if (uploadDir == null || uploadDir.isEmpty()) return "";

        String fileTemp = "";
        String fileName = file.getOriginalFilename();
        String fileType = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".") + 1) : "";

        try {
            if (file.getSize() > 0) {
                fileTemp = fileType.isEmpty() ? UUID.randomUUID().toString().replace("-", "").substring(0, 12) : UUID.randomUUID().toString().replace("-", "").substring(0, 12) + "." + fileType;
                String realUploadDir = config.getUploadPath() + uploadDir;
                fileTemp = getUniqueFileName(realUploadDir, fileTemp);
                String filePath = realUploadDir + "/" + fileTemp;

                File dir = new File(realUploadDir);
                if (!dir.exists()) {
                    dir.mkdir();
                }

                java.io.File f = new java.io.File(filePath);
                file.transferTo(f);
            }

        } catch (IOException e) {
        	e.printStackTrace();
        	return "";
        }

        return fileTemp;
    }

    // 이미지(jpg, png, gif) 파일 업로드
    public static String imageFileUpload(MultipartFile file, HttpServletRequest request, String uploadDir) {

    	if (uploadDir == null || uploadDir.isEmpty()) return "";

        String fileTemp = "";
        String fileName = file.getOriginalFilename();
        String fileType = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".") + 1) : "";
        if (!fileType.equalsIgnoreCase("jpg") && !fileType.equalsIgnoreCase("jpeg") && !fileType.equalsIgnoreCase("png") && !fileType.equalsIgnoreCase("gif") && !fileType.equalsIgnoreCase("bmp")) return "";
        try {
            if (file.getSize() > 0) {
                fileTemp = fileType.isEmpty() ? UUID.randomUUID().toString().replace("-", "").substring(0, 12) : UUID.randomUUID().toString().replace("-", "").substring(0, 12) + "." + fileType;
                String realUploadDir = config.getUploadPath() + uploadDir;
                fileTemp = getUniqueFileName(realUploadDir, fileTemp);
                String filePath = realUploadDir + "/" + fileTemp;

                File dir = new File(realUploadDir);
                if (!dir.exists()) {
                    dir.mkdir();
                }

                java.io.File f = new java.io.File(filePath);
                file.transferTo(f);

            }

        } catch (IOException e) {
        	return "";
        }

        return fileTemp;
    }

    //파일 중복 체크
    public static String getUniqueFileName(String uploadDir, String file) {
        int fileCnt = 0;
        String fileName = file.substring(0, file.lastIndexOf("."));
        String fileType = file.contains(".") ? file.substring(file.lastIndexOf(".") + 1) : "";

        while (true) {
            fileCnt++;
            String filePath = fileType.isEmpty() ? uploadDir + "/" + fileName : uploadDir + "/" + fileName + "." + fileType;
            java.io.File f = new java.io.File(filePath);
            if (!f.exists()) {
                break;
            } else {
                fileName = file.substring(0, file.lastIndexOf(".")) + "_" + fileCnt;
            }
        }

        String result = fileName + "." + fileType;

        return result;
    }

    // 파일 다운로드
    public static void download(FileVO fvo, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		File file = new File(fvo.getUploadPath());

		if(!file.exists()) {
			PrintWriter out = null;
			try {
				response.setContentType("text/html;charset=UTF-8");
				out = response.getWriter();
				out.println("<script>alert('파일이 없습니다.');history.back();</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (out != null) out.close();
			}

			return;
		}

		String fileName = fvo.getOriginalName();
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1);

		if (ext.trim().equalsIgnoreCase("txt")) {
		    response.setContentType("text/plain");
		} else {
		    response.setContentType("application/octet-stream");
		}

		response.setContentLength((int) file.length());

		if (Utils.checkBrowserIE(request)) {
			fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", " ");
		}
		else {
			fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), "8859_1");
		}

		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

		OutputStream os = null;
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);
			os = response.getOutputStream();
		    FileCopyUtils.copy(fis, os);
		} catch (IOException e) {
		} finally {
			if (fis != null) { try { fis.close(); } catch (IOException e) {} }
			if (os != null) { try { os.close(); } catch (IOException e) {} }
		}
    }
}
