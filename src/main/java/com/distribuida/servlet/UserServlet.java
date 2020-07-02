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


@WebServlet(urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private UsuarioServicio servicio;
	
	//Se han implemetado los dos metodos del tipo get y posta en la misma clase , en un principio nos muestra los campos para poder INSERTAR 
	//un usuario nuevo y mediante el enlace GUARDAR ejecutamos la accion POST que inserta los campos dentro de nuestra BDD persona 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Añadir un nuevo usuario</h1>");  
        
        out.print("<form action='UserServlet' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td>Id:</td><td><input type=\"number\" name=\"id\"/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type=\"text\" name=\"nombre\"/></td></tr>");  
        out.print("<tr><td>Direction</td><td><input type=\"text\" name=\"direccion\"/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type=\"email\" name=\"email\"/></td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='GUARDAR'/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
        out.print("<br/>");
        out.print("<a href='VerServlet'>Ver Usuarios</a>");
        
          
        out.close();  */
	}

		

	//Una vez ingresado los datos controlamos que no hay error de ejecución , sino lo no ofrece un enlace para volver a la lista de usuarios
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");  
        PrintWriter out=resp.getWriter();  
        
        
        String nombre=req.getParameter("nombre");  
        String direccion=req.getParameter("direccion");  
        String email=req.getParameter("email");  
       
        
        Usuario e=new Usuario();  
      
        e.setNombre(nombre);
        e.setDireccion(direccion); 
        e.setEmail(email);
       
          
        int status=servicio.insertarUsuario(e);  
        if(status>0){  
            out.print("<p>Se ha almacenado con Exito!</p>");  
            req.getRequestDispatcher("index.html").include(req, resp);  
        }else{  
            out.println("Lo siento! No se pudo guardar los campos");  
        }  
          
        out.close();  
	}

	

	
  
}  