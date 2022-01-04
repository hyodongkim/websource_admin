<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">고객센터 관리</h1>


<!-- DataTales Example -->
<form name="frm" id="frm" method="post" enctype="multipart/form-data">
    <div class="card shadow mb-4">
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered dataTable" width="100%" cellspacing="0">
                    <tbody>
                    <tr>
                        <th scope="row" style="width: 120px;">대표 전화번호</th>
                        <td>
                            <input type="text" name="telephone" id="telephone" value="${item.telephone}" style="width: 20%;">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">카카오톡 채널명</th>
                        <td>
                            <input type="text" name="kakao" id="kakao" value="${item.kakao}" style="width: 20%;">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">네이버 블로그</th>
                        <td>
                            <input type="text" name="naver_blog" id="naver_blog" value="${item.naver_blog}" style="width: 20%;">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">인스타그램</th>
                        <td>
                            <input type="text" name="instagram" id="instagram" value="${item.instagram}" style="width: 20%;">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">링크</th>
                        <td>
                            <input type="text" name="link" id="link" value="${item.link}" style="width: 70%;">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">이메일</th>
                        <td>
                            <input type="text" name="email" id="email" value="${item.email}" style="width: 70%;">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">운영시간</th>
                        <td>
                            <input type="text" name="operating_hours" id="operating_hours" value="${item.operating_hours}" style="width: 70%;">
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="btn_wrap">
                    <c:choose>
                        <c:when test="${item.id > 0}">
                            <a href="javascript:go_reg();" class="btn btn-primary btn-icon-split"><span class="text">수정</span></a>
                        </c:when>
                        <c:otherwise>
                            <a href="javascript:go_reg();" class="btn btn-primary btn-icon-split"><span class="text">등록</span></a>
                        </c:otherwise>
                    </c:choose>
                    <%--<a href="javascript:history.back();" class="btn btn-secondary btn-icon-split"><span class="text">목록</span></a>--%>
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
