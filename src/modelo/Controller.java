package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.HttpsParameters;

public class Controller {

	final String INSERTAR = "INSERT INTO usuarios (nombre_usuario,apellido_usuario,nick,contrasena_usuario,email,rol) VALUES(?,?,?,?,?,'cliente')";
	final String MOSTRAR = "SELECT * FROM usuarios WHERE nick=? and contrasena_usuario=? ";
	final String COGER = "SELECT * FROM usuarios WHERE nick=? ";
	final String BORRAR = "DELETE FROM usuarios WHERE nick=? ";

	final String URL_BD = "jdbc:mysql://localhost:3306/MangaTV";
	final String USUARIO = "root";
	final String PASS = "Alejandro97";
	final String CLASSE_DRIVER = "com.mysql.jdbc.Driver";

	public Connection conexion() {
		try {
			Class.forName(CLASSE_DRIVER);
			return DriverManager.getConnection(URL_BD, USUARIO, PASS);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof ClassNotFoundException) {
				System.err.println("VERIFIQUE Si EL DRIVER DE LA BD ESTA EN  CLASSPATH");
			} else {
				System.err.println("ESTA ARRANCANDO MYSQL ?, lAS CREDENCIALES ESTÁN BIEN ?");
			}
			System.exit(0);
			// el programa termina y devuelve el control al S.O.
			return null;
		}
	}

	public boolean inicioSesion(String nick, String pass) {

		try {
			Controller ctr = new Controller();
			Connection con = ctr.conexion();
			PreparedStatement ps = con.prepareStatement(MOSTRAR);
			ResultSet rs;
			ps.setString(1, nick);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			return rs.next();

		}

		catch (SQLException e) {
		}
		return false;
	}

	public void personaInicio(HttpServletRequest request) {
		Usuario usa = new Usuario();
		// Controller ctr = new Controller();
		HttpSession sesion = request.getSession();

		boolean logeado = inicioSesion(request.getParameter("user"), request.getParameter("pass"));
		// System.out.println(logeado);
		if (logeado == true) {
			usa = obtenerDatosUsuario(request.getParameter("user"));
			if (usa != null) {
				// System.out.println(usa.getNombre_usuario());
				// System.out.println(usa.getNick());
				sesion.setAttribute("nombre", usa.getNombre_usuario());
				sesion.setAttribute("apellido", usa.getApellido());
				sesion.setAttribute("nick", usa.getNick());
				sesion.setAttribute("email", usa.getEmail());
				sesion.setAttribute("rol", usa.getRol());
			}
		}
	}

	public Usuario obtenerDatosUsuario(String nick) {
		try {
			Controller ctr = new Controller();
			Connection con = ctr.conexion();
			PreparedStatement ps = con.prepareStatement(COGER);
			ResultSet rs;
			ps.setString(1, nick);
			rs = ps.executeQuery();
			boolean existe = rs.next();
			if (!existe) {
				// System.out.println("dentro");
				return null;
			}
			Usuario usuario = new Usuario(rs.getString("nombre_usuario"), rs.getString("apellido_usuario"),
					rs.getString("email"), rs.getString("nick"), rs.getString("contrasena_usuario"),
					rs.getString("rol"));
			// System.out.println(rs.getString(1) + usuario);
			return usuario;
		} catch (SQLException e) {
		}
		return null;
	}

	public boolean insertarRegistroUsuarios(String nombre, String apellido, String nick, String contrasena,
			String email) {

		try {
			Controller ctr = new Controller();
			Connection con = ctr.conexion();
			PreparedStatement ps = con.prepareStatement(INSERTAR);
			int filas;
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setString(3, nick);
			ps.setString(4, contrasena);
			ps.setString(5, email);
			filas = ps.executeUpdate();
			return true;
			// System.out.println("¡PERSONA AÑADIDA!");
			// rs.close();

		}

		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public void personaRegistro(HttpServletRequest request, String nombre, String apellido, String nick,
			String contrasena, String email) {

		HttpSession sesion = request.getSession();

		boolean insertado = insertarRegistroUsuarios(nombre, apellido, nick, contrasena, email);
		if (insertado) {
			sesion.setAttribute("nombre", nombre);
			sesion.setAttribute("apellido", apellido);
			sesion.setAttribute("nick", nick);
			sesion.setAttribute("email", email);
			sesion.setAttribute("rol", "cliente");
		}
	}

	public void borrarPersona(HttpServletRequest request, String nombre, String apellido, String contrasena, String email) {

		try {
			HttpSession sesion = request.getSession();
			String nick = (String) sesion.getAttribute("nick");
			Connection con = conexion();
			PreparedStatement ps;
			ps = con.prepareStatement(BORRAR);

			ps.setString(1, nick);
			ps.executeUpdate();
			ps.close();
			sesion.invalidate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
