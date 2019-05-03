package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BeanCliente;
import dao.ClienteDAO;
import util.NumberException;
import util.ValidacionException;

/**
 * Servlet implementation class OrdenServlet
 */
@WebServlet("/ordenServlet")
public class OrdenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO clienteDAO=new ClienteDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		try {
	    	String accion=request.getParameter("accion");
				if(accion!=null) {
					if(accion.equals("BUSCAR")) {
						String rucCliente=request.getParameter("rucCliente");
						BeanCliente cliente= ClienteDAO.getClienteRUC(rucCliente);
						request.setAttribute("cliente", cliente);
					}
				}
				request.setAttribute("contenido", "WEB-INF/paginas/Orden.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index2.jsp");
				//RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/paginas/Orden.jsp");
				dispatcher.forward(request, response);
			}catch (SQLException | ClassNotFoundException | IllegalArgumentException e) {
				request.setAttribute("mensaje", "Error : "+e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/paginas/Error.jsp");
				dispatcher.forward(request, response);
			}
	}

	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
