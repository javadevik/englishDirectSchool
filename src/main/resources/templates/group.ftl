<#import "parts/common.ftl" as c>

<@c.page "Groups" true>

    <#if message??>
        <div class="custom-alert">
            <div class="alert alert-danger" role="alert">
                ${message}
            </div>
        </div>
    </#if>

    <div>Create a new group</div>

    <form action="/group" method="post" class="mb-2">
        <input type="text" class="mb-2" name="name" placeholder="Name group">
        <select class="form-select" aria-label="Default select example" class="mb-2" name="studentId">
            <#list students as student>
                <option value="${student.getId()}">${student.getPerson().getName()} ${student.getPerson().getLastName()}</option>
            </#list>
        </select>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-dark mt-2">Accept</button>
    </form>
    <table class="table table-dark table-striped mt-2">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Students</th>
        </tr>
        </thead>
        <tbody>
        <#list groups as group>
            <tr>
                <th>${group.getId()}</th>
                <td>${group.getName()}</td>
                <td>
                    <#list group.getStudents() as student>
                        ${student.getPerson().getName()} ${student.getPerson().getLastName()}<#sep> ,
                    </#list>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>