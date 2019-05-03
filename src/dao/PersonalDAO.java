package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.BeanPersonal;



public class PersonalDAO {
	
	public List<BeanPersonal> getPersonal() throws SQLException,ClassNotFoundException{
		/*Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas","root","admin");*/
		Connection con=ConexionJDBCFactory.getConexion();
		PreparedStatement ps=con.prepareStatement("SELECT idpersonal,nom_personal,ape_personal,cargo_personal,clave_personal FROM personal ");
		ResultSet rs=ps.executeQuery();
		List<BeanPersonal> personal=new ArrayList<>();
		while(rs.next()) {
			personal.add(new BeanPersonal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
		}
		rs.close();
		ps.close();
		con.close();
		return personal;
		
	}
	
	public BeanPersonal obtenerPersonal(String log, String pas) throws Exception
	{
		
		BeanPersonal obj=null;
		
		Connection con=ConexionJDBCFactory.getConexion();
		PreparedStatement ps=con.prepareStatement("SELECT idpersonal,nom_personal,ape_personal,cargo_personal,clave_personal FROM personal WHERE nom_personal=? AND clave_personal=?");
		ps.setString(1, log);
		ps.setString(2, pas);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			return new BeanPersonal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}
		rs.close();
		ps.close();
		con.close();
		throw new IllegalArgumentException("No se encontro Acceso para el nombre"+log);

		
	}

	public void Guardar(BeanPersonal personal) throws SQLException,ClassNotFoundException{
		Connection con=ConexionJDBCFactory.getConexion();
		PreparedStatement stat= con.prepareStatement("INSERT INTO personal (nom_personal,ape_personal,cargo_personal,clave_personal) values (?,?,?,?)");
		stat.setString(1, personal.getNomPersonal());
		stat.setString(2, personal.getApePersonal());
		stat.setString(3, personal.getCargoPersonal());
		stat.setString(4, personal.getClavePersonal());
		stat.execute();
		stat.close();
		con.close();
	}

	public static void Eliminar(Integer idpersonal) throws SQLException,ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection con=ConexionJDBCFactory.getConexion();
		PreparedStatement stat= con.prepareStatement("DELETE FROM personal WHERE idpersonal=?");
		stat.setInt(1, idpersonal);
		stat.execute();
		stat.close();
		con.close();
	}

	public static BeanPersonal getPersonalID(Integer idpersonal) throws SQLException,ClassNotFoundException,IllegalArgumentException{//AGREGAR ValidacionException
		Connection con=ConexionJDBCFactory.getConexion();
		PreparedStatement ps=con.prepareStatement("SELECT idpersonal,nom_personal,ape_personal,cargo_personal,clave_personal FROM personal WHERE idpersonal=? ");
		ps.setInt(1, idpersonal);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			return new BeanPersonal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}
		rs.close();
		ps.close();
		con.close();
		throw new IllegalArgumentException("No se encontro producto para el codigo"+idpersonal);

	}

	public void Actualizar(BeanPersonal personal) throws SQLException,ClassNotFoundException{
		Connection con=ConexionJDBCFactory.getConexion();
		PreparedStatement stat= con.prepareStatement("UPDATE personal set nom_personal=?,ape_personal=?,cargo_personal=?,clave_personal=? where idpersonal=?");
		stat.setString(1, personal.getNomPersonal());
		stat.setString(2, personal.getApePersonal());
		stat.setString(3, personal.getCargoPersonal());
		stat.setString(4, personal.getClavePersonal());
		stat.setInt(5, personal.getIdpersonal());
		stat.execute();
		stat.close();
		con.close();
		
	}

}
