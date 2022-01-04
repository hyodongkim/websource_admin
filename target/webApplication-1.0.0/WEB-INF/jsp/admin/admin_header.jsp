<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>

<style>
    .depth3 {
        display: none;
    }

    .lm_a2, .lm_a2:hover {
        color: #fff;
    }

    .leftmenu ul .lm_l2 {
        position: relative;
        vertical-align: top;
    }

    .leftmenu ul .is-open .lm_a2 {
        background: #4e73df;
        color: #fff;
        font-weight: 600;
    }

    .is-open .lm_a2 .isMask {
        background-position: center 25px;
    }

    .is-open .lm_a2 span.isTxt {
        color: #fff;
    }

    .leftmenu ul.depth3 {
        display: none;
        height: 100%;
        background: #4e73df;
        padding: 15px;
        font-size: 13px;
        border-bottom: 0px solid #ddd;
    }

    .leftmenu ul .lm_a2 {
        transition: background .3s;
        border-bottom: 1px solid rgba(0,0,0,0.1);
        letter-spacing: -0.03em;
        display: block;
        z-index: 1;
        font-weight: 500;
        font-size: 13px;
        background-repeat: repeat;
        padding: 14px 14px 14px 18px;
    }

    li {
        list-style: none;
    }

</style>

<!-- Sidebar -->
    <div  class="leftmenu" id="leftmenu">
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion depth2">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
                <div class="sidebar-brand-text mx-3">
					<img src="${path}/admin/img/brand_logo.svg" alt="" />
				</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">
           <!-- Nav Item - Charts -->
            <li class="lm_l2">
                <a href="" class="lm_a2"><span class="isMask"></span><span class="isTxt">앱관리</span></a>
                <ul class="depth3">
                    <li class="nav-item lm_l3">
                        <a class="nav-link" href="${path}/versionList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>버전 관리</span></a>
                    </li>

                    <li class="nav-item lm_l3">
                        <a class="nav-link" href="${path}/bannerList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>배너 관리</span></a>
                    </li>

                    <li class="nav-item lm_l3">
                        <a class="nav-link" href="${path}/popupList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>팝업 관리</span></a>
                    </li>

                    <%--<li class="nav-item">
                        <a class="nav-link" href="${path}/pushList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>푸시 관리</span></a>
                    </li>--%>

                    <li class="nav-item lm_l3">
                        <a class="nav-link" href="${path}/policyList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>약관 관리</span></a>
                    </li>

                    <%--<li class="nav-item">
                        <a class="nav-link" href="${path}/privilegesList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>권한 관리</span></a>
                    </li>--%>

                    <%--<li class="nav-item lm_l3">
                        <a class="nav-link" href="${path}/configurationBoth.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>환경 설정</span></a>
                    </li>--%>
                </ul>
            </li>

            <li class="lm_l2">
                <a href="" class="lm_a2"><span class="isMask"></span><span class="isTxt">회원 관리</span></a>
                <ul class="depth3">

                    <li class="nav-item">
                        <a class="nav-link" href="${path}/memberList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>회원 조회</span></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="${path}/leaveList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>탈퇴 회원 조회</span></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="${path}/adminmemberList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>관리자 회원 조회</span></a>
                    </li>
                </ul>
            </li>

            <li class="lm_l2">
                <a href="" class="lm_a2"><span class="isMask"></span><span class="isTxt">판매처 관리</span></a>
                <ul class="depth3">

                    <li class="nav-item">
                        <a class="nav-link" href="${path}/sellerList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>판매처 관리</span></a>
                    </li>
                </ul>
            </li>

            <%--<li class="lm_l2">
                <a href="" class="lm_a2"><span class="isMask"></span><span class="isTxt">렌탈 관리</span></a>
                <ul class="depth3">

                    <li class="nav-item">
                        <a class="nav-link" href="${path}/rental_categoryList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>렌탈 카테고리 관리</span></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="${path}/rental_productList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>렌탈 상품 관리</span></a>
                    </li>
                </ul>
            </li>--%>

            <li class="lm_l2">
                <a href="" class="lm_a2"><span class="isMask"></span><span class="isTxt">보험 관리</span></a>
                <ul class="depth3">

                    <li class="nav-item">
                        <a class="nav-link" href="${path}/insurance_categoryList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>보험 카테고리 관리</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${path}/insurance_productList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>보험 상품 관리</span></a>
                    </li>
                </ul>
            </li>

            <li class="lm_l2">
                <a href="" class="lm_a2"><span class="isMask"></span><span class="isTxt">게시판 관리</span></a>
                <ul class="depth3">

                        <li class="nav-item">
                        <a class="nav-link" href="${path}/notificationList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>알림사항 관리</span></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="${path}/surveyList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>설문 관리</span></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="${path}/customercenterBoth.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>고객센터 관리</span></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="${path}/faqList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>FAQ 관리</span></a>
                    </li>
                </ul>
            </li>

            <li class="lm_l2">
                <a href="" class="lm_a2"><span class="isMask"></span><span class="isTxt">통계 관리</span></a>
                <ul class="depth3">

                    <li class="nav-item">
                        <a class="nav-link" href=#"${path}/app_statsList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>앱 이용 통계</span></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href=#"${path}/member_statsList.do">
                            <i class="fas fa-fw fa-chart-area"></i>
                            <span>회원 통계</span></a>
                    </li>
                </ul>
            </li>

            <%--

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="tables.html">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Tables</span></a>
            </li>--%>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>


        </ul>
    </div>
        <!-- End of Sidebar -->
