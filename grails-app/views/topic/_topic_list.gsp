<ul class="list-unstyled">
<li class=""><g:render template="/topic/topic" collection="${topics}" var="topic"/>
</li>
</ul>
<div class="pagination">
    <g:paginate controller="topic" action="topics" total="${topics.size()?:10}"/>

</div>

