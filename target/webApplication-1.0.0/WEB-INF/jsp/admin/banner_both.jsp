<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">배너 관리</h1>


<!-- DataTales Example -->
<form name="frm" id="frm" method="post" enctype="multipart/form-data">
  <input type="hidden" name="id" id="id" value="${item.id}">
  <div class="card shadow mb-4">
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered dataTable" width="100%" cellspacing="0">
          <tbody>

          <tr>
            <th scope="row" style="width: 120px;">위치</th>
            <td>
              <select name="position" id="position">
                <option value="매출" <c:if test="${item.position eq '매출'}">selected</c:if>>매출</option>
                <option value="렌탈" <c:if test="${item.position eq '렌탈'}">selected</c:if>>렌탈</option>
                <option value="보험" <c:if test="${item.position eq '보험'}">selected</c:if>>보험</option>
                <option value="설문" <c:if test="${item.position eq '설문'}">selected</c:if>>설문</option>
                <option value="마이페이지" <c:if test="${item.position eq '마이페이지'}">selected</c:if>>마이페이지</option>
              </select>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">배너명</th>
            <td>
              <input type="text" name="name" id="name" value="${item.name}">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">게시기간</th>
            <td>
              <input type="text" name="date_start" id="date_start" value="${item.date_start}" class="datepicker" autocomplete="off"/> ~ <input type="text" name="date_end" id="date_end" value="${item.date_end}" class="datepicker" autocomplete="off"/>
            </td>
          </tr>
          <tr>
            <th scope="row">파일</th>
            <td>
              <input type="text" id="file" readonly style="width: 220px;">
              <input type="file" name="community" id="communityFile" style="display: none;">
              <label for="communityFile" class="btn">찾기</label>
              <span style="color: gray">첨부파일 용량은 50MB까지만 가능합니다.</span>
              <div class="file_area1">
                <c:if test="${! empty item}">
                  <p data-seq="${item.files_id}"><span><c:out value="${item.original_name}"/></span><button type="button" class="deleteFile">삭제</button></p>
                  <p><img src="${path}/imgview.do?id=${item.files_id}" style="width: 300px;" onerror="this.style.display='none';"/></p>
                </c:if>
              </div>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">대체 텍스트</th>
            <td>
              <input type="text" name="alt_text" id="alt_text" value="${item.alt_text}">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">링크</th>
            <td>
              <input type="text" name="link" id="link" value="${item.link}">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">정렬순서</th>
            <td>
              <input type="number" name="order_by" id="order_by" value="${item.order_by}" min="1" max="100">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">클릭수</th>
            <td>
              ${item.click_count}
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">게시 상태</th>
            <td>
              <input type="radio" name="enabled" id="enabled_Y" value="Y" <c:if test="${item.enabled eq 'Y' || item.enabled eq null}">checked</c:if>> Y
              <input type="radio" name="enabled" id="enabled_N" value="N" <c:if test="${item.enabled eq 'N'}">checked</c:if>> N
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">등록일</th>
            <td>
              ${item.reg_datetime}
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

    if($("#name").val()==""){
      alert('배너명을 입력해주세요.');
      return;
    }
    if($("#date_start").val()==""){
      alert('게시 시작기간을 입력해주세요.');
      return;
    }
    if($("#date_end").val()==""){
      alert('게시 종료기간을 입력해주세요.');
      return;
    }
    <c:if test="${item.id eq ''}">
    if($("input[type=file]").val()==""){
      alert('배너 이미지 파일을 등록해주세요.');
      return;
    }
    </c:if>
    <c:if test="${item.id ne ''}">
    if($("input[type=file]").val()=="" && $("[name=deleteFileSeq]").val()!=undefined){
      alert('배너 이미지 파일을 등록해주세요.');
      return;
    }
    if($("#alt_text").val()==""){
      alert('대체 텍스트를 입력해주세요.');
      return;
    }
    if($("#link").val()==""){
      alert('링크값을 입력해주세요.');
      return;
    }
    if($("#order_by").val()==""){
      alert('정렬 순서를 입력해주세요.');
      return;
    }
    </c:if>


    $("#frm").submit();
  }
  $(function() {
    $(":file").change(function () {
      //const ext = "hwp, ppt, pptx, xls, xlsx, doc, docx, pdf, jpg, jpeg, gif, png, zip";
      //const ext = "jpg, jpeg, gif, png";
      const file = this.files[0];

      if ($(".file_area1 p").attr("data-seq") > 0) {
        $("#frm").append("<input type='hidden' name='deleteFileSeq' value='" + $(".file_area1 p").data("seq") + "'>")
      }

      var bool = fileSizeCheck(file.size, 50);// && fileExtCheck(file.name, ext);
      if (bool) {
        var html = '<p><span>' + file.name + '</span><button type="button" class="deleteFile">삭제</button></p>';
        $(".file_area1").html(html)
      }
    })

    $(".deleteFile").click(function () {

      var fileSeq = $(".file_area1 p").attr("data-seq")
      if (fileSeq > 0) {
        $("#frm").append("<input type='hidden' name='deleteFileSeq' value='" + fileSeq + "'>")
        $(".file_area1 p").data("seq", 0)
      }
      $(":file").val("")
      $(".file_area1 p").remove();
    })
  });
  //파일 확장자 체크
  function fileExtCheck(name, ext){
    var extchk = ext.split(", ");
    var ext = name.split('.').pop();
    if(extchk.indexOf(ext.toLowerCase()) < 0){
      alert(ext+"형식의 파일만 등록할 수 있습니다.");
      return false;
    } else {
      return true;
    }
  }

  //파일 사이즈 체크
  function fileSizeCheck(size, mb) {
    var maxSize = Number(mb) * 1024 * 1024;
    if(size > maxSize){
      alert("파일 용량이"+maxSize+"mb가 초과되었습니다. 다시 확인해주십시오.");
      return false;
    } else {
      return true;
    }
  }
</script>

<script type="text/javascript" src="${path}/se/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="${path}/js/smartEditor.js"></script>

<%@ include file="admin_footer.jsp" %>
