package com.distribuida.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.distribuida.servicio.UsuarioServicio;
import com.distribuida.usuario.Usuario;

@WebServlet(urlPatterns="/VerServlet")  
public class VerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private UsuarioServicio servicio; 
   
	//Esta se podria decir que es la vista principal de nuestra aplicacion , donde nos muestra la lista completa de usuarios , y para cada usuario 
	//dos opciones , la de eliminar y la de editar los campos , metodos que ya vimos en las clase anteriores.(EditarServlet2,EliminarServlet)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<a href='index.html'>Crear nuevo Usuario</a>");  
	        out.println("<h1>LISTA DE USUARIOS</h1>");  
	          
	        List<Usuario> list=servicio.selectAllUsers();  
	          
	        out.print("<table border='1' width='100%'");  
	        out.print("<tr><th>Id</th><th>Nombre</th><th>Direccion</th><th>Email</th><th>Editar</th><th>Borrar</th></tr>");  
	        for(Usuario e:list){  
	         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getNombre()+"</td><td>"+e.getDireccion()+"</td><td>"+e.getEmail()+"</td><td><a href='EditarServlet?id="+e.getId()+"'>editar</a></td><td><a href='EliminarServlet?id="+e.getId()+"'>eliminar</a></td></tr>");  
	        }  
	        out.print("</table>");  
	          
	        out.close();  
	    }  
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
