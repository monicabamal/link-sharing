<div class="container-left">
    <img class="img-responsive" src="/user/profilePhoto/${user.userName}">
</div>

<div class="container-right">
    <ul class="list-unstyled">

        <li><h4>${user.name}</h4></li>
        <li>@${user.userName}</li>
        <br>
        <br>
        <br>
        <li>
            <ul class="list-inline">
                <li>subscription ${user.subscription.size()}</li>
                <li>topic ${user.topic.size()}</li>

            </ul>
        </li>
    </ul>
</div>
