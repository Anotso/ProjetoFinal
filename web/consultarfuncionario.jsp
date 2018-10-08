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
        <!--	Font Awesome -->
        <link href="recursos/fontawesome/css/all.css" rel="stylesheet"/>
        <!--    Codificação própria -->
        <link href="recursos/estilo/estilo.css" rel="stylesheet"/>
        <title>SenTec</title>
    </head>
    <body>
        <nav>
                        <c:if test="${not empty f}">
                <c:import url="include/navlogout.jsp"/>
            </c:if>
            <c:if test="${empty f}">
                <% response.sendRedirect("index.jsp");%>
            </c:if>
            <c:if test="${not empty f}">
                <c:import url="include/navfun.jsp"/>
            </c:if>
        </nav>
        <c:if test="${not empty f}">
        <div class="corpo">
            <div class="esp50"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <center><h3>Pesquisar Funcionário</h3></center>
                    </div>
                </div>
                <div class="esp15"></div>
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <form action="buscafuncionario.html" method="post">
                            <div class="form-group row">
                                <!---Sobre nome-->
                                <label for="bfunc" class="col-md-4 col-form-label">Informe o CPF</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="bfunc" name="bfunc"/>
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
                        <a href="carregafuncionario.html">Carregar todos os Funcionário</a>
                    </div>
                </div>
                <c:if test="${not empty listaFuncionario}">
                    <div class="esp15"></div>
                    <c:forEach var="funcionario" items="${listaFuncionario}">
                        <div class="card">
                            <div class="card-header">
                                <label><h5>Nome: ${funcionario.funcionario}</h5></label>
                            </div>
                            <div class="card-body">
                                <p class="card-text">ID: ${funcionario.idfuncionario}</p>
                                <c:if test="${not empty funcionario.telfunc}">
                                    <p class="card-text">Telefone.: ${funcionario.telfunc}</p>
                                </c:if>
                                <c:if test="${not empty funcionario.celfunc}">
                                    <p class="card-text">Celular.: ${funcionario.celfunc}</p>
                                </c:if>
                                <p class="card-text">Endereço: ${funcionario.endfunc}</p>
                                <p class="card-text">CEP.: ${funcionario.cepfunc}</p>
                                <p class="card-text">Número: ${funcionario.numfunc}</p>
                                <c:if test="${not empty funcionario.complfunc}">
                                    <p class="card-text">Complemento: ${funcionario.complfunc}</p>
                                </c:if>
                                <p class="card-text">Bairro: ${funcionario.bairrofunc}</p>
                                <p class="card-text">Cidade: ${funcionario.cidfunc}</p>
                                <p class="card-text">Estado: ${funcionario.estfunc}</p>
                                <a href="excluirfuncionario.html?id=${funcionario.idfuncionario}" class="btn btn-primary">Excluir</a>
                                <a href="editarfuncionario.html?id=${funcionario.idfuncionario}" class="btn btn-primary">Editar</a>
                            </div>
                        </div>
                        <div class="esp15"></div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
        </c:if>
        <footer>
            <c:import url="include/rodape.jsp"/>
        </footer>
        <!--	JS Bootstrap	-->
        <script type="text/javascript" src="bootstrap/jquery/jquery-3.3.1.slim.min.js"></script>
        <script type="text/javascript" src="bootstrap/popper/popper.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
