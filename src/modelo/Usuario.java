package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {


	private String nombre_usuario;
	private String apellido;
	private String email;
	private String nick;
	private String contrasena;
	private String rol;
	
	public Usuario(String nombre_usuario, String apellido, String email, String nick, String contrasena, String rol) {
		super();
		this.nombre_usuario = nombre_usuario;
		this.apellido = apellido;
		this.email = email;
		this.nick = nick;
		this.contrasena = contrasena;
		this.rol = rol;
	}
	public Usuario () {
		
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
