<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">견적 문의 상세 내용</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered dataTable" width="100%" cellspacing="0">
                <tbody>
                <tr>
                    <th scope="row" style="width: 120px;">마켓팅 동의</th>
                    <td><c:out value="${item.is_agree}"/></td>
                </tr>
                <tr>
                    <th scope="row" style="width: 120px;">이름(회사명)</th>
                    <td><c:out value="${item.name}"/></td>
                </tr>
                <tr>
                    <th scope="row">이메일</th>
                    <td><c:out value="${item.email}"/></td>
                </tr>
                <tr>
                    <th scope="row">국가</th>
                    <td><c:out value="${item.country}"/></td>
                </tr>
                <tr>
                    <th scope="row">플랫폼</th>
                    <td><c:out value="${item.platform}"/></td>
                </tr>
                <tr>
                    <th scope="row">초기(기본) 비용</th>
                    <td><c:out value="${item.initial_cost}"/></td>
                </tr>
                <tr>
                    <th scope="row">사용 면적</th>
                    <td><c:out value="${item.use_area}"/></td>
                </tr>
                <tr>
                    <th scope="row">실제 사용자 수</th>
                    <td><c:out value="${item.active_user_num}"/></td>
                </tr>
                <tr>
                    <th scope="row">최대 동시 접속자 수</th>
                    <td><c:out value="${item.max_concurrent_users}"/></td>
                </tr>
                <tr>
                    <th scope="row">서비스 영역(지도) 수</th>
                    <td><c:out value="${item.service_num}"/></td>
                </tr>
                <tr>
                    <th scope="row">필요 앱 개수</th>
                    <td><c:out value="${item.app_num}"/></td>
                </tr>
                <tr>
                    <th scope="row">접속 아이피</th>
                    <td><c:out value="${item.ip}"/></td>
                </tr>
                <tr>
                    <th scope="row">등록일시</th>
                    <td><c:out value="${item.reg_timestamp}"/></td>
                </tr>
                <tr>
                    <th scope="row">처리여부</th>
                    <td><c:out value="${item.process_yn}"/></td>
                </tr>
                </tbody>
            </table>
            <div class="btn_wrap">
                <%--<a href="#" class="btn btn-primary btn-icon-split"><span class="text">등록확인</span></a>--%>
                <a href="javascript:history.back();" class="btn btn-secondary btn-icon-split"><span class="text">목록</span></a>
            </div>
        </div>
    </div>
</div>

<%@ include file="admin_footer.jsp" %>