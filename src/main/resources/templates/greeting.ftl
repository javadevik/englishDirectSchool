<#import "parts/common.ftl" as c>
<#import "parts/logreg.ftl" as l>

<@c.page "Greeting" true>

    <#if message??>
        <div class="custom-alert" xmlns="http://www.w3.org/1999/html">
            <div class="alert alert-danger" role="alert">
                ${message}
            </div>
        </div>
    </#if>

        <#if user??>
            <a href="/main">Main page</a>
        <#else>
            <@l.loginform />
        </#if>
</@c.page>