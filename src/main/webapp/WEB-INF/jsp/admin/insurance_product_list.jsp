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

    function go_delete_insurance_product_checked(){
        if(!confirm('선택한 상품을 삭제하시겠습니까?')) {
            return false;
        }

        let deleted=0;
        $(".checked:checked").each(function(){
            let id = $(this).val();
            $.post("${path}/deleteInsurance_productAction.do", {
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

    function go_delete_insurance_product(id){
        if(!confirm('정말로 삭제하시겠습니까? 복원할 수 없는 작업입니다.')) {
            return false;
        }
        $.post("${path}/deleteInsurance_productAction.do", {
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
        location.href = 'insurance_productList.do';
    }
</script>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">보험 상품 관리</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <form name="listForm" id="listForm" method="get" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <input type="hidden" name="pageIndex" id="pageIndex" value="1"/>
            <div class="input-group">
                <label for="search_product_name"></label>
                <input type="text" name="search_product_name" id="search_product_name" value="${param.search_product_name}" class="form-control bg-light border-0 small" placeholder="상품 이름"/>
                <label for="search_maker"></label>
                <input type="text" name="search_maker" id="search_maker" value="${param.search_maker}" class="form-control bg-light border-0 small" placeholder="보험사"/>
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
        <button class="btn btn-warning" type="button" onclick="go_delete_insurance_product_checked()">
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
                    <th>보험사</th>
                    <th>보험사 로고</th>
                    <th>신청 링크</th>
                    <th>상품명</th>
                    <th>상품 특징</th>
                    <th>보험 카테고리</th>
                    <th>승인상태</th>
                    <th>판매상태</th>
                    <th>관리</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${empty list}">
                        <tr>
                            <td colspan="12">등록한 상품이 없습니다.</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="item" items="${list}" varStatus="status">
                            <tr>
                                <td><input type="checkbox" value="${item.id}" class="checked"/></td>
                                <td>${paginationInfo.totalRecordCount - ((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage + status.index)}</td>
                                <td><c:out value="${item.maker}"/></td>
                                <td><img src="${path}/imgview.do?id=${item.files_id1}" style="width: 100px;" onerror="this.style.display='none';"/></td>
                                <td><c:out value="${item.apply_link}"/></td>
                                <td><c:out value="${item.product_name}"/></td>
                                <td><c:out value="${item.features}"/></td>
                                <td><c:out value="${item.category_name}"/></td>
                                <td><c:out value="${item.approval}"/></td>
                                <td><c:out value="${item.sales}"/></td>
                                <td>
                                    <a href="${path}/insurance_productBoth.do?id=<c:out value="${item.id}"/>" class="btn btn-primary btn-icon-split btn-sm"><span class="text">수정</span></a>
                                    <a href="javascript:go_delete_insurance_product('<c:out value="${item.id}"/>');" class="btn btn-danger btn-icon-split btn-sm"><span class="text">삭제</span></a>
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
                <a href="${path}/insurance_productBoth.do" class="btn btn-primary btn-icon-split btn-sm"><span class="text">상품 등록</span></a>
                <a href="${path}/insurance_productExcelList.do" class="btn btn-info btn-icon-split btn-sm"><span class="text">Excel 파일 다운로드</span></a>
            </div>
        </div>
    </div>
</div>

<%@ include file="admin_footer.jsp" %>
