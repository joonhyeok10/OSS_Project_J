package oss;

import java.sql.*;

public class foodDataDAO {
	 Connection connection = null;
     Statement st = null;
     
     private Connection getConnection() throws ClassNotFoundException, SQLException {
    	 String url = "jdbc:mysql://localhost/op?useUnicode=yes&CharacterEncoding=utf-8";
    	 Class.forName("com.mysql.jdbc.Driver");
    	 Connection c = DriverManager.getConnection(url, "admin", "1234");
    	 
    	 return c;
     }
     public void insertProduct(Product product) throws ClassNotFoundException, SQLException {
    	 Connection c = getConnection();
    	 
    	 PreparedStatement ps = c.prepareStatement("insert into fooddata(name, expdate) values(?, ?)");
    	 ps.setString(1, product.getName());
    	 ps.setDate(2, product.getExpdate());
    	 
    	 ps.executeUpdate();
    	 
    	 ps.close();
    	 c.close();
     }
     
     public void deleteProduct(int id) throws ClassNotFoundException, SQLException {
    	 Connection c = getConnection();
    	 
    	 System.out.println("delete from fooddata where id = " + id);
    	 
    	 PreparedStatement ps = c.prepareStatement("delete from fooddata where id = " + id);
    	 
    	 ps.executeUpdate();
    	 //System.out.println(product.getId());
    	 ps.close();
    	 c.close();
     }
     
     /*public Product get(int id) throws ClassNotFoundException, SQLException {
    	 Connection c = getConnection();
    	 
     }*/
}
