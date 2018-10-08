<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#conteudoNavbarSuportado" aria-controls="conteudoNavbarSuportado" aria-expanded="false" aria-label="Alterna navegaÃ§Ã£o">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Cliente
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="cadcliente.jsp">Cadastrar</a>
                        <a class="dropdown-item" href="consultarcliente.jsp">Pesquisar</a>
                    </div>
                </li>
            </ul>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Funcionário
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/ProjetoFinal/loadfuncao.html">Cadastrar</a>
                        <a class="dropdown-item" href="consultarfuncionario.jsp">Pesquisar</a>
                    </div>
                </li>
            </ul>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Produto
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/ProjetoFinal/carregacadprod.html">Cadastrar</a>
                        <a class="dropdown-item" href="consultaproduto.jsp">Pesquisar</a>
                    </div>
                </li>
            </ul>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Outros
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="cadfuncao.jsp">Cadastrar Função</a>
                        <a class="dropdown-item" href="cadsetor.jsp">Cadastrar Setor</a>
                        <a class="dropdown-item" href="/ProjetoFinal/loadsetor.html">Cadastrar Categoria</a>
                    </div>
                </li>
            </ul>
            <ul class="navbar-nav mr-auto">
                <a class="nav-link" href="/ProjetoFinal/menufun.jsp" id="navbarDropdown">
                    Menu
                </a>
            </ul>
            <form action="pesquisaproduto.html" method="post" class="form-inline my-2 my-lg-0">
                <input id="dado" name="dado" class="form-control mr-sm-2" type="search" placeholder="Pesquisar" aria-label="Pesquisar"/>
                <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Pesquisar</button>
            </form>
        </div>
    </div>
</nav>