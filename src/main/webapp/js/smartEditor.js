var oEditors = [];
$(function(){
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: 'content_editor',
		sSkinURI: '/saadmin/se/SmartEditor2Skin.html',
		htParams : {
			bUseToolbar : true,
			bUseVerticalResizer : true,
			bUseModeChanger : true,
			SE2M_FontName: {
			},
		},
	});
})



$(function(){
	$(".text_area").children().css({"background-color":"#fff","width":"100%"})
})
