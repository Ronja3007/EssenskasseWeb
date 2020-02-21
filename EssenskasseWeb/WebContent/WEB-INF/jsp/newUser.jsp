<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div>
<h2>Neuen User anlegen:</h2>
</div>
<div>
<form action="/EssenskasseWeb/saveUser.do" method ="post">
<table>
	<tr><td><c:out value="User ID eintragen:"></c:out></td>
			<td><input type="text" name = "userID" placeholder="User ID" value="<c:out value="${IDvalue}"></c:out>"></td></tr>
		<tr><td><c:out value="Vorname eintragen:"></c:out></td>
			<td><input type="text" name = "firstName" placeholder="Vorname" value="<c:out value="${FNValue}"></c:out>"></td></tr>
		<tr><td><c:out value="Nachname eintragen:"></c:out></td>
			<td><input type="text" name = "name" placeholder="Nachname" value="<c:out value="${NValue}"></c:out>"></td></tr>
	<tr><td><button type = "submit" style="background-color: green">Speichern</button></td></tr>
	</table>
</form>
<form action="/EssenskasseWeb/users.do" method="post">
	<button type = "submit">Abbrechen</button>
</form>
</div>