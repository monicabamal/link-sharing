
    <div id="email_modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Send Email</h4>
                </div>
                <div class="modal-body">
                    <div id="email-body">


                    <ul class="list-unstyled">
                        <li><g:select name="topic" from="${topics}" optionKey="id" optionValue="name" class="form-control chat-input"/></li>
                        <li>
                            <g:textField name="to" maxlength="30" placeholder="To:" class="form-control chat-input" /></li>

                    </ul>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button  id="invite" class="btn btn-default" onclick="$('#email-body').load('/topic/sendInvitation',{'to':$('#to').val(),'topic':$('#topic').val()}),function(){$('#invite').css('display','none')}">Send Invite</button>
                </div>

            </div>
        </div>
    </div>


