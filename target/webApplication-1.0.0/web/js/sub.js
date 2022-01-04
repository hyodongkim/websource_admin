$(document).ready(function(){

	var $sub01_visual_slide = $(".sub01_visual_slide");
	var $sub02_visual_slide = $(".sub02_visual_slide");
	var active = "active";
	var $tab_btn = $(".tab_btn");
	var $tab_btn02 = $(".tab_btn02");
	var $tab_con = $(".tab_con");
	var $tab_con02 = $(".tab_con02");
	var tab_wrap = ".tab_wrap";
	var tab_wrap02 = ".tab_wrap02";
	var tab_btn = ".tab_btn";
	var tab_btn02 = ".tab_btn02";
	var $sub02_con02_slide01 = $(".sub02_con02_slide01");
	var $sub02_con02_slide02 = $(".sub02_con02_slide02");
	var $sub02_con02_slide03 = $(".sub02_con02_slide03");
	var $sub02_con02_slide04 = $(".sub02_con02_slide04");
	var $sub02_con02_slide05 = $(".sub02_con02_slide05");
	var $sub02_con02_slide06 = $(".sub02_con02_slide06");
	var $travel_wrap01 = $(".travel_wrap01");
	var $travel_wrap02 = $(".travel_wrap02");
	var $travel_wrap03 = $(".travel_wrap03");

	//서브02-쇼핑 슬라이드
	/*$sub01_visual_slide.on('initialized.owl.carousel changed.owl.carousel', function(e) {
		var mv_item = $sub01_visual_slide.find(".owl-item");
		var visual_txt = ".visual_txt";
		var owl_item_active = ".owl-item.active";
		var isActive = mv_item.hasClass(active);

		if (!e.namespace)  {
	      return;
	    }
	    var carousel = e.relatedTarget;
	    $('.slider-counter').html(carousel.relative(carousel.current()) + 1 + '<span>/</span>' + '<span>'+carousel.items().length +'</span>');
	}).owlCarousel({
		margin:0,
		loop:true,
		items: 1,
		autoplay:true,
		autoplaySpeed:4000,
	});*/
	//서브02-여행 슬라이드
	/*$sub02_visual_slide.on('initialized.owl.carousel changed.owl.carousel', function(e) {
		var mv_item = $sub02_visual_slide.find(".owl-item");
		var visual_txt = ".visual_txt";
		var owl_item_active = ".owl-item.active";
		var isActive = mv_item.hasClass(active);

		if (!e.namespace)  {
	      return;
	    }
	    var carousel = e.relatedTarget;
	    $('.slider-counter').html(carousel.relative(carousel.current()) + 1 + '<span>/</span>' + '<span>'+carousel.items().length +'</span>');
	}).owlCarousel({
		margin:0,
		loop:true,
		items: 1,
		autoplay:true,
		autoplaySpeed:4000,
	});*/

	// main contents1 tab
	$tab_btn.on("mouseover",function(e){
		e.preventDefault();
		tab02($(this));
	});

	// main contents1 slides
	/*$sub02_con02_slide01.owlCarousel({
		loop: true,
		items: 5,
		nav: true,
		dots: false,
		mouseDrag: false,
		touchDrag: false,
		margin:20,
	});*/

	/*$sub02_con02_slide02.owlCarousel({
		loop: true,
		items: 5,
		nav: true,
		dots: false,
		mouseDrag: false,
		touchDrag: false,
		margin:20,
	});

	$sub02_con02_slide03.owlCarousel({
		loop: true,
		items: 5,
		nav: true,
		dots: false,
		mouseDrag: false,
		touchDrag: false,
		margin:20,
	});

	$sub02_con02_slide04.owlCarousel({
		loop: true,
		items: 5,
		nav: true,
		dots: false,
		mouseDrag: false,
		touchDrag: false,
		margin:20,
	});

	$sub02_con02_slide05.owlCarousel({
		loop: true,
		items: 5,
		nav: true,
		dots: false,
		mouseDrag: false,
		touchDrag: false,
		margin:20,
	});

	$sub02_con02_slide06.owlCarousel({
		loop: true,
		items: 5,
		nav: true,
		dots: false,
		mouseDrag: false,
		touchDrag: false,
		margin:20,
	});*/

	// sub search
	$tab_btn02.on("click",function(e){
		e.preventDefault();
		tab($(this));
	});
	// main contents1 slides
	/*$travel_wrap01.owlCarousel({
		dots: false,
		mouseDrag: false,
		touchDrag: false,
	});
	// main contents1 slides
	$travel_wrap02.owlCarousel({
		dots: false,
		mouseDrag: false,
		touchDrag: false,
	});
	// main contents1 slides
	$travel_wrap03.owlCarousel({
		dots: false,
		mouseDrag: false,
		touchDrag: false,
	});*/


	function tab($this){
		var tg = $this.attr("href");

		$tab_con02.removeClass(active);
		$(tg).addClass(active);
		$this.parents(tab_wrap02).find(tab_btn02).removeClass(active);
		$this.addClass(active);
	}

	function tab02($this){
		var tg = $this.attr("href");

		$tab_con.removeClass(active);
		$(tg).addClass(active);
		$this.parents(tab_wrap).find(tab_btn).removeClass(active);
		$this.addClass(active);
	}

	// main visual prev button
	$('.sub01_visual_prev').click(function(e) {
		e.preventDefault();
	   $sub01_visual_slide.trigger('prev.owl.carousel', [300]);
	});
	// main visual next button
	$('.sub01_visual_next').click(function(e) {
		e.preventDefault();
	   $sub01_visual_slide.trigger('next.owl.carousel');
	});

	// main visual prev button
	$('.sub02_visual_prev').click(function(e) {
		e.preventDefault();
	   $sub02_visual_slide.trigger('prev.owl.carousel', [300]);
	});
	// main visual next button
	$('.sub02_visual_next').click(function(e) {
		e.preventDefault();
	   $sub02_visual_slide.trigger('next.owl.carousel');
	});

	// sub01_파트너스 혜택
	/*$('.sub01_contents4 .owl-carousel').owlCarousel({
	    loop:true,
	    margin:27,
	    nav:true,
	    responsive:{
	        0:{
	            items:1
	        },
	        600:{
	            items:4
	        },
	        1000:{
	            items:7
	        }
	    }
	});
	// sub02_여행찬스
	$('.sub02_contents1 .owl-carousel').owlCarousel({
	    loop:true,
	    margin:20,
	    nav:true,
	    responsive:{
	        0:{
	            items:1
	        },
	        600:{
	            items:3
	        },
	        1000:{
	            items:5
	        }
	    }
	});*/
});


//탭 -여행 찬스
function openCity(evt, tabName) {
  var i, x, tablinks;
  x = document.getElementsByClassName("tabCon");
  for (i = 0; i < x.length; i++) {
	x[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < x.length; i++) {
	tablinks[i].className = tablinks[i].className.replace(" tab_active", "");
  }
  document.getElementById(tabName).style.display = "block";
  evt.currentTarget.className += " tab_active";
}

//탭 - 국내여행
function openCity02(evt, tabName) {
  var i, x, tablinks;
  x = document.getElementsByClassName("tabCon02");
  for (i = 0; i < x.length; i++) {
	x[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink02");
  for (i = 0; i < x.length; i++) {
	tablinks[i].className = tablinks[i].className.replace(" tab_active02", "");
  }
  document.getElementById(tabName).style.display = "block";
  evt.currentTarget.className += " tab_active02";
}



$(document).ready(function(){
	$('ul.tab_area03 li').click(function(){
		var tab_id = $(this).attr('data-tab');

		$('ul.tab_area03 li').removeClass('tab_active03');
		$('.tab-content').removeClass('tab_active03');

		$(this).addClass('tab_active03');
		$("#"+tab_id).addClass('tab_active03');
	})
})


$(document).ready(function(){
	$('ul.tab_area03 li').click(function(){
		var tab_id = $(this).attr('data-tab');

		$('ul.tab_area03 li').removeClass('tab_active03');
		$('.tab-content').removeClass('tab_active03');

		$(this).addClass('tab_active03');
		$("#"+tab_id).addClass('tab_active03');
	})
})

// FAQ
$(function(){
	$(".customer_faq dl dt").click(function(){
		$(".customer_faq dl dt").parent().removeClass();
		$(this).parent().addClass('selected');
	})
});

$(function() {
	$('#sub02_05 .tab-wrap ul li').click(function() {
		var activeTab = $(this).attr('data-tab');
		$('#sub02_05 .tab-wrap ul li').removeClass('selected');
		$('.tabcontent').removeClass('selected');
		$(this).addClass('selected');
		$('#' + activeTab).addClass('selected');
	})
});



