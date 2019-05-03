package servlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import bean.BeanProducto;
import dao.ProductoDAO;
import util.NumberException;
import util.ValidacionException;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/productoServlet")
public class ProductoServlet extends HttpServlet {
	
	
    
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDAO=new ProductoDAO();
	//private BeanProducto producto=new BeanProducto();
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// CRUD CREATE RETRIEVE UPDATE DELETE
    	String menu=request.getParameter("menu");
    	request.setAttribute("menu", menu);
    	try {
    	String accion=request.getParameter("accion");
			if(accion!=null) {
				if(accion.equals("CREATE")) {
					BeanProducto producto= CrearProducto(request);
					try {
						producto.valida();
						if(producto.getIdproducto()!=null) {
							productoDAO.Actualizar(producto);
							request.setAttribute("mensaje", "Producto se Actualizo con exito ");
						}else {
							productoDAO.Guardar(producto);
							request.setAttribute("mensaje", "Producto se guardo con exito ");	
						}
					} catch (ValidacionException e) {
						request.setAttribute("mensaje", "Error en validacion de los campos de texto "+e.getMessage());
						request.setAttribute("producto", producto);
					} catch (NumberException e){
						request.setAttribute("mensaje", "Error en validacion de los campos numericos "+e.getMessage());
						request.setAttribute("producto", producto);
					} catch (NumberFormatException e){
						request.setAttribute("mensaje", "Error en validacion de los campos numericos ");
						request.setAttribute("producto", producto);
					}
					
					
				}else if(accion.equals("RETRIEVE")) {
					String codigo=request.getParameter("codigo");
					Integer idproducto=Integer.parseInt(codigo);
					BeanProducto producto=ProductoDAO.getProductoID(idproducto);
					request.setAttribute("producto", producto);
				}else if(accion.equals("DELETE")) {
					String codigo=request.getParameter("codigo");
					Integer idproducto=Integer.parseInt(codigo);
					ProductoDAO.Eliminar(idproducto);
					request.setAttribute("mensaje", "Producto Eliminado");
				}
			}
			request.setAttribute("listaproducto", productoDAO.getProducto());
			//RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/paginas/Producto2.jsp");
			request.setAttribute("contenido", "WEB-INF/paginas/Producto2.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index2.jsp");
			dispatcher.forward(request, response);
		}catch (SQLException | ClassNotFoundException | IllegalArgumentException e) {
			request.setAttribute("mensaje", "Error : "+e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/paginas/Error.jsp");
			dispatcher.forward(request, response);
		}
		
    }

	private BeanProducto CrearProducto(HttpServletRequest request) {
		Double preciovProductoD;
		Integer stockProductoI;
		String idproducto = request.getParameter("idproducto");
		String nomProducto = request.getParameter("nomProducto");
		String descProducto = request.getParameter("descProducto");
		String preciovProducto = request.getParameter("preciovProducto");
		String stockProducto = request.getParameter("stockProducto");
		
		if(!preciovProducto.isEmpty()) {
			preciovProductoD=Double.parseDouble(preciovProducto);
		}else {
			preciovProductoD=0.0;
		}
		if(!stockProducto.isEmpty()) {
			stockProductoI=Integer.parseInt(stockProducto);
		}else {
			stockProductoI=0;
		}
		BeanProducto producto=new BeanProducto(null,nomProducto, descProducto, preciovProductoD, stockProductoI);
		if(idproducto!=null && !idproducto.equals("")) {
			producto.setIdproducto(Integer.parseInt(idproducto));
		}
		return producto;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion=request.getParameter("accion");
		String codigo=request.getParameter("codigo");
		
		try {
			if(accion!=null && accion.equals("eliminar")) {
				Integer idproducto=Integer.parseInt(codigo);
				ProductoDAO.Eliminar(idproducto);
				request.setAttribute("mensaje", "Producto Eliminado");
			} else if(accion!=null && accion.equals("editar")) {
				Integer idproducto=Integer.parseInt(codigo);
				BeanProducto producto=ProductoDAO.getProductoID(idproducto);
				request.setAttribute("producto", producto);
			}
			request.setAttribute("listaproducto", productoDAO.getProducto());
		} catch (SQLException e) {
			request.setAttribute("mensaje", "Error en base de datos");
		} catch (ClassNotFoundException e) {
			request.setAttribute("mensaje", "Error de Driver:");
		} catch (ValidacionException e) {
			request.setAttribute("mensaje", "Error en validacion "+e.getMessage());
		} 
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//List<BeanProducto> producto=new ArrayList<>();
		//producto.add(new BeanProducto(000001, "MEMORIA RAM", "1GB", 120.0, 10));
		//request.setAttribute("producto", producto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/paginas/Producto.jsp");
		dispatcher.forward(request, response);
		//PrintWriter pw = response.getWriter();
		//pw.write("<html><body>"+producto.toString()+"</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//BeanProducto producto;
		
		
		Double preciovProductoD;
		Integer stockProductoI;
		String idproducto = request.getParameter("idproducto");
		String nomProducto = request.getParameter("nomProducto");
		String descProducto = request.getParameter("descProducto");
		String preciovProducto = request.getParameter("preciovProducto");
		String stockProducto = request.getParameter("stockProducto");
		
		if(!preciovProducto.isEmpty()) {
			preciovProductoD=Double.parseDouble(preciovProducto);
		}else {
			preciovProductoD=0.0;
		}
		if(!stockProducto.isEmpty()) {
			stockProductoI=Integer.parseInt(stockProducto);
		}else {
			stockProductoI=0;
		}
		producto=new BeanProducto(null,nomProducto, descProducto, preciovProductoD, stockProductoI);
		if(idproducto!=null && !idproducto.equals("")) {
			producto.setIdproducto(Integer.parseInt(idproducto));
		}
		try {
			producto.valida();
			if(producto.getIdproducto()!=null) {
				productoDAO.Actualizar(producto);
				request.setAttribute("mensaje", "Producto se Actualizo con exito ");
			}else {
				productoDAO.Guardar(producto);
				request.setAttribute("mensaje", "Producto se guardo con exito ");	
			}
			
		} catch (ValidacionException e) {
			request.setAttribute("mensaje", "Error en validacion de los campos de texto "+e.getMessage());
			request.setAttribute("producto", producto);
		} catch (SQLException e) {
			request.setAttribute("mensaje", "Error en base de datos "+e.getMessage());
			request.setAttribute("producto", producto);
		} catch (ClassNotFoundException e) {
			request.setAttribute("mensaje", "Error de Driver: "+e.getMessage());
			request.setAttribute("producto", producto);
		} catch (NumberException e){
			request.setAttribute("mensaje", "Error en validacion de los campos numericos "+e.getMessage());
			request.setAttribute("producto", producto);
		} catch (NumberFormatException e){
			request.setAttribute("mensaje", "Error en validacion de los campos numericos ");
			request.setAttribute("producto", producto);
		}
		try {
			request.setAttribute("listaproducto", productoDAO.getProducto());
		} catch (SQLException f) {
			request.setAttribute("mensaje", "Error en base de datos "+f.getMessage());
			request.setAttribute("producto", producto);
		} catch (ClassNotFoundException f) {
			request.setAttribute("mensaje", "Error de Driver: "+f.getMessage());
			request.setAttribute("producto", producto);
		} 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/paginas/Producto.jsp");
		dispatcher.forward(request, response);
		
	}*/
	
}
