<#import "parts/common.ftl" as c>
<#import "parts/logreg.ftl" as l>
<@c.page "EnglishDirectSchool" false>
    ${message!""}
    <div class="mb-4">Registration form:</div>
    <div class="registration-customize-form"><@l.registration /></div>
</@c.page>