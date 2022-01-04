<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout_login.jsp" %>

<script>
    function login(){
        let params = new FormData($("#frm")[0]);
        //params.append("reg_file_company", $("#reg_file_company")[0].files[0]);
        $.ajax({
            type: 'POST',
            url: "${path}/loginAction.do",
            data: params,
            contentType: false,
            processData: false,
            success: function(result){
                if(result == "SUCCESS"){
                    alert('관리자님, 로그인에 성공하였습니다.');
                    top.location.href = "versionList.do";
                }else{
                    alert(result);
                }
            }
        });
    }
</script>
    
    <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-3 col-lg-6 col-md-5">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Login</h1>
                                    </div>
                                    <form id="frm" class="user">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                name="adminid" id="adminid" aria-describedby="emailHelp"
                                                placeholder="Enter ID...">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                name="passwd" id="passwd" placeholder="Password">
                                        </div>
                                        <%--<div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">Remember
                                                    Me</label>
                                            </div>
                                        </div>--%>
                                        <a href="javascript:login();" class="btn btn-primary btn-user btn-block">
                                            Login
                                        </a>
                                        
                                    </form>
                                    <hr>
                                    <%--<div class="text-center">
                                        <a class="small" href="forgot-password.html">Forgot Password?</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="register.html">Create an Account!</a>
                                    </div>--%>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    
    <%@ include file="admin_footer.jsp" %>