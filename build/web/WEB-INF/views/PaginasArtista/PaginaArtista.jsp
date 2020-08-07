<%-- 
    Document   : PaginaArtista
    Created on : 26/05/2020, 23:37:54
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<!doctype html>
<html lang="pt-br">
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
                  <a class="nav-item nav-link" href="http://localhost:8080/PI_GaleriaRua/pg_artistaFoto">Principal</a>
                  <a class="nav-item nav-link" href="http://localhost:8080/PI_GaleriaRua/pg_cadastroObra">Cadastrar Obra</a>
                  <a class="nav-item nav-link" href="http://localhost:8080/PI_GaleriaRua/pg_ModificaPerfilArtista?cod_usuario=${sessionScope['usuarioLogado'].cod_usuario}">Modificar Perfil</a>
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
        <!-- Dados perfil pessoal -->
        <div class="container" my-5 mb-5>
           <div class="row">
             <div class="col-9"><h5 class="modal-title">Perfil</h5></div>
             <div class="col-4"><br>
                <img src="${sessionScope['usuarioLogado'].imagem}" alt="..." class="img-thumbnail">
             </div>
             <div class="col-6"><br>
                <div class="container">
                    <div class="row">
                      <div class="col-9"><h5 class="modal-title">${sessionScope['usuarioLogado'].nome}</h5></div><br><br>
                      <p></p>
                      <div class="col-4">
                          Tag: ${sessionScope['usuarioLogado'].tag}<br><br>
                          Linguagem: ${sessionScope['usuarioLogado'].linguagem}<br><br>
                          País: ${sessionScope['usuarioLogado'].pais}<br><br>
                          Cidade: ${sessionScope['usuarioLogado'].cidade}<br>
                      </div>
                      <div class="col-8">Descrição do Artista:<br><br>
                        <p>${sessionScope['usuarioLogado'].descricao_artist_foto}</p>
                      </div>
                    </div>
                </div>
             </div>
           </div>
        </div>
        <!-- Dados perfil pessoal -->
                    
        <!-- Principais Obras -->
        <div class="container">
            <div class="row my-2">
            </div>
        </div>
        <div class="container">
            <div class="row my-5 mb-5">
                <div class="col-12 text-center my-3">
                    <h1 class="display-3">Principais Obras:</h1>
                    <a class="nav-item nav-link" href="http://localhost:8080/PI_GaleriaRua/pg_MostraObras?cod_artisFoto=${sessionScope['usuarioLogado'].cod_artistFoto}">[VER TODAS]</a>
                </div>
            </div>
        </div>
        <!-- Principais Obras -->
                    
        <!-- Card's -->
        <div class="container">
            <div class="row my-5 mb-5">
                <div class="card-deck">
                    <!-- -->               
                    <div class="card shadow-lg p-0 mb-5 bg-white rounded">
                        <img src="Imagens/graffiti.jpg" class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">Nome da Obra</h5>
                        <p class="card-text">Resumo - Dados da Obra:</p>
                        <p>This is a wider card with supporting text below as a natural lead-in to additional
                        This content is a little bit longer</p>
                        <a href="#" class="btn btn-dark stretched-link">Detalhes da obra</a>
                      </div>
                    </div>
                    <!-- -->
                    <div class="card shadow-lg p-0 mb-5 bg-white rounded">
                        <img src="Imagens/grafite-arte-urbana-og.jpg" class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
                      </div>
                      <div class="card-footer">
                        <small class="text-muted">Last updated 3 mins ago</small>
                      </div>
                    </div>
                    <!-- -->
                    <div class="card shadow-lg p-0 mb-5 bg-white rounded">
                        <img src="Imagens/kobra2.jpg" class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.</p>
                      </div>
                      <div class="card-footer">
                        <small class="text-muted">Last updated 3 mins ago</small>
                      </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Card's -->
        
        <!-- Contato Artista -->
        <div class="container">
            <div class="col-md-auto"><h5>Contatos:</h5></div><br>
            <div class="row">
              <div class="col">
                Email: ${sessionScope['usuarioLogado'].email}
              </div>
              <div class="col">
                Contato: ${sessionScope['usuarioLogado'].contato}<br><br>
              </div>
              <div class="col">
                Rede Social: Facebook
              </div>
            </div>
        </div>
        <!-- Contato Artista -->
        
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