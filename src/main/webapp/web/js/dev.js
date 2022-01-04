$(function() {
    /*
    $("#frm").validate();

    $("#phone").keyup(function(){
        return phonenumber();
    });
    $("#email").blur(function(){
        return valid_email();
    })

     */
});



function validateEmail(email)
{
    var re = /\S+@\S+\.\S+/;
    return re.test(email);
}

function validateKorEng(val)
{
    var re = /[0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g;
    return !re.test(val);
}

