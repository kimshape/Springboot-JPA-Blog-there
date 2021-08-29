<%@include file="../layout/header.jsp" %>
<div class="container">
    <form action="/user/join" method="POST">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" class="form-control" placeholder="Enter Username" id="username">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" placeholder="Enter Password" id="password">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" placeholder="Enter Email" id="email">
        </div>
    </form>
    <button id="btn-save" class="btn btn-primary">Join in</button>
</div>

<script src="/blog/js/user.js"></script>
<%@include file="../layout/footer.jsp" %>



