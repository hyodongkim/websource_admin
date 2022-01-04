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

    function go_delete_adminmember_checked(){
        if($(".checked:checked").length == 0){
            alert('체크박스를 통해 선택해주세요.');
            return false;
        }
        if(!confirm('선택한 관리자를 삭제하시겠습니까? 복원할 수 없는 작업입니다.')) {
            return false;
        }

        let deleted=0;
        $(".checked:checked").each(function(){
            let id = $(this).val();
            $.post("${path}/deleteAdminmemberAction.do", {
                'id' : id
            }, function(result){
                if (result == "SUCCESS"){

                }else{
                    alert(result);
                }
            });
        });

        window.setTimeout(function(){
            alert("성공적으로 삭제했습니다.");
            location.reload(true);
        }, 500);
    }

    function go_delete_adminmember(id){
        if(!confirm('정말로 삭제하시겠습니까? 복원할 수 없는 작업입니다.')) {
            return false;
        }
        $.post("${path}/deleteAdminmemberAction.do", {
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
        location.href = 'adminmemberList.do';
    }
</script>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">관리자 회원 조회</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <form name="listForm" id="listForm" method="get" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <input type="hidden" name="pageIndex" id="pageIndex" value="1"/>
            <div class="input-group">
                <label for="search_type">관리자 구분</label>
                <select name="search_type" id="search_type" class="form-control bg-light border-0 small">
                    <option value="" <c:if test="${param.search_type eq ''}">selected</c:if>>전체</option>
                    <option value="일반관리자" <c:if test="${param.search_type == '일반관리자'}">selected</c:if>>일반관리자</option>
                    <option value="기타" <c:if test="${param.search_type == '기타'}">selected</c:if>>기타</option>
                </select>
                <label for="search_enabled">상태</label>
                <select name="search_enabled" id="search_enabled" class="form-control bg-light border-0 small">
                    <option value="" <c:if test="${param.search_enabled eq ''}">selected</c:if>>전체</option>
                    <option value="이용중" <c:if test="${param.search_enabled == '이용중'}">selected</c:if>>이용중</option>
                    <option value="휴면예정" <c:if test="${param.search_enabled == '휴면예정'}">selected</c:if>>휴면예정</option>
                    <option value="휴면" <c:if test="${param.search_enabled == '휴면'}">selected</c:if>>휴면</option>
                    <option value="삭제" <c:if test="${param.search_enabled == '삭제'}">selected</c:if>>삭제</option>
                </select>
                <label for="search_name"></label>
                <input type="text" name="search_name" id="search_name" value="${param.search_name}" class="form-control bg-light border-0 small" placeholder="이름,아이디,이메일"/>
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
        <button class="btn btn-warning" type="button" onclick="go_delete_adminmember_checked()">
            선택삭제
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
                    <th>아이디</th>
                    <th>이름</th>
                    <th>이메일</th>
                    <th>전화번호</th>
                    <th>가입일</th>
                    <th>최근 접속일</th>
                    <th>상태</th>
                    <th>관리</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${empty list}">
                        <tr>
                            <td colspan="12">등록한 관리자가 없습니다.</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="item" items="${list}" varStatus="status">
                            <tr>
                                <td><input type="checkbox" value="${item.id}" class="checked"/></td>
                                <td>${paginationInfo.totalRecordCount - ((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage + status.index)}</td>
                                <td><c:out value="${item.type}"/></td>
                                <td><c:out value="${item.adminid}"/></td>
                                <td><c:out value="${item.name}"/></td>
                                <td><c:out value="${item.email}"/></td>
                                <td><c:out value="${item.phone}"/></td>
                                <td><c:out value="${item.signup_date}"/></td>
                                <td><c:out value="${item.recent_access}"/></td>
                                <td><c:out value="${item.enabled}"/></td>
                                <td>
                                    <a href="${path}/adminmemberBoth.do?id=<c:out value="${item.id}"/>" class="btn btn-primary btn-icon-split btn-sm"><span class="text">수정</span></a>
                                    <a href="javascript:go_delete_adminmember('<c:out value="${item.id}"/>');" class="btn btn-danger btn-icon-split btn-sm"><span class="text">삭제</span></a>
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
                <a href="${path}/adminmemberBoth.do" class="btn btn-primary btn-icon-split btn-sm"><span class="text">관리자 등록</span></a>
                <a href="${path}/adminmemberExcelList.do" class="btn btn-info btn-icon-split btn-sm"><span class="text">Excel 파일 다운로드</span></a>
            </div>
        </div>
    </div>
</div>

<%@ include file="admin_footer.jsp" %>
