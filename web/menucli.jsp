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
        <title>JSP Page</title>
    </head>
    <body>
        <nav>
            <c:if test="${not empty c}">
                <c:import url="include/navlogout.jsp"/>
            </c:if>
            <c:if test="${empty c}">
                <c:import url="include/navlogin.jsp"/>
            </c:if>
            <c:import url="include/menuprod.jsp"/>
        </nav>
        <c:if test="${not empty c}">
            <div class="esp50"></div>
            <div class="corpo">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="row">
                                <div class="col-md-12"><center><h4>Dados Pessoais:</h4></center></div>
                            </div>
                            <div class="row">
                                <c:forEach var="cliente" items="${listaCliente}">
                                    <div class="col-md-12">
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
                                        <form action="cadcliente.html" method="POST">
                                            <div class="form-group row">
                                                <label for="email" class="col-md-4 col-form-label">E-mail:</label>
                                                <div class="col-md-8">
                                                    <input type="email" class="form-control" id="email" name="email" placeholder="Ex.: exemplo@exemplo.com" value="${cliente.emailcli}"/>
                                                    </div>
                                                </div>
                                                <div class="esp5"></div>
                                                <hr/>
                                                <div class="esp5"></div>
                                                <div class="esp5"></div>
                                                <hr/>
                                                <div class="esp5"></div>
                                                <div class="form-row">
                                                    <div class="col-md-6">
                                                        <!-- PESSOA FÍSICA -->
                                                        <div id="pesfisica">
                                                            <div class="row">
                                                                <div class="col-md-12"><center><h4>Dados cadastrais</h4></center></div>
                                                            </div>
                                                            <div class="row"><div class="col-md-12 esp5"></div></div>
                                                            <c:if test="${cliente.tipocli == 'PF'}">
                                                            <div class="form-group row">
                                                                <label for="nomecli" class="col-md-4 col-form-label">Nome:</label>
                                                                <div class="col-md-8">
                                                                    <input type="text" class="form-control" id="nomecli" name="nomecli" value="${cliente.cliente}"/>
                                                                </div>
                                                            </div>	
                                                            <div class="form-group row">
                                                                <label for="sobrenome" class="col-md-4 col-form-label">Sobrenome:</label>
                                                                <div class="col-md-8">
                                                                    <input type="text" class="form-control" id="sobrenome" name="sobrenome" value="${cliente.snome}"/>
                                                                </div>
                                                            </div>
                                                            <div class="form-group row">
                                                                <label class="col-md-4 col-form-label" for="sexo">Sexo</label>
                                                                <div class="col-md-8">
                                                                    <select class="custom-select form-control" id="sexo" name="sexo" value="${cliente.sexo}">
                                                                        <option value="M">Masculino</option>
                                                                        <option value="F">Feminino</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="form-group row">
                                                                <label for="cpf" class="col-md-4 col-form-label">CPF:</label>
                                                                <div class="col-md-8">
                                                                    <input type="text" class="form-control" id="cpf" name="cpf" value="${cliente.cadfed}"/>
                                                                </div>
                                                            </div>
                                                            <div class="form-group row">
                                                                <label for="rg" class="col-md-4 col-form-label">Identidade:</label>
                                                                <div class="col-md-8">
                                                                    <input type="text" class="form-control" id="rg" name="rg" value="${cliente.cadest}"/>
                                                                </div>
                                                            </div>
                                                            <div class="form-group row">
                                                                <label for="nasc" class="col-md-4 col-form-label">Data de Nascimento:</label>
                                                                <div class="col-md-8">
                                                                    <input type="text" class="form-control" id="nasc" name="nasc" value="${cliente.dtnasc}"/>
                                                                </div>
                                                            </div>
                                                            <div class="form-group row">
                                                                <label for="tel" class="col-md-4 col-form-label">Telefone:</label>
                                                                <div class="col-md-8">
                                                                    <input type="text" class="form-control" id="tel" name="tel" value="${cliente.telcli}"/>
                                                                </div>
                                                            </div>
                                                            <div class="form-group row">
                                                                <label for="cel" class="col-md-4 col-form-label">Celular:</label>
                                                                <div class="col-md-8">
                                                                    <input type="text" class="form-control" id="cel" name="cel" value="${cliente.cadfed}"/>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${cliente.tipocli == 'PJ'}">
                                                        <div id="pesjuridica">
                                                            <div class="row">
                                                                <div class="col-md-12"><center><h4>Dados cadastrais</h4></center></div>
                                                            </div>
                                                            <div class="row"><div class="col-md-12 esp5"></div></div>
                                                            <div class="form-group row">
                                                                <label for="rsocial" class="col-md-4 col-form-label">Razão Social:</label>
                                                                <div class="col-md-8">
                                                                    <input type="text" class="form-control" id="rsocial" name="rsocial" value="${cliente.cliente}"/>
                                                                    </div>
                                                                </div>	
                                                                <div class="form-group row">
                                                                    <label for="fantasia" class="col-md-4 col-form-label">Nome Fantasia:</label>
                                                                    <div class="col-md-8">
                                                                        <input type="text" class="form-control" id="fantasia" name="fantasia" value="${cliente.snome}"/>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                    <label for="cnpj" class="col-md-4 col-form-label">CNPJ:</label>
                                                                    <div class="col-md-8">
                                                                        <input type="text" class="form-control" id="cnpj" name="cnpj" value="${cliente.cadfed}"/>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                    <label for="insest" class="col-md-4 col-form-label">Inscrição Estadual:</label>
                                                                    <div class="col-md-8">
                                                                        <input type="text" class="form-control" id="insest" name="insest" value="${cliente.cadest}"/>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                    <label for="telpj" class="col-md-4 col-form-label">Telefone:</label>
                                                                    <div class="col-md-8">
                                                                        <input type="text" class="form-control" id="telpj" name="telpj" value="${cliente.telcli}"/>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                    <label for="celpj" class="col-md-4 col-form-label">Celular:</label>
                                                                    <div class="col-md-8">
                                                                        <input type="text" class="form-control" id="celpj" name="celpj" value="${cliente.celcli}"/>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                    </c:if>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="row">
                                                        <div class="col-md-12"><center><h4>Endereço de entrega</h4></center></div>
                                                    </div>
                                                    <div class="row"><div class="col-md-12 esp5"></div></div>
                                                    <div class="form-group row">
                                                        <label for="cep" class="col-md-4 col-form-label">CEP:</label>
                                                        <div class="col-md-8">
                                                            <input type="text" class="form-control" id="cep" name="cep" onblur="pesquisacep(this.value)" value="${cliente.cepcli}"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="end" class="col-md-4 col-form-label">Rua:</label>
                                                        <div class="col-md-8">
                                                            <input type="text" class="form-control" id="end" name="end" readonly value="${cliente.endcli}"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="numero" class="col-md-4 col-form-label">Número:</label>
                                                        <div class="col-md-8">
                                                            <input type="text" class="form-control" id="numero" name="numero" value="${cliente.numcli}"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="comp" class="col-md-4 col-form-label">Complemento:</label>
                                                        <div class="col-md-8">
                                                            <input type="text" class="form-control" id="comp" name="comp" value="${cliente.complcli}"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="ref" class="col-md-4 col-form-label">Referência:</label>
                                                        <div class="col-md-8">
                                                            <input type="text" class="form-control" id="ref" name="ref" value="${cliente.refcli}"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="bairro" class="col-md-4 col-form-label">Bairro:</label>
                                                        <div class="col-md-8">
                                                            <input type="text" class="form-control" id="bairro" name="bairro" readonly value="${cliente.bairrocli}"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="cid" class="col-md-4 col-form-label">Cidade:</label>
                                                        <div class="col-md-8">
                                                            <input type="text" class="form-control" id="cid" name="cid" readonly value="${cliente.cidcli}"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="est" class="col-md-4 col-form-label">Estado:</label>
                                                        <div class="col-md-8">
                                                            <input type="text" class="form-control" id="est" name="est" readonly value="${cliente.estcli}"/>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="esp15"></div>
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
                                        </form>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="col-md-6"><center><h4>Pedidos:</h4></center></div>
                    </div>
                </div>
            </div>
            <footer>
                <c:import url="include/rodape.jsp"/>
            </footer>
        </c:if>
        <c:if test="${empty c}">
            <% response.sendRedirect("index.jsp");%>
        </c:if>
        <!--	JS Bootstrap	-->
        <script type="text/javascript" src="bootstrap/jquery/jquery-3.3.1.slim.min.js"></script>
        <script type="text/javascript" src="bootstrap/popper/popper.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
