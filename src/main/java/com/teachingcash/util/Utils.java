package com.teachingcash.util;

import org.json.simple.JSONObject;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Resource(name = "")
public class Utils {
    //public final static String AUTH_KEY_FCM_DEV = "AAAAYchzF9Y:APA91bE89I1Jkle9crhmDaPSu1LB_wVDa1aUtsVJEDbwQ0s-typ7SwM5VgcOGgb2anBQnvYLj3sncs96CqJ8fXmg7aFBVnftutv59cb3TIGVwDtY_bYyVZmenRnVZUPg_y8bcvZTrPr_"; //개발 서버 적용시 적용 요망

    public final static String AUTH_KEY_FCM = "AAAAhnXc3aE:APA91bEermVXe5IUvlUmbSy_XdnUyu8AwAYg3R_ZkEceCUsQ6PCjIiEY2k3SSO9WHVHyALfMZctbLhsraMZjn01aS0UvUUyFa-KkQDIyQhFmFLbuATVUiCcLnT0e0PY8GKVEQYo_-IWR"; //운영서버 적용시 적용 요망



    public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

    public static void sendPush(String _token, String _title, String _body) throws Exception{
        String _actionType = "new";
        String _code = "tc";
        //String _token = "/topics/ALL"; // 전체

        // 모바일기기에서 얻음
        //String _token = "dl60nc4Zy8s:APA91bEAgHQWgwdDKCyuw6YWNyIsbsWGVdV_x2qYevkLHJz6eTM4OaTjgtlu7O8B4MlXR23__i74_tWwzoRmpm96KOWOmJBVEEcmrF8vg3TnqGTnV67lzN-gmXWQsOD5tZ0gQcy7dwUp"; // 개인

        final String apiKey = AUTH_KEY_FCM;
        URL url = new URL("https://fcm.googleapis.com/fcm/send");
        HttpURLConnection conn = null;
        conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "key=" + apiKey);

        conn.setDoOutput(true);


        // 이렇게 보내면 주제를 ALL로 지정해놓은 모든 사람들한테 알림을 날려준다.
        String input = "{\"notification\" : {\"title\" : \" + _title + \", \"body\" : \" + _body + \"}, \"to\":\" + _token + \"}";

        // 이걸로 보내면 특정 토큰을 가지고있는 어플에만 알림을 날려준다  위에 둘중에 한개 골라서 날려주자
        //String input = "{\"notification\" : {\"title\" : \" 여기다 제목넣기 \", \"body\" : \"여기다 내용 넣기\"}, \"to\":\" 여기가 받을 사람 토큰  \"}";

        JSONObject json = new JSONObject();
        JSONObject notification = new JSONObject();
        JSONObject data = new JSONObject();

        notification.put("title", _title);
        notification.put("body", _body);

        data.put("actionType", _actionType);
        data.put("storeCode", _code);

        json.put("notification", notification);
        json.put("to", _token);
        json.put("data", data);

        String sendMsg = json.toString();

        OutputStream os = conn.getOutputStream();

        // 서버에서 날려서 한글 깨지는 사람은 아래처럼  UTF-8로 인코딩해서 날려주자
        //os.write(input.getBytes("UTF-8"));
        os.write(sendMsg.getBytes("UTF-8"));
        os.flush();
        os.close();

        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + input);
        System.out.println("Post parameters2 : " + sendMsg);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        // print result
        System.out.println(response.toString());
    }

    private static final Pattern REMOVE_TAGS = Pattern.compile("<.+?>");

    public static String removeTags(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }

        Matcher m = REMOVE_TAGS.matcher(string);
        return m.replaceAll("");
    }

    //  String null을 빈 문자열로 바꿔준다
    public static String nullToEmpty(String s) {
        if (s == null) s = "";
        return s;
    }
    // 랜덤문자 1글자 생성 문자
    public static char randomChar() {
        String pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        java.util.Random rand = new java.util.Random();
        return pattern.charAt(rand.nextInt(pattern.length()));
    }

    // 랜덤문자 1글자 생성 숫자
    public static char randomChar1() {
        String pattern = "0123456789";
        java.util.Random rand = new java.util.Random();
        return pattern.charAt(rand.nextInt(pattern.length()));
    }

    // 랜덤문자 1글자 생성 문자숫자
    public static char randomChar2() {
        String pattern = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        java.util.Random rand = new java.util.Random();
        return pattern.charAt(rand.nextInt(pattern.length()));
    }

    // 랜덤문자열 생성 문자
    public static String generateString(int length) {
        String pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        java.util.Random rand = new java.util.Random();
        String s = "";
        for (int i = 0; i < length; i++) {
            s += pattern.charAt(rand.nextInt(pattern.length()));
        }
        return s;
    }

    // 랜덤문자열 생성 숫자
    public static String generateString1(int length) {
        String pattern = "0123456789";
        java.util.Random rand = new java.util.Random();
        String s = "";
        for (int i = 0; i < length; i++) {
            s += pattern.charAt(rand.nextInt(pattern.length()));
        }
        return s;
    }
     // 랜덤문자열 생성 문자숫자
    public static String generateString2(int length) {
        String pattern = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        java.util.Random rand = new java.util.Random();
        String s = "";
        for (int i = 0; i < length; i++) {
            s += pattern.charAt(rand.nextInt(pattern.length()));
        }
        return s;
    }

    // 날짜를 문자열로 변환
    public static String dateToString(Date date, String format) {
        SimpleDateFormat f = new SimpleDateFormat(format);
        return f.format(date);
    }

    // 숫자에 콤마넣기
    public static String numberWithComma(short number) {
        DecimalFormat f = new DecimalFormat("###,##0");
        return f.format(number);
    }

    // 숫자에 콤마넣기
    public static String numberWithComma(int number) {
        DecimalFormat f = new DecimalFormat("###,##0");
        return f.format(number);
    }

    // 숫자에 콤마넣기
    public static String numberWithComma(long number) {
        DecimalFormat f = new DecimalFormat("###,##0");
        return f.format(number);
    }

    // 숫자에 콤마넣기
    public static String numberWithComma(float number, int pointDigit) {
        String format;
        if (pointDigit > 0) {
            format = "###,##0.";
            for (int i = 0; i < pointDigit; i++) {
                format += "0";
            }
        } else {
            format = "###,##0";
        }
        DecimalFormat f = new DecimalFormat(format);
        return f.format(number);
    }

 // 숫자에 콤마넣기
    public static String numberWithComma(double number, int pointDigit) {
        String format;
        if (pointDigit > 0) {
            format = "###,##0.";
            for (int i = 0; i < pointDigit; i++) {
                format += "0";
            }
        } else {
            format = "###,##0";
        }
        DecimalFormat f = new DecimalFormat(format);
        return f.format(number);
    }

    // 숫자에 콤마넣기
    public static String numberWithComma(String number, int pointDigit) {
        double n;

        try {
            n = Double.parseDouble(number);
        } catch (RuntimeException e) {
            n = 0;
        }
        String format;
        if (pointDigit > 0) {
            format = "###,##0.";
            for (int i = 0; i < pointDigit; i++) {
                format += "0";
            }
        } else {
            format = "###,##0";
        }
        DecimalFormat f = new DecimalFormat(format);
        return f.format(n);
    }

    // 전화번호 하이픈(-) 삽입
    public static String phoneNumberWithHypen(String s) {
        if (!s.matches("^[0-9]*$")) {
            return "";
        }
        if (s.startsWith("02")) {
            if (s.length() == 9) {
                s = s.substring(0, 2) + "-" + s.substring(2, 5) + "-" + s.substring(5);
            } else if (s.length() == 10) {
                s = s.substring(0, 2) + "-" + s.substring(2, 6) + "-" + s.substring(6);
            } else {
                return "";
            }
        } else {
            if (s.length() == 10) {
                s = s.substring(0, 3) + "-" + s.substring(3, 6) + "-" + s.substring(6);
            } else if (s.length() == 11) {
                s = s.substring(0, 3) + "-" + s.substring(3, 7) + "-" + s.substring(7);
            } else {
                return "";
            }
        }
        return s;
    }

    // 이전페이지 체크
    public static boolean checkReferer(HttpServletRequest request) {
        String baseURL = getBaseURL(request);
        String referer = request.getHeader("REFERER") == null ? "" : request.getHeader("REFERER");
        boolean result = false;

        if (!referer.isEmpty()) {
            if (referer.startsWith(baseURL)) {
                result = true;
            }
        }
        return result;
    }

    // IE 체크
    public static boolean checkBrowserIE(HttpServletRequest request) {
        boolean isIE = request.getHeader("User-Agent").contains("MSIE") || request.getHeader("User-Agent").contains("Trident");
        return isIE;
    }

    // 모바일 체크
    public static boolean checkMobile(HttpServletRequest request) {
        boolean isMobile = request.getHeader("User-Agent").contains("Mobile");
        return isMobile;
    }

    // 날짜 더하기
    public static String dateAdd(String date, int addDay) {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String result = "";
    	try {
	    	Date mydate = format.parse(date);
	    	Calendar cal = Calendar.getInstance();
	        cal.setTime(mydate);
	        cal.add(Calendar.DATE, addDay);		//날짜 더하기
	        result = format.format(cal.getTime());
    	} catch (Exception e) {
    	}

        return result;
    }

    // 날짜 더하기
    public static String dateAdd(String date, int addDay, String formatStr) {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	SimpleDateFormat informat = new SimpleDateFormat(formatStr);
    	String result = "";
    	try {
	    	Date mydate = format.parse(date);
	    	Calendar cal = Calendar.getInstance();
	        cal.setTime(mydate);
	        cal.add(Calendar.DATE, addDay);		//날짜 더하기
	        result = informat.format(cal.getTime());
    	}
    	catch (Exception e) {
    	}
        return result;
    }

    // 파일 확장자 가져오기
    public static String getFileExtension(String fileName) {
        String ext = "";

        if (fileName.contains(".")) {
            ext = fileName.substring(fileName.lastIndexOf(".") + 1);
            ext = ext.toLowerCase();
        }

        return ext;
    }

    //파일 이름만 가져오기
    public static String getFileNameNoExt(String fileName) {
    	String name = "";

    	if(fileName.contains(".")) {
    		name = fileName.substring(0, fileName.lastIndexOf("."));
    	}

    	return name;
    }

    //파일 내용 읽어오기
    public static String getFileContents(String filePath) {
        BufferedReader br = null;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        String s = "";
        try{
            File file = new File(filePath);
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            int i;
            while ((i = br.read()) != -1) {
                sb.append((char)i);
            }
            s = sb.toString();
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            if (br != null) { try { br.close(); } catch (IOException e) {} }
            if (isr != null) { try { isr.close(); } catch (IOException e) {} }
            if (fis != null) { try { fis.close(); } catch (IOException e) {} }
        }

        return s;
    }

    // 현제 도메인 불러오기
    public static String getBaseURL(HttpServletRequest request) {
        return request.getRequestURL().toString().replace(request.getRequestURI(), "");
    }

    // 서버 실제 경로 불러오기
    public static String getDocumentRoot(HttpServletRequest request) {
        return request.getSession().getServletContext().getRealPath("/");
    }

    // 검색어 문자열 가공
    public static List<String> getSearchKeywordList(String searchKeyword) {
    	// 양쪽 끝 빈문자 제거
    	String s = searchKeyword.trim();
    	// 빈칸 연속 두번 제거
    	while (s.contains("  ")) { s = s.replace("  ", " "); }
    	// 빈칸콤마 제거
    	while (s.contains(" ,")) { s = s.replace(" ,", ","); }
    	// 콤마빈칸 제거
    	while (s.contains(", ")) { s = s.replace(", ", ","); }
    	// 콤마 연속 두번 제거
    	while (s.contains(",,")) { s = s.replace(",,", ","); }
    	// 양쪽 끝 콤마 제거
		if (!s.isEmpty() && s.charAt(0) == ',') s = s.substring(1);
		if (!s.isEmpty() && s.charAt(s.length() - 1) == ',') s = s.substring(0, s.length() - 1);

    	List<String> searchKeywordList = new ArrayList<String>();
    	String keyword = "";
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) == ',') {
    			searchKeywordList.add(keyword);
    			searchKeywordList.add(",");
    			keyword = "";
    		} else if (s.charAt(i) == ' ') {
    			searchKeywordList.add(keyword);
    			searchKeywordList.add(" ");
    			keyword = "";
    		} else {
    			keyword += s.charAt(i);
    		}
    		if (i == s.length() - 1) {
    			searchKeywordList.add(keyword);
    		}
    	}

    	return searchKeywordList;
    }

    // XSS Filter
    public static String xssFilter(String s, boolean htmlTag) {
    	if (htmlTag) {
    		String video_urls =
    				"www\\.youtube\\.com/";

	        String regExScript           = "<script(( .*)|)>.*</script(( .*)|)>";
	        String regExScriptOpenOnly   = "<script(( .*)|)>";
	        String regExObject           = "<object(( .*)|)>.*</object(( .*)|)>";
	        String regExObjectOpenOnly   = "<object(( .*)|)>";
	        String regExEmbed            = "<embed(?!(.*src=('|\")(https?:)?//(" + video_urls + ").*('|\"))).*>.*</embed(( .*)|)>";
	        String regExEmbedOpenOnly    = "<embed(?!(.*src=('|\")(https?:)?//(" + video_urls + ").*('|\"))).*>";
	        String regExIframe           = "<iframe(?!(.*src=('|\")(https?:)?//(" + video_urls + ").*('|\"))).*>.*</iframe(( .*)|)>";
	        String regExIfrmaeOpenOnly   = "<iframe(?!(.*src=('|\")(https?:)?//(" + video_urls + ").*('|\"))).*>";
	        String regExAttr             = " *(action|archive|cite|classid|codebase|data|dsync|formaction|icon|longdesc|manifest|poster|profile|usemap)(=((('.*')|(\".*\"))|)|)";
	        String regExEvent1           = " *(onabort|onafterprint|onanimationend|onanimationiteration|onanimationstart|onbeforeprint|onbeforeunload|onblur|oncanplay|oncanplaythrough|onchange|onclick|oncontextmenu|oncopy|oncut|ondblclick|ondrag|ondragend|ondragenter)(=((('.*')|(\".*\"))|)|)";
	        String regExEvent2           = " *(ondragleave|ondragover|ondragstart|ondrop|ondurationchange|onended|onerror|onfocus|onfocusin|onfocusout|onfullscreenchange|onfullscreenerror|onhashchange|oninput|oninvalid|onkeydown|onkeypress|onkeyup|onload|onloadeddata)(=((('.*')|(\".*\"))|)|)";
	        String regExEvent3           = " *(onloadedmetadata|onloadstart|onmessage|onmousedown|onmouseenter|onmouseleave|onmousemove|onmouseover|onmouseout|onmouseup|onmousewheel|onoffline|ononline|onopen|onpagehide|onpageshow|onpaste|onpause|onplay|onplaying|onpopstate)(=((('.*')|(\".*\"))|)|)";
	        String regExEvent4           = " *(onprogress|onratechange|onresize|onreset|onscroll|onsearch|onseeked|onseeking|onselect|onshow|onstalled|onstorage|onsubmit|onsuspend|ontimeupdate|ontoggle|ontouchcancel|ontouchend|ontouchmove|ontouchstart|ontransitionend)(=((('.*')|(\".*\"))|)|)";
	        String regExEvent5           = " *(onunload|onvolumechange|onwaiting|onwheel)(=((('.*')|(\".*\")|(&quot;.*&quot;)|(&#39;.*&#39;))|)|)";
	        String regExHref             = "href=('|\")(j|(&#x6A;))(a|(&#x61;))(v|(&#x76;))(a|(&#x61;))(s|(&#x73;))(c|(&#xA;))(r|(&#x63;))(i|(&#x72;))(p|(&#x69;))(t|(&#x70;))(:|(&#x74;)).*('|\")";
	        String regExStyleTag         = "<style(( .*)|)>.*</style(( .*)|)>";
	        String regExStyleTagOpenOnly = "<style(( .*)|)>";

            s = Pattern.compile(regExScript, Pattern.CASE_INSENSITIVE).matcher(s).replaceAll("");
            s = Pattern.compile(regExScriptOpenOnly, Pattern.CASE_INSENSITIVE).matcher(s).replaceAll("");
            s = Pattern.compile(regExObject, Pattern.CASE_INSENSITIVE).matcher(s).replaceAll("");
            s = Pattern.compile(regExObjectOpenOnly, Pattern.CASE_INSENSITIVE).matcher(s).replaceAll("");
            s = Pattern.compile(regExEmbed, Pattern.CASE_INSENSITIVE).matcher(s).replaceAll("");
            s = Pattern.compile(regExEmbedOpenOnly, Pattern.CASE_INSENSITIVE).matcher(s).replaceAll("");
            s = Pattern.compile(regExIframe, Pattern.CASE_INSENSITIVE).matcher(s).replaceAll("");
            s = Pattern.compile(regExIfrmaeOpenOnly, Pattern.CASE_INSENSITIVE).matcher(s).replaceAll("");
            s = Pattern.compile(regExAttr, Pattern.CASE_INSENSITIVE).matcher(s).replaceAll("");
            s = Pattern.compile(regExEvent1, Pattern.CASE_INSENSITIVE).matcher(s).replaceAll("");
            s = Pattern.compile(regExEvent2, Pattern.CASE_INSENSITIVE).matcher(s).replaceAll("");
            s = Pattern.compile(regExEvent3, Pattern.CASE_INSENSITIVE).matcher(s).replaceAll("");
            s = Pattern.compile(regExEvent4, Pattern.CASE_INSENSITIVE).matcher(s).replaceAll("");
            s = Pattern.compile(regExEvent5, Pattern.CASE_INSENSITIVE).matcher(s).replaceAll("");
            s = Pattern.compile(regExHref, Pattern.CASE_INSENSITIVE).matcher(s).replaceAll("href=\"javascript:void(0);\"");
            s = Pattern.compile(regExStyleTag, Pattern.CASE_INSENSITIVE).matcher(s).replaceAll("");
            s = Pattern.compile(regExStyleTagOpenOnly, Pattern.CASE_INSENSITIVE).matcher(s).replaceAll("");
        } else {
            s = s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("'", "&#39;");
        }
        return s;
    }

    public static String removeHtmlTag(String s) {
    	String regEx = "<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>";
    	s = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE).matcher(s).replaceAll("");
    	return s;
    }

    // QueryString(key1=value1&key2=value2&...) to Map
    public static Map<String, String> queryStringToMap(String queryString) throws UnsupportedEncodingException {
    	if (queryString == null || queryString.isEmpty()) return null;
    	Map<String, String> result = new LinkedHashMap<String, String>();
    	String[] tmp = queryString.split("&");
    	for (String s : tmp) {
			String[] tmp2 = s.split("=");
			if (tmp2.length == 1) {
				result.put(URLDecoder.decode(tmp2[0], "UTF-8"), "");
			} else if (tmp2.length == 2) {
				result.put(URLDecoder.decode(tmp2[0], "UTF-8"), URLDecoder.decode(tmp2[1], "UTF-8"));
			} else {
				return null;
			}
		}
    	return result;
    }

    // 처리값이 0 이상이면 message 리턴
	public static Map<String, Object> returnMessage(int success, String message, Map<String, Object> responseMap) {
		if(responseMap == null) { responseMap = new HashMap<String, Object>(); }
		if (success > 0) {
			responseMap.put("result", "ok");
			responseMap.put("msg", message);
		} else {
			responseMap.put("result", "error");
			//responseMap.put("msg", "에러가 발생했습니다.");
		}
		return responseMap;
	}

	// 현재 접속 중인 아이피 가져
	public static String getIP(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");

	    if (ip == null) {
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if (ip == null) {
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if (ip == null) {
	        ip = request.getHeader("HTTP_CLIENT_IP");
	    }
	    if (ip == null) {
	        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	    }
	    if (ip == null) {
	        ip = request.getRemoteAddr();
	    }

	    return ip;
	}
}
