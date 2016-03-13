<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Link Sharing</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>

                    <div style="width: 150px;margin-top: 30px">
                        <div class="input-group">
                            <input type="text" id="search_box" class="form-control" placeholder="search..">
                            <span class="input-group-btn">
                                <button class="btn btn-primary" type="button" onclick="$('#search_div').load('/topic/searchTopic', {'search': $('#search_box').val()}, function () {
                                    $('#search_modal').modal('show')
                                })">
                                    <span class="glyphicon glyphicon-search" aria-hidden="true">
                                    </span>
                                </button>
                            </span>
                        </div><!-- /input-group -->
                    </div><!-- /.col-lg-6 -->

                </li>

                <g:if test="${session.username}">
                    <g:if test="${session.admin}">
                        <g:render template="/layouts/admin_navigation_list"/>
                    </g:if>
                    <g:else>
                        <g:render template="/layouts/navigation_list"/>
                    </g:else>
                </g:if>
            </ul>

            <g:render template="/layouts/modal_forms"/>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
