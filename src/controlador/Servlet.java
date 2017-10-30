package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Controller;
import modelo.Usuario;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		Controller ctr = new Controller();
		String base = "/jsp/";
		String url = base + "index.jsp";
		String action = request.getParameter("action");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String contrasena = request.getParameter("pass");
		String nick = request.getParameter("user");
		// recuperar datamanager del contexto

		if (action != null) {
			switch (action) {
			case "Home":
				url = base + "index.jsp";
				break;
			case "Mangas":
				url = base + "mangas.jsp";
				break;
			case "Acceder":
				url = base + "login.jsp";
				break;
			case "Merca":
				url = base + "merchandising.jsp";
				break;
			case "Registro":
				url = base + "registro.jsp";
				break;
			case "insertarRegistro":
				if (request.getParameter("registrar") != null) {
					ctr.personaRegistro(request, nombre, apellido, nick, contrasena, email);
					url = base + "index.jsp";
					break;
				}
				url = base + "index.jsp";
				break;

			case "Logout":
				sesion.invalidate();
				url = base + "index.jsp";
				break;

			case "Logeo":
				if (request.getParameter("enviar") != null) {
					//System.out.println(request.getParameter("user"));
					ctr.personaInicio(request);
					url = base + "index.jsp";
					break;
				}
				
				url = base + "index.jsp";
				break;
				
			case "Perfil":
				url = base + "perfil.jsp";
				break;
			
			case "BorrarCuenta":
				ctr.borrarPersona(request, nombre, apellido, contrasena, email);
				
			url = base + "index.jsp";
			break;
		}
		}

	RequestDispatcher requestDispatcher = getServletContext()
			.getRequestDispatcher(url);requestDispatcher.forward(request,response);
}

}
