

package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class Conexion {
    private static Connection conexion=null;
    
    private static void conectar(){ /*creo el metodo*/
        try{
            /*Encargado de realizar conexión con la Base de Datos. Se carga mediante el método estático:
             forName() de la clase java.lang.Class.*/
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            /*El encargado de abrir una conexión es el Driver Manager mediante el método estático: url: Identificador de la Base de Datos
              usr: Usuario con el que se abre la conexión (opcional), pwr: Contraseña del Usuario (opcional)*/
            conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/farm2015", "root", "");
            
            
        }catch (SQLException e){
         System.out.println("Error de MySQL: " + e.getMessage());
        
       }catch (Exception e){
         System.out.println("Error inesperado: " + e.getMessage());
       }
    }
    /*Patron singleton, Garantiza que una clase sólo tenga una instancia y proporciona un punto de acceso global a ella.*/
     private Conexion(){/*metodo vacio*/   
     }
     public static Connection getIntance(){
         if (conexion==null){
             conectar();
         }
     return conexion;
    }
    
}
