<div class="container">


    <div class="row">
        <div class="col-lg-5 col-lg-3">
            <div class="form-horizontal">

                <g:form name="changePasswordForm" controller="user" action="changePassword">

                    <g:hiddenField name="userName" value="${session["username"]}" />

                    <g:passwordField name="password" maxlength="20" placeholder="Password"
                 class="form-control input-sm chat-input"/>
<g:passwordField name="rePassword" maxlength="20" placeholder="Retype Password"
                 class="form-control input-sm chat-input"/>
                    <g:submitButton name="change" value="change password" class="btn btn-primary btn-md"/>
</g:form>
</div>

</div>
</div>
</div>