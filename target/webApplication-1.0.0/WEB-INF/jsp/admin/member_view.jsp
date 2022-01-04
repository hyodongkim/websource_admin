<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">회원 조회</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered dataTable" width="100%" cellspacing="0">
                <tbody>
                <tr>기본 정보</tr>
                <tr>
                    <th scope="row" style="width: 100px;">구분</th>
                    <td><c:out value="${item.type}"/></td>
                    <th scope="row" style="width: 100px;">가입일</th>
                    <td><c:out value="${item.signup_date}"/></td>
                </tr>
                <tr>
                    <th scope="row" style="width: 100px;">고객명</th>
                    <td><c:out value="${item.name}"/></td>
                    <th scope="row" style="width: 100px;">최근방문일</th>
                    <td><c:out value="${item.recent_access}"/></td>
                </tr>
                <tr>
                    <th scope="row" style="width: 100px;">이메일(ID)</th>
                    <td><c:out value="${item.email}"/></td>
                    <th scope="row" style="width: 100px;">프로필 사진</th>
                    <td><div>
                        <img src="${path}/imgview.do?id=${item.files_id}" style="width: 150px;"/>
                    </div></td>
                </tr>
                </tbody>
            </tbody>

            <table class="table table-bordered dataTable" width="50%" cellspacing="0">
                <tbody>
                <tr>SNS 로그인 연동</tr>
                <tr>
                    <th scope="row" style="width: 100px;">네이버</th>
                    <td><c:out value="${item.sns_naver_yn}"/></td>
                </tr>
                <tr>
                    <th scope="row">카카오톡</th>
                    <td><c:out value="${item.sns_kakao_yn}"/></td>
                </tr>
                <tr>
                    <th scope="row">페이스북</th>
                    <td><c:out value="${item.sns_facebook_yn}"/></td>
                </tr>
                <tr>
                    <th scope="row">애플</th>
                    <td><c:out value="${item.sns_apple_yn}"/></td>
                </tr>
                </tbody>
            </tbody>
            <table class="table table-bordered dataTable" width="50%" cellspacing="0">
                <tbody>
                <tr>수신 동의</tr>
                <tr>
                    <th scope="row" style="width: 100px;">SMS</th>
                    <td><c:out value="${item.agree_sms}"/></td>
                </tr>
                <tr>
                    <th scope="row">이메일</th>
                    <td><c:out value="${item.agree_email}"/></td>
                </tr>
                <tr>
                    <th scope="row">푸시(공지)</th>
                    <td><c:out value="${item.agree_push_notification}"/></td>
                </tr>
                <tr>
                    <th scope="row">푸시(마케팅)</th>
                    <td><c:out value="${item.agree_push_marketing}"/></td>
                </tr>
                </tbody>
            </table>
            <table class="table table-bordered dataTable" width="100%" cellspacing="0">
                <tbody>
                <tr>등록한 사업자: <c:out value="${fn:length(listBusinesses) }"/> 개</tr>
                <tr>
                    <th>No.</th>
                    <th>회사명(법인명)</th>
                    <th>사업자등록번호</th>
                    <th>온라인비즈니스여부</th>
                    <th>오프라인비즈니스여부</th>
                </tr>

                <c:choose>
                    <c:when test="${empty listBusinesses}">
                        <tr>
                            <td colspan="99">등록한 사업자가 없습니다.</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="itemBusinesses" items="${listBusinesses}" varStatus="status">
                            <tr>
                                <td>${status.index + 1}</td>
                                <td>${itemBusinesses.name}</td>
                                <td>${itemBusinesses.brn}</td>
                                <td>${itemBusinesses.has_online_business}</td>
                                <td>${itemBusinesses.has_offline_business}</td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
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
