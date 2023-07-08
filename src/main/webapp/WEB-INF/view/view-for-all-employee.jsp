<%@ taglib prefix="secutity" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>
<h3>All employee view</h3>

<br><br>
<secutity:authorize access="hasRole('HR')">
    <input type="button" value="Salary" onclick="window.location.href='hr-info'">
    Only for hr
</secutity:authorize>
<br><br>
<secutity:authorize access="hasRole('MANAGER')">
    <input type="button" value="Performance" onclick="window.location.href='manager-info'">
    Only for managers
</secutity:authorize>

</body>

</html>