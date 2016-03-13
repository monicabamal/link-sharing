<div class="container">


    <div class="row">
        <div class="col-lg-5 col-lg-3">
            <div class="form-horizontal">

                <g:form name="userEdit" controller="user" action="update" enctype="multipart/form-data">

                    <g:hiddenField name="userName" value="${session["username"]}" />

                    <g:textField name="firstName" maxlength="15" class="form-control input-sm chat-input"
                                 placeholder="First Name" value="${user.firstName}"/>
                    <g:textField name="lastName" maxlength="15" class="form-control input-sm chat-input"
                                 placeholder="Last Name" value="${user.lastName}"/>

                    <input type="file" id="photo" name="photo" class="form-control input-sm chat-input"/>

                    <div class="wrapper">
                        <span class="group-btn">
                            <g:actionSubmit value="update" class="btn btn-primary btn-md"></g:actionSubmit>
                        </span>
                    </div>

                </g:form>
            </div>

        </div>
    </div>
</div>