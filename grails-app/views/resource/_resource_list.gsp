<ul class="list-unstyled">
    <li class=""><g:render template="/resource/resource" collection="${resources}" var="resource"/>
    </li>
</ul>

<util:remotePaginate controller="${paginateController}" action="${paginateAction}" total="${totalResource}" update="${updateId}" id="${paginateId?:""}"
                          max="2" />