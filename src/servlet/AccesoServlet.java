package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BeanPersonal;

import dao.PersonalDAO;


/**
 * Servlet implementation class AccesoServlet
 */
@WebServlet("/accesoServlet")
public class AccesoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonalDAO personalDAO=new PersonalDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccesoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String log,pas;
		//OBTENEMOS PARAMETROS DEL JSP
		//============================
		log=(String)request.getParameter("username");
		pas=(String)request.getParameter("password");
		//SE INSTANCIA A LA CLASE Sql_Usuario
		//===================================
		
		//SE CREA LA SESSION
		//==================
		HttpSession misession = request.getSession(true);
		try
		{	//VERIFICAMOS SI EXISTE EL USUARIO INVOCANDO AL METODO obtenerUsuario EL CUAL DEBE DE DEVOLVER UN BEAN
			//====================================================================================================
			if(personalDAO.obtenerPersonal(log, pas)!=null)
			{
				//RECUPERAMOS EL BEAN TRAIDO DEL METODO obtenerUsuario
				//====================================================
				BeanPersonal personal =personalDAO.obtenerPersonal(log, pas);
				//CREAMOS UN ATRIBUTO DE SESSION "nombres" Y LE DAMOS LOS DATOS DEL NOMBRE, APELLIDO PATERNO Y MATERNO CONCATENADOS
				//=================================================================================================================
				misession.setAttribute("nombre y clave", personal.getNomPersonal()+" "+personal.getClavePersonal());
				response.sendRedirect("index2.jsp");	
			}else{
				response.sendRedirect("error.jsp");
			}
		}catch (Exception e)
		{System.out.println("HOLA "+e);}
	}

}
