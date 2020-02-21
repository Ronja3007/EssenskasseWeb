<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div>
<h2>Neues Menue anlegen:</h2>
</div>
<div>
<form action="/EssenskasseWeb/newMenue.do" method ="post">
<table>
	<tr><td><c:out value="Menue-Nummer eintragen:"></c:out></td>
			<td><input type="text" name = "menueNR" placeholder="Menue-Nummer" value='<c:out value="${NRvalue}"></c:out>'></td></tr>
		<tr><td><c:out value="Menue-Beschreibung eintragen:"></c:out></td>
			<td><input type="text" name = "menueDescription" placeholder="Menue-Beschreibung" value="<c:out value="${DescrValue}"></c:out>"></td></tr>
		<tr><td><c:out value="Menue-Kosten eintragen:"></c:out></td>
			<td><input type="text" name = "menueCost" placeholder="Menue-Kosten" value="<c:out value="${CostValue}"></c:out>"></td></tr>
	<tr><td><button type = "submit" style="background-color: green">Speichern</button></td></tr>
</table>
</form>
<form action="/EssenskasseWeb/menues.do" method="post">
	<button type = "submit">Abbrechen</button>
</form>
</div>