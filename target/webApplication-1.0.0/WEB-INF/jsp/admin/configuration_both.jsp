<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">환경 설정</h1>


<!-- DataTales Example -->
<form name="frm" id="frm" method="post" enctype="multipart/form-data">
    <div class="card shadow mb-4">
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered dataTable" width="100%" cellspacing="0">
                    <tbody>
                    <tr>
                        <th scope="row" style="width: 120px;">사이트 제목</th>
                        <td>
                            <input type="text" name="title" id="title" value="${item.title}" style="width: 100%;">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">사이트 설명</th>
                        <td>
                            <input type="text" name="description" id="description" value="${item.description}" style="width: 100%;">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">사이트 태그</th>
                        <td>
                            <input type="text" name="tag" id="tag" value="${item.tag}" style="width: 100%;">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">담당자명</th>
                        <td>
                            <input type="text" name="staff" id="staff" value="${item.staff}">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">담당자 이메일</th>
                        <td>
                            <input type="text" name="email" id="email" value="${item.email}">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">대표전화번호</th>
                        <td>
                            <input type="text" name="telephone" id="telephone" value="${item.telephone}">
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="btn_wrap">
                    <c:choose>
                        <c:when test="${item.id > 0}">
                            <a href="javascript:go_reg();" class="btn btn-primary btn-icon-split"><span class="text">확인</span></a>
                        </c:when>
                        <c:otherwise>
                            <a href="javascript:go_reg();" class="btn btn-primary btn-icon-split"><span class="text">확인</span></a>
                        </c:otherwise>
                    </c:choose>
                    <a href="javascript:location.reload();" class="btn btn-secondary btn-icon-split"><span class="text">취소</span></a>
                </div>
            </div>
        </div>
    </div>
</form>

<script>
    function go_reg(){
        $("#frm").submit();
    }
</script>

<%@ include file="admin_footer.jsp" %>
