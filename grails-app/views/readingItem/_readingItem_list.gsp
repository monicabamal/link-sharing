<%@ page import="com.com.intelli.linksharing.Visibility" %>
<ul class="list-unstyled">
    <li class=""><g:render template="/readingItem/readingItem" collection="${readingItems}" var="readingItem"/>
    </li>
</ul>
<div class="pagination">
    <g:paginate controller="readingItem" action="index" total="${readingItems.size()?:10}"/>

</div>