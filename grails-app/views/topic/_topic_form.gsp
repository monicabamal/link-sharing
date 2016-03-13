<g:form name="topicForm" action="save" controller="topic" method="post">
<div id="topic_modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Create Topic</h4>
            </div>
            <div class="modal-body">


    <ul class="list-unstyled">
        <li>
        <g:textField name="name" maxlength="20" placeholder="name" class="form-control input-sm chat-input" /></li>
        <li>
        <g:textArea name="description" maxlength="100"  rows="15" placeholder="Describe the Topic in 100 words" class="form-control input-sm chat-input" /></li>
        <li>
        <g:select name="visibility" from="${com.intelli.linksharing.Visibility}" class="form-control input-sm chat-input"/></li>


    </ul>



            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <g:submitButton name="create" class="btn btn-primary"/>
            </div>

        </div>
    </div>
</div>
</g:form>
