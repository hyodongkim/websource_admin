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

    function go_delete_quote_checked(){
        if(!confirm('선택한 자료를 삭제하시겠습니까? 복원할 수 없는 작업입니다.')) {
            return false;
        }

        let deleted=0;
        $(".checked:checked").each(function(){
            let pk_quote = $(this).val();
            $.post("${path}/saadmin/deleteQuoteAction.do", {
                'pk_quote' : pk_quote
            }, function(result){
                if (result == "SUCCESS"){

                }else{
                    alert(result);
                }
            });
        });

        window.setTimeout(function(){
            alert("삭제되었습니다.");
            location.reload(true);
        }, 500);

    }


    function go_delete_quote(pk_quote){
        if(!confirm('정말로 삭제하시겠습니까? 복원할 수 없는 작업입니다.')) {
            return false;
        }
        $.post("${path}/saadmin/deleteQuoteAction.do", {
            'pk_quote': pk_quote
        }, function(result){
            if(result == "SUCCESS"){
                alert('삭제하였습니다.');
                location.reload(true);
            }else{
                alert(result);
            }
        });

    }
    function change_process_yn(pk_quote, obj){
        if(!confirm('처리여부를 변경하시겠습니까?')){
            return false;
        }
        $.post("${path}/saadmin/changeQuoteProcessAction.do", {
            'pk_quote': pk_quote,
            'process_yn': obj.value
        }, function(result){
            if(result == "SUCCESS"){
                alert('처리여부를 변경하였습니다.');
                location.reload(true);
            }else{
                alert(result);
            }
        });
    }
</script>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">견적요청목록</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <form name="listForm" id="listForm" method="get" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <input type="hidden" name="pageIndex" id="pageIndex" value="1"/>
            <div class="input-group">
                <label for="field"></label>
                <select name="field" id="field" class="form-control bg-light border-0 small">
                    <option value="all" <c:if test="${param.field == 'all'}">selected</c:if>>전체</option>
                    <option value="name" <c:if test="${param.field == 'name'}">selected</c:if>>이름</option>
                    <option value="name_last" <c:if test="${param.field == 'name_last'}">selected</c:if>>성</option>
                    <option value="phone" <c:if test="${param.field == 'phone'}">selected</c:if>>전화번호</option>
                </select>
                <label for="keyword"></label>
                <input type="text" name="keyword" id="keyword" value="${param.keyword}" class="form-control bg-light border-0 small" placeholder="검색어"/>
                <div class="input-group-append">
                    <button class="btn btn-primary" type="submit">
                        검색
                    </button>
                </div>
            </div>
        </form>
    </div>

    <div class="input-group-append" style="float: left; padding: 15px;">
        <button class="btn btn-warning" type="button" onclick="go_delete_quote_checked()">
            선택삭제
        </button>
    </div>

    <div class="card-body">
        <div class="table-responsive">
            <%--<div class="mb-4">
                <a href="#" class="btn btn-success btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-check"></i>
                                        </span>
                    <span class="text">신규등록</span>
                </a>
            </div>--%>
            <table class="table table-bordered dataTable striped" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th><input type="checkbox" id="chk_all"/></th>
                    <th>no</th>
                    <%--<th>마켓팅 동의</th>--%>
                    <th>이름(회사명)</th>
                    <th>성</th>
                    <th>전화번호</th>
                    <th>이메일</th>
                    <th>국가</th>
                    <th>산업군</th>
                    <%--<th>플랫폼</th>--%>
                    <%--<th>초기(기본) 비용</th>--%>
                    <%--<th>사용 면적</th>--%>
                    <%--<th>실제 사용자 수</th>--%>
                    <%--<th>최대 동시 접속자 수</th>--%>
                    <%--<th>서비스 영역(지도) 수</th>--%>
                    <%--<th>필요 앱 개수</th>--%>
                    <th>등록일시</th>
                    <th>처리여부</th>
                    <th>관리</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${empty list}">
                        <tr>
                            <td colspan="8">등록된 내용이 없습니다.</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="item" items="${list}" varStatus="status">
                        <tr>
                            <td><input type="checkbox" value="${item.pk_quote}" class="checked"/></td>
                            <td>${paginationInfo.totalRecordCount - ((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage + status.index)}</td>
                            <%--<td><c:out value="${item.is_agree}"/></td>--%>
                            <td><c:out value="${item.name}"/></td>
                            <td><c:out value="${item.name_last}"/></td>
                            <td><c:out value="${item.phone}"/></td>
                            <td><c:out value="${item.email}"/></td>
                            <td><c:out value="${item.country}"/></td>
                            <td><c:out value="${item.industry}"/></td>
                            <%--<td><c:out value="${item.platform}"/></td>--%>
                            <%--<td><c:out value="${item.initial_cost}"/></td>--%>
                            <%--<td><c:out value="${item.use_area}"/></td>--%>
                            <%--<td><c:out value="${item.active_user_num}"/></td>--%>
                            <%--<td><c:out value="${item.max_concurrent_users}"/></td>--%>
                            <%--<td><c:out value="${item.service_num}"/></td>--%>
                            <%--<td><c:out value="${item.app_num}"/></td>--%>
                            <td>
                                <c:out value="${item.reg_timestamp}"/>
                                <c:if test="${fn:indexOf(item.reg_timestamp, today) != -1}">
                                    <span style="color: red; font-weight: bolder;">[NEW]</span>
                                </c:if>
                            </td>
                            <td><select onchange="change_process_yn('<c:out value="${item.pk_quote}"/>',this);">
                                <option value="Y" <c:if test="${item.process_yn eq 'Y'}">selected</c:if>>처리완료</option>
                                <option value="N" <c:if test="${item.process_yn eq 'N'}">selected</c:if>>미처리</option>
                            </select> </td>
                            <td>
                                <a href="${path}/saadmin/viewQuote.do?pk_quote=<c:out value="${item.pk_quote}"/>" class="btn btn-primary btn-icon-split btn-sm"><span class="text">상세</span></a>
                                <a href="javascript:go_delete_quote('<c:out value="${item.pk_quote}"/>');" class="btn btn-danger btn-icon-split btn-sm"><span class="text">삭제</span></a>
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
        </div>
    </div>
</div>

<%@ include file="admin_footer.jsp" %>
