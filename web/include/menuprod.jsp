<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="dao" class="br.com.projetofinal.dao.SetorDao"/>
<jsp:useBean id="dado" class="br.com.projetofinal.dao.CategoriaDao"/>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#conteudoNavbarSuportado" aria-controls="conteudoNavbarSuportado" aria-expanded="false" aria-label="Alterna navegaÃ§Ã£o">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
            <ul class="navbar-nav mr-auto">
                <c:forEach var="lista" items="${dao.buscarsetor()}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${lista.setor}
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <c:forEach var="lista" items="${dado.buscarcategoria()}">
                            <a class="dropdown-item" href="pesqporcat.html?id=${lista.idcategoria}">${lista.categoria}</a>
                        </c:forEach>
                    </div>
                </li>
                </c:forEach>
            </ul>
            <form action="pesquisaproduto.html" method="post" class="form-inline my-2 my-lg-0">
                <input id="dado" name="dado" class="form-control mr-sm-2" type="search" placeholder="Pesquisar" aria-label="Pesquisar"/>
                <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Pesquisar</button>
            </form>
        </div>
    </div>
</nav>