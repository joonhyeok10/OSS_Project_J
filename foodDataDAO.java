package oss;

import java.sql.*;

public class foodDataDAO {
    Connection connection = null;
     Statement st = null;
     
     public Connection getConnection() throws ClassNotFoundException, SQLException { // DB와 연결하는 함수
        String url = "jdbc:mysql://localhost:3306/exp?useUnicode=true&CharacterEncoding=utf8&characterSetResults=utf8";
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(url, "root", "1234");
        
        return c;
     }
     public void insertProduct(Product product) throws ClassNotFoundException, SQLException { // 객체(Product) 삽입 함수
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("insert into fooddata(name, expdate) values(?, ?)");
        
        ps.setString(1, product.name);
        ps.setDate(2, product.expdate);
        
        ps.executeUpdate();
        
        ps.close();
        c.close();
     }
     
     public void deleteProduct(int id) throws ClassNotFoundException, SQLException { // 객체 삭제 함수
        Connection c = getConnection();
        
        //System.out.println("delete from fooddata where id = " + id);
        
        PreparedStatement ps = c.prepareStatement("delete from fooddata where id = " + id);
        
        ps.executeUpdate();
        
        ps.close();
        c.close();
     }
     
     public void deleteEproduct(int id) throws ClassNotFoundException, SQLException { // 객체 삭제 함수
        Connection c = getConnection();
        
        //System.out.println("delete from efooddata where id = " + id);
        
        PreparedStatement ps = c.prepareStatement("delete from efooddata where id = " + id);
        
        ps.executeUpdate();
        
        ps.close();
        c.close();
     }
     
     public Product get(int id) throws ClassNotFoundException, SQLException { // 객체 불러오기 함수
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("select * from fooddata where id = ?");
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        rs.next();
        Product food = new Product();
        food.setId(rs.getInt(id));
        food.setName(rs.getString("name"));
        food.setExpdate(rs.getDate("expdate"));
        
        rs.close();
        ps.close();
        c.close();
        
        return food;
     }
     
     public String[] showProduct() throws ClassNotFoundException, SQLException { // 여유있는 유통기한 테이블 정렬된 출력
        String [] result = new String[100];
        int i = 0;
        Connection c = getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("select * from fooddata order by expdate asc");
        rs.beforeFirst();
        
        while(rs.next()) {
           //System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("expdate"));
           result[i] = rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("expdate");
           i++;
        }
        return result;
     }
     
     public String[] showEproduct() throws ClassNotFoundException, SQLException { // 유통기한 임박(3일이내) 테이블 데이터 정렬된 출력
        String [] result = new String[100];
        int i = 0;
        Connection c = getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("select * from efooddata order by expdate asc");
        rs.beforeFirst();
        
        while(rs.next()) {
           //System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("expdate"));
           result[i] = rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("expdate");
           i++;
        }
        return result;
     }
     
     public void moveProduct() throws ClassNotFoundException, SQLException { // 유통기한 임박 제품(3일이내) 이동 함수구현
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("insert into efooddata "
              + "select * from fooddata where date(subdate(now(), interval 3 day)) AND date(expdate) <= date(now());"); //AND date(expdate) <= date(now()) 삭제해놨음
        
        ps.executeUpdate();
        
        c.close();
        ps.close();
     }
     
     public void afterMove() throws ClassNotFoundException, SQLException { // 유통기한 3일이내 테이블에서 현재날짜를 지난 제품 삭제
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("delete from fooddata where date(expdate) <= date(now());");
        
        ps.executeUpdate();
        
        c.close();
        ps.close();
     }
     
     public void afterEMove() throws ClassNotFoundException, SQLException { // 유통기한 3일이내 테이블에서 현재날짜를 지난 제품 삭제
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("delete from efooddata where date(expdate) <= date(now());");
        
        ps.executeUpdate();
        
        c.close();
        ps.close();
     }
}