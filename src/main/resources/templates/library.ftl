<#import "parts/common.ftl" as c>

<@c.page "Library" true>

    <#if message??>
        <div class="custom-alert" xmlns="http://www.w3.org/1999/html">
            <div class="alert alert-danger" role="alert">
                ${message}
            </div>
        </div>
    </#if>

    <#if user.isAdmin()>
        <form action="/uploadFile" method="post" enctype="multipart/form-data">
            <input type="file" name="files" multiple>
            <div class="mb-2">
                <div class="col-sm-12"><input type="number" name="level" class="form-control" placeholder="Level"></div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-dark">Upload</button>
        </form>
    </#if>
    <br>

<#-- List of access library-->
    <div class="bd-example">
        <div class="row">
            <div class="col-4">
                <nav id="navbar-example3" class="navbar navbar-light bg-light">
                    <a class="navbar-brand" href="#">Library</a>
                    <nav class="nav nav-pills flex-column">

                        <#list books as book>
                            <a class="nav-link bg-dark" href="#item-${book.getId()}">
                                <#--Item 1-->${book.getName()}<br>
                                <div id="passwordHelpBlock" class="form-text">Level-${book.getLevel()}</div>
                            </a>
                            <#list voices as voice> <#--    -->

                                <#if voice.getLevel() == book.getLevel()>
                                    <nav class="nav nav-pills flex-column">
                                        <a class="nav-link ms-3 my-1 text-dark bg-light"
                                           href="#item-${voice.getId()}">${voice.getName()}</a>
                                    </nav>
                                </#if>

                            </#list>
                        </#list>

                    </nav>
                </nav>
            </div>
            <div class="col-8">
                <div data-bs-spy="scroll" data-bs-target="#navbar-example3" data-bs-offset="0" tabindex="0">
                    <#list books as book>
                        <h4 id="item-${book.getId()}">Stage level ${book.getLevel()}</h4>
                        <p><a href="/library/file/get/${book.getId()}">Open</a></p>
                        <#list voices as voice>
                            <#if voice.getLevel() == book.getLevel()>
                                <h5 id="item-${voice.getId()}">${voice.getName()}</h5>
                                <p>
                                    <audio controls>
                                        <source src="/library/file/get/${voice.getId()}">
                                    </audio>
                                    <br>
                                </p>
                            </#if>
                        </#list>
                    </#list>
                </div>
            </div>
        </div>
    </div>
</@c.page>