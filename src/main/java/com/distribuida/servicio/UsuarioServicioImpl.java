package com.distribuida.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
//import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

import com.distribuida.usuario.Usuario;
//Anotacion que me indica que esta clase es de ámbito de aplicación de un componente CDI
@ApplicationScoped
public class UsuarioServicioImpl implements UsuarioServicio {
	//Inyectamos la dependencia de la conexion a la base de datos
	@Inject	private DataSource datasource;
	    
   //Sobreescribimos el método 	insertarUsuario proveniente de la clase UsuarioServicio.
	@Override
	public int insertarUsuario(Usuario user){
		 int status=0;  
		    
        try{
        	Connection conn=datasource.getConnection();  
            PreparedStatement ps=conn.prepareStatement("INSERT INTO persona" + "  (nombre, direccion, email) VALUES " +
    		        " (?, ?, ?);");
            
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getDireccion());
            ps.setString(3, user.getEmail());
            
            status= ps.executeUpdate();
            conn.close();  
        } catch (SQLException e){e.printStackTrace();}  
        
        return status;
		
	}
	//Sobreescribimos el método buscarUsuario proveniente de la clase UsuarioServicio.
	@Override
	public Usuario buscarUsuario(int id) {
		 Usuario usuario = new Usuario();
	        
	        try {
	        	Connection conn=datasource.getConnection();  
	        	PreparedStatement ps=conn.prepareStatement("select * from persona where id=?");  
	        	 ps.setInt(1,id); 
	        	 ResultSet rs=ps.executeQuery();  
	        	 if (rs.next()) {
	        		 usuario.setId(rs.getInt(1));  
	        		 usuario.setNombre(rs.getString(2));
	        		 usuario.setDireccion(rs.getString(3));
	        		 usuario.setEmail(rs.getString(4));  
	                
	            }
	        	 conn.close();  
	        } catch (Exception e) {e.printStackTrace();}  
	        return usuario;
	}
	//Sobreescribimos el método selectAllUsers proveniente de la clase UsuarioServicio.
	@Override
	public List<Usuario> selectAllUsers() {
		
        List < Usuario > list = new ArrayList < > ();
       
        try {
        	Connection conn=datasource.getConnection();  
        	 PreparedStatement ps=conn.prepareStatement("select * from persona");  
        	 ResultSet rs=ps.executeQuery();  

          
            while (rs.next()) {
            	 Usuario usuario = new Usuario();
            	 usuario.setId(rs.getInt(1));  
        		 usuario.setNombre(rs.getString(2));
        		 usuario.setDireccion(rs.getString(3));
        		 usuario.setEmail(rs.getString(4));  
        		 list.add(usuario);  
            }
            conn.close();  
        } catch(Exception e){e.printStackTrace();}  
        return list;
	}
	//Sobreescribimos el método eliminarUsuario proveniente de la clase UsuarioServicio.
	@Override
	public int eliminarUsuario(int id){
		int status=0;  
	        try {
	        	  Connection conn=datasource.getConnection();  
	        	  PreparedStatement ps=conn.prepareStatement("delete from persona where id=?");  
	        	  ps.setInt(1,id);  
	              status=ps.executeUpdate();  
	                
	              conn.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	//Sobreescribimos el método actualizarUsuario proveniente de la clase UsuarioServicio.
	@Override
	public int actualizarUsuario(Usuario user){
		 int status=0;  
        try{
        	 Connection con=datasource.getConnection();  
        	   PreparedStatement ps=con.prepareStatement("update persona set nombre=?,direccion=?,email=? where id=?");  
        	   ps.setString(1, user.getNombre());
        	   ps.setString(2, user.getDireccion());
        	   ps.setString(3, user.getEmail());
        	   ps.setInt(4, user.getId());

        	   status=ps.executeUpdate();  
        	   con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }


	

}
