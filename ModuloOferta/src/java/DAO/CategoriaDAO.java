/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.CategoriasDTO;
import Util.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

/**
 *
 * @author LENOVO
 */
public class CategoriaDAO {
     String mensaje = "";
    PreparedStatement ps = null;
    Connection cn = null;
    ResultSet rs = null;

    public CategoriaDAO() {
        cn = Conexion.getIntance();
    }
    public CategoriasDTO obtenerUno(int id){
        CategoriasDTO categoria=new CategoriasDTO();
        try{
            String query="Select * from categorias where idCategoria=?;";
            ps=cn.prepareStatement(query);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            
            if(rs!=null){
                while (rs.next()){
                    categoria.setIdCategoria(rs.getInt("idCategoria"));
                    categoria.setDescripcion(rs.getString("descripcion"));
                }
            }
        }catch (SQLException ex) {
            mensaje = ex.getMessage();

        }
         return categoria;
        
    }
    
}
