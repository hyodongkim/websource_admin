<%@ page language="java" contentType="application/vnd.ms-excel; charset=utf-8" pageEncoding="utf-8"%><%
    response.setHeader("Content-Disposition","attachment;filename=tc_member.xls");    //디폴트 파일명 지정
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
        <th>구분</th>
        <th>이름</th>
        <th>이메일</th>
        <th>사업자 수</th>
        <th>가입일시</th>
        <th>휴대폰 번호</th>
        <th>최근 접속일</th>
        <th>상태</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${empty list}">
            <tr>
                <td colspan="12">등록한 회원이 없습니다.</td>
            </tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="item" items="${list}" varStatus="status">

                <c:set var="name"       value="${item.name}" />
                <c:set var="totalLength" value="${fn:length(name) }" />
                <c:set var="first"      value="${fn:substring(name, 0, 1) }" />
                <c:set var="last"      value="${fn:substring(name, 2, totalLength) }" />


                <tr>
                    <td>${paginationInfo.totalRecordCount - ((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage + status.index)}</td>
                    <td><c:out value="${item.type}"/></td>
                    <td><c:out value="${first}*${last}"/></td>

                    <c:set var="name"       value="${item.email}" />
                    <c:set var="totalLength" value="${fn:length(name) }" />
                    <c:set var="first"      value="${fn:substring(name, 0, 3) }" />
                    <c:set var="last"      value="${fn:substring(name, 6, totalLength) }" />

                    <td><c:out value="${first}***${last}"/></td>
                    <td><c:out value="${item.num_of_business}"/></td>
                    <td><c:out value="${item.reg_datetime}"/></td>
                    <td><span style="mso-number-format:'\@'">${fn:substring(item.phone,0,fn:length(item.phone)-3)}***</span></td>
                    <td><c:out value="${item.recent_access}"/></td>
                    <td><c:out value="${item.enabled}"/></td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
    </body>
    </html>