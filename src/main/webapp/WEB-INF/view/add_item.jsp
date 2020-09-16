<!--enable us to use JSTL tags-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--enable us to use Spring Form tags-->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!--imports-->
<%@ page import="academy.learnprogramming.util.AttributeNames" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Item</title>
</head>
<body>

    <h1>Add Item</h1>

    <div align="center">

        <!-- form id="todoItem" action="/todo-list/addItem" method="POST" -->
        <!-- form:form method="POST" modelAttribute="todoItem" -->
        <form:form method="POST" modelAttribute="${AttributeNames.TODO_ITEM_ATTRIBUTE_NAME}">

            <table>
                <tr>
                    <td><label>ID</label></td>
                    <td>
                        <form:input path="id" disabled="true" />
                    </td>
                </tr>

                <tr>
                    <td><label>Title</label></td>
                    <td><form:input path="title"/></td>
                </tr>

                <tr>
                    <td><label>Deadline</label></td>
                    <td><form:input path="deadline"/></td>
                </tr>

                <tr>
                    <td><label>Details</label></td>
                    <td><form:textarea path="details"/></td>
                </tr>

                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>

        </form:form>
    </div>

</body>
</html>

