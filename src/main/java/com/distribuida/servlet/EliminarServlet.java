package com.distribuida.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.distribuida.servicio.UsuarioServicio;

@WebServlet(urlPatterns="/EliminarServlet")  
public class EliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private UsuarioServicio servicio; 
   
	//Este metodo tambien se ejecuta por debajo de la vista, lo que haces es eliminar el usuario seleccionado 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	        servicio.eliminarUsuario(id);  
	        response.sendRedirect("VerServlet");  
	    }  
	 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
