<g:if test="${params.controller == 'home'}">
    <li><a href="#"><image src="${assetPath(src: 'createTopic.png')}" onclick="$('#topic_modal').modal('show')"/>
    </a></li>
    <li><a href="#"><image src="${assetPath(src: 'invite.png')}" onclick="$('#email_modal').modal('show')"/>
    </a></li>
</g:if>
<g:if test="${params.controller != 'user'}">
    <li><a href="#"><image src="${assetPath(src: 'link.png')}"
                           onclick="$('#link_modal').modal('show')"/></a></li>
    <li><a href="#"><image src="${assetPath(src: 'edit.png')}" onclick="$('#document_modal').modal('show')"/>
    </a></li>
</g:if>
<li><a href="/user/edit"><image src="${assetPath(src: 'user2.png')}"/></a>
</li>


