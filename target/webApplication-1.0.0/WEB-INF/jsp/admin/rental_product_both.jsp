<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">렌탈 상품 관리</h1>


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
            <th scope="row" style="width: 120px;">제조사</th>
            <td>
              <input type="text" name="maker" id="maker" value="${item.maker}">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">제조사 로고</th>
            <td>
              <input type="text" id="file1txt" readonly style="width: 220px;">
              <input type="file" name="file1" id="file1" style="display: none;">
              <label for="file1" class="btn">찾기</label>
              <span style="color: gray">로고 이미지는 10MB까지만 올릴 수 있습니다.</span>
              <div class="file_area1">
                <c:if test="${item.files_id1 ne null}">
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
            <th scope="row" style="width: 120px;">모델명</th>
            <td>
              <input type="text" name="model" id="model" value="${item.model}">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">렌탈 카테고리</th>
            <td>
              <select name="category" id="category">
              <c:forEach var="categoryItem" items="${listEnabledRentalCategory}" varStatus="status">
                <option value="<c:out value="${categoryItem.code}"/>" <c:if test="${categoryItem.code eq item.category}">selected</c:if>><c:out value="${categoryItem.name}"/></option>
              </c:forEach>
              </select>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">납품유형</th>
            <td>
              <input type="radio" name="delivery_type" id="delivery_type_1" value="배송설치" <c:if test="${item.delivery_type eq '배송설치'}">checked</c:if>/> 배송설치
              <input type="radio" name="delivery_type" id="delivery_type_2" value="택배" <c:if test="${item.delivery_type eq '택배'}">checked</c:if>/> 택배
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">만기시 소유권</th>
            <td>
              <input type="radio" name="ownership" id="ownership_1" value="제품회수" <c:if test="${item.ownership eq '제품회수'}">checked</c:if>/> 제품회수
              <input type="radio" name="ownership" id="ownership_2" value="소유권 이전" <c:if test="${item.ownership eq '소유권 이전'}">checked</c:if>/> 소유권 이전
            </td>
          </tr>

        <table class="table table-bordered dataTable" width="100%" cellspacing="0">
          <tbody>
          <tr>추가 정보</tr>
          <tr>
            <th scope="row" style="width: 120px;">상품규격</th>
            <td>
              <input type="text" name="specification" id="specification" value="${item.specification}">
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
            <th scope="row" style="width: 120px;">판매자 상품코드</th>
            <td>
              <input type="text" name="seller_code" id="seller_code" value="${item.seller_code}">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">제조사 상품코드</th>
            <td>
              <input type="text" name="maker_code" id="maker_code" value="${item.maker_code}">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">판매기간</th>
            <td>
              <input type="text" name="sell_start_date" id="sell_start_date" value="${item.sell_start_date}" class="datepicker" autocomplete="off"/> ~ <input type="text" name="sell_end_date" id="sell_end_date" value="${item.sell_end_date}" class="datepicker" autocomplete="off"/>
            </td>
          </tr>
          </tbody>
        </table>

        <table class="table table-bordered dataTable" width="100%" cellspacing="0" id="sales_condition">
          <tbody>
          <tr>판매 조건</tr>
          <tr>
            <th scope="row" style="width: 120px;">일시불</th>
            <td>
              <input type="text" name="one_time_payment" id="one_time_payment" value="${item.one_time_payment}">원
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">약정정보 </th>
            <td>
              <button type="button" onclick="go_add_commit();">추가</button>
            </td>
          </tr>
          <c:if test="${!empty salesConditionVOS}">
          <c:forEach var="itemcon" items="${salesConditionVOS}" varStatus="status">
          <tr>
            <th scope="row" style="width: 120px;">약정정보</th>
            <td>

                <input type="hidden" name="rental_product_id" id="rental_product_id" value="${item.id}">
                약정기간 : <input type="text" name="commitment_terms" id="commitment_terms" value="${itemcon.commitment_terms}">개월
                가격 : <input type="text" name="price" id="price" value="${itemcon.price}">원
                  <button type="button" onclick="go_remove_commit(this);">삭제</button><br/>
            </td>
          </tr>
          </c:forEach>
          </c:if>
          </tbody>
        </table>

        <table class="table table-bordered dataTable" width="100%" cellspacing="0" id="last_month">
          <tbody>
          <tr>추가 할인</tr>
          <tr>
            <th scope="row" style="width: 120px;">카드사</th>
            <td>
              <input type="text" name="card_company" id="card_company" value="${item.card_company}">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">카드명</th>
            <td>
              <input type="text" name="card_name" id="card_name" value="${item.card_name}">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">연회비(국내 전용)</th>
            <td>
              <input type="text" name="annual_fee_domestic_only" id="annual_fee_domestic_only" value="${item.annual_fee_domestic_only}">원
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">연회비(국내외 겸용)</th>
            <td>
              <input type="text" name="annual_fee_overseas" id="annual_fee_overseas" value="${item.annual_fee_overseas}">원
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">발급신청</th>
            <td>
              <select name="issue_apply" id="issue_apply">
                <option value="ARS간편신청" <c:if test="${item.issue_apply eq 'ARS간편신청'}">selected</c:if>>ARS간편신청</option>
                <option value="온라인신청" <c:if test="${item.issue_apply eq '온라인신청'}">selected</c:if>>온라인신청</option>
              </select>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">온라인 신청 링크</th>
            <td>
               <input type="text" name="issue_apply_url" id="issue_apply_url" value="${item.issue_apply_url}" style="width: 400px;">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">전월이용</th>
            <td>
              <button type="button" onclick="go_add_last();">추가</button>
            </td>
          </tr>
          <c:if test="${lastMonthVOS ne null}">
          <c:forEach var="itemcon" items="${lastMonthVOS}" varStatus="status">
          <tr>
            <th scope="row" style="width: 120px;">전월이용</th>
            <td>

                  <input type="hidden" name="rental_product_id" id="rental_product_id" value="${item.id}">
                  전월이용실적 : <input type="text" name="usage_amount" id="usage_amount" value="${itemcon.usage_amount}">원 이상
                  / 할인금액 : <input type="text" name="discount_amount" id="discount_amount" value="${itemcon.discount_amount}">원/월
                    <button type="button" onclick="go_remove_last(this);">삭제</button><br/>
            </td>
          </tr>
          </c:forEach>
          </c:if>
          </tbody>
        </table>

        <table class="table table-bordered dataTable" width="100%" cellspacing="0">
          <tbody>
          <tr>상품 정보</tr>
          <tr>
            <th scope="row" style="width: 120px;">상품 대표 이미지 1</th>
            <td>
              <input type="text" id="file2txt" readonly style="width: 220px;">
              <input type="file" name="file2" id="file2" style="display: none;">
              <label for="file2" class="btn">찾기</label>
              <span style="color: gray">상품 대표 이미지는 10MB까지만 올릴 수 있습니다.</span>
              <div class="file_area2">
                <c:if test="${item.files_id2 ne null}">
                  <p data-seq="${item.files_id2}"><span><c:out value="${item.original_name2}"/></span><button type="button" class="deleteFile2">삭제</button></p>
                  <p><img src="${path}/imgview.do?id=${item.files_id2}" style="width: 300px;" onerror="this.style.display='none';"/></p>
                </c:if>
              </div>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">상품 대표 이미지 2</th>
            <td>
              <input type="text" id="file3txt" readonly style="width: 220px;">
              <input type="file" name="file3" id="file3" style="display: none;">
              <label for="file3" class="btn">찾기</label>
              <span style="color: gray">상품 대표 이미지는 10MB까지만 올릴 수 있습니다.</span>
              <div class="file_area3">
                <c:if test="${item.files_id3 ne null}">
                  <p data-seq="${item.files_id3}"><span><c:out value="${item.original_name3}"/></span><button type="button" class="deleteFile3">삭제</button></p>
                  <p><img src="${path}/imgview.do?id=${item.files_id3}" style="width: 300px;" onerror="this.style.display='none';"/></p>
                </c:if>
              </div>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">상품 대표 이미지 3</th>
            <td>
              <input type="text" id="file4txt" readonly style="width: 220px;">
              <input type="file" name="file4" id="file4" style="display: none;">
              <label for="file4" class="btn">찾기</label>
              <span style="color: gray">상품 대표 이미지는 10MB까지만 올릴 수 있습니다.</span>
              <div class="file_area4">
                <c:if test="${item.files_id4 ne null}">
                  <p data-seq="${item.files_id4}"><span><c:out value="${item.original_name4}"/></span><button type="button" class="deleteFile4">삭제</button></p>
                  <p><img src="${path}/imgview.do?id=${item.files_id4}" style="width: 300px;" onerror="this.style.display='none';"/></p>
                </c:if>
              </div>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">상품 설명 이미지</th>
            <td>
              <input type="text" id="file5txt" readonly style="width: 220px;">
              <input type="file" name="file5" id="file5" style="display: none;">
              <label for="file5" class="btn">찾기</label>
              <span style="color: gray">상품 설명 이미지는 10MB까지만 올릴 수 있습니다.</span>
              <div class="file_area5">
                <c:if test="${item.files_id5 ne null}">
                  <p data-seq="${item.files_id5}"><span><c:out value="${item.original_name5}"/></span><button type="button" class="deleteFile5">삭제</button></p>
                  <p><img src="${path}/imgview.do?id=${item.files_id5}" style="width: 300px;" onerror="this.style.display='none';"/></p>
                </c:if>
              </div>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">상품 고시 정보</th>
            <td>
              <input type="radio" name="product_announcement" id="product_announcement_w" value="포함" <c:if test="${item.product_announcement eq '포함'}">checked</c:if> /> 설명이미지 내 포함
              <input type="radio" name="product_announcement" id="product_announcement_wo" value="미포함" <c:if test="${item.product_announcement eq '미포함'}">checked</c:if> /> 미포함

              <textarea name="product_announcement_note" id="product_announcement_note" placeholder="상품고시정보"><c:out value="${item.product_announcement_note}"/></textarea>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">설치/배송 정보</th>
            <td>
              <input type="radio" name="shipping_info" id="shipping_info_w" value="포함" <c:if test="${item.shipping_info eq '포함'}">checked</c:if>/> 설명이미지 내 포함
              <input type="radio" name="shipping_info" id="shipping_info_wo" value="미포함" <c:if test="${item.shipping_info eq '미포함'}">checked</c:if>/> 미포함

              <textarea name="shipping_info_note" id="shipping_info_note" placeholder="설치/배송 정보"><c:out value="${item.shipping_info_note}"/></textarea>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">환불 정보</th>
            <td>
              <input type="radio" name="refund_info" id="refund_info_w" value="포함" <c:if test="${item.refund_info eq '포함'}">checked</c:if>  onclick="go_refund_info('Y');"/> 설명이미지 내 포함
              <input type="radio" name="refund_info" id="refund_info_wo" value="미포함" <c:if test="${item.refund_info eq '미포함'}">checked</c:if>  onclick="go_refund_info('N');"/> 미포함

              <textarea name="refund_info_note" id="refund_info_note" placeholder="환불 정보"><c:out value="${item.refund_info_note}"/></textarea>
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">19세 미만 구매</th>
            <td>
              <input type="radio" name="minor_purchase" id="minor_purchase_ok" value="가능" <c:if test="${item.minor_purchase eq '가능'}">checked</c:if>/> 가능
              <input type="radio" name="minor_purchase" id="minor_purchase_nk" value="불가능" <c:if test="${item.minor_purchase eq '불가능'}">checked</c:if>/> 불가능
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">소비자상담관련 전화번호</th>
            <td>
              <input type="text" name="counseling_telephone" id="counseling_telephone" value="${item.counseling_telephone}">
            </td>
          </tr>
          </tbody>
        </table>

        <table class="table table-bordered dataTable" width="100%" cellspacing="0">
        <tbody>
          <tr>판매자 정보</tr>
          <tr>
            <th scope="row" style="width: 120px;">상호</th>
            <td>
              <input type="text" name="company_name" id="company_name" value="${item.company_name}">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">대표자</th>
            <td>
              <input type="text" name="president" id="president" value="${item.president}">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">사업장소재지</th>
            <td>
              <input type="text" name="location" id="location" value="${item.location}">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">고객센터 전화번호</th>
            <td>
              <input type="text" name="contact" id="contact" value="${item.contact}">
            </td>
          </tr>
          <tr>
            <th scope="row" style="width: 120px;">사업자 등록번호</th>
            <td>
              <input type="text" name="brn" id="brn" value="${item.brn}">
            </td>
          </tr>
        </tbody>
        </table>

        <table class="table table-bordered dataTable" width="100%" cellspacing="0">
          <tbody>
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

    oEditors1.getById["product_announcement_note"].exec("UPDATE_CONTENTS_FIELD", []);
    oEditors2.getById["shipping_info_note"].exec("UPDATE_CONTENTS_FIELD", []);
    oEditors3.getById["refund_info_note"].exec("UPDATE_CONTENTS_FIELD", []);

    if($("#maker").val()==""){
      alert('제조사를 입력하세요.');
      return;
    }
    if($("#product_name").val()==""){
      alert('상품명을 입력하세요.');
      return;
    }
    if($("#model").val()==""){
      alert('모델명을 입력하세요.');
      return;
    }


    $("[name=commitment_terms]").each(function(i){
      $(this).attr("name", "salesConditionVOS[" + i + "].commitment_terms");
    });
    $("[name=price]").each(function(i){
      $(this).attr("name", "salesConditionVOS[" + i + "].price");
    });
    $("[name=usage_amount]").each(function(i){
      $(this).attr("name", "lastMonthVOS[" + i + "].usage_amount");
    });
    $("[name=discount_amount]").each(function(i){
      $(this).attr("name", "lastMonthVOS[" + i + "].discount_amount");
    });




    $("#frm").submit();
  }

  var oEditors1 = [];
  var oEditors2 = [];
  var oEditors3 = [];
  $(function(){
    nhn.husky.EZCreator.createInIFrame({
      oAppRef: oEditors1,
      elPlaceHolder: 'product_announcement_note',
      sSkinURI: '/saadmin/se/SmartEditor2Skin.html',
      htParams : {
        bUseToolbar : true,
        bUseVerticalResizer : true,
        bUseModeChanger : true,
        SE2M_FontName: {
        },
      },
    });



    nhn.husky.EZCreator.createInIFrame({
      oAppRef: oEditors2,
      elPlaceHolder: 'shipping_info_note',
      sSkinURI: '/saadmin/se/SmartEditor2Skin.html',
      htParams : {
        bUseToolbar : true,
        bUseVerticalResizer : true,
        bUseModeChanger : true,
        SE2M_FontName: {
        },
      },
    });



    nhn.husky.EZCreator.createInIFrame({
      oAppRef: oEditors3,
      elPlaceHolder: 'refund_info_note',
      sSkinURI: '/saadmin/se/SmartEditor2Skin.html',
      htParams : {
        bUseToolbar : true,
        bUseVerticalResizer : true,
        bUseModeChanger : true,
        SE2M_FontName: {
        },
      },
    });

  })

  let afile = new Array();
  $(function() {
      $("#file1").change(function () {
        //const ext = "hwp, ppt, pptx, xls, xlsx, doc, docx, pdf, jpg, jpeg, gif, png, zip";
        let ext = "jpg, jpeg, gif, png";
        let file = this.files[0];

        if ($(".file_area1 p").attr("data-seq") > 0) {
          $("#frm").append("<input type='hidden' name='deleteFileSeq1' value='" + $(".file_area1 p").data("seq") + "'>")
        }


        let bool = fileSizeCheck(file.size, 50) && fileExtCheck(file.name, ext);
        if (bool) {
          $(".file_area1").html('<p><span>' + file.name + '</span><button type="button" class="deleteFile1">삭제</button></p>');
        }
      })
      $(".deleteFile1").click(function () {

        let fileSeq = $(".file_area1 p").attr("data-seq")
        if (fileSeq > 0) {
          $("#frm").append("<input type='hidden' name='deleteFileSeq1' value='" + fileSeq + "'>")
          $(".file_area1 p").data("seq", 0)
        }
        $("#file1").val("")
        $(".file_area1 p").remove();
      })

    $("#file2").change(function () {
      //const ext = "hwp, ppt, pptx, xls, xlsx, doc, docx, pdf, jpg, jpeg, gif, png, zip";
      let ext = "jpg, jpeg, gif, png";
      let file = this.files[0];

      if ($(".file_area2 p").attr("data-seq") > 0) {
        $("#frm").append("<input type='hidden' name='deleteFileSeq2' value='" + $(".file_area2 p").data("seq") + "'>")
      }


      let bool = fileSizeCheck(file.size, 50) && fileExtCheck(file.name, ext);
      if (bool) {
        $(".file_area2").html('<p><span>' + file.name + '</span><button type="button" class="deleteFile2">삭제</button></p>');
      }
    })
    $(".deleteFile2").click(function () {

      let fileSeq = $(".file_area2 p").attr("data-seq")
      if (fileSeq > 0) {
        $("#frm").append("<input type='hidden' name='deleteFileSeq2' value='" + fileSeq + "'>")
        $(".file_area2 p").data("seq", 0)
      }
      $("#file2").val("")
      $(".file_area2 p").remove();
    })

    $("#file3").change(function () {
      //const ext = "hwp, ppt, pptx, xls, xlsx, doc, docx, pdf, jpg, jpeg, gif, png, zip";
      let ext = "jpg, jpeg, gif, png";
      let file = this.files[0];

      if ($(".file_area3 p").attr("data-seq") > 0) {
        $("#frm").append("<input type='hidden' name='deleteFileSeq3' value='" + $(".file_area3 p").data("seq") + "'>")
      }


      let bool = fileSizeCheck(file.size, 50) && fileExtCheck(file.name, ext);
      if (bool) {
        $(".file_area3").html('<p><span>' + file.name + '</span><button type="button" class="deleteFile3">삭제</button></p>');
      }
    })
    $(".deleteFile3").click(function () {

      let fileSeq = $(".file_area3 p").attr("data-seq")
      if (fileSeq > 0) {
        $("#frm").append("<input type='hidden' name='deleteFileSeq3' value='" + fileSeq + "'>")
        $(".file_area3 p").data("seq", 0)
      }
      $("#file3").val("")
      $(".file_area3 p").remove();
    })

    $("#file4").change(function () {
      //const ext = "hwp, ppt, pptx, xls, xlsx, doc, docx, pdf, jpg, jpeg, gif, png, zip";
      let ext = "jpg, jpeg, gif, png";
      let file = this.files[0];

      if ($(".file_area4 p").attr("data-seq") > 0) {
        $("#frm").append("<input type='hidden' name='deleteFileSeq4' value='" + $(".file_area4 p").data("seq") + "'>")
      }


      let bool = fileSizeCheck(file.size, 50) && fileExtCheck(file.name, ext);
      if (bool) {
        $(".file_area4").html('<p><span>' + file.name + '</span><button type="button" class="deleteFile4">삭제</button></p>');
      }
    })
    $(".deleteFile4").click(function () {

      let fileSeq = $(".file_area4 p").attr("data-seq")
      if (fileSeq > 0) {
        $("#frm").append("<input type='hidden' name='deleteFileSeq4' value='" + fileSeq + "'>")
        $(".file_area4 p").data("seq", 0)
      }
      $("#file4").val("")
      $(".file_area4 p").remove();
    })

    $("#file5").change(function () {
      //const ext = "hwp, ppt, pptx, xls, xlsx, doc, docx, pdf, jpg, jpeg, gif, png, zip";
      let ext = "jpg, jpeg, gif, png";
      let file = this.files[0];

      if ($(".file_area5 p").attr("data-seq") > 0) {
        $("#frm").append("<input type='hidden' name='deleteFileSeq5' value='" + $(".file_area5 p").data("seq") + "'>")
      }


      let bool = fileSizeCheck(file.size, 50) && fileExtCheck(file.name, ext);
      if (bool) {
        $(".file_area5").html('<p><span>' + file.name + '</span><button type="button" class="deleteFile5">삭제</button></p>');
      }
    })
    $(".deleteFile5").click(function () {

      let fileSeq = $(".file_area5 p").attr("data-seq")
      if (fileSeq > 0) {
        $("#frm").append("<input type='hidden' name='deleteFileSeq5' value='" + fileSeq + "'>")
        $(".file_area5 p").data("seq", 0)
      }
      $("#file5").val("")
      $(".file_area5 p").remove();
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



  function go_add_commit(){
    let html = `
    <tr>
            <th scope="row" style="width: 120px;">약정정보</th>
            <td>
              <input type="hidden" name="rental_product_id" id="rental_product_id" value="${item.id}">
              약정기간 : <input type="text" name="commitment_terms" value="">개월
              가격 : <input type="text" name="price" value="">원 <button type="button" onclick="go_remove_commit(this);">삭제</button>
            </td>
          </tr>
          `;
    $("#sales_condition").append(html);
  }
  function go_remove_commit(el){
      el.parentElement.parentElement.remove();
  }

  function go_add_last(){
    let html = `<tr>
            <th scope="row" style="width: 120px;">전월이용</th>
            <td>
              전월이용실적 : <input type="text" name="usage_amount" value="">원 이상
              / 할인금액 : <input type="text" name="discount_amount" value="">원/월 <button type="button" onclick="go_remove_last(this);">삭제</button>
            </td>
          </tr>`;
    $("#last_month").append(html);
  }
  function go_remove_last(el){
    el.parentElement.parentElement.remove();
  }
</script>

<script type="text/javascript" src="${path}/se/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="${path}/js/smartEditor.js"></script>

<%@ include file="admin_footer.jsp" %>
