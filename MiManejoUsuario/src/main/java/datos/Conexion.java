package datos;

import java.sql.*;


public class Conexion {

    private final static String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private final static String JDBC_USER = "root";
    private final static String JDBC_PASSWORD = "admin";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
    
    public static void close(PreparedStatement st) throws SQLException{
        st.close();
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
}
