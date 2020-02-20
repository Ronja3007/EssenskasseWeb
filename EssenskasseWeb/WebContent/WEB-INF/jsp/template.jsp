<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Essenskasse</title>
 <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/0be993e115.js" crossorigin="anonymous"></script>
    <link rel="STYLESHEET" type="text/css" href="<c:url value="/include/stylesheet.css"/>">
</head>
<body>
<h1>Essenskasse</h1>
<div id="message" style="color: red;">
       <c:out value="${notifications}"/>
   </div>
   <div id="inhalt">
       <c:import url="${url}"></c:import>
   </div>
 <footer style = "position: fixed; padding: 10px; bottom: 0; left: 0; right: 0">
   <table>
   <tr><td><form action="/EssenskasseWeb/start.do" method="post">
         <button style="background-color: green">Bestellungen</button> 
         </form></td>
         <td><form action="/EssenskasseWeb/payIN.do" method="post">
         <button>Einzahlungen</button>  
         </form></td></tr>
   </table>   
   </footer> 
</body>
</html>