/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import DAO.OfertarDAO;
import DAO.ProductosDAO;
import DTO.OfertarDTO;
import DTO.ProductosDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author LENOVO
 */
public class VerificarConexion {
    public static void main(String[] args) {
        Connection co=null;
        PreparedStatement ps;
        ResultSet rs;
        
        co = Conexion.getIntance();
        
        if (co != null) {
            System.out.println("Conectado");
        }
        
//        ProductosDAO dao = new ProductosDAO();
//        LinkedList<ProductosDTO> misProductos;
//        misProductos = ( LinkedList <ProductosDTO>) dao.listarTodos();
//        
//        for (ProductosDTO d: misProductos) {
//            System.out.println(d);
//        }
        
        OfertarDAO o = new OfertarDAO();
        LinkedList<OfertarDTO> misOfertas;
        
        misOfertas = (LinkedList<OfertarDTO>) o.listar();
        
        for (OfertarDTO d: misOfertas) {
            System.out.println(d);
        }
        
    }
    
}
