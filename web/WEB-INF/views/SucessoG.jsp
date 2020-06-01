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
              <a>${sessionScope['usuarioLogado'].nome}</a>
              <a class="btn btn-default navbar-btn" href="http://localhost:8080/PI_GaleriaRua/logout">
                Logout
                <svg class="bi bi-box-arrow-left" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M4.354 11.354a.5.5 0 0 0 0-.708L1.707 8l2.647-2.646a.5.5 0 1 0-.708-.708l-3 3a.5.5 0 0 0 0 .708l3 3a.5.5 0 0 0 .708 0z"/>
                    <path fill-rule="evenodd" d="M11.5 8a.5.5 0 0 0-.5-.5H2a.5.5 0 0 0 0 1h9a.5.5 0 0 0 .5-.5z"/>
                    <path fill-rule="evenodd" d="M14 13.5a1.5 1.5 0 0 0 1.5-1.5V4A1.5 1.5 0 0 0 14 2.5H7A1.5 1.5 0 0 0 5.5 4v1.5a.5.5 0 0 0 1 0V4a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 .5.5v8a.5.5 0 0 1-.5.5H7a.5.5 0 0 1-.5-.5v-1.5a.5.5 0 0 0-1 0V12A1.5 1.5 0 0 0 7 13.5h7z"/>
                </svg>
            </a>
          </div>
      </nav>
      <!-- Barra de navegação -->
    </head>
  
    <body>
        
        <div class="container">
            <div class="card-deck">
                <div class="card border-white"> </div>
                <!-- -->
                <div class="card border-white">
                    <div class="container">
                        <div class="card shadow-lg p-0 mb-5 bg-white rounded" style="max-width: 18rem;">
                            <div class="card-body">
                                <c:if test="${not empty mensagem}">
                                    <h3>
                                        <strong style="color: black";"> ${mensagem}</strong>
                                    </h3>
                                </c:if> 
                                <div class="row">
                                  <div class="col-md-12">
                                    <a class="btn btn-lg btn-warning" href="http://localhost:8080/PI_GaleriaRua/ListaUsuario">Voltar</a>
                                  </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- -->
                <div class="card border-white"> </div>
            </div> 
        </div>
        
    </body>
    
</html>