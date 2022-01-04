<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">푸시 관리</h1>


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
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">대상</th>
                        <td>
                            <input type="radio" name="device" id="device_all" value="전체" <c:if test="${item.device eq null}">checked</c:if>> 전체
                            <input type="radio" name="device" id="device_android" value="Android" <c:if test="${item.device eq 'Android'}">checked</c:if>> Android
                            <input type="radio" name="device" id="device_ios" value="iOS" <c:if test="${item.device eq 'iOS'}">checked</c:if>> iOS
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">내용</th>
                        <td>
                            <input type="text" name="content" id="content" value="${item.content}">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">등록일시</th>
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
            alert("파일 크기가 "+maxSize+"mb를 초과했습니다. 다시 확인해주십시오.");
            return false;
        } else {
            return true;
        }
    }
</script>

<script type="text/javascript" src="${path}/se/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="${path}/js/smartEditor.js"></script>

<%@ include file="admin_footer.jsp" %>