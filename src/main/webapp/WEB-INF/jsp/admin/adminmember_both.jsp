<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">관리자 회원 조회</h1>


<!-- DataTales Example -->
<form name="frm" id="frm" method="post" enctype="multipart/form-data">
  <input type="hidden" name="id" id="id" value="${item.id}">
  <div class="card shadow mb-4">
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered dataTable" width="100%" cellspacing="0">
          <tbody>
          <tr>
            <th scope="row" style="width: 120px;">로그인 아이디</th>
            <td>
              <input type="text" name="adminid" id="adminid" value="${item.adminid}" style="width: 200px;">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">비밀번호</th>
            <td>
              <input type="password" name="passwd" id="passwd" value="" style="width: 200px;">
            </td>
          </tr>
          <input type="hidden" name="type" value="일반관리자"/>
          <%--<tr>
            <th scope="row" style="width: 120px;">구분</th>
            <td>
              <select name="type" id="type">
                <option value="일반관리자" <c:if test="${item.type == '일반관리자'}">selected</c:if>>일반관리자</option>
                <option value="A/S관리자" <c:if test="${item.type == 'A/S관리자'}">selected</c:if>>A/S관리자</option>
                <option value="기타" <c:if test="${item.type == '기타'}">selected</c:if>>기타</option>
              </select>
            </td>
          </tr>--%>
          <tr>
            <th scope="row" style="width: 120px;">이름</th>
            <td>
              <input type="text" name="name" id="name" value="${item.name}" style="width: 100%;">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">이메일</th>
            <td>
              <input type="text" name="email" id="email" value="${item.email}" style="width: 100%;">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">연락처</th>
            <td>
              <input type="text" name="phone" id="phone" value="${item.phone}" style="width: 100%;">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">회사명</th>
            <td>
              <input type="text" name="company" id="company" value="${item.company}" style="width: 100%;">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">부서명</th>
            <td>
              <input type="text" name="dept" id="dept" value="${item.dept}" style="width: 100%;">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">직급/직책</th>
            <td>
              <input type="text" name="title" id="title" value="${item.title}" style="width: 100%;">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">메모</th>
            <td>
              <textarea name="memo" id="memo" style="width: 100%;" rows="5">${item.memo}</textarea>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">상태</th>
            <td>
              <select name="enabled" id="enabled">
                <option value="이용중" <c:if test="${item.enabled == '이용중'}">selected</c:if>>이용중</option>
                <option value="휴면예정" <c:if test="${item.enabled == '휴면예정'}">selected</c:if>>휴면예정</option>
                <option value="휴면" <c:if test="${item.enabled == '휴면'}">selected</c:if>>휴면</option>
              </select>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">가입일</th>
            <td>
              <input type="text" name="signup_date" id="signup_date" value="<c:if test="${item.signup_date eq null}"><jsp:useBean id="now" class="java.util.Date" /><fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="now"/><c:out value="${now}"/></c:if>${item.signup_date}" style="width: 200px;">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">최근 방문일</th>
            <td>

              ${item.recent_access}

            </td>
          </tr>
          </tbody>
        </table>
        <div class="btn_wrap">
          <a href="javascript:history.back();" class="btn btn-secondary btn-icon-split"><span class="text">취소</span></a>
          <c:choose>
            <c:when test="${item.id > 0}">
              <a href="javascript:go_reg();" class="btn btn-primary btn-icon-split"><span class="text">수정</span></a>
            </c:when>
            <c:otherwise>
              <a href="javascript:go_reg();" class="btn btn-primary btn-icon-split"><span class="text">확인</span></a>
            </c:otherwise>

          </c:choose>
        </div>
      </div>
    </div>
  </div>
</form>

<script>
  function go_reg(){
    if($("#adminid").val()==""){
      alert('로그인 아이디를 입력해주세요.');
      return;
    }
    <c:if test="${param.id == null}">
    if($("#passwd").val()==""){
      alert('비밀번호를 입력해주세요.');
      return;
    }
    </c:if>
    if($("#name").val()==""){
      alert('이름을 입력해주세요.');
      return;
    }


    $("#frm").submit();
  }
</script>

<%@ include file="admin_footer.jsp" %>
