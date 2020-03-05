<%-- 
    Document   : index
    Created on : Feb. 13, 2020, 6:48:38 p.m.
    Author     : andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="styles/main.css" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
    </head>
    <body>
        <div id="main-div">
            <div id="sign-up-text"><h1>Sign Up</h1></div>
            <form action="SignUpServlet" method="POST">
                <p>Full Name: <input type="text" name="fullName" value="${name}" required /></p>
                <p>Weight: <input type="number" name="weight" value="${weight}" required /></p>
                <div><input type="submit" value="Load Me Up" /></div>
            </form>
        </div>
    </body>
</html>
