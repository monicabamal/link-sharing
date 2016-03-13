<g:render template="/layouts/navigation_icons" />
    <li id="fat-menu" class="dropdown">
        <a href="#" id="drop3" role="button" class="dropdown-toggle" data-toggle="dropdown">${session.name}<b class="caret"></b></a>
        <ul class="dropdown-menu" role="menu" aria-labelledby="drop3">
            <li role="presentation"><a role="menuitem" tabindex="-1" href="/user/edit">Profile</a></li>
            <li role="presentation" class="divider"></li>
            <li role="presentation"><a role="menuitem" tabindex="-1" href="/logout">Logout</a></li>
        </ul>
    </li>


