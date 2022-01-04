<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">블로그 상세 내용</h1>


<!-- DataTales Example -->
<form name="frm" id="frm" method="post" enctype="multipart/form-data">
    <input type="hidden" name="pk_blog" id="pk_blog" value="${blog.pk_blog}">
    <div class="card shadow mb-4">
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered dataTable" width="100%" cellspacing="0">
                    <tbody>
                    <tr>
                        <th scope="row" style="width: 120px;">탑포스트 여부</th>
                        <td>
                            <select name="is_toppost" id="is_toppost">
                               <option value="N" <c:if test="${blog.is_toppost == 'N'}">selected</c:if>>N</option>
                               <option value="Y" <c:if test="${blog.is_toppost == 'Y'}">selected</c:if>>Y</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">국문 제목</th>
                        <td>
                            <input type="text" name="subject" id="subject" value="${blog.subject}" style="width: 100%;">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">영문 제목</th>
                        <td>
                            <input type="text" name="subject_en" id="subject_en" value="${blog.subject_en}" style="width: 100%;">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">국문 카테고리</th>
                        <td>
                            기존 카테고리에서 선택 :
                            <select name="category" id="category">
                                <c:forEach var="item" items="${listCategory}" varStatus="vs">
                                    <option value="${item.category}" <c:if test="${blog.category == item.category}">selected</c:if>>${item.category}</option>
                                </c:forEach>
                            </select>
                            신규 : <input type="text" name="category_new" id="category_new" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">영문 카테고리</th>
                        <td>
                            기존 카테고리에서 선택 :
                            <select name="category_en" id="category_en">
                                <c:forEach var="item" items="${listCategoryEn}" varStatus="vs">
                                    <option value="${item.category_en}" <c:if test="${blog.category_en == item.category_en}">selected</c:if>>${item.category_en}</option>
                                </c:forEach>
                            </select>
                            신규 : <input type="text" name="category_en_new" id="category_en_new" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">내용(국문)</th>
                        <td class="text_area"><textarea name="content_ko" id="content_ko" placeholder="에디터영역(국문)"><c:out value="${blog.content_ko}"/></textarea></td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">내용(영문)</th>
                        <td class="text_area"><textarea name="content_en" id="content_en" placeholder="에디터영역(영문)"><c:out value="${blog.content_en}"/></textarea></td>
                    </tr>
                    <tr>
                        <th scope="row">첨부파일</th>
                        <td>
                            <input type="text" id="file" readonly style="width: 220px;">
                            <input type="file" name="community" id="communityFile" style="display: none;">
                            <label for="communityFile" class="btn">찾기</label>
                            <span style="color: gray">첨부파일 용량은 20MB까지만 가능합니다.</span>
                            <div class="file_area1">
                                <c:if test="${! empty fvo}">
                                    <p data-seq="${fvo.seq}"><span><c:out value="${fvo.originName}"/></span><button type="button" class="deleteFile">삭제</button></p>
                                </c:if>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="btn_wrap">
                    <a href="javascript:history.back();" class="btn btn-secondary btn-icon-split"><span class="text">목록</span></a>
                    <c:choose>
                        <c:when test="${blog.pk_blog > 0}">
                            <a href="javascript:go_reg();" class="btn btn-primary btn-icon-split"><span class="text">수정</span></a>
                        </c:when>
                        <c:otherwise>
                            <a href="javascript:go_reg();" class="btn btn-primary btn-icon-split"><span class="text">등록</span></a>
                        </c:otherwise>

                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</form>

<script>
    function go_reg(){
        oEditors1.getById["content_ko"].exec("UPDATE_CONTENTS_FIELD", []);
        oEditors2.getById["content_en"].exec("UPDATE_CONTENTS_FIELD", []);

        if($("#subject").val()==""){
            alert('제목을 입력해주세요.');
            return;
        }
        if($("#category option:selected").val()=="" && $("#category_new").val() == ""){
            alert('카테고리를 선택해주세요.');
            return;
        }
        if($("#content_ko").val()==""){
            alert('국문 내용을 입력해주세요.');
            return;
        }
        if($("#content_en").val()==""){
            alert('영문 내용을 입력해주세요.');
            return;
        }

        $("#frm").submit();
    }
$(function() {
    $(":file").change(function () {
        //const ext = "hwp, ppt, pptx, xls, xlsx, doc, docx, pdf, jpg, jpeg, gif, png, zip";
        const ext = "jpg, jpeg, gif, png";
        const file = this.files[0];

        if ($(".file_area1 p").attr("data-seq") > 0) {
            $("#frm").append("<input type='hidden' name='deleteFileSeq' value='" + $(".file_area1 p").data("seq") + "'>")
        }

        var bool = fileSizeCheck(file.size, 20) && fileExtCheck(file.name, ext);
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