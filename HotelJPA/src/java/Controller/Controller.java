/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Entities.Habitacion;
import Entities.Ocupacion;
import Entities.OcupacionPK;
import Entities.Reserva;

import java.io.IOException;
import java.sql.Connection;
import javax.persistence.EntityManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import Util.JPAUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        /*
		 * Crear el singleton con
         */
    
        List<Habitacion> habitacioneslibres;
        EntityTransaction t;
       List<Habitacion>ocupadas;
        
        EntityManager em = (EntityManager) session.getAttribute("em");
        if (em == null) {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            session.setAttribute("em", em);
        }
        Query q;
        String op = request.getParameter("op");
      
        if (op.equals("inicio")) {
            q = em.createQuery("SELECT h FROM Habitacion h WHERE h.ocupada = false");
            habitacioneslibres = q.getResultList();
            session.setAttribute("lhl", habitacioneslibres);
            
             q = em.createNamedQuery("Habitacion.findAll");
             ocupadas = q.getResultList();
             session.setAttribute("lh", ocupadas);
             session.setAttribute("ficha", "entrada");
             request.getRequestDispatcher("home.jsp").forward(request, response);
        }
         else if (op.equals("entradaoreserva")) {
            String ficha = request.getParameter("ficha");
            session.setAttribute("ficha", ficha);
            
          request.getRequestDispatcher("home.jsp").forward(request, response);

        }
         
         
          
            else if (op.equals("resumen")) {
            String persona = request.getParameter("nhabitacion");
             q = em.createQuery("SELECT r FROM Reserva r WHERE r.nhabitacion.nhabitacion= "+persona+"");
             
             List<Reserva> reservas = q.getResultList();
             session.setAttribute("resumen", reservas);
            
            
            request.getRequestDispatcher("resumen.jsp").forward(request, response);
        }else if(op.equals("hospedar")){
             String dni = (String) request.getParameter("dni");
            String nhabitacion = (String) request.getParameter("nhabitacion");
            String fechas = (String) request.getParameter("fecha");
              fechas = fechas.replace("/", "-");
             Date fechae = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String fechaf = sdf.format(fechae);
            OcupacionPK ocupapk = new OcupacionPK(nhabitacion, fechaf);
            Ocupacion ocupa = new Ocupacion(ocupapk, fechas, dni);
            Habitacion habitacion = (Habitacion) em.find(Habitacion.class, nhabitacion);
            t = em.getTransaction();
            t.begin();
            em.persist(ocupa);
            habitacion.setOcupada(Short.valueOf("1"));
            em.merge(habitacion);
            t.commit();
            habitacioneslibres = (List<Habitacion>) session.getAttribute("lhl");
            for (int i = 0; i < habitacioneslibres.size(); i++) {
                Habitacion h = (Habitacion) habitacioneslibres.get(i);
                if (h.getNhabitacion().equals(habitacion.getNhabitacion())) {
                    habitacioneslibres.remove(i);
                }
            }
              session.setAttribute("lhl", habitacioneslibres);
              request.getRequestDispatcher("home.jsp").forward(request, response);
        }
    }
    
            
          
            
        
    

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

