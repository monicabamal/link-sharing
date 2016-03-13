
<tr>
    <td>${user.id}</td>
    <td>${user.userName}</td>
    <td>${user.email}</td>
    <td>${user.firstName}</td>
    <td>${user.lastName}</td>
    <td>${user.active ? "Yes" : "NO"}</td>
    <td>
        <g:if test="${user.active}">
            <g:render template="/user/deactivate_user"/>

        </g:if>
        <g:else>
            <g:render template="/user/activate_user" />

        </g:else>

        </td>


</tr>
