<div class="container">
    <h4>Create User</h4>

    <div class="row">
        <div class="col-lg-5 col-lg-3">
            <div class="form-horizontal">

                <g:form name="userForm" controller="user" action="save" enctype="multipart/form-data">

                    <g:textField name="firstName" maxlength="15" class="form-control input-sm chat-input"
                                 placeholder="First Name"/>
                    <g:textField name="lastName" maxlength="15" class="form-control input-sm chat-input"
                                 placeholder="Last Name"/>
                    <g:textField name="userName" maxlength="15" class="form-control input-sm chat-input"
                                 placeholder="username"/>


                    <g:passwordField name="password" maxlength="20" placeholder="Password"
                                     class="form-control input-sm chat-input"/>
                    <g:passwordField name="rePassword" maxlength="20" placeholder="Retype Password"
                                     class="form-control input-sm chat-input"/>
                    <input type="email" name="email" value="" placeholder="email" id="email"
                           class="form-control input-sm chat-input"/>
                    <g:if test="${session.admin}"><g:checkBox name="active" class="form-control input-sm chat-input"
                                placeholder="active">Active</g:checkBox>
                    <g:checkBox name="admin" class="form-control input-sm chat-input"
                                placeholder="admin">Admin</g:checkBox>
                        </g:if>
                    <input type="file" id="photo" name="photo" class="form-control input-sm chat-input"/>

                    <div class="wrapper">
                        <span class="group-btn">
                            <g:actionSubmit value="save" class="btn btn-primary btn-md"></g:actionSubmit>
                        </span>
                    </div>

                </g:form>
            </div>

        </div>
    </div>
</div>