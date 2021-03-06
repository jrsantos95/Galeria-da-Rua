<%-- 
    Document   : PaginaCadastroObra
    Created on : 22/07/2020, 14:14:58
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Galeria da Rua</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    
    <!-- Barra de navegação -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light mb-5">
        <div class="container">
            <a class="navbar-brand" href="http://localhost:8080/PI_GaleriaRua/pg_artistaFoto">
                <svg class="bi bi-layout-wtf" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M5 1H1v8h4V1zM1 0a1 1 0 0 0-1 1v8a1 1 0 0 0 1 1h4a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1H1zm13 2H9v5h5V2zM9 1a1 1 0 0 0-1 1v5a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H9zM5 13H3v2h2v-2zm-2-1a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1H3zm12-1H9v2h6v-2zm-6-1a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1H9z"/>
                </svg>
                Galeria da Rua
            </a>
            <div class="navbar-nav mr-auto">
                  <a class="nav-item nav-link" href="http://localhost:8080/PI_GaleriaRua/pg_artistaFoto">Perfil</a>
                  <a class="nav-item nav-link" href="http://localhost:8080/PI_GaleriaRua/pg_ModificaPerfilArtista?cod_usuario=${sessionScope['usuarioLogado'].cod_usuario}">Modificar Perfil</a>
                  <a class="nav-item nav-link" href="http://localhost:8080/PI_GaleriaRua/pg_cadastroObra">Cadastrar Obra</a>
                  <a class="nav-item nav-link" href="http://localhost:8080/PI_GaleriaRua/pg_MostraObras?cod_artisFoto=${sessionScope['usuarioLogado'].cod_artistFoto}">Obras Pessoais</a>
            </div>
        </div>
        <a>${sessionScope['usuarioLogado'].nome}</a>
        <a class="btn btn-default navbar-btn" href="http://localhost:8080/PI_GaleriaRua/logout">
            Logout
            <svg class="bi bi-box-arrow-left" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" d="M4.354 11.354a.5.5 0 0 0 0-.708L1.707 8l2.647-2.646a.5.5 0 1 0-.708-.708l-3 3a.5.5 0 0 0 0 .708l3 3a.5.5 0 0 0 .708 0z"/>
                <path fill-rule="evenodd" d="M11.5 8a.5.5 0 0 0-.5-.5H2a.5.5 0 0 0 0 1h9a.5.5 0 0 0 .5-.5z"/>
                <path fill-rule="evenodd" d="M14 13.5a1.5 1.5 0 0 0 1.5-1.5V4A1.5 1.5 0 0 0 14 2.5H7A1.5 1.5 0 0 0 5.5 4v1.5a.5.5 0 0 0 1 0V4a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 .5.5v8a.5.5 0 0 1-.5.5H7a.5.5 0 0 1-.5-.5v-1.5a.5.5 0 0 0-1 0V12A1.5 1.5 0 0 0 7 13.5h7z"/>
            </svg>
        </a>
    </nav>
    <!-- Barra de navegação -->
  </head>
  
  <body>
    <!-- Dados de cadastro -->
    <div class="container">
        <div class="row my-5 mb-5">    
            <div class="col-1">
            </div>
            <div class="col-10">
                <div class="mx-auto col-lg-12 col-15">
                    <!-- Formulario/Dados de cadastro -->
                    <form role="form" action="ModificaArtista?cod_usuario=${cod_usuario}&cod_pg=2" method="POST">
                        <div class="tab-content" id="myTabContent">
                            
                            <fieldset disabled>
                                <div class="form-group">
                                  <label for="disabledTextInput">Codigo</label>
                                  <input type="text" placeholder="${cod_usuario}"
                                         class="form-control">
                                </div>
                            </fieldset>

                            <div class="was-validated mb-2">
                                <label for="exampleFormControlInput1">Nome</label>
                                <input type="text" class="form-control" name="nome" value="${nome}" required>
                            </div> 

                            <div class="mb-2 col-md-13  was-validated">  
                                <label for="validationTooltip01">TAG</label>
                                <div class="input-group-prepend">
                                  <div class="input-group-text">@</div>
                                  <input type="text" class="form-control" name="tag" value="${tag}" required>
                                </div>
                            </div> 

                            <div class="was-validated mb-2">
                                <label for="exampleFormControlInput1">Email</label>
                                <input type="email" class="form-control" name="email" value="${email}" required>
                            </div>

                            <div class="was-validated input-grup date">                            
                              <div class="col-md-13 mb-2">
                                  <label for="validationTooltip01">Data de Nascimento</label>
                                  <input type="data" class="form-control" name="idade" value="${idade}" required>
                              </div> 
                            </div>

                            <div class="was-validated"> 
                                <label for="form18">Linguagem do Trabalho</label> 
                                <input type="text" class="form-control" name="linguagem" required value="${linguagem}" required> 
                            </div>

                            <div class="was-validated"> 
                                <label for="form18">Contato</label> 
                                <input type="text" class="form-control" name="contato" value="${contato}" required> 
                            </div>

                            <div class="form-group was-validated"> 
                                <label>Descrição Pessoal</label>
                                <textarea class="form-control" name="desc_artist_foto" rows="3" 
                                          value="${desc_artist_foto}" required>${desc_artist_foto}</textarea>
                            </div>
                            
                            <div class="was-validated"> 
                                <label for="form18">Pais</label> 
                                <input type="text" class="form-control" name="pais" value="${pais}" required> 
                            </div>
                            
                            <div class="was-validated"> 
                                <label for="form18">Cidade</label> 
                                <input type="text" class="form-control" name="cidade" value="${cidade}" required> 
                            </div>

                            <div class="was-validated">
                              <div class="col-md-13"> 
                                  <label for="form19">Senha</label> 
                                  <input type="text" class="form-control" name="senha" value="${senha}" required> 
                              </div>
                              <div class="form-group col-md-13"> 
                                  <label for="form20">Confirmar Senha</label> 
                                  <input type="text" class="form-control" name="confirmaSenha" value="${senha}" required> 
                              </div>
                            </div>
                        </div>  
                    <button type="submit" class="btn btn-dark">Modificar</button>
                    <a href="http://localhost:8080/PI_GaleriaRua/pg_artistaFoto" class="btn btn-danger">Cancelar</a>
                </form>
                </div>
            </div>
        </div>
    </div>
    <!-- Dados de cadastro -->
      
    <!-- Footer -->
    <div class="container my-5 mb-5">
        <nav class="navbar navbar-expand-lg navbar-dark bg-light">
          <a class="col-12 text-center">Acompanhe nossas redes sociais</a>
        </nav>
    </div>
    <div class="container">
        <div class="row my-5 mb-5">
            <div class="row">

                <div class="col-2">
                    <div data-spy="scroll" data-target="#navbar-example3" data-offset="0" class="scroollspyPaginaInicial.css">
                        <h4 id="item-1">Galeria da Rua</h4>
                        <p>A Galeria da Rua foi criada pensando em você, que quer uma decoração diferenciada gastando pouco.
                           Artes exclusivas, com tiragens limitadas e com um preço acessível, democratizando a arte!
                        </p>
                    </div>
                      <div class="card-body">
                      </div>
                </div>

                <div class="col-2">
                    <div data-spy="scroll" data-target="#navbar-example3" data-offset="0" class="scroollspyPaginaInicial.css">
                        <h4 id="item-1">Parcerias</h4>
                          <p>Ex consequat commodo adipisicing exercitation aute excepteur occaecat ullamco duis aliqua id 
                            magna ullamco eu. Do aute ipsum ipsum ullamco cillum consectetur ut et aute consectetur 
                            </p>
                    </div>
                </div>

                <div class="col-2">
                    <div data-spy="scroll" data-target="#navbar-example3" data-offset="0" class="scroollspyPaginaInicial.css">
                        <h4 id="item-1">Atendimento</h4>
                          <p>Ex consequat commodo adipisicing exercitation aute excepteur occaecat ullamco duis aliqua id 
                            magna ullamco eu. Do aute ipsum ipsum ullamco cillum consectetur ut et aute consectetur 
                            </p>  

                    </div>
                </div>

                <div class="col-2">
                    <div data-spy="scroll" data-target="#navbar-example3" data-offset="0" class="scroollspyPaginaInicial.css">
                        <h4 id="item-1">Contato</h4>
                          <p>Ex consequat commodo adipisicing exercitation aute excepteur occaecat ullamco duis aliqua id 
                            magna ullamco eu. Do aute ipsum ipsum ullamco cillum consectetur ut et aute consectetur 
                          </p>
                    </div>
                </div>

                <div class="col-1">
                    <div data-spy="scroll" data-target="#navbar-example3" data-offset="0" class="scroollspyPaginaInicial.css">
                    </div>
                </div>

                <div class="card" style="width: 18rem;">
                    <img src="Imagens/Sem título.png" class="card-img-top" alt="...">
                    <div class="card-body">
                      <h4 id="item-1">Colaboradores</h4>
                      <p class="card-text">Para de trabalhar o merda e começa a aproveitar 
                          um pouco do que nada importa (acorda, percebe que vc está bebado em quarentena (24/05/2020), 
                          good nights. Até que enfim!</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer -->
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS    -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>
