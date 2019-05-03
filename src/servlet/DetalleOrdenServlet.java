package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BeanProducto;
import dao.ProductoDAO;

/**
 * Servlet implementation class DetalleOrdenServlet
 */
@WebServlet("/detalleOrdenServlet")
public class DetalleOrdenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDAO=new ProductoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleOrdenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	    	String accion=request.getParameter("accion");
				if(accion!=null) {
					if(accion.equals("BUSCAR")) {
						String nomProducto=request.getParameter("nomProducto");
						request.setAttribute("listaproducto", productoDAO.getProducto(nomProducto));
						RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/paginas/BuscarProducto.jsp");
						dispatcher.forward(request, response);
					}else if(accion.equals("AGREGAR")) {
						String codigo=request.getParameter("idproducto");
						Integer idproducto=Integer.parseInt(codigo);
						BeanProducto producto=ProductoDAO.getProductoID(idproducto);
						request.setAttribute("producto", producto);
						RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/paginas/BuscarProducto.jsp");
						dispatcher.forward(request, response);
					}

				}else {
				request.setAttribute("listaproducto", productoDAO.getProducto());
				request.setAttribute("contenido", "WEB-INF/paginas/BuscarProducto.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index2.jsp");
				//RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/paginas/BuscarProducto.jsp");
				dispatcher.forward(request, response);
				}
			}catch (SQLException | ClassNotFoundException | IllegalArgumentException e) {
				request.setAttribute("mensaje", "Error : "+e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/paginas/Error.jsp");
				dispatcher.forward(request, response);
			}
	}

	

}
