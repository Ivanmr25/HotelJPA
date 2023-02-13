<%-- 
    Document   : home
    Created on : 10-feb-2023, 22:59:30
    Author     : Usuario
--%>

<%@page import="java.util.List"%>
<%@page import="Entities.Habitacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Bootstrap CSS -->
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/mycss.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
  <title>Web Hotel Azarquiel</title>
</head>
<%
    String ficha = (String)session.getAttribute("ficha");
    Habitacion habitacion;
%>
  <!-- NavBar-->
  <div class="container shadow bg-primary">
    <nav class="navbar navbar-expand-md navbar-light">
      <a class="navbar-brand bgazulc textazulo px-2" href="#"><i class="fa fa-home textgranate"></i> Hotel Azarquiel <i class="fa fa-home textgranate"></i></a>
      <button class="navbar-toggler custom-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link text-white <%=(ficha.equals("entrada")?"active":"")%>" href="Controller?op=entradaoreserva&ficha=entrada">Entrada</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white <%=(ficha.equals("reserva")?"active":"")%>" href="Controller?op=entradaoreserva&ficha=reserva">Habitaciones</a>
          </li>
        </ul>
      </div>
    </nav>
  </div>
          <%
    if (ficha.equals("entrada")) {
    %>
    <div class="container shadow">
    <div class="row">
      <div class="col-md-6 offset-md-3 shadow my-3 py-3">
        <h5 class="bg-primary text-white text-center">ENTRADAS AL HOTEL</h5>
        <form action="Controller?op=hospedar" method="POST" name="fentrada">
          <div class="form-group">
            <label for="dni">Dni</label>
            <input name="dni" placeholder="dni" id="dni" type="text" class="form-control" required>
          </div>
          <div class="form-group">
            <label for="nhabitacion">Habitación</label>
            <%
              List<Habitacion> lhl=(List<Habitacion>) session.getAttribute("lhl");
            %>  
            <select class="form-control" name="nhabitacion" id="nhabitacion" required>
              <option value="" disabled selected>Elija Habitación</option>
             <%for(Habitacion habit:lhl){%>
                    <option value="<%=habit.getNhabitacion() %>"><%=habit.getNhabitacion() %></option>
             <%}%>
            </select>
          </div>
          <div class="form-group">
            <label for="fecha">Fecha Salida</label>
            <input name="fecha" placeholder="Fecha Salida" id="fecha" type="text" class="form-control datepicker" required>
          </div>
          <button type="submit" class="btn btn-primary">Hospedar</button>
        </form>
      </div>
    </div>
  </div>
            <%}%>
            <%if (ficha.equals("reserva")) {  
         List<Habitacion> lh=(List<Habitacion>) session.getAttribute("lh");
    %>
            <div class="container shadow">
    <div class="row mt-2">
      <div class="col-md-8 offset-md-2 shadow table-responsive-sm py-3">
          <h5 class="bg-primary text-white text-center">LISTADO DE HABITACIONES PARA CONSULTA DE RESERVAS</h5>
          <table class="w-100 table table-striped">
              <thead>
                  <tr class="textazulo bgazulc">
                  <th>N&ordm; Habitacion</th>
                  <th>N&ordm; Personas</th>
                  <th>Precio</th>
                  <th>Ocupada(Si/No)</th>
                </tr>
              </thead>
              <tbody
                  <%for(Habitacion habit:lh){%>
                  <tr>
                            <td><button class="btn-primary showreservas" data-id="<%=habit.getNhabitacion() %>" data-toggle="modal" data-target="#modalreservas">Reservas de la <%=habit.getNhabitacion()%></button></td>
                            <td><%=habit.getNpersonas()%></td>
                            <td><%=habit.getPrecio()%></td>
                            <td><%=(habit.getOcupada()==Short.valueOf("1")?"Si":"No")%></td>
                        </tr>
                         </tbody>
                         <%}%>
          </table>
        </div>
    </div>
  </div>
          <%}%>
                        <div class="modal fade" id="modalreservas" tabindex="-1" role="dialog" aria-labelledby="modalreservas" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">RESERVAS</h5>
      </div>
      <div class="modal-body">
        <div class="row">
          <div id="reservas" class="col-sm-12">
               <!--se rellena con ajax-->
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Aceptar</button>
      </div>
    </div>
  </div>
</div>
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
   <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    <script src="myjs.js"></script>
  
</body>

</html>