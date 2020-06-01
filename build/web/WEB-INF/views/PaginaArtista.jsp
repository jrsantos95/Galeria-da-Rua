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

    </head>
    
    <body>
        <h1>Hello World!</h1>
        <a>${sessionScope['usuarioLogado'].nome}</a>
        <a href="http://localhost:8080/PI_GaleriaRua/pg_index" class="btn btn-dark stretched-link">
            Voltar
        </a>
    </body>
</html>
