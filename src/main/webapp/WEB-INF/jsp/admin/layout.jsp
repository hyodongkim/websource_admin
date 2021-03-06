<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin</title>

    <!-- Custom fonts for this template -->
    <link href="$${path}/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${path}/admin/css/sb-admin-2.min.css" rel="stylesheet">
	<link href="${path}/admin/css/modify.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="${path}/admin/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

    <link rel="shortcut icon" href="${path}/favicon.ico">

    <!-- Bootstrap core JavaScript-->
    <script src="${path}/admin/vendor/jquery/jquery.min.js"></script>
    <script src="${path}/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${path}/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${path}/admin/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="${path}/admin/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="${path}/admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="${path}/admin/js/demo/datatables-demo.js"></script>


    <script type="text/javascript" src="${path}/web/js/common.js"></script>
    <script type="text/javascript" src="${path}/js/common.js"></script>
    <script type="text/javascript" src="${path}/js/dev.js"></script>
    <script type="text/javascript" src="${path}/js/leftmenu.js"></script>
    <script type="text/javascript" >
        $(document).ready(function(){
            subNavi._init();
            if($("#leftmenu li").length<1) $(".lm-tit button").hide();
        });
    </script>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
    <script
            src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"
            integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU="
            crossorigin="anonymous"></script>

    <script type="text/javascript">
        $.datepicker.setDefaults({
            dateFormat: 'yy-mm-dd',
            prevText: '?????? ???',
            nextText: '?????? ???',
            monthNames: ['1???', '2???', '3???', '4???', '5???', '6???', '7???', '8???', '9???', '10???', '11???', '12???'],
            monthNamesShort: ['1???', '2???', '3???', '4???', '5???', '6???', '7???', '8???', '9???', '10???', '11???', '12???'],
            dayNames: ['???', '???', '???', '???', '???', '???', '???'],
            dayNamesShort: ['???', '???', '???', '???', '???', '???', '???'],
            dayNamesMin: ['???', '???', '???', '???', '???', '???', '???'],
            showMonthAfterYear: true,
            yearSuffix: '???'
        });

        $(function() {
            $("#datepicker1, #datepicker2, #datepicker3, #datepicker4, .datepicker").datepicker();
        });
    </script>



</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <%@ include file="admin_header.jsp" %>

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <%@ include file="top_bar.jsp" %>

                <!-- Begin Page Content -->
                <div class="container-fluid">
