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
        <link rel="stylesheet" type="text/css" href="recursos/estilo/telaprod.css"/>
        <script type="text/javascript" src="recursos/js/functop.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <nav>
            <c:if test="${not empty f or not empty c}">
                <c:import url="include/navlogout.jsp"/>
            </c:if>
            <c:if test="${empty f and empty c}">
                <c:import url="include/navlogin.jsp"/>
            </c:if>
            <c:if test="${not empty f}">
                <c:import url="include/navfun.jsp"/>
            </c:if>
            <c:if test="${empty f}">
                <c:import url="include/menuprod.jsp"/>
            </c:if>
        </nav>
        <div class="esp50"></div>
        <div class="corpo">  
            <div class="container">
                <c:forEach var="produto" items="${listaProduto}">
                    <form action="addcarrinho.html" method="post">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="row">
                                    <div id="carouselExampleControls" class="carousel slide imgprod" data-ride="carousel">
                                        <div class="carousel-inner">
                                            <div class="carousel-item active">
                                                <!--<img class="d-block w-100"  src="recursos/imgprod/gx.jpg" alt="Primeiro slide">-->
                                                <img class="d-block w-100"  src="recursos/imgprod/${produto.foto1}" alt="Primeiro slide">
                                            </div>
                                            <div class="carousel-item">
                                                <!--<img class="d-block w-100"  src="recursos/imgprod/gx.jpg" alt="Primeiro slide">-->
                                                <img class="d-block w-100"  src="recursos/imgprod/${produto.foto2}" alt="Segundo slide">
                                            </div>
                                            <div class="carousel-item">
                                                <!--<img class="d-block w-100"  src="recursos/imgprod/gx.jpg" alt="Primeiro slide">-->
                                                <img class="d-block w-100"  src="recursos/imgprod/${produto.foto3}" alt="Terceiro slide">
                                            </div>
                                            <div class="carousel-item">
                                                <!--<img class="d-block w-100"  src="recursos/imgprod/gx.jpg" alt="Primeiro slide">-->
                                                <img class="d-block w-100"  src="recursos/imgprod/${produto.foto4}" alt="Quarto slide">
                                            </div>
                                            <div class="carousel-item">
                                                <!--<img class="d-block w-100"  src="recursos/imgprod/gx.jpg" alt="Primeiro slide">-->
                                                <img class="d-block w-100"  src="recursos/imgprod/${produto.foto5}" alt="Quinto slide">
                                            </div>
                                        </div>
                                        <a class="carousel-control-prev btnmudafoto" href="#carouselExampleControls" role="button" data-slide="prev">
                                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                            <span class="sr-only">Previous</span>
                                        </a>
                                        <a class="carousel-control-next btnmudafoto" href="#carouselExampleControls" role="button" data-slide="next">
                                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                            <span class="sr-only">Next</span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6" >
                                <div class="coluninha">
                                    <div class="tlcod">
                                        <h4 >${produto.produto}</h4>
                                    </div>
                                    <div class="tlcod">
                                        <strong id="cod" title="codigo do produto">Codígo: </strong>
                                        <input type="text" name="id" value="${produto.idproduto}" readonly/>
                                    </div>
                                    <c:if test="${produto.qtd >0}">
                                        <div class="tldisp">
                                            <strong>Disponibilidade:</strong>
                                            <span id="em"> Em estoque</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${produto.qtd == 0 or produto.qtd<0}">
                                        <div class="tldisp">
                                            <strong>Disponibilidade:</strong>
                                            <h5>Produto indisponível</h5>
                                        </div>
                                    </c:if>
                                    <hr>
                                    <div class="preco">
                                        <strong>Valor:</strong>
                                        <label id="vis">R$ ${produto.venda}</label>
                                    </div>
                                    <div class="col-md-10">
                                        <label>quantidade</label>
                                        <input min="1" max="${produto.qtd}" type="number" name="qtd" value="1"/>
                                    </div>
                                    <hr>
                                    <div>
                                        <img  id="imagemcart" src="recursos/imagens/0028110001523475662.png" />
                                    </div>
                                    <div class="section"  style="padding-bottom:20px;">
                                        <c:if test="${produto.qtd>0}">
                                            <input type="submit" class="btn btn-success " id="botao" value="Adicionar ao carrinho"/>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <div class="row">
                        <div class="col-md-2"></div>
                        <div class="col-md-8">
                            <label>${produto.descricao}</label>
                        </div>
                        <div class="col-md-2"></div>
                    </div>
                </c:forEach>
                <div class="btopo">
                    <a id="btopo" title="voltar ao topo" href="#"> 
                        <a title="botao para subir" onclick="topFunction()" id="myBtn" title="Go to top">Topo</a>
                </div>
            </div><!--fechando container -->
        </div><!--fechando div corpo -->
        <footer>
            <c:import url="include/rodape.jsp"/>
        </footer>
        <!--	JS Bootstrap	-->
        <script type="text/javascript" src="bootstrap/jquery/jquery-3.3.1.slim.min.js"></script>
        <script type="text/javascript" src="bootstrap/popper/popper.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>