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
    <nav class="navbar navbar-expand-lg navbar-light bg-light mb-5">
        <div class="container">
            <a>
                <svg class="bi bi-layout-wtf" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M5 1H1v8h4V1zM1 0a1 1 0 0 0-1 1v8a1 1 0 0 0 1 1h4a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1H1zm13 2H9v5h5V2zM9 1a1 1 0 0 0-1 1v5a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H9zM5 13H3v2h2v-2zm-2-1a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1H3zm12-1H9v2h6v-2zm-6-1a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1H9z"/>
                </svg>
                Galeria da Rua
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
        </div>
        <a>${sessionScope['usuarioLogado'].nome}</a>
        <a class="btn btn-default navbar-btn" href="http://localhost:8080/PI_GaleriaRua/pg_index">Logout</a>
    </nav>
    <!-- Barra de navegação -->
  </head>
  
  <body>
      
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