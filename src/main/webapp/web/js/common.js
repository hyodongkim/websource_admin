$(document).ready(function(){
	var $menuAllWrap = $(".manu_all_wrap");
	var $menuAllOpen = $(".menu_all_open");
	var $menuAllClose = $(".menu_all_close");

	var $quickMenu = $(".quick_menu");


	// menu all open / close
	$menuAllOpen.on("click",function(e){
		e.preventDefault();
		if($menuAllWrap.is(":visible") == true){
			$menuAllWrap.hide();
		}else{
			$menuAllWrap.show();
		}
		$("#header").prepend("<div class='mask'></div>");
	});
	$menuAllClose.on("click",function(e){
		e.preventDefault();
		$menuAllWrap.hide();
		$(".mask").remove();
	});
	$(document).on("click", ".mask", function(e){
		e.preventDefault();
		$menuAllWrap.hide();
		$(".mask").remove();
	});
	// end


	if(1300 > ($(window).width())){
		$quickMenu.hide();
	}else{
		$quickMenu.show();
	}
	$(window).resize(function() {
		if(1300 > ($(window).width())){
			$quickMenu.hide();
		}else{
			$quickMenu.show();
		}
	});

	// top btn

	// end

});




// select js
// This really isn't a great way to do this sort of thing any more!
// For some reason this pen is quite popular, but I'd look elsewhere!

$(document).ready(function(){

	// set up radio boxes
	$('.radioholder').each(function(){
		$(this).children().hide();
		var description = $(this).children('label').html();
		$(this).append('<span class="desc">'+description+'</span>');
		$(this).prepend('<span class="tick"></span>');
		// on click, update radio boxes accordingly
		$(this).click(function(){
			$(this).children('input').prop('checked', true);
			$(this).children('input').trigger('change');
		});
	});
	// update radio holder classes when a radio element changes
	$('input[type=radio]').change(function(){
		$('input[type=radio]').each(function(){
			if($(this).prop('checked') == true) {
				$(this).parent().addClass('activeradioholder');
			}
			else $(this).parent().removeClass('activeradioholder');
		});
	});
	// manually fire radio box change event on page load
	$('input[type=radio]').change();

	// set up select boxes
	$('.selectholder').each(function(){
		$(this).children().hide();
		var description = $(this).children('label').text();
		$(this).append('<span class="desc">'+description+'</span>');
		$(this).append('<span class="pulldown"></span>');
		// set up dropdown element
		$(this).append('<div class="selectdropdown"></div>');
		$(this).children('select').children('option').each(function(){
			if($(this).attr('value') != '0') {
				$drop = $(this).parent().siblings('.selectdropdown');
				var name = $(this).attr('value');
				$drop.append('<span>'+name+'</span>');
			}
		});
		// on click, show dropdown
		$(this).click(function(){
			if($(this).hasClass('activeselectholder')) {
				// roll up roll up
				$(this).children('.selectdropdown').slideUp(200);
				$(this).removeClass('activeselectholder');
				// change span back to selected option text
				if($(this).children('select').val() != '0') {
					$(this).children('.desc').fadeOut(100, function(){
						$(this).text($(this).siblings("select").val());
						$(this).fadeIn(100);
					});
				}
			}
			else {
				// if there are any other open dropdowns, close 'em
				$('.activeselectholder').each(function(){
					$(this).children('.selectdropdown').slideUp(200);
					// change span back to selected option text
					if($(this).children('select').val() != '0') {
						$(this).children('.desc').fadeOut(100, function(){
							$(this).text($(this).siblings("select").val());
							$(this).fadeIn(100);
						});
					}
					$(this).removeClass('activeselectholder');
				});
				// roll down
				$(this).children('.selectdropdown').slideDown(200);
				$(this).addClass('activeselectholder');
				// change span to show select box title while open
				if($(this).children('select').val() != '0') {
					$(this).children('.desc').fadeOut(100, function(){
						$(this).text($(this).siblings("select").children("option[value=0]").text());
						$(this).fadeIn(100);
					});
				}
			}
		});
	});
	// select dropdown click action
	$('.selectholder .selectdropdown span').click(function(){
		$(this).siblings().removeClass('active');
		$(this).addClass('active');
		var value = $(this).text();
		$(this).parent().siblings('select').val(value);
		$(this).parent().siblings('.desc').fadeOut(100, function(){
			$(this).text(value);
			$(this).fadeIn(100);
		});
	});

});

/* hambuger */
/*
$(document).ready(function(){
	ham.addEventListener("click", function () {
		ham.classList.toggle("clicked");
		menu_wrapper.classList.toggle("clicked");
	});
});

 */

/*accordion */
$(document).ready(function(){
	$(function() {
		var Accordion = function(el, multiple) {
			this.el = el || {};
			this.multiple = multiple || false;

			// Variables privadas
			var links = this.el.find('.link');
			// Evento
			links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
		}

		Accordion.prototype.dropdown = function(e) {
			var $el = e.data.el;
			$this = $(this),
				$next = $this.next();

			$next.slideToggle();
			$this.parent().toggleClass('open');

			if (!e.data.multiple) {
				$el.find('.submenu').not($next).slideUp().parent().removeClass('open');
			}
		}

		var accordion = new Accordion($('#accordion'), false);
	});
});

// header scroll fixed
$(document).ready( function() {

	if(location.href.indexOf("blogView.do")>0){
		$("#header").addClass("fixed");
		$("#btn_top").addClass("active");

	}



	var headerHeight = $("#header").outerHeight();
	$(window).scroll( function() {
		if($(document).scrollTop() > headerHeight){
			$("#header").addClass("fixed");
			$("#btn_top").addClass("active");
		}
		else {
			if(location.href.indexOf("blogView.do")===-1) {
				$("#header").removeClass("fixed");
				$("#btn_top").removeClass("active");
			}
		}


	});

	$(function() {
		$("#btn_top").on("click", function() {
			$("html, body").animate({scrollTop:0}, '500');
			return false;
		});
});
});

$(document).ready( function() {
	if(location.href.indexOf("blogView.do")>0){
		$("#mobile_header").addClass("fixed");
	}
	var headerHeight = $("#mobile_header").outerHeight();
	$(window).scroll( function() {
		if($(document).scrollTop() > headerHeight){
			$("#mobile_header").addClass("fixed");
			if($("#menu_wrapper").hasClass("clicked")) {
				$("#mobile_header").css("backdrop-filter", "none");
			}else{
				$("#mobile_header").css("backdrop-filter", "blur(10px)");
			}
		}
		else {
			if(location.href.indexOf("blogView.do")===-1) {
				$("#mobile_header").removeClass("fixed");
			}
			$("#mobile_header").css("backdrop-filter", "none");
		}
	});

	$("#ham").click(function(){
		if($("#mobile_header").hasClass("fixed")){
			if($("#menu_wrapper").hasClass("clicked")) {
				$("#mobile_header").css("backdrop-filter", "none");
			}
		}
	})
});

function go_lang(val){
	top.location.href = "?lang="+val;
}

function getCookie(cname) {
	let name = cname + "=";
	let decodedCookie = decodeURIComponent(document.cookie);
	let ca = decodedCookie.split(';');
	for(let i = 0; i <ca.length; i++) {
		let c = ca[i];
		while (c.charAt(0) == ' ') {
			c = c.substring(1);
		}
		if (c.indexOf(name) == 0) {
			return c.substring(name.length, c.length);
		}
	}
	return "";
}

/*$(function(){
	if(getCookie("clientlanguage")=="en"){
		$("#lang").html("ENG");
	}else{
		$("#lang").html("KOR");
	}
})*/

//페이징 이동
function fn_egov_link_page(pageNo){
	document.listForm.pageIndex.value = pageNo;
	//document.listForm.action = "<c:url value='/egovSampleList.do'/>";
	document.listForm.submit();
}