<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">회원 조회</h1>


<!-- DataTales Example -->
<form name="frm" id="frm" method="post" enctype="multipart/form-data">
  <input type="hidden" name="id" id="id" value="${item.id}">
  <div class="card shadow mb-4">
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered dataTable" width="100%" cellspacing="0">
          <tbody>
          <tr>기본 정보</tr>
          <tr>
            <th scope="row" style="width: 120px;">구분</th>
            <td>${item.type}
              <input type="hidden" name="type" value="${item.type}"/>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">고객명</th>
            <td>
              ${item.name}
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">이메일(ID)</th>
            <td>
              ${item.email}
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">비밀번호 초기화</th>
            <td>
              <button type="button" onclick="go_reset_password('${item.id}');">비밀번호 초기화</button>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">가입일자</th>
            <td>
              ${item.reg_datetime}
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">최근방문일자</th>
            <td>
              ${item.recent_access}
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">프로필 사진</th>
            <td>
              <div>
                <img src="${path}/imgview.do?id=${item.files_id}" style="width: 100px;" onerror="this.style.display='none';"/>
              </div>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">os</th>
            <td>
              <div>
                ${item.app_os}
              </div>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">앱 토큰</th>
            <td>
              <div>
                ${item.app_token}
              </div>
            </td>
          </tr>
          </tbody>
        </table>
        <table class="table table-bordered dataTable" width="100%" cellspacing="0">
          <tbody>
          <tr>SNS 로그인 연동</tr>
          <tr>
            <th scope="row" style="width: 120px;">네이버</th>
            <td>
              연동여부 : <c:if test="${item.sns_naver_datetime == null}">N</c:if>
              <c:if test="${item.sns_naver_datetime != null}">Y <br/> 키값 : ${item.sns_naver_id} / 연동일시 : ${item.sns_naver_datetime}</c:if>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">카카오톡</th>
            <td>
              연동여부 : <c:if test="${item.sns_kakao_datetime == null}">N</c:if>
              <c:if test="${item.sns_kakao_datetime != null}">Y <br/> 키값 : ${item.sns_kakao_id} / 연동일시 : ${item.sns_kakao_datetime}</c:if>
            </td>
          </tr>
          <%--<tr>
            <th scope="row" style="width: 120px;">페이스북</th>
            <td>
              연동여부 : ${item.sns_facebook_yn} / 아이디 : ${item.sns_facebook_id} / 연동일시 : ${item.sns_facebook_datetime}
            </td>
          </tr>--%>
          <tr>
            <th scope="row" style="width: 120px;">애플</th>
            <td>
              연동여부 : <c:if test="${item.sns_apple_datetime == null}">N</c:if>
              <c:if test="${item.sns_apple_datetime != null}">Y <br/> 키값 : ${item.sns_apple_id} / 연동일시 : ${item.sns_apple_datetime}</c:if>
            </td>
          </tr>
          </tbody>
        </table>
        <table class="table table-bordered dataTable" width="100%" cellspacing="0">
          <tbody>
          <tr>수신 동의</tr>
          <tr>
            <th scope="row" style="width: 120px;">SMS</th>
            <td>
              ${item.agree_sms}
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">이메일</th>
            <td>
              ${item.agree_email}
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">푸시(공지)</th>
            <td>
              ${item.agree_push_notification}
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">푸시(마케팅)</th>
            <td>
              ${item.agree_push_marketing}
            </td>
          </tr>
          </tbody>
        </table>
        <table class="table table-bordered dataTable" width="100%" cellspacing="0">
          <tbody>
          <tr>
            <th>No.</th>
            <th>회사명(법인명)</th>
            <th>사업자등록번호</th>
            <th>대표자 휴대폰 번호</th>
            <th>온라인비즈니스여부</th>
            <th>오프라인비즈니스여부</th>
            <th>삭제 처리</th>
          </tr>

<c:choose>
  <c:when test="${empty listBusinesses}">
    <tr>
      <td colspan="99">등록한 사업자가 없습니다.</td>
    </tr>
  </c:when>
  <c:otherwise>
    <c:forEach var="itemBusinesses" items="${listBusinesses}" varStatus="status">
          <tr>
            <td>${status.index + 1}</td>
            <td>${itemBusinesses.name}</td>
            <td>${itemBusinesses.brn}</td>
            <td>${itemBusinesses.contact}</td>
            <td>${itemBusinesses.has_online_business}</td>
            <td>${itemBusinesses.has_offline_business}</td>
            <td><a href="javascript:go_remove_business('${itemBusinesses.id}');">[삭제]</a></td>
          </tr>
    </c:forEach>
  </c:otherwise>
</c:choose>
          </tbody>
        </table>

        <div class="btn_wrap">
          <a href="javascript:history.back();" class="btn btn-secondary btn-icon-split"><span class="text">목록</span></a>
          <c:choose>
            <c:when test="${item.id > 0}">
              <a href="javascript:go_reg();" class="btn btn-primary btn-icon-split"><span class="text">수정</span></a>
            </c:when>
            <c:otherwise>
              <a href="javascript:go_reg();" class="btn btn-primary btn-icon-split"><span class="text">확인</span></a>
            </c:otherwise>

          </c:choose>
        </div>
        <div>
          <a href="${path}/leave.do?id=${item.id}" class="btn btn-info btn-icon-split btn-sm"><span class="text">탈퇴처리</span></a>
        </div>
      </div>
    </div>
  </div>
</form>

<script>
  function go_reg(){
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

  function go_reset_password(id){
    $.get("${path}/resetPassword.do?id="+id, function(result){
      alert('비밀번호를 111111로 초기화하였습니다.');
    });
  }

  function go_remove_business(id){

    //<c:if test="${listBusinesses.size() == 1}">alert('1개의 사업자만 남은 경우, 삭제할 수 없습니다.'); return false;</c:if>

    if(!confirm('정말로 해당 사업자를 삭제하시겠습니까?')){
      return false;
    }
    $.get("${path}/removeBusiness.do?id="+id, function(result){
      alert('해당 사업자를 삭제하였습니다.');
      location.reload(true);
    });
  }
</script>

<%@ include file="admin_footer.jsp" %>
