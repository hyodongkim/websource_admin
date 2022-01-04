<%@ page language="java" contentType="application/vnd.ms-excel; charset=utf-8" pageEncoding="utf-8"%><%
    response.setHeader("Content-Disposition","attachment;filename=tc_rental_prod.xls");    //디폴트 파일명 지정
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
        <th>제조사</th>
        <th>신청 링크</th>
        <th>상품명</th>
        <th>모델명</th>
        <th>렌탈 카테고리</th>
        <th>납품유형</th>
        <th>만기시 소유권</th>
        <th>승인상태</th>
        <th>판매상태</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${empty list}">
            <tr>
                <td colspan="12">등록한 상품이 없습니다.</td>
            </tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="item" items="${list}" varStatus="status">
                <tr>
                    <td>${paginationInfo.totalRecordCount - ((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage + status.index)}</td>
                    <td><c:out value="${item.maker}"/></td>
                    <td><c:out value="${item.apply_link}"/></td>
                    <td><c:out value="${item.product_name}"/></td>
                    <td><c:out value="${item.model}"/></td>
                    <td><c:out value="${item.category}"/></td>
                    <td><c:out value="${item.delivery_type}"/></td>
                    <td><c:out value="${item.ownership}"/></td>
                    <td><c:out value="${item.approval}"/></td>
                    <td><c:out value="${item.sales}"/></td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
    </body>
    </html>