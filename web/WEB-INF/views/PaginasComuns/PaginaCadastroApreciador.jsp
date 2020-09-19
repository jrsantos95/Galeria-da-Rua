<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="pt-br">
  <head>
    <title>Galeria da Rua</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    
    <!-- Barra de navegação -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="http://localhost:8080/PI_GaleriaRua/pg_index">
                <svg class="bi bi-layout-wtf" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                     <path fill-rule="evenodd" d="M5 1H1v8h4V1zM1 0a1 1 0 0 0-1 1v8a1 1 0 0 0 1 1h4a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1H1zm13 2H9v5h5V2zM9 1a1 1 0 0 0-1 1v5a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H9zM5 13H3v2h2v-2zm-2-1a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1H3zm12-1H9v2h6v-2zm-6-1a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1H9z"/>
                </svg>
                Galeria da Rua
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
              <div class="navbar-nav mr-auto">
                  
              </div>
              <div class="navbar-nav ml-auto">
                  <a class="btn btn-default navbar-btn" href="http://localhost:8080/PI_GaleriaRua/pg_login">Entrar
                  <svg class="bi bi-box-arrow-right" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M11.646 11.354a.5.5 0 0 1 0-.708L14.293 8l-2.647-2.646a.5.5 0 0 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0z"/>
                    <path fill-rule="evenodd" d="M4.5 8a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z"/>
                    <path fill-rule="evenodd" d="M2 13.5A1.5 1.5 0 0 1 .5 12V4A1.5 1.5 0 0 1 2 2.5h7A1.5 1.5 0 0 1 10.5 4v1.5a.5.5 0 0 1-1 0V4a.5.5 0 0 0-.5-.5H2a.5.5 0 0 0-.5.5v8a.5.5 0 0 0 .5.5h7a.5.5 0 0 0 .5-.5v-1.5a.5.5 0 0 1 1 0V12A1.5 1.5 0 0 1 9 13.5H2z"/>
                  </svg>
                  </a>
                  <div class="dropdown">
                    <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Cadastrar-se
                    </a>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                      <a class="dropdown-item" href="http://localhost:8080/PI_GaleriaRua/pg_cadastroApreciador">Apreciador</a>
                      <a class="dropdown-item" href="http://localhost:8080/PI_GaleriaRua/pg_cadastroArtistaFotografo">Artista</a>
                      <a class="dropdown-item" href="http://localhost:8080/PI_GaleriaRua/pg_cadastroArtistaFotografo">Fotografo</a>
                    </div>
                  </div>
              </div>
            </div>
        </div>
    </nav>
    <!-- Barra de navegação -->
  </head>
  
  <body>
      
    <!-- Dados de cadastro -->
    <div class="container">
        <div class="row my-5 mb-5">    
            <div class="col-1">
                <a class="btn btn-dark" href="http://localhost:8080/PI_GaleriaRua/pg_index">
                    <svg class="bi bi-arrow-90deg-left" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M6.104 2.396a.5.5 0 0 1 0 .708L3.457 5.75l2.647 2.646a.5.5 0 1 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 0 1 .708 0z"/>
                        <path fill-rule="evenodd" d="M2.75 5.75a.5.5 0 0 1 .5-.5h6.5a2.5 2.5 0 0 1 2.5 2.5v5.5a.5.5 0 0 1-1 0v-5.5a1.5 1.5 0 0 0-1.5-1.5h-6.5a.5.5 0 0 1-.5-.5z"/>
                    </svg>
                </a>
            </div>
            <div class="col-10">
                <div class="mx-auto col-lg-12 col-15">
                    <!-- Cabeça opçoes -->
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                      <li class="nav-item" role="presentation">
                        <a class="nav-link active" id="home-tab" data-toggle="tab" href="#pessoa" role="tab" 
                           aria-controls="pessoa" aria-selected="true">Pessoa</a>
                      </li>
                      <li class="nav-item" role="presentation">
                        <a class="nav-link" id="localidade-tab" data-toggle="tab" href="#localidade" role="tab" 
                           aria-controls="localidade" aria-selected="false">Localidade</a>
                      </li>
                    </ul>
                    <!-- Cabeça opçoes -->
                    
                    <!-- Formulario/Dados de cadastro -->
                    <form role="form" action="CadastraApreciador" method="POST">
                        <div class="tab-content" id="myTabContent">

                            <div class="tab-pane fade show active" id="pessoa" role="tabpanel" aria-labelledby="home-tab">
                                <h1>Cadastrar-se</h1>
                                <p class="mb-3">Dados relativos a pessoa</p>

                                    <div class="was-validated">                            
                                      <div class="form-group col-md-13 mb-2">
                                          <label for="validationTooltip01">Nome</label>
                                          <input type="text" class="form-control" name="nome" placeholder="Exemplo Nome" required>
                                      </div> 
                                    </div>

                                    <div class="was-validated mb-2">
                                        <label for="exampleFormControlInput1">Email address</label>
                                        <input type="email" class="form-control" name="email" placeholder="name@example.com" required>
                                    </div>

                                    <div class="was-validated input-grup date">                            
                                      <div class="col-md-13 mb-2">
                                          <label for="validationTooltip01">Data de Nascimento</label>
                                          <input type="text" class="form-control" name="idade" placeholder="00/00/0000" required>
                                      </div> 
                                    </div> 

                                    <div class="was-validated">
                                      <div class="col-md-13"> 
                                          <label for="form19">Senha</label> 
                                          <input type="password" class="form-control" name="senha" placeholder="••••••••" required> 
                                      </div>
                                      <div class="form-group col-md-13"> 
                                          <label for="form20">Confirmar Senha</label> 
                                          <input type="password" class="form-control" name="confirmaSenha" placeholder="••••••••" required> 
                                      </div>
                                    </div>

                                    <div class="progress my-4">
                                      <div class="progress-bar bg-success" role="progressbar" style="width: 50%" aria-valuenow="50" 
                                      aria-valuemin="0" aria-valuemax="100">50%</div>
                                  </div>
                            </div>

                            <div class="tab-pane fade show" id="localidade" role="tabpanel" aria-labelledby="home-tab">
                                <h1>Cadastrar-se</h1>
                                <p class="mb-3">Dados relativos a localidade</p>
                               
                                <div class="form-group">
                                  <label for="exampleFormControlSelect2">Pais</label>
                                  <select multiple class="form-control" name="pais">
                                        <c:forEach var="paises" items="${paises}">
                                            <option>${paises.nome}</option>
                                            <c:set var="teste" value="50"/>
                                        </c:forEach>
                                  </select>
                                </div>
                                
                                <div class="form-group"> 
                                    <label for="form18">Cidade</label> 
                                    <input type="text" class="form-control" name="cidade"> 
                                </div>
                                
                                <div class="progress my-4">
                                  <div class="progress-bar bg-success" role="progressbar" style="width: 100%" aria-valuenow="100" 
                                  aria-valuemin="0" aria-valuemax="100">100%</div>
                              </div>
                              <button type="submit" class="btn btn-dark">Cadastrar</button>
                            </div>
                        </div>    
                    </form>
                    <!-- Formulario/Dados de cadastro -->
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
                    <img src="../../Imagens/Sem título.png" class="card-img-top" alt="...">
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
    <!-- Footer -->]

    <!-- Modal -->
    <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            ...
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary">Understood</button>
          </div>
        </div>
      </div>
    </div>
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS    -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>