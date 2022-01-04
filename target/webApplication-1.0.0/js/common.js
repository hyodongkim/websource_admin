/**
$(document).on("change", ":file", function(){
	const ext = "hwp, ppt, pptx, xls, xlsx, doc, docx, pdf, jpg, jpeg, gif, png, zip";
	const file = this.files[0];

	if($(".file_area1 p").data("seq") > 0) {
		$("#registForm").append("<input type='hidden' name='deleteFileSeq' value='"+$(".file_area1 p").data("seq")+"'>")
	}

	var bool = fileSizeCheck(file.size, 20) && fileExtCheck(file.name, ext);
	if(bool){
		var html = '<p><span>'+ file.name +'</span><button type="button" class="deleteFile">삭제</button></p>';
		$(".file_area1").html(html)
	}
})

$(document).on("click", ".deleteFile", function(){
	var fileSeq = $(".file_area1 p").data("seq")
	if(fileSeq > 0){
		$("#registForm").append("<input type='hidden' name='deleteFileSeq' value='"+fileSeq+"'>")
		$(".file_area1 p").data("seq", 0)
	}
	$(":file").val("")
	$(".file_area1 p").remove()
})
 */
//페이징 이동
function fn_egov_link_page(pageNo){
	document.listForm.pageIndex.value = pageNo;
	//document.listForm.action = "<c:url value='/egovSampleList.do'/>";
   	document.listForm.submit();
}

//공백 체크
function checkInputText(item, text) {
	var test = item.val()
	if( test.replace(/\s/g,"") == "" ){
		alert(text+" 입력해주세요.");
		item.focus();
		return false;
	}
	return true;
}

//네이버스마트에디터 공백 체크
function checkInputTextarea(item, text) {
	var test = item.val()
	if( test.replace(/\s/g,"") == "" || test.replace(/\s/g,"") == "<br>"){
		alert(text+" 입력해주세요.");
		item.focus();
		return false;
	}
	return true;
}

//공백 체크 select
function checkInputSelect(item, text) {
	if( item.val() == "" || item.val() == 0){
		alert(text+" 선택해주세요.");
		item.focus();
		return false;
	}
	return true;
}

//number 체크
function checkNumber(item, text){
	if( $.isNumeric( item.val() ) ){
		return true;
	}else{
		alert("숫자를 입력해주세요.");
		item.focus();
		return false;
	}
	return true;
}

function checkValid(value, text) {
	if (!value) {
		alert(text);
		return false;
	}
	return true;
}

//데이트피커 유효성
function datepickerChk(startId, endId){
	var start = $("#"+startId);
	var end = $("#"+endId);

	if(start.val() != "" && end.val() != "" && start.val() > end.val()) {
		alert("기간을 확인 해주세요.");
		start.val("");
		end.val("");
		return false;
	}
	return true;
}

//file 객체에서 바이너리 읽어와 view
function imgPreview(input, selector) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function (e) { selector.attr('style', 'background-size: cover; background-image:url(' + e.target.result+ ');'); }
		reader.readAsDataURL(input.files[0]);
	}
}

//float 체크
function floatCheck(obj){
	 var num_check=/^([0-9]*)[\.]?([0-9])?$/;
		if(!num_check.test(obj)){
		return false;
	}
	return true;
}

//ajax call
function ajaxCall(url, data, callBack, errorMsg){
	$.ajax({
		type : "POST",
		url : url,
		data : data,
		success : function(obj){
		callBack(obj);
		},error : function() {
			console.log(errorMsg+"에러가 발생되었습니다");
		}
	});
}

//ajax call json
function ajaxCallJson(url, data, callBack, errorMsg){
	$.ajax({
		type : "POST",
		url : url,
		data : data,
		dataType : "json",
		success : function(obj){
		callBack(obj);
		},error : function() {
			console.log(errorMsg+"에러가 발생되었습니다");
		}
	});
}

//날짜포맷
function getFormatDate(date){
	var year = date.getFullYear();                                 //yyyy
	var month = (1 + date.getMonth());                     //M
	month = month >= 10 ? month : '0' + month;     // month 두자리로 저장
	var day = date.getDate();                                        //d
	day = day >= 10 ? day : '0' + day;                            //day 두자리로 저장
	return  year + '-' + month + '-' + day;
}

function changeDate(obj,month){

	var d = new Date()
	$("#datepicker2").val( getFormatDate(d) );


    var monthOfYear = d.getMonth()
    d.setMonth(monthOfYear - month)
	$("#datepicker1").val( getFormatDate(d) );

    $(".month").removeClass("on")
    $(obj).addClass("on")

}

function changeDateWeek(obj,month){

	var d = new Date()
	$("#datepicker2").val( getFormatDate(d) );

	var dayOfMonth = d.getDate()
	d.setDate(dayOfMonth - 7)
	$("#datepicker1").val( getFormatDate(d) );

    $(".month").removeClass("on")
    $(obj).addClass("on")

}


//textarea 값 엔터처리
function textareaSave(val){
	val = val.replace(/(?:\r\n|\r|\n)/g, '<br/>');
	return val
}

function textareaLoad(val){
	val = val.split('<br/>').join("\r\n");
	return val;
}

//3자리마다 숫자 콤마
function AddComma(num)
{
	var regexp = /\B(?=(\d{3})+(?!\d))/g;
	return num.toString().replace(regexp, ',');
}

// 전체선택
function checkAll(){
	if ( $("#chkAll").is(":checked") ) {
   		$("input[type=checkbox]").not(":disabled").prop("checked",true);
	}else {
   		$("input[type=checkbox]").prop("checked",false);
	}
}
$(function(){
	$(document).on("focus", "button", function(){
		if($(this).text() == "검색"){
			$("#pageIndex").val(1);
		}
	})

	$(":checkbox:not(#chkAll)").change(function(){
		var chk = $(":checkbox:not(#chkAll)");
		var chkAll = $('#chkAll');

	    if(chk.length != chk.filter(":checked").length){
	    	chkAll.prop('checked', false);
	    } else {
	    	chkAll.prop('checked', true);
	    }
	});
});

function paramSetting(form, param){
	var querystring = param.replace("{", "").replace("}", "").split(", ");

    for (var i = querystring.length - 1; i >= 0; i--) {
    	var map = querystring[i].split('=');
    	if(map[1] != null && map[1] != "null" && map[1] != ""){
    		var input = document.createElement("input");
    		input.setAttribute("type", "hidden");
    		input.setAttribute("name", map[0]);
    		input.setAttribute("value", map[1]);

    		form.appendChild(input);
    	}
    }

    return form;
}

//파일 확장자 체크
function fileExtCheck(name, ext){
	var extchk = ext.split(", ");
	var ext = name.split('.').pop();
	if(extchk.indexOf(ext.toLowerCase()) < 0){
		alert(ext+"형식의 파일만 등록할 수 있습니다.");
		return false;
	} else {
		return true;
	}
}

//파일 사이즈 체크
function fileSizeCheck(size, mb) {
	var maxSize = Number(mb) * 1024 * 1024;
	if(size > maxSize){
		alert("파일 용량이"+maxSize+"mb가 초과되었습니다. 다시 확인해주십시오.");
		return false;
	} else {
		return true;
	}
}

//날짜 자동입력
function insertDate(term) {
	var date = new Date();
	var month = String(date.getMonth()+1);
	var day = String(date.getDate())

	if(month.length == 1){
	  month = "0" + month;
	}
	if(day.length == 1){
	  day = "0" + day;
	}

	var startDate = ""
	var endDate = date.getFullYear() + "-" + month + "-" + day

	switch (term) {
		case "oneWeek":
			day = String(date.getDate()-7)

			if(day.length == 1) {
				  day = "0" + day;
				}

			startDate = date.getFullYear() + "-" + month + "-" + day
		break;

		case "oneMonth":
			month = String(date.getMonth())

			if(month.length == 1){
				  month = "0" + month;
				}

			startDate = date.getFullYear() + "-" + month + "-" + day
		break;

		case "threeMonth":
			month = String(date.getMonth()-2)

			if(month.length == 1){
				  month = "0" + month;
				}

			startDate = date.getFullYear() + "-" + month + "-" + day
		break;
	}

	$(":text[name=startDate]").val(startDate)
	$(":text[name=endDate]").val(endDate)
}
