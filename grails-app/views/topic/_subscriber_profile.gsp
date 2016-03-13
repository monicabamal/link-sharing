<div class="clearfix">
<div class="container-left">
    <a href="/home/show/${subscriber.userName}"><img class="img-responsive" src="/user/profilePhoto/${subscriber.userName}"></a>
</div>

<div class="container-right">
    <ul class="list-unstyled">

        <li><h4>${subscriber.name}</h4></li>
        <li>@${subscriber.userName}</li>
        <br>
        <br>
        <br>
        <li>
            <ul class="list-inline">
                <li>subscription ${subscriber.subscription.size()}</li>
                <li>topic ${subscriber.topic.size()}</li>

            </ul>
        </li>
    </ul>
</div>
</div>