<div class="container-left">
    <a href="/home/show/${topic.createdBy.userName}"> <img src="/user/profilePhoto/${topic.createdBy.userName}" class="img-responsive"></a>
</div>

<div class="container-right">
    <ul class="list-unstyled">

        <li>
            <ul class="list-inline">
                <li><h4>${topic.name}</h4></li>
                <li>(${topic.visibility})</li>

            </ul></li>
        <li><div id="subscribe_button">
            <g:if test="${session.username}">
                <g:if test="${session.username == topic.createdBy.userName}">
                </g:if>
                <g:else>
                    <g:if test="${subscribed}">
                        <button class="btn btn-primary"
                                onclick="$('#subscribe_button').load('/topic/unSubscribe/${topic.id}')">Un-subscribe</button>

                    </g:if>
                    <g:else>
                        <button class="btn btn-primary"
                                onclick="$('#subscribe_button').load('/topic/subscribe/${topic.id}')">Subscribe</button>

                    </g:else>
                </g:else>
            </g:if>
        </div>
        </li>
        <br>
        <g:if test="${session.username}">
            <li><g:select name="seriousness" class="form-control input-sm chat-input" from="${com.intelli.linksharing.Seriousness}"
                          value="${topic.subscription.seriousness}"
                          onchange="jQuery.get('/topic/changeSeriousness/${topic.id}',{'seriousness':\$('#seriousness option:selected').val()})"/></li>
        </g:if>
        <li>${topic.createdBy.name}
        </li>
    </ul>
</div>