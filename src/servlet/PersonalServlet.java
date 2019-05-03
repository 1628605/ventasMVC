package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BeanPersonal;
import dao.PersonalDAO;
import util.NumberException;
import util.ValidacionException;

/**
 * Servlet implementation class PersonalServlet
 */
@WebServlet("/personalServlet")
public class PersonalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonalDAO personalDAO=new PersonalDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// CRUD CREATE RETRIEVE UPDATE DELETE
    	try {
    	String accion=request.getParameter("accion");
			if(accion!=null) {
				if(accion.equals("CREATE")) {
					BeanPersonal personal= CrearPersonal(request);
					try {
						personal.valida();
						if(personal.getIdpersonal()!=null) {
							personalDAO.Actualizar(personal);
							request.setAttribute("mensaje", "Personal se Actualizo con exito ");
						}else {
							personalDAO.Guardar(personal);
							request.setAttribute("mensaje", "Personal se guardo con exito ");	
						}
					} catch (ValidacionException e) {
						request.setAttribute("mensaje", "Error en validacion de los campos de texto "+e.getMessage());
						request.setAttribute("personal", personal);
					} catch (NumberException e){
						request.setAttribute("mensaje", "Error en validacion de los campos numericos "+e.getMessage());
						request.setAttribute("personal", personal);
					} catch (NumberFormatException e){
						request.setAttribute("mensaje", "Error en validacion de los campos numericos ");
						request.setAttribute("personal", personal);
					}
					
					
				}else if(accion.equals("RETRIEVE")) {
					String codigo=request.getParameter("codigo");
					Integer idpersonal=Integer.parseInt(codigo);
					BeanPersonal personal=PersonalDAO.getPersonalID(idpersonal);
					request.setAttribute("personal", personal);
				}else if(accion.equals("DELETE")) {
					String codigo=request.getParameter("codigo");
					Integer idpersonal=Integer.parseInt(codigo);
					PersonalDAO.Eliminar(idpersonal);
					request.setAttribute("mensaje", "Personal Eliminado");
				}
			}
			request.setAttribute("listapersonal", personalDAO.getPersonal());
			request.setAttribute("contenido", "WEB-INF/paginas/Personal2.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index2.jsp");
			//RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/paginas/Personal2.jsp");
			dispatcher.forward(request, response);
		}catch (SQLException | ClassNotFoundException | IllegalArgumentException e) {
			request.setAttribute("mensaje", "Error : "+e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/paginas/Error.jsp");
			dispatcher.forward(request, response);
		}
		
    }

	private BeanPersonal CrearPersonal(HttpServletRequest request) {
		
		String idpersonal = request.getParameter("idpersonal");
		String nomPersonal = request.getParameter("nomPersonal");
		String apePersonal = request.getParameter("apePersonal");
		String cargoPersonal = request.getParameter("cargoPersonal");
		String clavePersonal = request.getParameter("clavePersonal");
		
		
		//BeanProducto producto=new BeanProducto(null,nomProducto, descProducto, preciovProductoD, stockProductoI);
		BeanPersonal personal=new BeanPersonal(null, nomPersonal, apePersonal, cargoPersonal, clavePersonal);
		if(idpersonal!=null && !idpersonal.equals("")) {
			personal.setIdpersonal(Integer.parseInt(idpersonal));
		}
		return personal;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
