<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">FAQ 관리</h1>


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
              <input type="text" name="type" id="type" value="${item.type}">
            </td>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">순서</th>
            <td>
              <input type="text" name="order_by" id="order_by" value="${item.order_by}">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">질문 제목</th>
            <td>
              <input type="text" name="question" id="question" style="width:40%;" rows="10" value="${item.question}"></td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">답변 내용</th>
            <td>
              <textarea name="content_editor" id="content_editor" rows="10" style="width: 100%;">${item.content_editor}</textarea>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">사용</th>
            <td>
              <input type="radio" name="enabled" id="enabled_Y" value="사용" <c:if test="${item.enabled eq '사용' || item.enabled eq null}">checked</c:if>> 사용
              <input type="radio" name="enabled" id="enabled_N" value="사용안함" <c:if test="${item.enabled eq '사용안함'}">checked</c:if>> 사용안함
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">작성자</th>
            <td>
              <input type="text" name="author" id="author" style="width:40%;" rows="10" value="<c:if test="${param.id != null}">${item.author}</c:if><c:if test="${param.id == null}">관리자</c:if>"></td>
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
