<%@ page language="java" contentType="application/vnd.ms-excel; charset=utf-8" pageEncoding="utf-8"%><%
    response.setHeader("Content-Disposition","attachment;filename=leave_member.xls");    //디폴트 파일명 지정
    response.setHeader("Content-Description", "JSP Generated Data");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        </meta>
    </head>
        <body>
<table class="table table-bordered dataTable striped" width="100%" cellspacing="0">
    <thead>
        <tr>
            <th>no</th>
            <th>고객명</th>
            <th>이메일</th>
            <th>가입일</th>
            <th>탈퇴일</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${empty list}">
                <tr>
                    <td colspan="99">등록한 회원이 없습니다.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="item" items="${list}" varStatus="status">
                    <tr>
                        <td>${paginationInfo.totalRecordCount - ((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage + status.index)}</td>
                        <c:set var="name"       value="${item.name}" />
                        <c:set var="totalLength" value="${fn:length(name) }" />
                        <c:set var="first"      value="${fn:substring(name, 0, 1) }" />
                        <c:set var="last"      value="${fn:substring(name, 2, totalLength) }" />


                        <td><c:out value="${first}*${last}"/></td>

                        <c:set var="name"       value="${item.email}" />
                        <c:set var="totalLength" value="${fn:length(name) }" />
                        <c:set var="first"      value="${fn:substring(name, 0, 3) }" />
                        <c:set var="last"      value="${fn:substring(name, 6, totalLength) }" />

                        <td><c:out value="${first}***${last}"/></td>
                        <td><c:out value="${item.reg_datetime}"/></td>
                        <td><c:out value="${item.leave_datetime}"/></td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </tbody>
</table>
        </body>
    </html>