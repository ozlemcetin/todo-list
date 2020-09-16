<!--enable us to use JSTL tags-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--imports-->
<%@ page import="academy.learnprogramming.util.AttributeNames" %>
<%@ page import="academy.learnprogramming.util.Mappings" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Item</title>
</head>
<body>

    <h1>View Item</h1>

    <div align="center">

        <!--todoItem is hardcoded and is being referred from TodoItemController.viewItem method -->
        <!--Thymeleaf preprocessing helps to avoid this hard coding.-->


        <p>
            <c:set var="name" scope="request" value = "${AttributeNames.TODO_ITEM_ATTRIBUTE_NAME}"/>
            Attibute name in the model is <c:out value="${it}"/>
        </p>

        <c:set var="im" value = "${requestScope[AttributeNames.TODO_ITEM_ATTRIBUTE_NAME]}"/>
        <table>
            <tr>
                <td><label>ID</label></td>
                <td><c:out value="${im.id}"/></td>
            </tr>

            <tr>
                <td><label>Title</label></td>
                <td><c:out value="${im.title}"/></td>
            </tr>

            <tr>
                <td><label>Deadline</label></td>
                <td><c:out value="${im.deadline}"/></td>
            </tr>

            <tr>
                <td><label>Details</label></td>
                <td><c:out value="${im.details}"/></td>
            </tr>
        </table>

        <p>
            <c:url var="itemsLink" value="${Mappings.ITEMS_MAPPING}"/>
            <a href="${itemsLink}">Show Todo Item List</a>
        </p>

    </div>

</body>
</html>

