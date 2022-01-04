<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">보험 상품 관리</h1>


<!-- DataTales Example -->
<form name="frm" id="frm" method="post" enctype="multipart/form-data">
  <input type="hidden" name="id" id="id" value="${item.id}">
  <div class="card shadow mb-4">
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered dataTable" width="100%" cellspacing="0">
          <tbody>
          <tr>필수 정보</tr>
          <tr>
            <th scope="row" style="width: 120px;">보험사</th>
            <td>
              <input type="text" name="maker" id="maker" value="${item.maker}">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">보험사 로고</th>
            <td>
              <input type="text" id="file1text" readonly style="width: 220px;">
              <input type="file" name="file1" id="file1" style="display: none;">
              <label for="file1" class="btn">찾기</label>
              <span style="color: gray">로고 이미지는 10MB까지만 올릴 수 있습니다.</span>
              <div class="file_area1">
                <c:if test="${! empty item}">
                  <p data-seq="${item.files_id1}"><span><c:out value="${item.original_name1}"/></span><button type="button" class="deleteFile1">삭제</button></p>
                  <p><img src="${path}/imgview.do?id=${item.files_id1}" style="width: 300px;" onerror="this.style.display='none';"/></p>
                </c:if>
              </div>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">신청 링크</th>
            <td>
              <input type="text" name="apply_link" id="apply_link" value="${item.apply_link}">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">상품명</th>
            <td>
              <input type="text" name="product_name" id="product_name" value="${item.product_name}">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">상품 특징</th>
            <td>
              <input type="text" name="features" id="features" value="${item.features}">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">보험 카테고리</th>
            <td>
              <select name="category" id="category">
                <c:forEach var="categoryItem" items="${listEnabledInsuranceCategory}" varStatus="status">
                  <option value="<c:out value="${categoryItem.code}"/>" <c:if test="${categoryItem.code eq item.category}">selected</c:if>><c:out value="${categoryItem.name}"/></option>
                </c:forEach>
              </select>
            </td>
          </tr>

          <tr>상품 정보</tr>
          <tr>
            <th scope="row" style="width: 120px;">상품 설명 이미지</th>
            <td>
              <input type="text" id="file2text" readonly style="width: 220px;">
              <input type="file" name="file2" id="file2" style="display: none;">
              <label for="file2" class="btn">찾기</label>
              <span style="color: gray">상품 설명 이미지는 10MB까지만 올릴 수 있습니다.</span>
              <div class="file_area2">
                <c:if test="${! empty item}">
                  <p data-seq="${item.files_id2}"><span><c:out value="${item.original_name2}"/></span><button type="button" class="deleteFile2">삭제</button></p>
                  <p><img src="${path}/imgview.do?id=${item.files_id2}" style="width: 300px;" onerror="this.style.display='none';"/></p>
                </c:if>
              </div>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">승인상태</th>
            <td>
              <input type="radio" name="approval" id="approval_1" value="승인 완료" <c:if test="${item.approval eq '승인 완료'}">checked</c:if>/> 승인 완료
              <input type="radio" name="approval" id="approval_2" value="승인 대기" <c:if test="${item.approval eq '승인 대기'}">checked</c:if>/> 승인 대기
              <input type="radio" name="approval" id="approval_3" value="승인 반려" <c:if test="${item.approval eq '승인 반려'}">checked</c:if>/> 승인 반려
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">판매상태</th>
            <td>
              <input type="radio" name="sales" id="sales_Y" value="판매함" <c:if test="${item.sales eq '판매함'}">checked</c:if>/> 판매함
              <input type="radio" name="sales" id="sales_N" value="판매안함" <c:if test="${item.sales eq '판매안함'}">checked</c:if>/> 판매안함
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

    if($("#maker").val()==""){
      alert('제조사를 입력하세요.');
      return;
    }
    if($("#product_name").val()==""){
      alert('상품명을 입력하세요.');
      return;
    }
    /*if($("#model").val()==""){
      alert('모델명을 입력하세요.');
      return;
    }*/
    $("#frm").submit();
  }
  $(function() {
    $("#file1").change(function () {
      //const ext = "hwp, ppt, pptx, xls, xlsx, doc, docx, pdf, jpg, jpeg, gif, png, zip";
      const ext = "jpg, jpeg, gif, png";
      const file = this.files[0];

      if ($(".file_area1 p").attr("data-seq") > 0) {
        $("#frm").append("<input type='hidden' name='deleteFileSeq1' value='" + $(".file_area1 p").data("seq") + "'>")
      }

      var bool = fileSizeCheck(file.size, 50);// && fileExtCheck(file.name, ext);
      if (bool) {
        var html = '<p><span>' + file.name + '</span><button type="button" class="deleteFile1">삭제</button></p>';
        $(".file_area1").html(html)
      }
    })

    $(".deleteFile1").click(function () {

      var fileSeq = $(".file_area1 p").attr("data-seq")
      if (fileSeq > 0) {
        $("#frm").append("<input type='hidden' name='deleteFileSeq1' value='" + fileSeq + "'>")
        $(".file_area1 p").data("seq", 0)
      }
      $("#file1").val("")
      $(".file_area1 p").remove();
    })



    $("#file2").change(function () {
      //const ext = "hwp, ppt, pptx, xls, xlsx, doc, docx, pdf, jpg, jpeg, gif, png, zip";
      const ext = "jpg, jpeg, gif, png";
      const file = this.files[0];

      if ($(".file_area2 p").attr("data-seq") > 0) {
        $("#frm").append("<input type='hidden' name='deleteFileSeq2' value='" + $(".file_area2 p").data("seq") + "'>")
      }

      var bool = fileSizeCheck(file.size, 50);// && fileExtCheck(file.name, ext);
      if (bool) {
        var html = '<p><span>' + file.name + '</span><button type="button" class="deleteFile2">삭제</button></p>';
        $(".file_area2").html(html)
      }
    })

    $(".deleteFile2").click(function () {

      var fileSeq = $(".file_area2 p").attr("data-seq")
      if (fileSeq > 0) {
        $("#frm").append("<input type='hidden' name='deleteFileSeq2' value='" + fileSeq + "'>")
        $(".file_area2 p").data("seq", 0)
      }
      $("#file2").val("")
      $(".file_area2 p").remove();
    })
  });
  //파일 확장자 체크
  function fileExtCheck(name, ext){
    var extchk = ext.split(", ");
    var ext = name.split('.').pop();
    if(extchk.indexOf(ext.toLowerCase()) < 0){
      alert(ext+" 형식의 파일만 등록할 수 있습니다.");
      return false;
    } else {
      return true;
    }
  }

  //파일 사이즈 체크
  function fileSizeCheck(size, mb) {
    var maxSize = Number(mb) * 1024 * 1024;
    if(size > maxSize){
      alert("파일 크기가 "+maxSize+"MB보다 큽니다. 다시 확인해주십시오.");
      return false;
    } else {
      return true;
    }
  }
</script>

<script type="text/javascript" src="${path}/se/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="${path}/js/smartEditor.js"></script>

<%@ include file="admin_footer.jsp" %>
