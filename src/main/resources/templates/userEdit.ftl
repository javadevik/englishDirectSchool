<#import "parts/common.ftl" as c>
<@c.page "UserEdit" true>
    <div>User edit form:</div>
    <form method="post" action="/user">
        <input type="text" value="${user.getUsername()}" placeholder="Username" name="username">
        <#list roles as role>
            <div><label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label></div>
        </#list>
        <input type="hidden" name="userId" value="${user.getId()}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Save</button>
    </form>
</@c.page>