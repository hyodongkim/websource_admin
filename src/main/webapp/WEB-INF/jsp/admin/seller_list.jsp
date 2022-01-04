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

    function go_delete_seller_checked(){
        if($(".checked:checked").length == 0){
            alert('체크박스를 통해 선택해주세요.');
            return false;
        }
        if(!confirm('선택한 자료를 삭제하시겠습니까? 복원할 수 없는 작업입니다.')) {
            return false;
        }

        let deleted=0;
        $(".checked:checked").each(function(){
            let id = $(this).val();
            $.post("${path}/deleteSellerAction.do", {
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

    function go_delete_seller(id){
        if(!confirm('정말로 삭제하시겠습니까? 복원할 수 없는 작업입니다.')) {
            return false;
        }
        $.post("${path}/deleteSellerAction.do", {
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

    function resetBtn(){
        location.href = 'sellerList.do';
    }
</script>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">판매처 관리</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <form name="listForm" id="listForm" method="get" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <input type="hidden" name="pageIndex" id="pageIndex" value="1"/>
            <div class="input-group">
                <label for="search_type">구분</label>
                <select name="search_type" id="search_type" class="form-control bg-light border-0 small">
                    <option value="" <c:if test="${param.search_type eq ''}">selected</c:if>>전체</option>
                    <option value="온라인" <c:if test="${param.search_type == '온라인'}">selected</c:if>>온라인</option>
                    <option value="오프라인" <c:if test="${param.search_type == '오프라인'}">selected</c:if>>오프라인</option>
                    <option value="기타" <c:if test="${param.search_type == '기타'}">selected</c:if>>기타</option>
                </select>
                <label for="search_name"></label>
                <input type="text" name="search_name" id="search_name" value="${param.search_name}" class="form-control bg-light border-0 small" placeholder="판매처명"/>
                <label for="search_code"></label>
                <input type="text" name="search_code" id="search_code" value="${param.search_code}" class="form-control bg-light border-0 small" placeholder="판매처 코드"/>
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
        <button class="btn btn-warning" type="button" onclick="go_delete_seller_checked()">
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
                    <th>로고 이미지</th>
                    <th>구분</th>
                    <th>판매처명</th>
                    <th>사용건수</th>
                    <th>판매처 코드</th>
                    <th>등록일</th>
                    <th>관리</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${empty list}">
                        <tr>
                            <td colspan="12">등록한 판매처가 없습니다.</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="item" items="${list}" varStatus="status">
                            <tr>
                                <td><input type="checkbox" value="${item.id}" class="checked"/></td>
                                <td>${paginationInfo.totalRecordCount - ((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage + status.index)}</td>
                                <td><img src="${path}/imgview.do?id=${item.files_id}" style="height: 50px;" onerror="this.style.display='none';"/></td>
                                <td><c:out value="${item.type}"/></td>
                                <td><c:out value="${item.name}"/></td>
                                <td><c:out value="${item.used_cnt}"/></td>
                                <td><c:out value="${item.code}"/></td>
                                <td><c:out value="${item.reg_datetime}"/></td>
                                <td>
                                    <a href="${path}/sellerBoth.do?id=<c:out value="${item.id}"/>" class="btn btn-primary btn-icon-split btn-sm"><span class="text">수정</span></a>
                                    <a href="javascript:go_delete_seller('<c:out value="${item.id}"/>');" class="btn btn-danger btn-icon-split btn-sm"><span class="text">삭제</span></a>
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
                <a href="${path}/sellerBoth.do" class="btn btn-primary btn-icon-split btn-sm"><span class="text">판매처 등록</span></a>
            </div>
        </div>
    </div>
</div>

<%@ include file="admin_footer.jsp" %>
