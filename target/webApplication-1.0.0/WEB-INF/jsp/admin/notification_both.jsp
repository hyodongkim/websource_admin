<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">알림사항 관리</h1>


<!-- DataTales Example -->
<form name="frm" id="frm" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" id="id" value="${item.id}">
    <div class="card shadow mb-4">
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered dataTable" width="100%" cellspacing="0">
                    <tbody>
                    <tr>
                        <th scope="row" style="width: 120px;">구분</th>
                        <td>
                            <input type="radio" name="type" id="type1" value="마케팅" <c:if test="${item.type eq '마케팅'}">checked</c:if>> 마케팅
                            <input type="radio" name="type" id="type2" value="공지" <c:if test="${item.type eq '공지'}">checked</c:if>> 공지
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">등록일시</th>
                        <td>
                            <c:set var="now" value="<%=new java.util.Date()%>" />
                            <c:if test="${empty item.reg_datetime}">
                                <input type="text" name="reg_datetime" id="reg_datetime" value="<fmt:formatDate value="${now}" pattern="yyyy-MM-dd hh:mm:ss" />">
                            </c:if>
                            <c:if test="${!empty item.reg_datetime}">
                                <input type="text" name="reg_datetime" id="reg_datetime" value="${item.reg_datetime}" readonly>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">작성자</th>
                        <td>
                            <input type="text" name="author" id="author" value="${item.author}">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">조회수</th>
                        <td>
                            ${item.hit_count}
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">제목</th>
                        <td>
                            <input type="text" name="subject" id="subject" value="${item.subject}" style="width: 90%;">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">내용</th>
                        <td>
                            <textarea name="content_editor" id="content_editor" style="width:100%;" rows="10">${item.content_editor}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">확인 URL</th>
                        <td>
                            <input type="text" name="url" id="url" value="${item.url}" style="width: 90%;">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">사용</th>
                        <td>
                            <input type="radio" name="enabled" id="enabled_Y" value="사용" <c:if test="${item.enabled eq '사용' || empty item.enabled}">checked</c:if>> 사용
                            <input type="radio" name="enabled" id="enabled_N" value="사용안함" <c:if test="${item.enabled eq '사용안함'}">checked</c:if>> 사용안함
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">푸시 여부</th>
                        <td>
                            <input type="radio" name="push" id="push_Y" value="진행" <c:if test="${item.push eq '진행' || empty item.push}">checked</c:if>> 진행
                            <input type="radio" name="push" id="push_N" value="미진행" <c:if test="${item.push eq '미진행'}">checked</c:if>> 미진행
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">푸시 대상</th>
                        <td>
                            <input type="radio" name="push_to" id="push_to1" value="전체" <c:if test="${item.push_to eq '전체' || empty item.push_to }">checked</c:if>> 전체
                            <input type="radio" name="push_to" id="push_to2" value="Android" <c:if test="${item.push_to eq 'Android'}">checked</c:if>> Android
                            <input type="radio" name="push_to" id="push_to3" value="iOS" <c:if test="${item.push_to eq 'iOS'}">checked</c:if>> iOS
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">푸시 메시지</th>
                        <td>
                            <textarea name="push_msg" id="push_msg" style="width: 90%; height: 120px;">${item.push_msg}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">게시(발송) 일시</th>
                        <td>
                            <input type="text" name="post_datetime" id="post_datetime" value="<c:if test="${empty item.post_datetime}"><fmt:formatDate value="${now}" pattern="yyyy-MM-dd hh:mm:ss" /></c:if><c:if test="${!empty item.post_datetime}">${item.post_datetime}</c:if>" style="width: 90%;">
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
                            <a href="javascript:go_reg();" class="btn btn-primary btn-icon-split"><span class="text">확인</span></a>
                        </c:otherwise>
                    </c:choose>
                    <a href="javascript:history.back();" class="btn btn-secondary btn-icon-split"><span class="text">취소</span></a>
                </div>
            </div>
        </div>
    </div>
</form>

<script>
    function go_reg(){

        if($("#push_msg").val()=="" && $("#push_Y").prop("checked") == true){
            alert('푸시 메시지는 필수입력하셔야 합니다.');
            return false;
        }

        oEditors.getById["content_editor"].exec("UPDATE_CONTENTS_FIELD", []);

        $("#frm").submit();
    }
</script>

<script type="text/javascript" src="${path}/se/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="${path}/js/smartEditor.js"></script>

<%@ include file="admin_footer.jsp" %>
