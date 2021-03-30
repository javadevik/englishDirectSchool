<#import "parts/common.ftl" as c>

<@c.page "Library" true>

    <#if user.isAdmin()>
        <form action="/uploadFile" method="post" enctype="multipart/form-data">
            <input type="file" name="files" multiple>
            <input type="number" name="level" placeholder="Level">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Upload</button>
        </form>
    </#if>
        <#list voices as voice>
            <audio controls>
                <source src="/library/voice/get/${voice.getId()}">
            </audio><br>
        </#list>
</@c.page>