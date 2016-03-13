<div id="resource_${resource.id}">
<hr>
<ul class="list-inline">
    <li> <div style="height: 80px;width: 80px">
        <a href="/home/show/${resource.createdBy.userName}"> <img src="/user/profilePhoto/${resource.createdBy.userName}" class="img-responsive"></a>
    </div>
    </li>
    <li>
        <ul class="list-unstyled">
            <li><div style="width: 200px">
                ${resource.description.substring(0,40)}...
           </div>
            </li>
            <li>
                <div style="width: 200px ;font-size: xx-small">
                <ul class="list-inline">
                    <li><div class="fb-share-button" data-href="${grailsApplication.config.grails.serverURL}/documentResource/show/${resource.id}" data-layout="button_count"></div></li>
                    <li><script type="IN/Share" data-url="${grailsApplication.config.grails.serverURL}/documentResource/show/${resource.id}"></script></li>
                    <li><a href="https://plus.google.com/share?url=${grailsApplication.config.grails.serverURL}/documentResource/show/${resource.id}" onclick="javascript:window.open(this.href,
                            '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');return false;"><img
                            src="${assetPath(src: 'goog-icon-a.gif')}" alt="Share on Google+"/></a></li>
                    <g:if test="${session.username}">
                        <g:if test="${resource.properties.containsKey("filePath")}">
                    <li><a href="/documentResource/getDocument/${resource.id}" download="resource.topic.name">Download</a></li>
                            </g:if>
                        <g:else>
                    <li><a href="${resource.url}" target="_blank">View full site</a></li>
                        </g:else>
                    <li><a href="" onclick="jQuery('#resource_${resource.id}').load('/linkResource/markAsRead/${resource.id}')">Mark as read</a></li>
                    </g:if>
                    <li><a href="/documentResource/show/${resource.id}">View Post</a></li>
                </ul>
                    </div>
            </li>
        </ul>
    </li>
</ul>
<hr>
</div>