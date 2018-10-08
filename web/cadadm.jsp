<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" type="text/css" href="recursos/estilo/reset.css"/>
        <link rel="stylesheet" type="text/css" href="recursos/estilo/estilo.css"/>
        <!--	Bootstrap	-->
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css"/>
        <!--	Font Awesome -->
        <link href="recursos/fontawesome/css/all.css" rel="stylesheet"/>
        <title>SenTec</title>
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
        </nav>
        <div class="esp50"></div>
        <div class="corpo">
            <div class="container">
                <div class="esp15"></div>
                <div class="row">
                    <div class="col-md-12">
                        <center><h3>Cadastro de Funcionário</h3></center>
                        <hr>
                    </div>
                </div>
                <c:if test="${not empty avisos}">
                    <div class="alert alert-success">
                        <p>${avisos}</p>
                    </div>
                </c:if>
                <c:if test="${not empty erros}">
                    <div class="alert alert-danger">
                        <p>${erros}</p>
                    </div>
                </c:if>
                <c:if test="${not empty alertas}">
                    <div class="alert alert-warning">
                        <p>${alertas}</p>
                    </div>
                </c:if>
                <div class="esp15"></div>
                <c:if test="${empty listaFuncionario}">
                    <form action="cadfuncionario.html" method="POST" id="cadfuncionario">
                        <div class="form-group row">
                            <label for="nfu" class="col-md-4 col-form-label">Nome do Funcionário:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="nfu" name="nfun" placeholder="Informe o nome do funcionário" value="${funcionario.funcionario}"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="emailfun" class="col-md-4 col-form-label">E-mail do Funcionário:</label>
                            <div class="col-md-8">
                                <input type="email" class="form-control" id="emailfun" name="emailfun" placeholder="Ex.: exemplo@exemplo.com"  value="${funcionario.emailfunc}"/>
                            </div>
                        </div>
                        <c:if test="${empty editaFuncionario}">
                            <div class="form-group row">
                                <label for="senhafun" class="col-md-4 col-form-label">Senha do Funcionário:</label>
                                <div class="col-md-8">
                                    <input type="password" class="form-control" id="senhafun" name="senhafun" placeholder="Informe a senha"  value="${funcionario.senhafunc}"/>
                                </div>
                            </div>
                        </c:if>
                        <div class="form-group row">
                            <label for="telfu" class="col-md-4 col-form-label">Telefone do Funcionário:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="telfu" name="telfun" placeholder="Ex.: (xx) xxxx-xxxx"  value="${funcionario.telfunc}"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="celfu" class="col-md-4 col-form-label">Celular do Funcionário:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="celfu" name="celfun" placeholder="Ex.: (xx) xxxx-xxxx"  value="${funcionario.celfunc}"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="cpffu" class="col-md-4 col-form-label">CPF do Funcionário:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="cpffu" name="cpffu"  value="${funcionario.cpffunc}"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="funcaofu" class="col-md-4 col-form-label">Selecione a função:</label>
                            <div class="col-md-8">
                                <select name="funcaofu" class="form-control" id="funcaofu">
                                    <option value="1">Administrador</option>
                                </select>
                            </div>
                        </div>
                        <div class="esp5"></div>
                        <hr/>
                        <!--    DADOS DO BUSCA CEP  -->
                        <div class="esp5"></div>
                        <div class="form-group row">
                            <label for="cep" class="col-md-4 col-form-label">Informe o CEP do Fornecedor:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="cep" name="cep" onblur="pesquisacep(this.value)"  value="${funcionario.cepfunc}"/>
                            </div>
                        </div>
                        <div class="esp5"></div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group row">
                                    <label for="end" class="col-md-4 col-form-label">Endereço:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="end" name="end" value="${funcionario.endfunc}" readonly/>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="numfu" class="col-md-4 col-form-label">Número:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="numfu" name="numfu" value="${funcionario.numfunc}"/>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="complfun" class="col-md-4 col-form-label">Complemento:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="complfu" name="complfu" value="${funcionario.complfunc}"/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group row">
                                    <label for="bairro" class="col-md-4 col-form-label">Bairro:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="bairro" name="bairro" value="${funcionario.bairrofunc}" readonly/>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="cid" class="col-md-4 col-form-label">Cidade:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="cid" name="cid" value="${funcionario.cidfunc}" readonly/>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="est" class="col-md-4 col-form-label">Estado:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="est" name="est" value="${funcionario.estfunc}" readonly/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="esp5"></div>
                        <hr/>
                        <div class="esp15"></div>
                        <div class="row">
                            <div class="col-md-5">
                                <button type="button" class="btn btn-danger btn-block">Cancelar</button>
                            </div>
                            <div class="col-md-2 esp5"></div>
                            <div class="col-md-5">
                                <button type="submit" class="btn btn-danger btn-block">Cadastrar</button>
                            </div>
                        </div>
                        <div class="esp50"></div>
                    </form>
                </c:if>
            </div>
        </div>
        <footer>
            <c:import url="include/rodape.jsp"/>
        </footer>
        <script type="text/javascript" src="bootstrap/jquery/jquery-3.3.1.slim.min.js"></script>
        <script type="text/javascript" src="bootstrap/popper/popper.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
        <!--    Codificação própria -->
        <script type="text/javascript" src="recursos/js/cep.js"></script>
        <script type="text/javascript" src="recursos/js/code.js"></script>
    </body>
</html>