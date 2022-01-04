<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">알림사항 상세</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered dataTable" width="100%" cellspacing="0">
                <tbody>
                <tr>
                    <th scope="row" style="width: 120px;">구분</th>
                    <td><c:out value="${item.type}"/></td>
                </tr>
                <tr>
                    <th scope="row" style="width: 120px;">제목</th>
                    <td><c:out value="${item.subject}"/></td>
                </tr>
                <tr>
                    <th scope="row" style="width: 120px;">내용</th>
                    <td><c:out value="${item.content_editor}"/></td>
                </tr>
                <tr>
                    <th scope="row">사용</th>
                    <td><c:out value="${item.enabled}"/></td>
                </tr>
                <tr>
                    <th scope="row">푸시 여부</th>
                    <td><c:out value="${item.push}"/></td>
                </tr>
                <tr>
                    <th scope="row">푸시 대상</th>
                    <td><c:out value="${item.push_to}"/></td>
                </tr>
                <tr>
                    <th scope="row">푸시 메시지</th>
                    <td><c:out value="${item.push_msg}"/></td>
                </tr>
                <tr>
                    <th scope="row">등록일시</th>
                    <td><c:out value="${item.reg_datetime}"/></td>
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