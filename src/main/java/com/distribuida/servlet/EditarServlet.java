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

@WebServlet(urlPatterns="/EditarServlet")  
public class EditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Injecto una variable de dependencia de la clase UsuarioServicio para poder usar los difernetes metodos CRUD
	@Inject
	private UsuarioServicio servicio; 
	
	//Sobreescribo el metodo doGet para realizar la acción de mostrar los campos de un usuario mediante lenguaje html
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>ACTUALIZAR CAMPOS</h1>");  
        //Este método requiere de un valor "id" para realizar la busqueda de un usuario por su clave primaria "id"
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Usuario e=servicio.buscarUsuario(id);  
          //Presentamos en el buscador los campos del usuario para que se los pueda editar. 
          //La accion que va a realizar esta contenida en la clase EditarServlet2
        out.print("<form action='EditarServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Nombre:</td><td><input type='text' name='nombre' value='"+e.getNombre()+"'/></td></tr>");  
        out.print("<tr><td>Direccion:</td><td><input type='text' name='direccion' value='"+e.getDireccion()+"'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Editar y Guardar '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
