<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Show All Developers</title>
</head>
<body>
<table border=1>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>Developer Id</th>--%>
<%--        <th>Name</th>--%>
<%--        <th>Specialty</th>--%>
<%--        <th>Salary</th>--%>
<%--        <th colspan=2>Action</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
    <c:forEach var="developer" items="${developers}">
        <tr>
            <td><c:out value="${developer.developerid}" /></td>
            <td><c:out value="${developer.name}" /></td>
            <td><c:out value="${developer.specialty}" /></td>
            <td><c:out value="${developer.salary}" /></td>

<%--            <td>--%>
<%--                <a href="DeveloperController?action=edit&developerId=<c:out value="${developer.id}"/>">Update</a>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <a href="DeveloperController?action=delete&developerId=<c:out value="${developer.id}"/>">Delete</a>--%>
<%--            </td>--%>
        </tr>
    </c:forEach>
<%--    </tbody>--%>
</table>
<p><a href="DeveloperController?action=insert">Add User</a></p>
</body>
</html>
