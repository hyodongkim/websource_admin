<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<script>
    function resetBtn(){
        location.href = 'leaveList.do';
    }
</script>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">탈퇴 회원 조회</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <form name="listForm" id="listForm" method="get" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <input type="hidden" name="pageIndex" id="pageIndex" value="1"/>
            <div class="input-group">
                <label for="date_start">기간</label>
                <input type="text" name="date_start" id="date_start" value="${item.date_start}" class="datepicker" autocomplete="off"/>&nbsp;~&nbsp;<input type="text" name="date_end" id="date_end" value="${item.date_end}" class="datepicker" autocomplete="off"/>
            </div>
            <div class="input-group">
                <label for="keyword"></label>
                <input type="text" name="keyword" id="keyword" value="${item.keyword}" class="form-control bg-light border-0 small" placeholder="이름 또는 이메일"/>
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
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered dataTable striped" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>no</th>
                    <th>고객명</th>
                    <th>이메일</th>
                    <th>가입일</th>
                    <th>탈퇴일</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${empty list}">
                        <tr>
                            <td colspan="12">탈퇴 회원이 없습니다.</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="item" items="${list}" varStatus="status">
                            <tr>
                                <td>${paginationInfo.totalRecordCount - ((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage + status.index)}</td>
                                <c:set var="name"       value="${item.name}" />
                                <c:set var="totalLength" value="${fn:length(name) }" />
                                <c:set var="first"      value="${fn:substring(name, 0, 1) }" />
                                <c:set var="last"      value="${fn:substring(name, 2, totalLength) }" />


                                <td><c:out value="${first}*${last}"/></td>

                                <c:set var="name"       value="${item.email}" />
                                <c:set var="totalLength" value="${fn:length(name) }" />
                                <c:set var="first"      value="${fn:substring(name, 0, 3) }" />
                                <c:set var="last"      value="${fn:substring(name, 6, totalLength) }" />

                                <td><c:out value="${first}***${last}"/></td>
                                <td><c:out value="${item.reg_datetime}"/></td>
                                <td><c:out value="${item.leave_datetime}"/></td>
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
        listForm.action = "${path}/memberLeaveExcelList.do";
        listForm.submit();

        listForm.action = "";
    }
</script>

<%@ include file="admin_footer.jsp" %>
