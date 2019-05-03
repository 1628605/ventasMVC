package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.BeanProducto;
import util.ValidacionException;

public class ProductoDAO {
	
	public List<BeanProducto> getProducto() throws SQLException,ClassNotFoundException{
		/*Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas","root","admin");*/
		Connection con=ConexionJDBCFactory.getConexion();
		PreparedStatement ps=con.prepareStatement("SELECT idproducto,nom_producto,desc_producto,preciov_producto,stock_producto FROM producto ");
		ResultSet rs=ps.executeQuery();
		List<BeanProducto> producto=new ArrayList<>();
		while(rs.next()) {
			producto.add(new BeanProducto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5)));
		}
		rs.close();
		ps.close();
		con.close();
		return producto;
	}
	
	public List<BeanProducto> getProducto(String nomProducto) throws SQLException,ClassNotFoundException{
		/*Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas","root","admin");*/
		Connection con=ConexionJDBCFactory.getConexion();
		PreparedStatement ps=con.prepareStatement("SELECT idproducto,nom_producto,desc_producto,preciov_producto,stock_producto FROM producto WHERE nom_producto LIKE '%?%'");
												//" + nomProducto + "
												//SELECT name FROM table_example WHERE name LIKE "%search%" OR description LIKE "%search%";
		ps.setString(1, nomProducto);
		ResultSet rs=ps.executeQuery();
		List<BeanProducto> producto=new ArrayList<>();
		while(rs.next()) {
			producto.add(new BeanProducto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5)));
		}
		rs.close();
		ps.close();
		con.close();
		return producto;
	}

	public void Guardar(BeanProducto producto) throws SQLException,ClassNotFoundException{
		Connection con=ConexionJDBCFactory.getConexion();
		PreparedStatement stat= con.prepareStatement("INSERT INTO producto(nom_producto,desc_producto,preciov_producto,stock_producto)"
				+ "values (?,?,?,?)");
		stat.setString(1, producto.getNomProducto());
		stat.setString(2, producto.getDescProducto());
		stat.setDouble(3, producto.getPreciovProducto());
		stat.setInt(4, producto.getStockProducto());
		stat.execute();
		stat.close();
		con.close();
	}

	public static void Eliminar(Integer idproducto) throws SQLException,ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection con=ConexionJDBCFactory.getConexion();
		PreparedStatement stat= con.prepareStatement("DELETE FROM producto WHERE idproducto=?");
		stat.setInt(1, idproducto);
		stat.execute();
		stat.close();
		con.close();
	}

	public static BeanProducto getProductoID(Integer idproducto) throws SQLException,ClassNotFoundException,IllegalArgumentException{//AGREGAR ValidacionException
		Connection con=ConexionJDBCFactory.getConexion();
		PreparedStatement ps=con.prepareStatement("SELECT idproducto,nom_producto,desc_producto,preciov_producto,stock_producto FROM producto WHERE idproducto=? ");
		ps.setInt(1, idproducto);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			return new BeanProducto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5));
		}
		rs.close();
		ps.close();
		con.close();
		throw new IllegalArgumentException("No se encontro producto para el codigo"+idproducto);

	}
	

	public void Actualizar(BeanProducto producto) throws SQLException,ClassNotFoundException{
		Connection con=ConexionJDBCFactory.getConexion();
		PreparedStatement stat= con.prepareStatement("UPDATE producto set nom_producto=?,desc_producto=?,preciov_producto=?,stock_producto=? WHERE idproducto=?");
		stat.setString(1, producto.getNomProducto());
		stat.setString(2, producto.getDescProducto());
		stat.setDouble(3, producto.getPreciovProducto());
		stat.setInt(4, producto.getStockProducto());
		stat.setInt(5, producto.getIdproducto());
		stat.execute();
		stat.close();
		con.close();
		
	}

	
		
	
}
