/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.PresentacionDTO;
import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author LENOVO
 */
public class PresentacionDAO {
    String mensaje="";
    PreparedStatement ps = null;
    Connection cn = null;
    ResultSet rs = null;
    
    public PresentacionDAO() {
        cn = Conexion.getIntance();
    } 
    
    public LinkedList<PresentacionDTO> listarTodos(){
        LinkedList<PresentacionDTO> presentaciones = new LinkedList<PresentacionDTO>();
        try {
            String query = "Select * from presentacion;";
            ps = cn.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    PresentacionDTO presentacion = new PresentacionDTO();
                    presentacion.setIdPresentacion(rs.getInt("idPresentacion"));
                    presentacion.setDescripcion(rs.getString("descripcion"));
                    presentacion.setDetallevalor(rs.getFloat("conversion"));
                    presentaciones.add(presentacion);

                }
            }
        } catch (SQLException ex) {
            mensaje = "Error" + ex.getSQLState() + " - " + ex.getMessage();
        }
        
        return presentaciones;
    
}
    public PresentacionDTO obtenerUno(int id){
        PresentacionDTO presentacion=new PresentacionDTO();
        try{
            String query="Select * from presentacion where idPresentacion=?;";
            ps=cn.prepareStatement(query);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            
            if(rs!=null){
                while (rs.next()){
                    presentacion.setIdPresentacion(rs.getInt("idPresentacion"));
                    presentacion.setDescripcion(rs.getString("descripcion"));
                    
                }
            }
        }catch (SQLException ex) {
            mensaje = ex.getMessage();

        }
         return presentacion;
        
    }
}
