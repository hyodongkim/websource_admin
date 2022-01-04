<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">설문 관리</h1>


<!-- DataTales Example -->
<form name="frm" id="frm" method="post" enctype="multipart/form-data">
  <input type="hidden" name="id" id="id" value="${item.id}">
  <div class="card shadow mb-4">
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered dataTable" width="100%" cellspacing="0">
          <tbody>
          <tr>
            <th scope="row" style="width: 120px;">설문 제목</th>
            <td>
              <input type="text" name="title" id="title" value="${item.title}" style="width: 100%;">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">소요 시간</th>
            <td>
              <input type="text" name="duration" id="duration" value="${item.duration}" style="width: 120px;">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">혜택</th>
            <td>
              <input type="text" name="benefit" id="benefit" value="${item.benefit}" style="width: 100%;">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">설문 소개글</th>
            <td>
              <textarea name="introduction" id="introduction" style="width: 100%;" rows="15">${item.introduction}"</textarea>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">복수 응답 가능 여부</th>
            <td>
              <select name="is_multi_answers" id="is_multi_answers">
                <option value="N" <c:if test="${item.is_multi_answers eq 'N'}">selected</c:if>>단수 선택만 가능</option>
                <option value="Y" <c:if test="${item.is_multi_answers eq 'Y'}">selected</c:if>>복수 선택 가능</option>
              </select>

            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">설문 답안 관리</th>
            <td class="examples">
              <div>
                <c:if test="${list eq null}">
                  <select name="type">
                    <option value="객관식">객관식</option>
                    <option value="주관식">주관식</option>
                  </select>
                  답변예제 : <input type="text" name="answer_text" id="answer_text" value="" style="width: 400px;">
                  정렬순서 : <input type="text" name="order_by" id="order_by" value="" style="width: 80px;"></c:if>
                <button type="button" onClick="go_add_example();">줄 추가</button>
              </div>

              <c:forEach var="example" items="${list}" varStatus="status">
                <div>
                  <select name="type">
                    <option value="객관식" <c:if test="${example.type eq '객관식'}">selected</c:if>>객관식</option>
                    <option value="주관식" <c:if test="${example.type eq '주관식'}">selected</c:if>>주관식</option>
                  </select>
                  답변예제 : <input type="text" name="answer_text" id="answer_text" value="${example.answer_text}" style="width: 400px;">
                  정렬순서 : <input type="text" name="order_by" id="order_by" value="${example.order_by}" style="width: 80px;">
                  <button type="button" onClick="go_remove_example(this);">줄 삭제</button>
                </div>
              </c:forEach>



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
          <a href="javascript:history.back();" class="btn btn-secondary btn-icon-split"><span class="text">목록</span></a>
        </div>
      </div>
    </div>
  </div>
</form>

<script>
  function go_reg(){

    $("[name=type]").each(function(i){
      $(this).attr("name", "list[" + i + "].type");
    });
    $("[name=answer_text]").each(function(i){
      $(this).attr("name", "list[" + i + "].answer_text");
    });
    $("[name=order_by]").each(function(i){
      $(this).attr("name", "list[" + i + "].order_by");
    });

    $("#frm").submit();
  }

  function go_add_example(){
    let html = `<div>
            <select name="type">
            <option value="객관식">객관식</option>
        <option value="주관식">주관식</option>
    </select>
        답변예제 : <input type="text" name="answer_text" id="answer_text" value="" style="width: 400px;">
            정렬순서 : <input type="text" name="order_by" id="order_by" value="" style="width: 80px;">
            <button type="button" onClick="go_remove_example(this);">줄 삭제</button>
        </div>`;
    $(".examples").append(html);
  }

  function go_remove_example(el){
    el.parentElement.remove();
  }
</script>



<%@ include file="admin_footer.jsp" %>
