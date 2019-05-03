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
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/clienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO clienteDAO=new ClienteDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteServlet() {
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
					BeanCliente cliente= CrearCliente(request);
					try {
						cliente.valida();
						if(cliente.getIdcliente()!=null) {
							clienteDAO.Actualizar(cliente);
							request.setAttribute("mensaje", "Cliente se Actualizo con exito ");
						}else {
							clienteDAO.Guardar(cliente);
							request.setAttribute("mensaje", "Cliente se guardo con exito ");	
						}
					} catch (ValidacionException e) {
						request.setAttribute("mensaje", "Error en validacion de los campos de texto "+e.getMessage());
						request.setAttribute("cliente", cliente);
					} catch (NumberException e){
						request.setAttribute("mensaje", "Error en validacion de los campos numericos "+e.getMessage());
						request.setAttribute("cliente", cliente);
					} catch (NumberFormatException e){
						request.setAttribute("mensaje", "Error en validacion de los campos numericos ");
						request.setAttribute("cliente", cliente);
					}
					
					
				}else if(accion.equals("RETRIEVE")) {
					String codigo=request.getParameter("codigo");
					Integer idcliente=Integer.parseInt(codigo);
					BeanCliente cliente=clienteDAO.getClienteID(idcliente);
					request.setAttribute("cliente", cliente);
				}else if(accion.equals("DELETE")) {
					String codigo=request.getParameter("codigo");
					Integer idcliente=Integer.parseInt(codigo);
					clienteDAO.Eliminar(idcliente);
					request.setAttribute("mensaje", "Cliente Eliminado");
				}
			}
			request.setAttribute("listacliente", clienteDAO.getCliente());
			request.setAttribute("contenido", "WEB-INF/paginas/Cliente2.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index2.jsp");
			//RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/paginas/Cliente2.jsp");
			dispatcher.forward(request, response);
		}catch (SQLException | ClassNotFoundException | IllegalArgumentException e) {
			request.setAttribute("mensaje", "Error : "+e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/paginas/Error.jsp");
			dispatcher.forward(request, response);
		}
		
    }

	private BeanCliente CrearCliente(HttpServletRequest request) {
		Integer dniClienteI;
		String idcliente = request.getParameter("idcliente");
		String nomCliente = request.getParameter("nomCliente");
		String dniCliente = request.getParameter("dniCliente");
		String dirCliente = request.getParameter("dirCliente");
		String razonSocial = request.getParameter("razonSocial");
		String rucCliente = request.getParameter("rucCliente");
		String emailCliente = request.getParameter("emailCliente");
		
		if(!dniCliente.isEmpty()) {
			dniClienteI=Integer.parseInt(dniCliente);
		}else {
			dniClienteI=0;
		}
		//BeanProducto producto=new BeanProducto(null,nomProducto, descProducto, preciovProductoD, stockProductoI);
		BeanCliente cliente=new BeanCliente(null, nomCliente, dniClienteI, dirCliente, razonSocial, rucCliente, emailCliente);
		if(idcliente!=null && !idcliente.equals("")) {
			cliente.setIdcliente(Integer.parseInt(idcliente));
		}
		return cliente;
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
