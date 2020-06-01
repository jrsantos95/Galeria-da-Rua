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
              <a class="navbar-brand" href="http://localhost:8080/PI_GaleriaRua/ListaUsuario">
                  <svg class="bi bi-layout-wtf" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                      <path fill-rule="evenodd" d="M5 1H1v8h4V1zM1 0a1 1 0 0 0-1 1v8a1 1 0 0 0 1 1h4a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1H1zm13 2H9v5h5V2zM9 1a1 1 0 0 0-1 1v5a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H9zM5 13H3v2h2v-2zm-2-1a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1H3zm12-1H9v2h6v-2zm-6-1a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1H9z"/>
                  </svg>
                  Galeria da Rua
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
                                    <a class="btn btn-success" href="http://localhost:8080/PI_GaleriaRua/pg_index">Voltar</a>
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