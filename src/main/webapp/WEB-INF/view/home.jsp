<!--enable us to use JSTL tags-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--imports-->
<%@ page import="academy.learnprogramming.util.Mappings" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>

    <h1>Home</h1>

    <div align="center">

        <h2>
            <c:url var="itemsLink" value="${Mappings.ITEMS_MAPPING}"/>
            <a href="${itemsLink}">Show Todo Item List</a>
        </h2>
    </div>

</body>
</html>

