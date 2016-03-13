<g:form name="documentForm" action="save" controller="documentResource" method="post" enctype="multipart/form-data">
    <div id="document_modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Document Resource</h4>
                </div>
                <div class="modal-body">


                    <ul class="list-unstyled">
                        <li>
                            <input type="file" name="file" id="file" class="form-control input-sm chat-input" /> </li>
                        <li>
                            <g:textArea name="description" rows="15" placeholder="Describe the Resource in 100 words" class="form-control input-sm chat-input" /></li>
                        <li>
                            <g:select name="topic" from="${topics}" optionKey="id" optionValue="name" class="form-control input-sm chat-input"/></li>

                    </ul>



                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <g:submitButton name="save" class="btn btn-primary"/>
                </div>

            </div>
        </div>
    </div>
</g:form>