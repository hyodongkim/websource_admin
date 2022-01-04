<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">약관 관리</h1>


<!-- DataTales Example -->
<form name="frm" id="frm" method="post" action="${path}/policyBoth.do">
    <input type="hidden" name="id" id="id" value="${item.id}">
    <div class="card shadow mb-4">
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered dataTable" width="100%" cellspacing="0">
                    <tbody>

                    <tr>
                        <th scope="row" style="width: 120px;">약관명</th>
                        <td>
                            <input type="text" name="name" id="name" value="${item.name}" readonly> [수정불가]
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">내용</th>
                        <td class="text_area">
                            <textarea name="content_editor" id="content_editor" style="width: 99%;" rows="10">${item.content_editor}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">필수 동의</th>
                        <td>
                            <input type="radio" name="consent" id="consent_Y" value="Y" <c:if test="${item.consent eq 'Y' || item.consent eq null}">checked</c:if>> Y
                            <input type="radio" name="consent" id="consent_N" value="N" <c:if test="${item.consent eq 'N'}">checked</c:if>> N
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">상태</th>
                        <td>
                            <input type="radio" name="enabled" id="enabled_Y" value="Y" <c:if test="${item.enabled eq 'Y' || item.enabled eq null}">checked</c:if>> 사용함
                            <input type="radio" name="enabled" id="enabled_N" value="N" <c:if test="${item.enabled eq 'N'}">checked</c:if>> 사용안함
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

        oEditors.getById["content_editor"].exec("UPDATE_CONTENTS_FIELD", []);

        $("#frm").submit();
    }
</script>

<script type="text/javascript" src="${path}/se/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="${path}/js/smartEditor.js"></script>

<%@ include file="admin_footer.jsp" %>
