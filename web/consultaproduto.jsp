<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" type="text/css" href="recursos/estilo/reset.css"/>
        <link rel="stylesheet" type="text/css" href="recursos/estilo/estilo.css"/>
        <!--	Bootstrap	-->
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css"/>
        <script type="text/javascript" src="bootstrap/jquery/jquery-3.3.1.slim.min.js"></script>
        <script type="text/javascript" src="bootstrap/popper/popper.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
        <!--	Font Awesome -->
        <link href="recursos/fontawesome/css/all.css" rel="stylesheet"/>
        <!--    Codificação própria -->
        <link href="recursos/estilo/estilo.css" rel="stylesheet"/>
        <title>JSP Page</title>
    </head>
    <body>
        <nav>
            <%
                Object usuario = session.getAttribute("funcionario");
                if (usuario == null) {
            %><c:import url="include/navlogin.jsp"/>
            <%
            } else {
            %><c:import url="include/navlogout.jsp"/>
            <%
                }
            %>
            <c:import url="include/menuprod.jsp"/>
        </nav>
        <%
            if (usuario == null) {
        %>
        <div class="corpo">
            <div class="esp50"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <center><h3>Pesquisar Produto</h3></center>
                    </div>
                </div>
                <div class="esp15"></div>
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <form action="buscaproduto.html" method="post">
                            <div class="form-group row">
                                <!---Sobre nome-->
                                <label for="dado" class="col-md-4 col-form-label">Informe o CPF</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="dado" name="dado"/>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-danger btn-block">Pesquisar</button>
                        </form>
                    </div>
                    <div class="col-md-3"></div>
                </div>
                <div class="esp15"></div>
                <div class="row">
                    <div class="col-md-8"></div>
                    <div class="col-md-4">
                        <a href="carregaproduto.html">Carregar todos os Produtos</a>
                    </div>
                </div>
                <c:if test="${not empty listaProduto}">
                    <div class="esp15"></div>
                    <c:forEach var="produto" items="${listaProduto}">
                        <div class="card">
                            <div class="card-header">
                                <label><h5>Nome: ${produto.produto}</h5></label>
                            </div>
                            <div class="card-body">
                                <p class="card-text">ID: ${produto.idproduto}</p>
                                <p class="card-text">R$ ${produto.venda}</p>
                                <a href="excluirproduto.html?id=${produto.idproduto}" class="btn btn-primary">Excluir</a>
                                <a href="editarproduto.html?id=${produto.idproduto}" class="btn btn-primary">Editar</a>
                            </div>
                        </div>
                        <div class="esp15"></div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
        <%
            } else {
                response.sendRedirect("index.jsp");
            }
        %>
        <footer>
            <c:import url="include/rodape.jsp"/>
        </footer>
    </body>
</html>