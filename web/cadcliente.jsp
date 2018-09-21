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
                <script type="text/javascript" src="bootstrap/jquery/jquery-3.3.1.slim.min.js"></script>
                <script type="text/javascript" src="bootstrap/popper/popper.min.js"></script>
                <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
            <!--	Font Awesome -->
                <link href="recursos/fontawesome/css/all.css" rel="stylesheet"/>
            <!--    Codificação própria -->
                <script type="text/javascript" src="recursos/js/cep.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
			<form action="" method="POST">
				<div action="form-group row">
					<label for="email" class="col-md col-form-label">E-mail:</label>
					<div class="col-md-8">
						<input type="text" class="form-control" id="email" name="email" placeholder="Ex.: exemplo@exemplo.com"/>
					</div>
				</div>
				<div class="form-group row">
                    <label for="senha" class="col-md- col-form-label">Senha:</label>
					<div class="col-md-8">
						<input type="senha" class="form-control" id="senha" name="senha" placeholder="Digite a senha"/>
                    </div>
                </div>
				<div class="form-group row">
                    <label for="reptsenha" class="col-md- col-form-label">Repetir senha:</label>
                    <div class="col-md-8">
                        <input type="url" class="form-control" id="reptsenha" name="reptsenha" placeholder="Repetir senha"/>
                    </div>
                </div>
			<div class="row">
                <div class="col-md-6">
					<h4>Dados cadastrais</h4>
                    <div class="form-group row">
                        <label for="nomecli" class="col-md-2 col-form-label">Nome:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="nomecli" name="nomecli" readonly/>
                        </div>
                    </div>	
					<div class="form-group row">
                        <label for="sobrenome" class="col-md-2 col-form-label">Sobrenome:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="sobrenome" name="sobrenome"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="mr-sm-2"class="col-md-1" for="inlineFormCustomSelect">Sexo</label>
						<select class="custom-select mr-sm-" id="inlineFormCustomSelect">
							<option selected>Selecione</option>
							<option value="1">Masculino</option>
							<option value="2">Feminino</option>
						</select>
                    </div>
					<div class="form-group row">
                        <label for="cpf" class="col-md-2col-form-label">CPF:</label>
							<div class="col-md-8">
                                <input type="text" class="form-control" id="cpf" name="cpf"/>
                            </div>
                    </div>
					<div class="form-group row">
                        <label for="tel" class="col-md-2 col-form-label">Telefone:</label>
							<div class="col-md-8">
                                <input type="text" class="form-control" id="tel" name="tel"/>
                            </div>
                    </div>
					<div class="form-group row">
                        <label for="cel" class="col-md-2 col-form-label">Celular:</label>
							<div class="col-md-8">
                                <input type="text" class="form-control" id="cel" name="cel"/>
                            </div>
                    </div>
					<div class="form-group row">
                        <label for="nasc" class="col-md-2 col-form-label">Nascimento:</label>
							<div class="col-md-8">
                                <input type="text" class="form-control" id="nasc" name="nasc"/>
								<input type="checkbox" class="custom-control-input" id="customCheck1">
								<label class="custom-control-label" for="customCheck1">Receber ofertas e novidade por E-mail</label>
							</div>
							
                    </div>
                </div>
				<div class="col-md-6">
					<h4>Endereço de entrega</h4>
					<div class="form-group row">
                        <label for="cep" class="col-md-2 col-form-label">CEP:</label>
                            <div class="col-md-8">
                            <input type="text" class="form-control" id="cep" name="cep" readonly/>
                            </div>
                    </div>
					<div class="form-group row">
                        <label for="rua" class="col-md-2 col-form-label">Rua:</label>
                            <div class="col-md-8">
                            <input type="text" class="form-control" id="rua" name="rua" readonly/>
                            </div>
                    </div>
					<div class="form-group row">
                        <label for="numero" class="col-md-2 col-form-label">Número:</label>
                            <div class="col-md-8">
                            <input type="text" class="form-control" id="numero" name="numero" readonly/>
                            <input type="checkbox" class="custom-control-input" id="customCheck1">
							<label class="custom-control-label" for="customCheck1">Sem número</label>
							</div>
					</div>
					<div class="form-group row">
                        <label for="comp" class="col-md-3 col-form-label">Complemento:</label>
                            <div class="col-md-8">
                            <input type="text" class="form-control" id="comp" name="comp" readonly/>
                            </div>
                    </div>
					<div class="form-group row">
                        <label for="ref" class="col-md-2 col-form-label">Referência:</label>
                            <div class="col-md-8">
                            <input type="text" class="form-control" id="ref" name="ref" readonly/>
                            </div>
                    </div>
					<div class="form-group row">
                        <label for="bairro" class="col-md-2 col-form-label">Bairro:</label>
                            <div class="col-md-8">
                            <input type="text" class="form-control" id="bairro" name="bairro" readonly/>
                            </div>
                    </div>
					<div class="form-group row">
                        <label for="cidade" class="col-md-2 col-form-label">Cidade:</label>
                            <div class="col-md-8">
                            <input type="text" class="form-control" id="cidade" name="cidade" readonly/>
                            </div>
                    </div>
					<div class="form-group row">
                        <label for="estado" class="col-md-2 col-form-label">Estado:</label>
                            <div class="col-md-8">
                            <input type="text" class="form-control" id="estado" name="estado" readonly/>
                            </div>
                    </div>
					<div class="form-group">
						<label class="col-md-4 control-label" for="idConfirmar"></label>
						<div class="col-md-8">
							<button id="idConfirmar" name="idConfirmar" class="btn btn-success">Cadastrar</button>
						</div>
					</div>
				</div>
			</div>
				
            </div>
    </body>
</html>
