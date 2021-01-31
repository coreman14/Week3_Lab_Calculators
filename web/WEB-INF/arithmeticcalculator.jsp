<%-- 
    Document   : arithmeticcalculator
    Created on : 30-Jan-2021, 6:45:29 PM
    Author     : rcgam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculator Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="POST" action="arithmetic">
            <label>First number:</label>
            <input type="text" name="first" value="${first}">
            <br>
            <label>Second number:</label>
            <input type="text" name="second" value="${second}">
            <br>
            <p>Result: ${message}</p>
            <br>
            <input type="submit" name="operation" value="+"> <input type="submit" name="operation" value="-"> <input type="submit" name="operation" value="*"> <input type="submit" name="operation" value="%">
        </form>
           <a href="age">Age Calculator</a>
    </body>
</html>
