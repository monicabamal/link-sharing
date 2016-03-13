<div class="container">
    <div class="row">
        <div class="col-lg-5 col-lg-3">
            <div class="form-login">
                <g:form controller="login" action="login" name="loginForm" >
                <h4>Please login</h4>
                    <h6>${msg}</h6>
                    <g:textField name="userName" class="form-control input-sm chat-input" placeholder="username">UserName</g:textField>
            </br>
                    <g:passwordField name="password" class="form-control input-sm chat-input" placeholder="password">password</g:passwordField>
            </br>
                <div class="wrapper">
                    <span class="group-btn">
                        <g:actionSubmit value="login" action="login" class="btn btn-primary btn-md"></g:actionSubmit>
                    </span>
                </div>
                </g:form>
            </div>

        </div>
    </div>
</div>









