
/*
등록시에만, 라디오버튼에서 첫번째 버튼을 'checked'로 바꿔쭘....
 */
$(function(){
    $("input[type=radio]").each(function(a){
        if($("#id").val() == "0") {
            let this_name = $(this).attr("name");

            $("input[name=" + this_name).each(function (b) {
                if (b == 0) {
                    $(this).prop("checked", true);
                }
            })
        }
    });
})