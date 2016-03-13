// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery.min
//= require bootstrap.min
//= require classie
//= require cbpAnimatedHeader
//= require jquery.validate.min
//= require freelancer
//= require_self


//$.validator.setDefaults({
//    submitHandler:
//
//        function() {
//        //alert("submitted!");
//    }
//});


function popoverMessages(element,msg,side){
    $(element).attr({'data-toggle':'popover'})
    $(element).attr({'data-placement':side})
    $(element).attr({'data-content':msg})
    $(element).popover('show')}






$().ready(function() {
    // validate the comment form when it is submitted
    $('#linkForm').validate({
        rules:{
            url:{
                required:true,
                url:true
            },
            description:{
                required:true,
                minlength:100
            }
        },
        messages:{
            url :"please enter valid url",
            description:"Please give description in at least 100 words"

        }
    })



    $('#documentForm').validate({
        rules:{
            file : "required",
            description :{
                required:true,
                minlength:100
            }

        },
        messages:{
            file :"please upload document",
            description:"Please give description in at least 100 words"

        }
    });


    $("#topicForm").validate({
        rules :{
            name :{
                required:true,
                minlenth:2
            },
            description:{
                required:true,
                minlength:10
            }

        },
        messages:{
            name :"Please enter Valid Name",
            description:"Please provide description in minimum 10 words"
        }
    });


    $("#loginForm").validate({
        rules :{
            userName: {
                required: true,
                minlength: 2
            },
            password: {
                required: true,
                minlength: 5
            }
        },
        messages:{
            userName: {
                required:function(){popoverMessages('#loginForm #userName','Please insert username...','left')},
                minlength:function(){popoverMessages('#loginForm #userName','invalid username','left')}
            },
            password: {
                required: function(){popoverMessages('#loginForm #password','Please provide a password','left')},
                minlength: function(){popoverMessages('#loginForm #password','invalid password','left')}
            }
        }
    });

    // validate signup form on keyup and submit
    $("#userForm").validate({
        rules: {
            firstName: "required",
            userName: {
                required: true,
                minlength: 2,
                remote:"/user/validateUserName"
            },
            password: {
                required: true,
                minlength: 5
            },
            rePassword: {
                required: true,
                minlength: 5,
                equalTo: "#userForm #password"
            },
            email: {
                required: true,
                email: true,
                remote:"/user/validateEmail"
            }
        },
        messages: {
            firstName: function(){popoverMessages('#userForm #firstName','Please enter your firstname','left')},
            userName: {
                required: "Please enter a username",
                minlength: "Your username must consist of at least 2 characters",
                remote:"already exists"
            },
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            },
            rePassword: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long",
                equalTo: "Please enter the same password as above"
            },
            email: "Please enter a valid email address",
            agree: "Please accept our policy"
        }
    });

    // propose username by combining first- and lastname
    $("#userName").focus(function() {
        var firstname = $("#firstname").val();
        var lastname = $("#lastname").val();
        if (firstname && lastname && !this.value) {
            this.value = firstname + "." + lastname;
        }
    });

    //code to hide topic selection, disable for demo
    var newsletter = $("#newsletter");
    // newsletter topics are optional, hide at first
    var inital = newsletter.is(":checked");
    var topics = $("#newsletter_topics")[inital ? "removeClass" : "addClass"]("gray");
    var topicInputs = topics.find("input").attr("disabled", !inital);
    // show when newsletter is checked
    newsletter.click(function() {
        topics[this.checked ? "removeClass" : "addClass"]("gray");
        topicInputs.attr("disabled", !this.checked);
    });
});




$(document).ready(function() {
    var rating=0;
    var index=0;
    var isClicked=false;
    $('#hrt_lst li img').hover(
        function () {
            isClicked=false;
            index=$('#hrt_lst li img').index($(this))
            for(var i= 0;i<=index;i++){
                $('#hrt_lst li img').eq(i).attr({src : '/assets/red.svg'});
                $('#hrt_lst li img').click(function(){
                    isClicked=true;
                    rating=index;

                })
            }
            //$(this).attr({src : '/assets/red.svg'});
        },
        function () {
            if (!isClicked) {
                for (var i = rating+1; i <= 5; i++) {
                    $('#hrt_lst li img').eq(i).attr({src: '/assets/black.svg'});
                }
                //$(this).attr({src : '/assets/black.svg'});
            }
            else{
                for (var i = rating+1; i <= 5; i++) {
                    $('#hrt_lst li img').eq(i).attr({src: '/assets/black.svg'});
                }
            }
        }
    );

    //$('.hrts').click(
    //    function () {
    //        var index = $('.hrts').index($(this))
    //        for (var i = 0; i <= index; i++) {
    //            $('.hrts').eq(i).attr({src: '/assets/red.svg'});
    //        }
    //        //$(this).attr({src : '/assets/red.svg'})
    //    }
    //);

});
