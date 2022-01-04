<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<%@ include file="layout.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">설문 관리</h1>


<!-- DataTales Example -->
<form name="frm" id="frm" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" id="id" value="${item.id}">
    <div class="card shadow mb-4">
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered dataTable" width="100%" cellspacing="0">
                    <tbody>
                    <tr>
                        <th scope="row" style="width: 120px;">설문 게시 여부</th>
                        <td>
                            <select name="is_show">
                                <option value="Y" <c:if test="${item.is_show == 'Y'}">selected</c:if>>Y</option>
                                <option value="N" <c:if test="${item.is_show == 'N'}">selected</c:if>>N</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">설문 제목</th>
                        <td>
                            <input type="text" name="survey_title" id="survey_title" value="${item.survey_title}" style="width: 100%;">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">소요 시간</th>
                        <td>
                            <input type="text" name="duration" id="duration" value="${item.duration}" style="width: 120px;">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">혜택</th>
                        <td>
                            <input type="text" name="benefit" id="benefit" value="${item.benefit}" style="width: 100%;">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">시작일</th>
                        <td>
                            <input type="text" name="date_start" id="date_start" value="${item.date_start}" class="datepicker" autocomplete="off">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">종료일</th>
                        <td>
                            <input type="text" name="date_end" id="date_end" value="${item.date_end}" class="datepicker" autocomplete="off">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">설문 소개글</th>
                        <td>
                            <textarea name="introduction" id="introduction" style="width: 100%;" rows="15">${item.introduction}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;">설문 질문/답변</th>
                        <td>
                            <button type="button" onclick="go_add_question();">추가</button>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row" style="width: 120px;"></th>
                        <td id="question">
                            <c:forEach var="surveyQuestionsVOS" items="${item.surveyQuestionsVOS}">
                            <table class="table table-bordered dataTable question" width="100%" cellspacing="0">
                                <tr>
                                    <th scope="row" style="width: 120px;">문항</th>
                                    <td>
                                        <input type="hidden" name="no"/>
                                        <input type="text" style="width: 95%;" name="question" value="${surveyQuestionsVOS.question}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">답변 유형</th>
                                    <td>
                                        <select name="is_multi_answer">
                                            <option value="N" <c:if test="${surveyQuestionsVOS.is_multi_answer eq 'N'}">selected</c:if>>단수 선택만 가능</option>
                                            <option value="Y" <c:if test="${surveyQuestionsVOS.is_multi_answer eq 'Y'}">selected</c:if>>복수 선택 가능</option>
                                        </select>
                                    </td>
                                </tr>

                                <tr>
                                    <th scope="row" style="width: 120px;">답변</th>
                                    <td>
                                        <button type="button" onclick="go_add_example(this)">추가</button>
                                        <c:forEach var="surveyExamplesVOList" items="${surveyQuestionsVOS.surveyExamplesVOList}">
                                        <div>
                                            <select name="type">
                                                <option value="객관식" <c:if test="${surveyExamplesVOList.type eq '객관식'}">selected</c:if>>객관식</option>
                                                <option value="주관식" <c:if test="${surveyExamplesVOList.type eq '주관식'}">selected</c:if>>주관식</option>
                                            </select>
                                            <input type="text" style="width: 90%;" name="answer_text" value="${surveyExamplesVOList.answer_text}"/>
                                            <input type="hidden" name="order_by"/>
                                        </div>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </table>
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <th>설문 결과</th>
                        <td>
                            <c:forEach var="surveyQuestionsVOS1" items="${surveyQuestionsVOS1}" varStatus="status">
                            <h4>${status.index + 1}. ${surveyQuestionsVOS1.question}</h4>
                                <c:forEach items="${surveyQuestionsVOS1.surveyAnswersVOS}" var="surveyAnswersVOS" varStatus="statusAnswer">
                                    <h5>${statusAnswer.index + 1}) ${surveyAnswersVOS.answer_text} (${surveyAnswersVOS.result_percent}%, ${surveyAnswersVOS.answer_cnt}명) <c:if test="${surveyAnswersVOS.text_answer ne ''}">: <a href="javascript:window.open('${path}/surveyPopup.do?id=${surveyQuestionsVOS1.id}','top=0,left=0,width=500,height=800');">[주관식 답변 보기]</a></c:if> </h5>
                                </c:forEach>
                            </c:forEach>


                        </td>
                    </tr>

                    </tbody>
                </table>
                <div class="btn_wrap">
                    <c:choose>
                        <c:when test="${item.id > 0}">
                            <a href="javascript:go_reg();" class="btn btn-primary btn-icon-split"><span class="text">수정</span></a>
                        </c:when>
                        <c:otherwise>
                            <a href="javascript:go_reg();" class="btn btn-primary btn-icon-split"><span class="text">등록</span></a>
                        </c:otherwise>
                    </c:choose>
                    <a href="javascript:history.back();" class="btn btn-secondary btn-icon-split"><span class="text">목록</span></a>
                </div>
            </div>
        </div>
    </div>
</form>

<script>
    function go_reg(){

        $(".question").each(function(i){
            $(this).find("[name=no]").val(i+1).attr("name", "surveyQuestionsVOS["+i+"].no");
            $(this).find("[name=question]").attr("name", "surveyQuestionsVOS["+i+"].question");
            $(this).find("[name=is_multi_answer]").attr("name", "surveyQuestionsVOS["+i+"].is_multi_answer");
            $(this).find("[name=type]").each(function(j){
                $(this).attr("name", "surveyQuestionsVOS["+i+"].surveyExamplesVOList["+j+"].type");
            });
            $(this).find("[name=answer_text]").each(function(j){
                $(this).attr("name", "surveyQuestionsVOS["+i+"].surveyExamplesVOList["+j+"].answer_text");
            });
            $(this).find("[name=order_by]").each(function(j){
                $(this).val(j+1).attr("name", "surveyQuestionsVOS["+i+"].surveyExamplesVOList["+j+"].order_by");
            })
        })

        $("#frm").submit();
    }

    function go_add_example(el){
        let html = `<div>
                                    <th scope="row" style="width: 120px;"></th>
                                    <td>
                                        <select name="type">
                                            <option value="객관식">객관식</option>
                                            <option value="주관식">주관식</option>
                                        </select>
                                        <input type="text" style="width: 90%;" name="answer_text"/>
                                        <input type="hidden" name="order_by"/>
                                        <button type="button" onclick="go_remove_example(this);">삭제</button></td>
                                </div>`;
        el.parentElement.insertAdjacentHTML('beforeend',html);
    }

    function go_remove_example(el){
        el.parentElement.remove();
    }

    function go_remove_question(el){
        el.parentElement.parentElement.parentElement.parentElement.remove();
    }

    function go_add_question(){
        let html = `<table class="table table-bordered dataTable question" width="100%" cellspacing="0">
                                <tr>
                                    <th scope="row" style="width: 120px;">문항 <button type="button" onclick="go_remove_question(this);">삭제</button></th>
                                    <td>
                                        <input type="hidden" name="no"/>
                                        <input type="text" style="width: 95%;" name="question"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">답변 유형</th>
                                    <td>
                                        <select name="is_multi_answer">
                                            <option value="N">단수 선택만 가능</option>
                                            <option value="Y">복수 선택 가능</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row" style="width: 120px;">답변</th>
                                    <td>
                                        <button type="button" onclick="go_add_example(this)">추가</button>
                                        <div>
                                            <select name="type">
                                                <option value="객관식">객관식</option>
                                                <option value="주관식">주관식</option>
                                            </select>
                                            <input type="text" style="width: 90%;" name="answer_text"/>
                                            <input type="hidden" name="order_by"/>
                                        </div>
                                    </td>
                                </tr>
                            </table>`;
        $("#question").append(html);
    }
</script>



<%@ include file="admin_footer.jsp" %>
