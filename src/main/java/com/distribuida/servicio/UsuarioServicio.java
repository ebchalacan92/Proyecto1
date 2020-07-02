package com.distribuida.servicio;


import java.util.List;

import com.distribuida.usuario.Usuario;

// Creo los diferentes métodos del CRUD de la BDD persona
public interface UsuarioServicio {
	
	public int insertarUsuario(Usuario user);
	
	public Usuario buscarUsuario(int id);
	
	public List<Usuario> selectAllUsers();
	
	public int eliminarUsuario(int id);
	
	public int actualizarUsuario(Usuario user);
	
	
	
}
