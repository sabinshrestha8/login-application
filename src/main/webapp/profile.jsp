<%@ include file="/templates/header.jsp"%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache");   //HTTP 1.0
    response.setHeader("Expires", "0"); //Proxies
%>
<div class="container vh-100 d-flex align-items-center justify-content-center">
    <div>
        <h2>Welcome ${user.first_name} ${user.last_name}!!!</h2>
    </div>
    <a href="admin" class="btn btn-danger">Logout</a>
</div>

<%@ include file="/templates/footer.jsp"%>

