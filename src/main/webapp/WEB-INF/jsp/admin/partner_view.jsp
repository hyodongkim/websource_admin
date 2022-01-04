<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">파트너 요청 상세 내용</h1>

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
                    <th scope="row" style="width: 120px;">이름</th>
                    <td><c:out value="${item.name}"/></td>
                </tr>
                <tr>
                    <th scope="row">성</th>
                    <td><c:out value="${item.name_last}"/></td>
                </tr>
                <tr>
                    <th scope="row">이메일</th>
                    <td><c:out value="${item.email}"/></td>
                </tr>
                <tr>
                    <th scope="row">포지션</th>
                    <td><c:out value="${item.position}"/></td>
                </tr>
                <tr>
                    <th scope="row">국가</th>
                    <td><c:out value="${item.country}"/></td>
                </tr>
                <tr>
                    <th scope="row">전화번호</th>
                    <td><c:out value="${item.phone}"/></td>
                </tr>
                <tr>
                    <th scope="row">회사명</th>
                    <td><c:out value="${item.company_name}"/></td>
                </tr>
                <tr>
                    <th scope="row">산업</th>
                    <td><c:out value="${item.industry}"/></td>
                </tr>
                <tr>
                    <th scope="row">파트너 타입</th>
                    <td><c:out value="${item.partner_type}"/></td>
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