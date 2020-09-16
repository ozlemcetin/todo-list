<!--enable us to use JSTL tags-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--imports-->
<%@ page import="academy.learnprogramming.util.Mappings" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Items</title>
</head>
<body>

    <h1>Items</h1>

    <div align="center">

        <p>
            <c:url var="addUrl" value="${Mappings.ADD_ITEM_MAPPING}"/>
            <a href="${addUrl}">Add New Todo Item</a>
        </p>

        <table border="1" cellpadding="5">
            <caption>Todo Items</caption>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Dead Line</th>
                    <th>View</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="im" items="${todoItemList}">

                    <c:url var="viewItem" value="${Mappings.VIEW_ITEM_MAPPING}">
                        <c:param name="id" value="${im.id}"/>
                    </c:url>

                    <c:url var="editItem" value="${Mappings.ADD_ITEM_MAPPING}">
                        <c:param name="id" value="${im.id}"/>
                    </c:url>

                    <c:url var="deleteItem" value="${Mappings.DELETE_ITEM_MAPPING}">
                        <c:param name="id" value="${im.id}"/>
                    </c:url>

                    <tr>
                        <td><c:out value="${im.title}"/></td>
                        <td><c:out value="${im.deadline}"/></td>
                        <td>
                            <a href="${viewItem}">View Item</a>
                        </td>
                        <td>
                            <a href="${editItem}">Edit Item</a>
                        </td>
                        <td>
                            <a href="${deleteItem}">Delete Item</a>
                        </td>
                     </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>

</body>
</html>

