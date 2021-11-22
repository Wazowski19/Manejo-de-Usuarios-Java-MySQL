
package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.*;

public class TestManejoUsuarios {
    public static void main(String[] args) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        Usuario userInsert = new Usuario("berenice.romero", "789");
        Usuario userUpdate = new Usuario(3, "miguel.garcia", "135");
        Usuario userDelete = new Usuario(3);
        //usuarioDao.insertar(userInsert);
        
        //usuarioDao.update(userUpdate);
        
        usuarioDao.delete(userDelete);
        
        List<Usuario> usuarios = usuarioDao.select();
        for(Usuario usuario : usuarios){
            System.out.println("usuario = " + usuario);
        }
       
    }
    
    
}
