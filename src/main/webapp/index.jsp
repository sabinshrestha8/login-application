<%@ include file="/templates/header.jsp" %>

<%
    if (session.getAttribute("user") != null) {
        response.sendRedirect("profile");
    }

    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache");   //HTTP 1.0
    response.setHeader("Expires", "0"); //Proxies
%>

<div class="container">
    <div class="form-wrapper w-25 mx-auto p-4 shadow my-5">
        <form action ="admin" method="post">
            <h2 class="text-center mt-2 mb-4 p-1 bg-primary text-light rounded">Login App</h2>
            <div class="mb-3">
                <label class="form-label">Username: </label>
                <input type="text" class="form-control" value="${username}" placeholder="admin" name="username">
            </div>
            <div class="mb-3">
                <label class="form-label">Password:</label>
                <input type="password" class="form-control" placeholder="admin123" name="password">
            </div>
            <p class="text-danger">${error}</p>
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>
        </form>
    </div>
</div>

<%@ include file="/templates/footer.jsp" %>
