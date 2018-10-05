<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${not empty listaProduto}">
    <div class="esp15"></div>
    <c:forEach var="produto" items="${listaProduto}">
        <a href="telaprod.html?id=${produto.idproduto}" class="linkprod">
            <div class="row">
                <div class="col-md-6">
                    <img src="C:/Users/graci/Pictures/imgprod/${produto.foto1}"/>
                </div>
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header">
                            <label><h5>Nome: ${produto.produto}</h5></label>
                        </div>
                        <div class="card-body">
                            <p class="card-text">ID: ${produto.idproduto}</p>
                            <p class="card-text">R$ ${produto.venda}</p>
                        </div>
                    </div>
                </div>
            </div>
        </a>
        <div class="esp15"></div>
    </c:forEach>
</c:if>
