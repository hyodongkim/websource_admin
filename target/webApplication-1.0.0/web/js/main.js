$(document).ready(function(){

	var $main_visual_slide = $(".main_visual_slide");
	var active = "active";
	var $tab_btn = $(".tab_btn");
	var $tab_con = $(".tab_con");
	var tab_wrap = ".tab_wrap";
	var tab_btn = ".tab_btn";
	var $mc1_slide01 = $(".mc1_slide01");
	var $mc1_slide02 = $(".mc1_slide02");
	var $mc1_slide03 = $(".mc1_slide03");
	var $mc1_slide04 = $(".mc1_slide04");
	var $mc1_slide05 = $(".mc1_slide05");
	var $mc1_slide06 = $(".mc1_slide06");
	var $mc1_slide07 = $(".mc1_slide07");
	var $mc1_slide08 = $(".mc1_slide08");
	var $mc1_slide09 = $(".mc1_slide09");
	var $mc1_slide10 = $(".mc1_slide10");
	var $mc3_slide01 = $('.mc3_slide01');
	var $mc3_slide02 = $('.mc3_slide02');
	var $mc3_slide03 = $('.mc3_slide03');
	var $mc3_slide04 = $('.mc3_slide04');
	var $mc3_slide05 = $('.mc3_slide05');
	var $mc3_slide06 = $('.mc3_slide06');
	var $mc3_slide07 = $('.mc3_slide07');
	var $mc3_slide08 = $('.mc3_slide08');
	var $mc3_slide09 = $('.mc3_slide09');
	var $mc3_slide10 = $('.mc3_slide10');
	var $main_banner01 = $(".main_banner01");
	var $main_banner02 = $(".main_banner02");

	$main_visual_slide.on('initialized.owl.carousel changed.owl.carousel', function(e) {
		var mv_item = $main_visual_slide.find(".owl-item");
		var visual_txt = ".visual_txt";
		var owl_item_active = ".owl-item.active";
		var isActive = mv_item.hasClass(active);
		var txt_s1 = ".s1";
		var txt_s2 = ".s2";
		var txt_a = "a";

		if(isActive){
			$main_visual_slide.find(visual_txt).children(txt_s1).removeClass(active);
			$main_visual_slide.find(visual_txt).children(txt_s2).removeClass(active);
			$main_visual_slide.find(visual_txt).children(txt_a).removeClass(active);
			setTimeout(function(){
				$main_visual_slide.find(owl_item_active).find(visual_txt).children(txt_s1).addClass(active);
			}, 500);

			setTimeout(function(){
				$main_visual_slide.find(owl_item_active).find(visual_txt).children(txt_s2).addClass(active);
			}, 1000);
			setTimeout(function(){
				$main_visual_slide.find(owl_item_active).find(visual_txt).children(txt_a).addClass(active);
			}, 1500);
		}else{

		}
	}).owlCarousel({
		loop: true,
		items: 1,
		nav: false,
		dots: true,
		autoplay:true,
		autoplaySpeed:5000,
		animateIn: 'fadeIn',
		animateOut: 'fadeOut',
		mouseDrag: false,
		touchDrag: false,
		dotsContainer: '.main_visual_dots'
	});

	// main visual prev button
	$('.main_visual_prev').click(function(e) {
		e.preventDefault();
	   $main_visual_slide.trigger('prev.owl.carousel', [300]);
	});
	// main visual next button
	$('.main_visual_next').click(function(e) {
		e.preventDefault();
	   $main_visual_slide.trigger('next.owl.carousel');
	});
	// main visual play button
	$('.main_visual_play').on('click',function(e){
		e.preventDefault();
		$(this).hide();
		$(".main_visual_stop").show();
		$main_visual_slide.trigger('play.owl.autoplay',[1000]);
	});
	//main visual stop button
	$('.main_visual_stop').on('click',function(e){
		e.preventDefault();
		$(this).hide();
		$(".main_visual_play").show();
		$main_visual_slide.trigger('stop.owl.autoplay');
	});
	/*add start 190611*/
	$(".owl-item").each(function(){
		$(this).children("div").css({"background-image":"url('"+ $(this).children("div").children("img").attr('src') +"')"});
	});
	/*add end 190611*/

	// end

	// main contents1 tab
	$tab_btn.on("click",function(e){
		e.preventDefault();
		tab($(this));
	});

	// main contents1 slides
	$mc1_slide01.owlCarousel({
		loop: true,
		items: 5,
		nav: true,
		dots: false,
		mouseDrag: false,
		touchDrag: false,
	});

	$mc1_slide02.owlCarousel({
		loop: true,
		items: 5,
		nav: true,
		dots: false,
		mouseDrag: false,
		touchDrag: false,
	});

	$mc1_slide03.owlCarousel({
		loop: true,
		items: 5,
		nav: true,
		dots: false,
		mouseDrag: false,
		touchDrag: false,
	});

	$mc1_slide04.owlCarousel({
		loop: true,
		items: 5,
		nav: true,
		dots: false,
		mouseDrag: false,
		touchDrag: false,
	});

	$mc1_slide05.owlCarousel({
		loop: true,
		items: 5,
		nav: true,
		dots: false,
		mouseDrag: false,
		touchDrag: false,
	});

	$mc1_slide06.owlCarousel({
		loop: true,
		items: 5,
		nav: true,
		dots: false,
		mouseDrag: false,
		touchDrag: false,
	});

	$mc1_slide07.owlCarousel({
		loop: true,
		items: 5,
		nav: true,
		dots: false,
		mouseDrag: false,
		touchDrag: false,
	});

	$mc1_slide08.owlCarousel({
		loop: true,
		items: 5,
		nav: true,
		dots: false,
		mouseDrag: false,
		touchDrag: false,
	});

	$mc1_slide09.owlCarousel({
		loop: true,
		items: 5,
		nav: true,
		dots: false,
		mouseDrag: false,
		touchDrag: false,
	});

	$mc1_slide10.owlCarousel({
		loop: true,
		items: 5,
		nav: true,
		dots: false,
		mouseDrag: false,
		touchDrag: false,
	});
	//end

	// main contents3 slides
	$mc3_slide01.on('initialized.owl.carousel changed.owl.carousel', function(e) {
		if (!e.namespace)  {
			return;
		}
		var carousel = e.relatedTarget;
		$('.owl-counter1').html( "<b>" + (carousel.relative(carousel.current()) + 1 ) + '</b>/' + carousel.items().length);
	}).owlCarousel({
		items: 1,
		loop:true,
		nav:true,
		dots: false,
		autoplay: true,
		mouseDrag: false,
		touchDrag: false,
	});

	$mc3_slide02.on('initialized.owl.carousel changed.owl.carousel', function(e) {
		if (!e.namespace)  {
			return;
		}
		var carousel = e.relatedTarget;
		$('.owl-counter2').html( "<b>" + (carousel.relative(carousel.current()) + 1 ) + '</b>/' + carousel.items().length);
	}).owlCarousel({
		items: 1,
		loop:true,
		nav:true,
		dots: false,
		autoplay: true,
		mouseDrag: false,
		touchDrag: false,
	});

	$mc3_slide03.on('initialized.owl.carousel changed.owl.carousel', function(e) {
		if (!e.namespace)  {
			return;
		}
		var carousel = e.relatedTarget;
		$('.owl-counter3').html( "<b>" + (carousel.relative(carousel.current()) + 1 ) + '</b>/' + carousel.items().length);
	}).owlCarousel({
		items: 1,
		loop:true,
		nav:true,
		dots: false,
		autoplay: true,
		mouseDrag: false,
		touchDrag: false,
	});

	$mc3_slide04.owlCarousel({
		loop: true,
		items: 1,
		nav: false,
		dots: true,
		autoplay: true,
		mouseDrag: false,
		touchDrag: false,
	});

	$mc3_slide05.owlCarousel({
		loop: true,
		items: 1,
		nav: false,
		dots: true,
		autoplay: true,
		mouseDrag: false,
		touchDrag: false,
	});

	$mc3_slide06.owlCarousel({
		loop: true,
		items: 1,
		nav: false,
		dots: true,
		autoplay: true,
		mouseDrag: false,
		touchDrag: false,
	});

	$mc3_slide07.owlCarousel({
		loop: true,
		items: 1,
		nav: false,
		dots: true,
		autoplay: true,
		mouseDrag: false,
		touchDrag: false,
	});

	$mc3_slide08.owlCarousel({
		loop: true,
		items: 1,
		nav: false,
		dots: true,
		autoplay: true,
		mouseDrag: false,
		touchDrag: false,
	});

	$mc3_slide09.owlCarousel({
		loop: true,
		items: 1,
		nav: false,
		dots: true,
		autoplay: true,
		mouseDrag: false,
		touchDrag: false,
	});

	$mc3_slide10.owlCarousel({
		loop: true,
		items: 1,
		nav: false,
		dots: true,
		autoplay: true,
		mouseDrag: false,
		touchDrag: false,
	});
	//end

	$main_banner01.owlCarousel({
		loop: true,
		items: 1,
		nav: false,
		dots: true,
		autoplay: true
	});

	$main_banner02.owlCarousel({
		loop: true,
		items: 1,
		nav: false,
		dots: true,
		autoplay: true
	});

	function tab($this){
		var tg = $this.attr("href");

		$tab_con.removeClass(active);
		$(tg).addClass(active);
		$this.parents(tab_wrap).find(tab_btn).removeClass(active);
		$this.addClass(active);
	}

	function owlCounter1(event) {
	   var element   = event.target;    // DOM element, in this example .owl-carousel
	   var items     = event.item.count;    // Number of items
	   var item      = event.item.index + 1;    // Position of the current item

	   // it loop is true then reset counter from 1
	   if(item > items) {
	   	item = item - items
	   }
	   $('.owl-counter1').html("<b>"+item+"</b>/ "+items);
	}
	function owlCounter2(event) {
	   var element   = event.target;    // DOM element, in this example .owl-carousel
	   var items     = event.item.count;    // Number of items
	   var item      = event.item.index + 1;    // Position of the current item

	   // it loop is true then reset counter from 1
	   if(item > items) {
	   	item = item - items
	   }
	   $('.owl-counter2').html("<b>"+item+"</b>/ "+items);
	}
	function owlCounter3(event) {
	   var element   = event.target;    // DOM element, in this example .owl-carousel
	   var items     = event.item.count;    // Number of items
	   var item      = event.item.index + 1;    // Position of the current item

	   // it loop is true then reset counter from 1
	   if(item > items) {
	   	item = item - items
	   }
	   $('.owl-counter3').html("<b>"+item+"</b>/ "+items);
	}

});
