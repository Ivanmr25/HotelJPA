<%@page import="Entities.Reserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<% 
    List<Reserva> resumen=(List<Reserva>)session.getAttribute("resumen");
    if (resumen.size()==0) {%>
    <table class="table table-striped">
        <tr>
        <th class="text-danger">Habitacion sin reservas</th>
        </tr>
        </table>
    <%} else {%>
        <table class="table table-striped">
            <thead>
                  <th>Nº de Habitacion</th>
                   <th>Fecha de Entrada</th>
                       <th>Fecha de Salida</th>
                <th>DNI</th>
            </thead>
            <tbody>
            <%for (Reserva tanteo:resumen){%>
                <tr>
                  
                    <td><%=tanteo.getNhabitacion().getNhabitacion() %></td>
                    
                   <td><%=tanteo.getFechae()%></td>
                
                   <td><%=tanteo.getFechas()%></td>
                    
                   <td><%=tanteo.getDni()%></td>
                </tr>
            <%}%>
            </tbody>
        </table>
    <%}
%>

