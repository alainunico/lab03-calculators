<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form action="age" method="post">
            <label for="age">Please enter your age:</label>
            <input type="text" name="age" id="age"> <br>
            <input type="submit" value="Age next birthday"> <br>
            ${message} <br>
            <a href="arithmetic">Arithmetic Calculator</a>
        </form>
        
    </body>
</html>