
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Produk</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${empty daftarProduk}">
                <h3>Record Empty</h3>
            </c:when>
            <c:otherwise>
                <table border="1">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>kode</th>
                            <th>nama</th>
                            <th>harga</th>
                            <th>terakhir update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${daftarProduk}" var="p" varStatus="i">
                            <tr>
                                <td>${i.count}</td>
                                <td>${p.kodeProduk}</td>
                                <td>${p.nama}</td>
                                <td>${p.harga}</td>
                                <td>${p.terakhirUpdate}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>       
    </body>
</html>