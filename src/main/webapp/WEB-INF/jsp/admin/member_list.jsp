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

    function go_leave_member_checked(){

        if($(".checked:checked").length == 0){
            alert('체크박스를 통해 선택해주세요.');
            return false;
        }

        if(!confirm('선택한 회원을 탈퇴시키겠습니까? 탈퇴한 회원은 되살릴 수 없습니다.')) {
            return false;
        }

        let deleted=0;
        $(".checked:checked").each(function(){
            let id = $(this).val();
            $.get("${path}/leave.do?id="+id, function(result){
//                alert(result);
            });
        });

        window.setTimeout(function(){
            alert("성공적으로 탈퇴 처리했습니다.");
            location.reload(true);
        }, 2000);
    }

    function go_delete_member(id){
        if(!confirm('정말로 삭제하시겠습니까? 삭제하면 되살릴 수 없습니다.')) {
            return false;
        }
        $.post("${path}/deleteMemberAction.do", {
            'id': id
        }, function(result){
            if(result == "SUCCESS"){
                alert('성공적으로 삭제했습니다.');
                location.reload(true);
            }else{
                alert(result);
            }
        });

    }

    function resetBtn(){
        location.href = 'memberList.do';
    }
</script>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">회원 조회</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <form name="listForm" id="listForm" method="get" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <input type="hidden" name="pageIndex" id="pageIndex" value="1"/>
            <div class="input-group">
                <label for="search_signup_date_start">가입일</label>
                <input type="text" name="search_signup_date_start" id="search_signup_date_start" value="${memberVO.search_signup_date_start}" class="datepicker" autocomplete="off"/>&nbsp;~&nbsp;<input type="text" name="search_signup_date_end" id="search_signup_date_end" value="${memberVO.search_signup_date_end}" class="datepicker"/>
            </div>
            <div class="input-group">
                <label for="search_type">회원 구분</label>
                <select name="search_type" id="search_type" class="form-control bg-light border-0 small">
                    <option value="" <c:if test="${param.search_type eq ''}">selected</c:if>>전체</option>
                    <option value="기업" <c:if test="${param.search_type == '기업'}">selected</c:if>>기업</option>
                    <option value="기타" <c:if test="${param.search_type == '기타'}">selected</c:if>>기타</option>
                </select>
                <label for="search_enabled">상태</label>
                <select name="search_enabled" id="search_enabled" class="form-control bg-light border-0 small">
                    <option value="" <c:if test="${param.search_enabled eq ''}">selected</c:if>>전체</option>
                    <option value="이용중" <c:if test="${param.search_enabled == '이용중'}">selected</c:if>>이용중</option>
                    <option value="휴면예정" <c:if test="${param.search_enabled == '휴면예정'}">selected</c:if>>휴면예정</option>
                    <option value="휴면" <c:if test="${param.search_enabled == '휴면'}">selected</c:if>>휴면</option>
                </select>
                <label for="search_name"></label>
                <input type="text" name="search_name" id="search_name" value="${param.search_name}" class="form-control bg-light border-0 small" placeholder="이름 또는 이메일"/>
                <div class="input-group-append">
                    <button class="btn btn-primary" type="submit">
                        조회하기
                    </button>
                    <button class="btn btn-secondary" type="button" onclick="resetBtn()">
                        초기화
                    </button>
                </div>
            </div>
        </form>
    </div>
    <div class="input-group-append" style="float: left; padding: 15px;">
        <button class="btn btn-warning" type="button" onclick="go_leave_member_checked()">
            선택탈퇴
        </button>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered dataTable striped" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th><input type="checkbox" id="chk_all"/></th>
                    <th>no</th>
                    <th>구분</th>
                    <th>이름</th>
                    <th>이메일</th>
                    <th>가입일시</th>
                    <th>휴대폰 번호</th>
                    <th>최근 접속일시</th>
                    <th>상태</th>
                    <th>관리</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${empty list}">
                        <tr>
                            <td colspan="12">등록한 회원이 없습니다.</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="item" items="${list}" varStatus="status">
                            <tr>
                                <td><input type="checkbox" value="${item.id}" class="checked"/></td>
                                <td>${paginationInfo.totalRecordCount - ((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage + status.index)}</td>
                                <td><c:out value="${item.type}"/></td>
                                <td><%--<a href="${path}/memberView.do?id=<c:out value="${item.id}"/>" >--%><c:out value="${item.name}"/><%--</a>--%></td>
                                <td><c:out value="${item.email}"/></td>
                                <td><c:out value="${item.reg_datetime}"/></td>
                                <td><c:out value="${item.phone}"/></td>
                                <td><c:out value="${item.recent_access}"/></td>
                                <td><c:out value="${item.enabled}"/></td>
                                <td>
                                    <a href="${path}/memberBoth.do?id=<c:out value="${item.id}"/>" class="btn btn-primary btn-icon-split btn-sm"><span class="text">수정</span></a>
                                    <a href="javascript:go_delete_member('<c:out value="${item.id}"/>');" class="btn btn-danger btn-icon-split btn-sm"><span class="text">삭제</span></a>
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
                <a href="javascript:go_excel();" class="btn btn-info btn-icon-split btn-sm"><span class="text">Excel 파일 다운로드</span></a>
            </div>
        </div>
    </div>
</div>

<script>
    function go_excel(){
        listForm.action = "${path}/memberExcelList.do";
        listForm.submit();

        listForm.action = "";
    }
</script>

<%@ include file="admin_footer.jsp" %>
