<#import "parts/common.ftl" as c>
<#import "parts/logreg.ftl" as l>

<@c.page "UserList" true>
    <div>Users list:</div>
    <table class="table table-dark table-hover">
        <thead>
            <th scope="col">Username</th>
            <th scope="col">Roles</th>
            <th scope="col">Action</th>
        </thead>
        <tbody>
            <#list users as user>
                <tr>
                    <th scope="row">${user.getUsername()}</th>
                    <th scope="row"><#list user.getRoles() as role>${role}<#sep>, </#list></th>
                    <th scope="row"><a href="/user/${user.id}">Edit</a> <a href="/user">View</a></th>
                </tr>
            </#list>
        </tbody>
    </table>
</@c.page>