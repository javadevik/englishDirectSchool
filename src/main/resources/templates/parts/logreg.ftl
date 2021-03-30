<#macro loginform>
    <div class="login-form-container">
        <form action="/login" method="post">
            <div class="mb-1">
                <label class="col-sm-2 col-form-label">Login:</label>
                <div class="col-sm-12">
                    <input type="text" class="form-control" name="username" placeholder="Username">
                </div>
            </div>
            <div class="mb-2">
                <label class="col-sm-2 col-form-label">Password:</label>
                <div class="col-sm-12">
                    <input type="password" class="form-control" name="password" placeholder="Password">
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-light">SignIn</button>
            <a href="/registration" class="btn btn-light ms-3">Registration</a>
        </form>
    </div>
</#macro>

<#macro registration>
    <form action="/registration" method="post">
        <div class="input-group flex-nowrap  mb-2">
            <span class="input-group-text" id="addon-wrapping">Username</span>
            <div class="col-sm-25 ms-1">
                <input type="text" class="form-control" name="username" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
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
                <input type="text" aria-label="First name" class="form-control" name="name" placeholder="Name">
            </div>
            <div class="col-sm-35 ms-1">
                <input type="text" aria-label="Last name" class="form-control" name="lastName" placeholder="Last name">
            </div>
        </div>
        <div class="input-group flex-nowrap  mb-2">
            <span class="input-group-text" id="addon-wrapping">Passport or Id card number</span>
            <div class="col-sm-30 ms-1">
                <input type="text" class="form-control" name="passport" placeholder="Passport/IdCard" aria-describedby="addon-wrapping">
            </div>
        </div>
        <div class="input-group flex-nowrap  mb-2">
            <span class="input-group-text" id="addon-wrapping">Tax number</span>
            <div class="col-sm-30 ms-1">
                <input type="text" class="form-control" name="taxNumber" placeholder="Tax number" aria-describedby="addon-wrapping">
            </div>
        </div>
        <div class="input-group flex-nowrap  mb-2">
            <span class="input-group-text" id="addon-wrapping">Email</span>
            <div class="col-sm-30 ms-1">
                <input type="text" class="form-control" name="email" placeholder="example@gmail.com" aria-describedby="addon-wrapping">
            </div>
        </div>
        <div class="input-group flex-nowrap  mb-2">
            <span class="input-group-text" id="addon-wrapping">Phone</span>
            <div class="col-sm-30 ms-1">
                <input type="text" class="form-control" name="phone" placeholder="+380*********" aria-describedby="addon-wrapping">
            </div>
        </div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-dark">SignOut</button>
    </form>
</#macro>