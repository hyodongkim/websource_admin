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

    function go_delete_banner_checked(){
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
            $.post("${path}/deleteBannerAction.do", {
                'id' : id
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

    function go_delete_banner(id){
        if(!confirm('삭제하시겠습니까? 복원할 수 없는 작업입니다.')) {
            return false;
        }
        $.post("${path}/deleteBannerAction.do", {
            'id': id
        }, function(result){
            if(result == "SUCCESS"){
                alert('삭제처리하였습니다.');
                location.reload(true);
            }else{
                alert(result);
            }
        });

    }

    function resetBtn(){
        location.href = 'bannerList.do';
    }
</script>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">배너 관리</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <form name="listForm" id="listForm" method="get" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <input type="hidden" name="pageIndex" id="pageIndex" value="1"/>
            <div class="input-group">
                <label for="search_position">위치</label>
                <select name="search_position" id="search_position" class="form-control bg-light border-0 small">
                    <option value="" <c:if test="${param.search_position eq ''}">selected</c:if>>전체</option>
                    <option value="매출" <c:if test="${param.search_position == '매출'}">selected</c:if>>매출</option>
                    <option value="보험" <c:if test="${param.search_position == '보험'}">selected</c:if>>보험</option>
                    <option value="렌탈" <c:if test="${param.search_position == '렌탈'}">selected</c:if>>렌탈</option>
                    <option value="설문" <c:if test="${param.search_position == '설문'}">selected</c:if>>설문</option>
                    <option value="마이페이지" <c:if test="${param.search_position == '마이페이지'}">selected</c:if>>마이페이지</option>
                </select>
                <label for="search_enabled">상태</label>
                <select name="search_enabled" id="search_enabled" class="form-control bg-light border-0 small">
                    <option value="" <c:if test="${param.search_enabled eq ''}">selected</c:if>>전체</option>
                    <option value="Y" <c:if test="${param.search_enabled == 'Y'}">selected</c:if>>Y</option>
                    <option value="N" <c:if test="${param.search_enabled == 'N'}">selected</c:if>>N</option>
                </select>
                <label for="search_name"></label>
                <input type="text" name="search_name" id="search_name" value="${param.search_name}" class="form-control bg-light border-0 small" placeholder="배너명"/>
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
        <button class="btn btn-warning" type="button" onclick="go_delete_banner_checked()">
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
                    <th>위치</th>
                    <th>배너이미지</th>
                    <th>배너명</th>
                    <th>등록일</th>
                    <th>게시 기간</th>
                    <th>클릭수</th>
                    <th>순서</th>
                    <th>상태</th>
                    <th>다운로드</th>
                    <th>관리</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${empty list}">
                        <tr>
                            <td colspan="12">등록된 내용이 없습니다.</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="item" items="${list}" varStatus="status">
                            <tr>
                                <td><input type="checkbox" value="${item.id}" class="checked"/></td>
                                <td>${paginationInfo.totalRecordCount - ((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage + status.index)}</td>
                                <td><c:out value="${item.position}"/></td>
                                <td><img src="${path}/imgview.do?id=${item.files_id}" style="width: 100px;" onerror="this.style.display='none';"/></td>
                                <td><c:out value="${item.name}"/></td>
                                <td><c:out value="${item.reg_datetime}"/></td>
                                <td><c:out value="${item.date_start}"/> ~ <c:out value="${item.date_end}"/></td>
                                <td><c:out value="${item.click_count}"/></td>
                                <td><c:out value="${item.order_by}"/></td>
                                <td><c:out value="${item.enabled}"/></td>
                                <td><a href="${path}/util/download.do?id=${item.files_id}" style="height: 100px;"/>[파일 받기]</td>
                                <td>
                                    <a href="${path}/bannerBoth.do?id=<c:out value="${item.id}"/>" class="btn btn-primary btn-icon-split btn-sm"><span class="text">수정</span></a>
                                    <a href="javascript:go_delete_banner('<c:out value="${item.id}"/>');" class="btn btn-danger btn-icon-split btn-sm"><span class="text">삭제</span></a>
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
                <a href="${path}/bannerBoth.do" class="btn btn-primary btn-icon-split btn-sm"><span class="text">신규 등록</span></a>
            </div>
        </div>
    </div>
</div>

<%@ include file="admin_footer.jsp" %>
