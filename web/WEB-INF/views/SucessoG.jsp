<%-- 
    Document   : dashboard
    Created on : 08/10/2018, 15:50:24
    Author     : Juan Ramos dos Santos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>  
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
    <title>TrabalhoJuan</title>
</head>
  <body>
    <div class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
           <a class="navbar-brand" href="http://localhost:8080/TrabalhoJuan/pg_paginaInicialGerente"><span>Bem Vindo Sr.Gerente!</span></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
          <ul class="nav navbar-nav navbar-right">
            <li>
              <a>${sessionScope['usuarioLogado'].nome}</a>
            </li>
            <li>
              <a href="http://localhost:8080/TrabalhoJuan/logout">Sair</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
       <c:if test="${not empty mensagem}">
            <h2>
                <strong style="color:green";"> ${mensagem}</strong>
            </h2>
       </c:if>
       <h2>Nome: ${nome}</h2>
       <div class="section">
        <div class="container">
         <div class="row">
           <div class="col-md-12">
             <a class="btn btn-lg btn-warning" href="http://localhost:8080/PI_GaleriaRua/ListaUsuario">Voltar</a>
           </div>
         </div>
       </div>
      </div> 
  </body>
</html>