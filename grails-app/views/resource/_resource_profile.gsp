<div class="clearfix">
    <div class="clearfix">
        <div class="container-left">
            <ul class="list-inline">
                <li><a href="/home/show/${resource.createdBy.userName}"> <img class="img-responsive" src="/user/profilePhoto/${resource.createdBy.userName}"></a></li>
                <li><ul class="list-unstyled">
                    <li>${resource.createdBy.name}</li>
                    <li>@${resource.createdBy.userName}</li>
                </ul>
                </li>
            </ul>
        </div>

        <div class="container-right">
            <ul class="list-unstyled">
                <li><a href="/topic/show/${resource.topic.id}">${resource.topic.name}</a></li>
                <li>${resource.dateCreated}</li>
                <g:if test="${session.username}">
                    <li>

                        <ul class="list-inline" id="hrt_lst">
                            <g:each in="${1..5}" var="count">
                                <g:if test="${count <= score}">
                                    <li><img class="hrts" style="height: 13px; width: 13px "
                                             src="${assetPath(src: 'red.svg')}"
                                             onclick="$.get('/resourceRating/rateResource/${resource.id}', {'score':${count}})"/>
                                    </li>
                                </g:if>
                                <g:else>
                                    <li><img class="hrts" style="height: 13px; width: 13px "
                                             src="${assetPath(src: 'black.svg')}"
                                             onclick="$.get('/resourceRating/rateResource/${resource.id}', {'score':${count}})"/>
                                    </li>
                                </g:else>
                            </g:each>
                        </ul>

                    </li>
                </g:if>
            </ul>
        </div>
    </div>

    <p>${resource.description}</p>
    <ul class="list-inline">
        <li><a href=""><image src="${assetPath(src: 'fb-icon-a.gif')}" onclick="$('#topic_modal').modal('show')"/></a>
        </li>
        <li><a href=""><image src="${assetPath(src: 'goog-icon-a.gif')}" onclick="$('#topic_modal').modal('show')"/></a>
        </li>
        <li><a href=""><image src="${assetPath(src: 'twit-icon-a.gif')}" onclick="$('#topic_modal').modal('show')"/></a>
        </li>
        <g:if test="${session.username}">
            <g:if test="${(session.username==resource.createdBy.userName || session.username==resource.topic.createdBy.userName || session.admin)}">
            <li><a href="">Delete</a></li>
            <li><a href="">Edit</a></li>
            </g:if>
            <g:if test="${isSubscribed || session.admin}">
            <g:if test="${resource.properties.containsKey("filePath")}">
                <li><a href="/documentResource/getDocument/${resource.id}" download="${resource.topic.name}">Download</a></li>
            </g:if>
            <g:else>
                <li><a href="${resource.url}" target="_blank">View full site</a></li>
            </g:else>
            </g:if>
        </g:if>
    </ul>
</div>