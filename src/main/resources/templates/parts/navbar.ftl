<#include "security.ftl">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <#if user??>
            <a class="navbar-brand" href="/${user.getId()}"><span class="hd-logo">EnglishDirectSchool</span></a>
        <#else>
            <a class="navbar-brand" href="/"><span class="hd-logo">EnglishDirectSchool</span></a>
        </#if>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mx-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/main">Profile</a>
                </li>
                <#if isAdmin>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/user">UserList</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/group">Groups</a>
                    </li>
                </#if>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/library">Library</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto mb-2 mb-lg-0">
                <#if user??>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        ${name}
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                        <li><a class="dropdown-item" href="#">Settings</a></li>
                        <li><a class="dropdown-item" href="/logout">Exit</a></li>
                    </ul>
                </li>
                <#else>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="#">${name}</a>
                    </li>
                </#if>
            </ul>
        </div>
    </div>
</nav>
