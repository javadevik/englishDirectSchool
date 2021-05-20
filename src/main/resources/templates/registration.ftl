<#import "parts/common.ftl" as c>
<#import "parts/logreg.ftl" as l>
<@c.page "EnglishDirectSchool" false>

    <#if message??>
        <div class="custom-alert">
            <div class="alert alert-danger" role="alert">
                ${message}
            </div>
        </div>
    </#if>

    <div class="mb-4">Registration form:</div>
    <@l.registration />
</@c.page>