<%-- 
    Document   : cadprod
    Created on : 24/09/2018, 18:40:30
    Author     :Putão
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Hello, world!</title>
  </head>
  <body>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
   
    <form>
         <div class="esp50"></div>
        <div class="corpo">
            <div class="container">
                <div class="esp15"></div>
                <div class="row">
                    <div class="col-md-12">
                        <center><h3>Cadastro de Produtos</h3></center>
                        <hr>
                    </div>
                </div>
                <div class="esp15"></div>
                <form action="cadfornecedor.html" method="POST">
                    
                    <div class="form-group  row">
                        <label for="nfor" class="col-md-1 col-form-label">Nome:</label>
                        <div class="col-md-7">
                            <input type="text" class="form-control" id="nfor" name="nfor" placeholder="Informe o nome do fornecedor"/>
                        </div>
                   
                    </div>
                    
                    
                        <div class="form-row">
                
                        <label for="telfor" class="form-group col-md-1">fornecedor:</label>
                        <div class="form-group col-md-7">
                            <select type="text" class="form-control" id="telfor" name="telfor" placeholder="Ex.: (xx) xxxx-xxxx">
                              <option selected>Abra este menu select</option>
                                <option value="1">Um</option>
                                 <option value="2">Dois</option>
                                      <option value="3">Três</option>
                        </select> 
                        </div>
                    </div>
                    
                        <div class="form-row">
                
                        <label for="telfor" class="form-group col-md-1">categoria:</label>
                        <div class="form-group col-md-7">
                            <select type="text" class="form-control" id="telfor" name="telfor" placeholder="Ex.: (xx) xxxx-xxxx">
                              <option selected>Abra este menu select</option>
                                <option value="1">Um</option>
                                 <option value="2">Dois</option>
                                      <option value="3">Três</option>
                        </select> 
                        </div>
                    </div>
                    
                    
                    
                    
         
                    <div class="form-group row">
                        <div class="form-group row"> 
                            <label class=" col-md-5 col-form-label" for="text">Valor de compra</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" id="emailfor" name="emailfor" placeholder="Digite o valor de compra"/>
                            </div>
                        </div>
                        
                        <div class="form-group row"> 
                            <label class=" col-md-5 col-form-label" for="text">Valor de venda</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" id="emailfor" name="emailfor" placeholder="Digite o valor de compra"/>
                            </div>
                        </div>
                            <div class="form-group row"> 
                            <label class=" col-md-5 col-form-label" for="text">qauntidade</label>
                            <div class="col-md-4">
                                <input type="text" class="form-control" id="emailfor" name="emailfor" placeholder="Digite o valor de compra"/>
                            </div>
                        </div>
            </div>           
                    
               
                    
                    <div class="esp5"></div>
                    <hr/>
                    
                   ​<picture>
                   <img src="..." class="rounded float-left" alt="...">
                   <img src="..." class="rounded float-right" alt="...">
                  
                   <div class="text-center">
                    <img src="..." class="rounded" alt="...">
</div>
                        ​</picture>
                          <hr/>
        
    </form>
    
    
    
  </body>
</html>
