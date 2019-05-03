package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.BeanCliente;

public class ClienteDAO {
	public List<BeanCliente> getCliente() throws SQLException,ClassNotFoundException{
		/*Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas","root","admin");*/
		Connection con=ConexionJDBCFactory.getConexion();
		PreparedStatement ps=con.prepareStatement("SELECT idcliente,nom_cliente,dni_cliente,dir_cliente,razon_social,ruc_cliente,email_cliente FROM cliente ");
		ResultSet rs=ps.executeQuery();
		List<BeanCliente> cliente=new ArrayList<>();
		while(rs.next()) {
			cliente.add(new BeanCliente(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
		}
		rs.close();
		ps.close();
		con.close();
		return cliente;
		
	}

	public void Guardar(BeanCliente cliente) throws SQLException,ClassNotFoundException{
		Connection con=ConexionJDBCFactory.getConexion();
		PreparedStatement stat= con.prepareStatement("INSERT INTO cliente (nom_cliente,dni_cliente,dir_cliente,razon_social,ruc_cliente,email_cliente) values (?,?,?,?,?,?)");
		stat.setString(1, cliente.getNomCliente());
		stat.setInt(2, cliente.getDniCliente());
		stat.setString(3, cliente.getDirCliente());
		stat.setString(4, cliente.getRazonSocial());
		stat.setString(5, cliente.getRucCliente());
		stat.setString(6, cliente.getEmailCliente());
		stat.execute();
		stat.close();
		con.close();
	}

	public static void Eliminar(Integer idcliente) throws SQLException,ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection con=ConexionJDBCFactory.getConexion();
		PreparedStatement stat= con.prepareStatement("DELETE FROM cliente WHERE idcliente=?");
		stat.setInt(1, idcliente);
		stat.execute();
		stat.close();
		con.close();
	}

	public static BeanCliente getClienteID(Integer idcliente) throws SQLException,ClassNotFoundException,IllegalArgumentException{//AGREGAR ValidacionException
		Connection con=ConexionJDBCFactory.getConexion();
		PreparedStatement ps=con.prepareStatement("SELECT idcliente,nom_cliente,dni_cliente,dir_cliente,razon_social,ruc_cliente,email_cliente FROM cliente WHERE idcliente=? ");
		ps.setInt(1, idcliente);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			return new BeanCliente(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
		}
		rs.close();
		ps.close();
		con.close();
		throw new IllegalArgumentException("No se encontro producto para el codigo"+idcliente);
	}
	
	public static BeanCliente getClienteRUC(String rucCliente) throws SQLException,ClassNotFoundException,IllegalArgumentException{//AGREGAR ValidacionException
		Connection con=ConexionJDBCFactory.getConexion();
		PreparedStatement ps=con.prepareStatement("SELECT idcliente,nom_cliente,dni_cliente,dir_cliente,razon_social,ruc_cliente,email_cliente FROM cliente WHERE ruc_cliente=? ");
		ps.setString(1, rucCliente);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			return new BeanCliente(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
		}
		rs.close();
		ps.close();
		con.close();
		throw new IllegalArgumentException("No se encontro Cliente para el RUC"+rucCliente);
	}

	public void Actualizar(BeanCliente cliente) throws SQLException,ClassNotFoundException{
		Connection con=ConexionJDBCFactory.getConexion();
		PreparedStatement stat= con.prepareStatement("UPDATE cliente set nom_cliente=?,dni_cliente=?,dir_cliente=?,razon_social=?,ruc_cliente=?,email_cliente=? where idcliente=?");
		stat.setString(1, cliente.getNomCliente());
		stat.setInt(2, cliente.getDniCliente());
		stat.setString(3, cliente.getDirCliente());
		stat.setString(4, cliente.getRazonSocial());
		stat.setString(5, cliente.getRucCliente());
		stat.setString(6, cliente.getEmailCliente());
		stat.setInt(7, cliente.getIdcliente());
		stat.execute();
		stat.close();
		con.close();
		
	}
}
