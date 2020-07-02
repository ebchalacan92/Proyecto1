package com.distribuida.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.distribuida.servicio.UsuarioServicio;
import com.distribuida.usuario.Usuario;

@WebServlet(urlPatterns="/EditarServlet2")  
public class EditarServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private UsuarioServicio servicio; 
   
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	//Al ser un metodo POST realiza la accion por debajo de la interfaz , su funcion sera actualizar y guardar los campos que han sido modificados.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	        String nombre=request.getParameter("nombre");  
	        String direccion=request.getParameter("direccion");  
	        String email=request.getParameter("email");  
	        
	        Usuario e=new Usuario();  	          
	       
	        e.setId(id);  
	        e.setNombre(nombre);  
	        e.setDireccion(direccion);  
	        e.setEmail(email);  
	       
	         //Controlamos que si hay algun error de ejecución lo muestre en pantalla, caso contrario volvemos a la vista VerServlet.
	        int status=servicio.actualizarUsuario(e);  
	        if(status>0){  
	            response.sendRedirect("VerServlet");  
	        }else{  
	            out.println("Error! no se pudo Actualizar los campos");  
	        }  
	          
	        out.close();  
	    }  
	  
	}  