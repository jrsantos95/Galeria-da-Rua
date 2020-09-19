<%-- 
    Document   : PaginaInicial
    Created on : 18/09/2020, 10:55:37
    Author     : Juan
--%>

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
            <a class="navbar-brand" href="index.html">
                <svg class="bi bi-layout-wtf" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                     <path fill-rule="evenodd" d="M5 1H1v8h4V1zM1 0a1 1 0 0 0-1 1v8a1 1 0 0 0 1 1h4a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1H1zm13 2H9v5h5V2zM9 1a1 1 0 0 0-1 1v5a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H9zM5 13H3v2h2v-2zm-2-1a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1H3zm12-1H9v2h6v-2zm-6-1a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1H9z"/>
                </svg>
                Galeria da Rua
            </a>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
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
    <!-- Carroceu --> 
    <div id="carouselPaginaInicial" class="carousel slide my-0" data-ride="carousel" >
        <div class="carousel-inner">
          <div class="carousel-item active">
              <img src="Imagens/c6aeaccca6762f6ff3978737b483c4ef.jpg" 
                   class="img-fluid d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
              <img src="Imagens/904481-rio20de20janeiro_grafite_20arte20urbana__dsc2263.jpg" 
                   class="img-fluid d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
              <img src="Imagens/tapumes_do_inca_com_grafite_11.jpg" 
                   class="img-fluid d-block w-100" alt="...">
          </div>
        </div>

        <a class="carousel-control-prev" href="#carouselPaginaInicial" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Para Trás</span>
        </a>
        <a class="carousel-control-next" href="#carouselPaginaInicial" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Para Frente</span>
        </a>
    </div>
    <!-- Carroceu -->
    
    <!-- Carroceu 2
        <div id="carouselPaginaInicial" class="carousel slide my-3" data-ride="carousel" >
             <c:forEach var="obras" items="${obras}">
                    <c:set var="codigo_lista" value="${codigo_lista+1}"/>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="${obras.getImagem()}" 
                               class="img-fluid d-block w-100" alt="...">
                        </div>
                        <a class="carousel-control-prev" href="#carouselPaginaInicial" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Para Trás</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselPaginaInicial" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Para Frente</span>
                        </a>
                    </div>
            </c:forEach>
        </div>
    Carroceu -->
    
    <!-- Pesquisa por lingugens das obras -->
    <div class="container">
        <div class="row my-2">
        </div>
    </div>
    <div class="container">
        <div class="row mb-3">
            <div class="col-12 text-center mb-5">
                <h1 class="display-3">Procure por linguagem</h1>
                    <div class="container my-5 mb-5">
                        <div class="row">
                          <div class="col"><a href="http://localhost:8080/PI_GaleriaRua/pg_ObraCategoria?categoria=Grafite" class="btn btn-outline-secondary">Grafite</a></div>
                          <div class="col"><a href="http://localhost:8080/PI_GaleriaRua/pg_ObraCategoria?categoria=Adesivos" class="btn btn-outline-secondary">Adesivos</a></div>
                          <div class="col"><a href="http://localhost:8080/PI_GaleriaRua/pg_ObraCategoria?categoria=Muralismo" class="btn btn-outline-secondary">Muralismo</a></div>
                          <div class="col"><a href="http://localhost:8080/PI_GaleriaRua/pg_ObraCategoria?categoria=Poemas" class="btn btn-outline-secondary">Poemas</a></div>
                        </div>
                    </div>
                <!-- <a class="nav-item nav-link" href="http://localhost:8080/PI_GaleriaRua/pg_ObraCategoria?categoria=VerTodas">[VER TODAS]</a> -->
                <a class="nav-item nav-link" href="http://localhost:8080/PI_GaleriaRua/pg_SelecaoPais">[VER POR PAIS]</a>
            </div>
        </div>
    <!-- Pesquisa por lingugens das obras -->
    
    <div class="container">
        <div class="row my-5 mb-5">
            <div class="card-deck">
                    <c:if test="${not empty obras}">
                        <c:forEach var="obras" items="${obras}">
                                    <c:set var="codigo_lista" value="${codigo_lista+1}"/>
                                    <div class="card shadow-lg p-0 mb-5 bg-white rounded">

                                        <!-- testar se existe foto se não mostrar foto padrão -->
                                        <img src="${obras.getImagem()}" width="300" class="card-img-top">
                                    
                                      <div class="card-body">
                                        <h5 class="card-title">${obras.getNome()}</h5>
                                        <p class="card-text">${obras.getLinguagem()} </p>
                                        <p class="card-text">${obras.getCor_predominante()}</p>
                                        <p> ${obras.getDescricao_obra()}</p>

                                        <a href="http://localhost:8080/PI_GaleriaRua/pg_detalhesObraIndex?cod_obra=${obras.getCod_obra()}" class="btn btn-dark">Detalhes</a>
                                      </div>
                                    </div>
                                    <!-- -->
                        </c:forEach>
                    </c:if>
            </div>
        </div>
    </div>
    
    <div class="container">
        <div class="row my-5 mb-5">
            <div class="card-deck">
                    <c:if test="${not empty obras2}">
                        <c:forEach var="obras2" items="${obras2}">
                                    <c:set var="codigo" value="${codigo+1}"/>
                                    <div class="card shadow-lg p-0 mb-5 bg-white rounded">

                                        <!-- testar se existe foto se não mostrar foto padrão -->
                                        <img src="${obras2.getImagem()}" width="300" class="card-img-top">
                                    
                                      <div class="card-body">
                                        <h5 class="card-title">${obras2.getNome()}</h5>
                                        <p class="card-text">${obras2.getLinguagem()} </p>
                                        <p class="card-text">${obras2.getCor_predominante()}</p>
                                        <p> ${obras2.getDescricao_obra()}</p>

                                        <a href="http://localhost:8080/PI_GaleriaRua/pg_detalhesObraIndex?cod_obra=${obras2.getCod_obra()}" class="btn btn-dark">Detalhes</a>
                                      </div>
                                    </div>
                                    <!-- -->
                        </c:forEach>
                    </c:if>
            </div>
        </div>
    </div>
    
    <!-- Footer -->
    <div class="container">
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
                        <p>A Galeria da Rua foi criada pensando em colocar em um unico lugar, toda a arte disponivel nas ruas, 
                           pintadas por artistas muitas vezes anonimos, mas tazendo a exencia de rua.
                        </p>
                    </div>
                      <div class="card-body">
                      </div>
                </div>
                
                <div class="col-2">
                    <div data-spy="scroll" data-target="#navbar-example3" data-offset="0" class="scroollspyPaginaInicial.css">
                        <h4 id="item-1">Parcerias</h4>
                          <p>
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
                      <p class="card-text">Ex consequat commodo adipisicing exercitation aute excepteur occaecat ullamco duis aliqua id 
                            magna ullamco eu. Do aute ipsum ipsum ullamco cillum consectetur ut et aute consectetur</p>
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