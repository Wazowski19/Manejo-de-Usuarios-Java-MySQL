
package datos;

import static datos.Conexion.*;
import domain.Usuario;
import java.sql.*;
import java.util.*;



public class UsuarioDAO {
   private static final String SQL_SELECT = "SELECT id_usuario, username, password FROM test.usuario"; 
   private static final String SQL_INSERT = "INSERT INTO test.usuario(username, password) VALUES(?, ?)";
   private static final String SQL_UPDATE = "UPDATE test.usuario SET username = ?, password = ? WHERE id_usuario = ?";
   private static final String SQL_DELETE = "DELETE FROM test.usuario WHERE id_usuario = ?";
   
   public List<Usuario> select(){
       Connection conn = null;
       PreparedStatement stmt= null;
       ResultSet rs = null;
       Usuario usuario = null;
       List<Usuario> usuarios = new ArrayList<>();
       try {
           conn = getConnection();
           stmt = conn.prepareStatement(SQL_SELECT);
           rs = stmt.executeQuery();
           while(rs.next()){
               int idPersona = rs.getInt("id_usuario");
               String username = rs.getString("username");
               String password = rs.getString("password");
               
               usuario = new Usuario(idPersona,username, password);
               usuarios.add(usuario);
           }
       } catch (SQLException ex) {
           ex.printStackTrace(System.out);
       }finally{
           try {
               close(rs);
               close(stmt);
               close(conn);
           } catch (SQLException ex) {
               ex.printStackTrace(System.out);
           }
       }
       return usuarios;
   }
   
   public int insertar(Usuario usuario){
       Connection conn = null;
       PreparedStatement stmt = null;
       int registros = 0;
       
       try {
           conn = getConnection();
           stmt = conn.prepareStatement(SQL_INSERT);
           stmt.setString(1, usuario.getUsuario());
           stmt.setString(2, usuario.getPassword());
           registros = stmt.executeUpdate();
       } catch (SQLException ex) {
           ex.printStackTrace(System.out);
       }finally{
           try {
               close(stmt);
               close(conn);
           } catch (SQLException ex) {
               ex.printStackTrace(System.out);
           }
       }
       return registros;
   }
   
   public int update(Usuario usuario){
       Connection conn = null;
       PreparedStatement stmt = null;
       int registros = 0;
       try {
           conn = getConnection();
           stmt = conn.prepareStatement(SQL_UPDATE);
           stmt.setString(1, usuario.getUsuario());
           stmt.setString(2, usuario.getPassword());
           stmt.setInt(3, usuario.getIdUsuario());
           registros = stmt.executeUpdate();
       } catch (SQLException ex) {
           ex.printStackTrace(System.out);
       }finally{
           try {
               close(stmt);
               close(conn);
           } catch (SQLException ex) {
               ex.printStackTrace(System.out);
           }
       }
       return registros;
   }
   
   public int delete(Usuario usuario){
       Connection conn = null;
       PreparedStatement stmt = null;
       int registros = 0;
       try {
           conn = getConnection();
           stmt = conn.prepareStatement(SQL_DELETE);
           stmt.setInt(1, usuario.getIdUsuario());
           registros = stmt.executeUpdate();
       } catch (SQLException ex) {
           ex.printStackTrace(System.out);
       }finally{
           try {
               close(stmt);
               close(conn);
           } catch (SQLException ex) {
               ex.printStackTrace(System.out);
           }
           
       }
       return registros;
   }
}
