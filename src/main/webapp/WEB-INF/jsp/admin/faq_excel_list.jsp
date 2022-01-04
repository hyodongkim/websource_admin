<%@ page language="java" contentType="application/vnd.ms-excel; charset=utf-8" pageEncoding="utf-8"%><%
    response.setHeader("Content-Disposition","attachment;filename=faq_list.xls");    //디폴트 파일명 지정
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
            <th>순서</th>
            <th>질문 제목</th>
            <th>답변 내용</th>
            <th>사용 여부</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${empty list}">
                <tr>
                    <td colspan="12">등록한 FAQ가 없습니다.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="item" items="${list}" varStatus="status">
                    <tr>
                        <td>${paginationInfo.totalRecordCount - ((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage + status.index)}</td>
                        <td><c:out value="${item.type}"/></td>
                        <td><c:out value="${item.order_by}"/></td>
                        <td><c:out value="${item.question}"/></td>
                        <td><c:out value="${fn:replace({fn:replace(item.content_editor, '&gt;', '>')}, '&lt;', '<')}"/></td>
                        <td><c:out value="${item.enabled}"/></td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </tbody>
</table>
    </body>
    </html>