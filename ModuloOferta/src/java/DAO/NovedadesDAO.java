/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.NovedadesDTO;
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
public class NovedadesDAO {
    String mensaje="";
    PreparedStatement ps = null;
    Connection cn = null;
    ResultSet rs = null;
    
    public NovedadesDAO() {
        cn = Conexion.getIntance();
    } 
    
    
    public LinkedList<NovedadesDTO> listartodos(){
        LinkedList<NovedadesDTO> novedades = new LinkedList<NovedadesDTO>();
        try {
            String query = "Select * from novedades;";
            ps = cn.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    NovedadesDTO novedad = new NovedadesDTO();
                    novedad.setIdNovedad(rs.getInt("idNovedad"));
                    novedad.setDescripcion(rs.getString("descripcion"));
                    novedad.setDetalle(rs.getFloat("detalle"));
                    novedades.add(novedad);

                }
            }
        } catch (SQLException ex) {
            mensaje = "Error" + ex.getSQLState() + " - " + ex.getMessage();
        }
        
        return novedades;
        
    }
    public NovedadesDTO obtenerUno(int id){
        NovedadesDTO novedad=new NovedadesDTO();
        try{
            String query="Select * from novedades where idNovedad=?;";
            ps=cn.prepareStatement(query);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            
            if(rs!=null){
                while (rs.next()){
                    novedad.setIdNovedad(rs.getInt("idNovedad"));
                    novedad.setDescripcion(rs.getString("descripcion"));
                }
            }
        }catch (SQLException ex) {
            mensaje = ex.getMessage();

        }
         return novedad;
        
    }
    
}
