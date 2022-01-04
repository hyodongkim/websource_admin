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

    function go_delete_notification_checked(){
        if(!confirm('선택한 알림을 삭제하시겠습니까?')) {
            return false;
        }

        let deleted=0;
        $(".checked:checked").each(function(){
            let id = $(this).val();
            $.post("${path}/deleteNotificationAction.do", {
                'id' : id
            }, function(result){
                if (result == "SUCCESS"){

                }else{
                    alert(result);
                }
            });
        });

        window.setTimeout(function(){
            alert("성공적으로 삭제하였습니다.");
            location.reload(true);
        }, 500);
    }

    function go_delete_notification(id){
        if(!confirm('정말로 삭제하시겠습니까? 복원할 수 없는 작업입니다.')) {
            return false;
        }
        $.post("${path}/deleteNotificationAction.do", {
            'id': id
        }, function(result){
            if(result == "SUCCESS"){
                alert('성공적으로 삭제하였습니다.');
                location.reload(true);
            }else{
                alert(result);
            }
        });
    }

    function resetBtn(){
        location.href = 'notificationList.do';
    }
</script>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">알림사항 관리</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <form name="listForm" id="listForm" method="get" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <input type="hidden" name="pageIndex" id="pageIndex" value="1"/>
            <div class="input-group">
                <label for="search_enabled">사용여부</label>
                <select name="search_enabled" id="search_enabled" class="form-control bg-light border-0 small">
                    <option value="" <c:if test="${param.search_enabled eq ''}">selected</c:if>>전체</option>
                    <option value="사용" <c:if test="${param.search_enabled == '사용'}">selected</c:if>>사용</option>
                    <option value="사용안함" <c:if test="${param.search_enabled == '사용안함'}">selected</c:if>>사용안함</option>
                </select>
                <label for="search_subject"></label>
                <input type="text" name="search_subject" id="search_subject" value="${param.search_subject}" class="form-control bg-light border-0 small" placeholder="제목"/>
                <div class="input-group-append">
                    <button class="btn btn-primary" type="submit">
                        검색
                    </button>
                    <button class="btn btn-secondary" type="button" onclick="resetBtn()">
                        초기화
                    </button>
                </div>
            </div>
        </form>
    </div>
    <div class="input-group-append" style="float: left; padding: 15px;">
        <button class="btn btn-warning" type="button" onclick="go_delete_notification_checked()">
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
                    <th>제목</th>
                    <th>사용 여부</th>
                    <th>푸시 여부</th>
                    <th>조회수</th>
                    <th>작성자</th>
                    <th>등록일</th>
                    <th>푸시 발송</th>
                    <th>관리</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${empty list}">
                        <tr>
                            <td colspan="12">등록한 알림사항이 없습니다.</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="item" items="${list}" varStatus="status">
                            <tr>
                                <td><input type="checkbox" value="${item.id}" class="checked"/></td>
                                <td>${paginationInfo.totalRecordCount - ((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage + status.index)}</td>
                                <td><c:out value="${item.type}"/></td>
                                <td><c:out value="${item.subject}"/></td>
                                <td><c:out value="${item.enabled}"/></td>
                                <td><c:out value="${item.push}"/></td>
                                <td><c:out value="${item.hit_count}"/></td>
                                <td><c:out value="${item.author}"/></td>
                                <td><c:out value="${item.reg_datetime}"/></td>
                                <td>
                                    <c:if test="${item.push == '진행'}">
                                    <a href="javascript:go_send_push('${item.id}');" class="btn btn-danger btn-icon-split btn-sm"><span class="text">푸시 발송</span></a>
                                    </c:if>
                                </td>
                                <td>
                                    <a href="${path}/notificationBoth.do?id=<c:out value="${item.id}"/>" class="btn btn-primary btn-icon-split btn-sm"><span class="text">수정</span></a>
                                    <a href="javascript:go_delete_notification('<c:out value="${item.id}"/>');" class="btn btn-danger btn-icon-split btn-sm"><span class="text">삭제</span></a>
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
                <a href="${path}/notificationBoth.do" class="btn btn-primary btn-icon-split btn-sm"><span class="text">알림 등록</span></a>
            </div>
        </div>
    </div>
</div>

<script>
    function go_send_push(id){
        if(!confirm('발송하시겠습니까? 실시간 발송되므로, 취소가 불가능한 작업입니다.')){
            return false;
        }
        $.get("/saadmin/sendPush.do?id="+id, function(result){
            if(result == "SUCCESS"){
                alert('성공적으로 푸쉬를 발송하였습니다.');
            }
        })
    }
</script>

<%@ include file="admin_footer.jsp" %>
