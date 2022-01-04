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

    function go_delete_blog_checked(){
        if(!confirm('선택한 자료를 삭제하시겠습니까? 복원할 수 없는 작업입니다.')) {
            return false;
        }

        let deleted=0;
        $(".checked:checked").each(function(){
            let pk_blog = $(this).val();
            $.post("${path}/saadmin/deleteBlogAction.do", {
                'pk_blog' : pk_blog
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

    function go_delete_blog(pk_blog){
        if(!confirm('삭제하시겠습니까? 복원할 수 없는 작업입니다.')) {
            return false;
        }
        $.post("${path}/saadmin/deleteBlogAction.do", {
            'pk_blog': pk_blog
        }, function(result){
            if(result == "SUCCESS"){
                alert('삭제처리하였습니다.');
                location.reload(true);
            }else{
                alert(result);
            }
        });

    }

</script>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">블로그 목록</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <form name="listForm" id="listForm" method="get" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <input type="hidden" name="pageIndex" id="pageIndex" value="1"/>
            <div class="input-group">
                <label for="keyword"></label>
                <input name="keyword" id="keyword" type="text" class="form-control bg-light border-0 small" placeholder="검색어(제목+내용)"
                       aria-label="Search" aria-describedby="basic-addon2" value="<c:out value="${param.keyword}"/>">
                <div class="input-group-append">
                    <button class="btn btn-primary" type="submit">
                        검색
                    </button>
                </div>
            </div>
        </form>
    </div>
    <div class="input-group-append" style="float: left; padding: 15px;">
        <button class="btn btn-warning" type="button" onclick="go_delete_blog_checked()">
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
                    <th>탑포스트</th>
                    <th>카테고리</th>
                    <th>제목</th>
                    <th>썸네일</th>
                    <th>조회수</th>
                    <th>등록일시</th>
                    <th>관리</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${empty list}">
                        <tr>
                            <td colspan="5">등록된 내용이 없습니다.</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="item" items="${list}" varStatus="status">
                            <tr>
                                <td><input type="checkbox" value="${item.pk_blog}" class="checked"/></td>
                                <td>${paginationInfo.totalRecordCount - ((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage + status.index)}</td>
                                <td><c:out value="${item.is_toppost}"/></td>
                                <td><c:out value="${item.category}"/><br/>${item.category_en}</td>
                                <td><c:out value="${item.subject}"/><br/>${item.subject_en}</td>
                                <td><img src="/imgview.do?seq=${item.seq}" style="height: 100px;"/></td>
                                <td><c:out value="${item.cnt}"/></td>
                                <td><c:out value="${item.reg_timestamp}"/></td>
                                <td>
                                    <a href="${path}/saadmin/blogBoth.do?pk_blog=<c:out value="${item.pk_blog}"/>" class="btn btn-primary btn-icon-split btn-sm"><span class="text">상세</span></a>
                                    <a href="javascript:go_delete_blog('<c:out value="${item.pk_blog}"/>');" class="btn btn-danger btn-icon-split btn-sm"><span class="text">삭제</span></a>
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
                <a href="${path}/saadmin/blogBoth.do" class="btn btn-primary btn-icon-split btn-sm"><span class="text">신규 등록</span></a>
            </div>
        </div>
    </div>
</div>

<%@ include file="admin_footer.jsp" %>
