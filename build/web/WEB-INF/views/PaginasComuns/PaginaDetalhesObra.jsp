<%-- 
    Document   : PaginaCadastroObra
    Created on : 22/07/2020, 14:14:58
    Author     : Juan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
            <a class="navbar-brand" href="http://localhost:8080/PI_GaleriaRua/pg_index">
                <svg class="bi bi-layout-wtf" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M5 1H1v8h4V1zM1 0a1 1 0 0 0-1 1v8a1 1 0 0 0 1 1h4a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1H1zm13 2H9v5h5V2zM9 1a1 1 0 0 0-1 1v5a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H9zM5 13H3v2h2v-2zm-2-1a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1H3zm12-1H9v2h6v-2zm-6-1a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1H9z"/>
                </svg>
                Galeria da Rua
            </a>
        </div>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav ml-auto">
              <a class="btn btn-default navbar-btn" href="http://localhost:8080/PI_GaleriaRua/pg_index">Voltar
                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-skip-backward" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" d="M.5 3.5A.5.5 0 0 1 1 4v3.248l6.267-3.636c.52-.302 1.233.043 1.233.696v2.94l6.267-3.636c.52-.302 1.233.043 1.233.696v7.384c0 .653-.713.998-1.233.696L8.5 8.752v2.94c0 .653-.713.998-1.233.696L1 8.752V12a.5.5 0 0 1-1 0V4a.5.5 0 0 1 .5-.5zm7 1.133L1.696 8 7.5 11.367V4.633zm7.5 0L9.196 8 15 11.367V4.633z"/>
                </svg>
              </a>
            </div>
        </div>
    </nav>
    <!-- Barra de navegação -->
  </head>
  
  <body>
      
    <div class="container">
        <div class="row my-5 mb-5">
            <c:forEach var="obras" items="${obras}">
                <img src="${obras.getImagem()}" width="300" class="card-img-top" alt="Responsive image">
                    <blockquote class="blockquote my-4 mb-4">
                        <p class="mb-0">Nome da Obra: ${obras.getNome()}</p>
                        <footer class="blockquote-footer">Linguagem: <cite title="Source Title">${obras.getLinguagem()}</cite></footer>
                        <footer class="blockquote-footer">Cor Predominante: <cite title="Source Title">${obras.getCor_predominante()}</cite></footer>
                        <footer class="blockquote-footer">Descrição: <cite title="Source Title">${obras.getDescricao_obra()}</cite></footer>
                    </blockquote>
            </c:forEach>
        </div>
    </div>
    
    
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
