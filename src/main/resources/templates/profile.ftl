<#import "parts/common.ftl" as c>
<#import "parts/logreg.ftl" as l>
<@c.page "Profile" true>
    <form action="/registration" method="post">
        <div class="input-group flex-nowrap  mb-2">
            <span class="input-group-text" id="addon-wrapping">Username</span>
            <div class="col-sm-25 ms-1">
                <input type="text" value="${username}" class="form-control" name="username" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
            </div>
        </div>
        <div class="input-group flex-nowrap mb-4">
            <span class="input-group-text" id="addon-wrapping">Password</span>
            <div class="col-sm-25 ms-1">
                <input type="password" class="form-control" name="password" placeholder="Password" aria-label="Password" aria-describedby="addon-wrapping">
            </div>
        </div>
        <div class="input-group mb-2">
            <span class="input-group-text">First and last name</span>
            <div class="col-sm-35 ms-1">
                <input type="text" value="${person.getName()}" aria-label="First name" class="form-control" name="name" placeholder="Name">
            </div>
            <div class="col-sm-35 ms-1">
                <input type="text" value="${person.getLastName()}" aria-label="Last name" class="form-control" name="lastName" placeholder="Last name">
            </div>
        </div>
        <div class="input-group flex-nowrap  mb-2">
            <span class="input-group-text" id="addon-wrapping">Passport or Id card number</span>
            <div class="col-sm-30 ms-1">
                <input type="text" value="${person.getPassportNumber()}" class="form-control" name="passport" placeholder="Passport/IdCard" aria-describedby="addon-wrapping">
            </div>
        </div>
        <div class="input-group flex-nowrap  mb-2">
            <span class="input-group-text" id="addon-wrapping">Tax number</span>
            <div class="col-sm-30 ms-1">
                <input type="text" value="${person.getTaxNumber()}" class="form-control" name="taxNumber" placeholder="Tax number" aria-describedby="addon-wrapping">
            </div>
        </div>
        <div class="input-group flex-nowrap  mb-2">
            <span class="input-group-text" id="addon-wrapping">Email</span>
            <div class="col-sm-30 ms-1">
                <input type="text" value="${person.getEmail()}" class="form-control" name="email" placeholder="example@gmail.com" aria-describedby="addon-wrapping">
            </div>
        </div>
        <div class="input-group flex-nowrap  mb-2">
            <span class="input-group-text" id="addon-wrapping">Phone</span>
            <div class="col-sm-30 ms-1">
                <input type="text" value="${person.getPhone()}" class="form-control" name="phone" placeholder="+380*********" aria-describedby="addon-wrapping">
            </div>
        </div>
    </form>
</@c.page>