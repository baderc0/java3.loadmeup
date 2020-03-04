<%-- 
    Document   : loadout
    Created on : Feb. 13, 2020, 6:49:02 p.m.
    Author     : andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoadoutServlet" method="POST">
            <h1>Load Up</h1>
            <h3>
                Name: <c:out value="${name}"></c:out> 
                Weight: <c:out value="${weight}"></c:out> 
                </h3>

                <table style="border: 1px solid black">
                    <tr>
                        <th>Description</th>
                        <th>Weight</th>
                        <th>Action</th>    
                    </tr>

                <c:forEach var="weapon" items="${weapons}">
                    <tr>
                        <td>${weapon.description}</td>
                        <td>${weapon.weight}</td>
                        <td>
                            <form action="LoadoutServlet" method="POST">
                                <input type="hidden" name="addCode" value="${weapon.code}">
                                <input type="submit" value="Add" name="add"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>


        <h1>Your Loadout</h1>
        <form method="POST" action="LoadoutServlet">
            <c:if test="${empty loadout.items}">
                <h2>You don't have any weapons. <h2><br>
                    </c:if>
                    <c:if test="${not empty loadout.items}">       
                        <table style="border: 1px solid black">
                            <tr>
                                <th>Description</th>
                                <th>Unit Weight</th>
                                <th>Quantity</th> 
                                <th>Total Weight</th> 
                                <th>Action</th> 
                            </tr>

                            <c:forEach var="loadoutweapon" items="${loadout.items}">
                                <tr>
                                    <td>${loadoutweapon.weapon.description}</td>
                                    <td>${loadoutweapon.weapon.weight}</td>
                                    <td>${loadoutweapon.quantity}</td>
                                    <td>
                                        <fmt:formatNumber type="number" 
                                                          minFractionDigits="2"
                                                          maxFractionDigits="2" 
                                                          value="${loadoutweapon.totalWeight}"/>kg

                                    </td>
                                    <td>
                                        <form action="LoadoutServlet" method="POST">
                                            <input type="hidden" name="removeCode" value="${loadoutweapon.weapon.code}">
                                            <input type="submit" value="Remove" name="remove"/>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                    </form>

                    <h2>Total Weight: 
                        <fmt:formatNumber type="number" 
                                          minFractionDigits="2"
                                          maxFractionDigits="2" 
                                          value="${loadout.getTotalWeight()}"/>kg
                    </h2>
                        <c:if test="${loadout.getTotalWeight() le weight and loadout.getTotalWeight() > 0}">
                             <input type="submit" value="Checkout" />
                        </c:if>
                              
                    </body>
                    </html>
