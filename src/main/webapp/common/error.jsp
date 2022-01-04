<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!doctype html>
<html lang="ko">
<head>
<c:set var="gnbMenu" value="에러페이지"/>
	<c:import url="/WEB-INF/jsp/inc/header.jsp">
		<c:param name="gnbMenu" value="${gnbMenu}"/>
	</c:import>
<style type="text/css">
	.content{width:100%; text-align:center;}
	.error_wrap{text-align: center;padding: 52px 0 52px;}
	.error_wrap .ico_error{display: block;height: 124px;background-repeat: no-repeat;background-position: center; background-image: url(${path}/images/common/error_bg.png);text-indent: -9999em;}
	.error_wrap .error_tit{position: relative;font-size: 26px;font-weight: 500; line-height: 32px;padding-bottom: 18px; margin-top: 50px;}
	.error_wrap .error_tit:after{content: '';width: 22px;height: 1px;background-color: #9e9e9e; position: absolute;left: 50%;bottom: 0;margin-left: -11px;}
	.error_wrap .error_txt{margin-top: 15px;font-size: 16px;line-height: 24px;}
	.error_wrap .btn{margin-top: 120px;width: 250px;height: 54px;line-height: 54px;font-size: 16px;font-weight: 400;color: #fff;background-color: #ff5a5f;}
</style>
</head>
<body class="mypage">
<c:set var="path" value="${pageContext.request.contextPath }" />
<c:set var="title" value="ERROR" />
	<div id="skipNav"><a href="#container">본문 바로가기</a></div>
	<hr>
	<!-- wrap -->
	<div id="wrap">
		<hr>
		<!-- header -->
		<header class="header" id="gnb">
			<%@ include file="/WEB-INF/jsp/inc/gnb.jsp"%>
		</header>
		<!-- //header -->
		<hr>
		<!-- container -->
		<section id="container" class="sub_centent">
			<!-- error_wrap -->
			<div class="inner error_inner">
				<div class="content">
					<div class="error_wrap">
						<i class="ico_error">오류 아이콘</i>
						<p class="error_tit">일시적인 오류가 발생했습니다.</p>
						<p class="error_txt">
							서비스 이용에 불편을 드려 죄송합니다. <br>
							잠시후에 다시 시도해주세요
						</p>
						<a href="javascript:history.back();" class="btn">이전페이지로 돌아가기</a>
					</div>
				</div>
			</div>
			<!-- error_wrap -->
		</section>
	</div>
		<!-- //container -->
	<hr>		
	<!-- footer -->
	<%@ include file="/WEB-INF/jsp/inc/footer.jsp"%>
		<!-- //footer -->
	<!-- //wrap -->
	
	<script type="text/javascript">
		ajaxCall("${path}/gnbMenu.do", {}, function(result){
			$(".nav").prepend(result)
			ajaxCall("${path}/gnbMobileMenu.do",{},function(result){
				$(".menu_list").prepend(result)
			}, "")
		}, "")
	</script>
</html>