<#import "parts/common.ftl" as c>
<#import "parts/logreg.ftl" as l>
<@c.page "Profile" true>

    <#if message??>
        <div class="custom-alert" xmlns="http://www.w3.org/1999/html">
            <div class="alert alert-danger" role="alert">
                ${message}
            </div>
        </div>
    </#if>

    <div>Welcome to main page! ${user.getUsername()}</div>

<#--    <div class="lg-main-menu">-->
<#--        <div class="logomain-menu">-->
<#--            <div class="card" style="width: 18rem;">-->
<#--                <img src="/images/logo.png" class="card-img-top" alt="...">-->
<#--                <div class="card-body">-->
<#--                    <p class="card-text">-->
<#--                        ${user.getUsername()}-->
<#--                        (<#list user.getRoles() as role>${role}<#sep>, </#list>)-->
<#--                    </p>-->
<#--                </div>-->
<#--            </div>-->
<#--        </div>-->

<#--        <div class="navtab-menu">-->
<#--            <nav>-->
<#--                <div class="nav nav-tabs" id="nav-tab" role="tablist">-->
<#--                    <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home"-->
<#--                            type="button" role="tab" aria-controls="nav-home" aria-selected="true">Profile-->
<#--                    </button>-->
<#--                    <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile"-->
<#--                            type="button" role="tab" aria-controls="nav-profile" aria-selected="false">Group-->
<#--                    </button>-->
<#--                    <button class="nav-link" id="nav-contact-tab" data-bs-toggle="tab" data-bs-target="#nav-contact"-->
<#--                            type="button" role="tab" aria-controls="nav-contact" aria-selected="false">Rating-->
<#--                    </button>-->
<#--                </div>-->
<#--            </nav>-->
<#--            <div class="tab-content" id="nav-tabContent">-->
<#--                <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">-->
<#--                    <div class="contact-information-container">-->
<#--                        <span class="contact-information">Name:</span> ${person.getName()}<br>-->
<#--                        <span class="contact-information">Last Name:</span> ${person.getLastName()}<br>-->
<#--                        <span class="contact-information">Email:</span> ${person.getEmail()}<br>-->
<#--                        <span class="contact-information">Phone:</span> ${person.getPhone()}<br>-->
<#--                        <span class="contact-information">Address:</span> ${person.getAddress()}<br>-->
<#--                    </div>-->
<#--                </div>-->
<#--                <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">-->
<#--                    <div class="contact-information-container">-->
<#--                        <#if student??>-->
<#--                            <#if student.getGroup()??>-->
<#--                                <span class="contact-information">Group: ${student.getGroup().getName()}</span><br>-->
<#--                                <#list student.getGroup().getStudents() as pupil>-->
<#--                                    <#if !pupil.equals(student)>-->
<#--                                        <span class="contact-information">-->
<#--                                        ${pupil.getPerson().getName()}-->
<#--                                        </span>-->
<#--                                    </#if>-->
<#--                                </#list>-->
<#--                            </#if>-->
<#--                        </#if>-->
<#--                    </div>-->
<#--                </div>-->
<#--                <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">Something-->
<#--                    three-->
<#--                </div>-->
<#--            </div>-->
<#--        </div>-->
<#--    </div>-->

</@c.page>