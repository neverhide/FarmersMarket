/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

/**
 *
 * @author LENOVO
 */
public class MyException extends Exception {/*creamos una clase que extiende de la clase Exception*/


    public MyException(String msg) {/*creamos un metodo constructor y le pasamos la variable mensaje*/

        super(msg);
    }

}
