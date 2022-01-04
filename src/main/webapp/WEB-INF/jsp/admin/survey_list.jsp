<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<script>
    $(function(){
        $("#chk_all").click(function(){
            $(".checked").prop("checked", $(this).prop("checked"));
        })
    })

    function go_delete_survey_checked(){
        if(!confirm('선택한 설문을 삭제하시겠습니까? 삭제한 설문은 되살릴 수 없습니다.')) {
            return false;
        }

        let deleted=0;
        $(".checked:checked").each(function(){
            let id = $(this).val();
            $.post("${path}/deleteSurveyAction.do", {
                'id' : id
            }, function(result){
                if (result == "SUCCESS"){

                }else{
                    alert(result);
                }
            });
        });

        window.setTimeout(function(){
            alert("삭제하였습니다.");
            location.reload(true);
        }, 500);
    }

    function go_delete_survey(id){
        if(!confirm('정말로 삭제하시겠습니까? 삭제한 설문은 되살릴 수 없습니다.')) {
            return false;
        }
        $.post("${path}/deleteSurveyAction.do", {
            'id': id
        }, function(result){
            if(result == "SUCCESS"){
                alert('삭제하였습니다.');
                location.reload(true);
            }else{
                alert(result);
            }
        });

    }

</script>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">설문 관리</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <form name="listForm" id="listForm" method="get" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <input type="hidden" name="pageIndex" id="pageIndex" value="1"/>
        </form>
    </div>
    <div class="input-group-append" style="float: left; padding: 15px;">
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered dataTable striped" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th><input type="checkbox" id="chk_all"/></th>
                    <th>no</th>
                    <th>설문 게시 여부</th>
                    <th>설문 제목</th>
                    <th>소요시간</th>
                    <th>참여혜택</th>
                    <th>시작일</th>
                    <th>종료일</th>
                    <th>등록일</th>
                    <th>관리</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${empty list}">
                        <tr>
                            <td colspan="999">등록한 설문이 없습니다.</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="item" items="${list}" varStatus="status">
                            <tr>
                                <td><input type="checkbox" value="${item.id}" class="checked"/></td>
                                <td>${paginationInfo.totalRecordCount - ((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage + status.index)}</td>
                                <td><c:out value="${item.is_show}"/></td>
                                <td><c:out value="${item.survey_title}"/></td>
                                <td><c:out value="${item.duration}"/></td>
                                <td><c:out value="${item.benefit}"/></td>
                                <td><c:out value="${item.date_start}"/></td>
                                <td><c:out value="${item.date_end}"/></td>
                                <td><c:out value="${item.reg_datetime}"/></td>
                                <td>
                                    <a href="${path}/surveyBoth.do?id=<c:out value="${item.id}"/>" class="btn btn-primary btn-icon-split btn-sm"><span class="text">수정</span></a>
                                    <a href="javascript:go_delete_survey('<c:out value="${item.id}"/>');" class="btn btn-danger btn-icon-split btn-sm"><span class="text">삭제</span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
            <div class="paging_wrap">
                <ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="fn_egov_link_page" />
            </div>
            <div>
                <a href="javascript:toggle_survey('Y');" class="btn btn-warning btn-icon-split btn-sm"><span class="text">설문 보이기</span></a>
                <a href="javascript:toggle_survey('N');" class="btn btn-danger btn-icon-split btn-sm"><span class="text">설문 가림</span></a>
                <a href="${path}/surveyBoth.do" class="btn btn-primary btn-icon-split btn-sm"><span class="text">설문 등록</span></a>
            </div>
        </div>
    </div>
</div>

<script>
    function toggle_survey(is_show){
        let confirm_msg, result_msg;
        if(is_show == "Y"){
            confirm_msg = "정말로 설문상태를 보이기로 바꾸시겠습니까?";
            result_msg = '설문 상태를 보이기로 바꾸었습니다.';
        }else if(is_show == "N"){
            confirm_msg = "정말로 설문상태를 가리시겠습니까?";
            result_msg = '설문 상태를 가리기로 바꾸었습니다.';

        }
        if(!confirm(confirm_msg)){
            return false;
        }
        $.get("${path}/surveyToggle.do?is_show="+is_show, function(result){
            alert(result_msg);
            location.reload(true);
        });
    }
</script>

<%@ include file="admin_footer.jsp" %>
