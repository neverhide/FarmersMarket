/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

/**
 *
 * @author LENOVO
 */
import Controlador.Correo;

/**
 *
 * @author admin
 */
public class TestCorreo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        if (Correo.sendMail("Producto", "Cuerpo del mensaje", "ladyaguilar26o@gmail.com")) {

            System.out.println("envío Correcto");

        } else {
            System.out.println("envío Fallido");
        }

    }
}
