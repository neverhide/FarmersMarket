/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.OfertarDTO;
import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class OfertarDAO {

    String mensaje = "";
    PreparedStatement ps = null;
    Connection cn = null;
    ResultSet rs = null;

    public OfertarDAO() {
        cn = Conexion.getIntance();
    }

    public String CrearOferta(OfertarDTO oferta) throws MyException {
        try {
            int resultado = 0;
            ps = cn.prepareStatement("Insert into Oferta values (?,?,?,?,?,?,?,?,?);");
            ps.setInt(1, 0);//quitar esto cuando el campo sea auto incremental
            ps.setInt(2, oferta.getIdPresentacion());
            ps.setInt(3, oferta.getIdProducto());
            ps.setInt(4, oferta.getIdProductor());
            ps.setFloat(5, oferta.getPrecioVenta());
            ps.setInt(6, oferta.getIdNovedad());
            ps.setString(7, oferta.getFechaInicio());
            ps.setString(8, oferta.getFechaFin());
            ps.setBoolean(9, oferta.isEstado());
            resultado = ps.executeUpdate();
            if (resultado != 0) {
                mensaje = "La oferta ha sido registrada exitosamente" + resultado + "filas afectadas";
            } else {
                throw new MyException("Error no se pudo registrar");
            }
        } catch (SQLException ex) {
            mensaje = "Error" + ex.getMessage();
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {

            }
        }
        return mensaje;

    }

    public List<OfertarDTO> listar() {
        LinkedList<OfertarDTO> mylist = new LinkedList<>();
        try {
            String query = "Select oferta.idOferta, CONCAT(usuarios.nombres, usuarios.apellidos) as Productor,"
                    + " productos.nombres as Producto, presentacion.descripcion as Presentación,"
                    + " novedades.descripcion, oferta.precioVenta, oferta.fechaInicio, oferta.fechaFin, oferta.estado from oferta"
                    + " inner join presentacion on oferta.idPresentacion=presentacion.idPresentacion"
                    + " inner join productos on oferta.idProducto=productos.idProducto"
                    + " inner join usuarios on oferta.idProductor=usuarios.idUsuario"
                    + " inner join novedades on oferta.idNovedad=novedades.idNovedad";
            ps = cn.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    OfertarDTO ofertas = new OfertarDTO();
                    ofertas.setIdOferta(rs.getInt("idOferta"));
                    ofertas.setProductor(rs.getString("Productor"));
                    ofertas.setProducto(rs.getString("Producto"));
                    ofertas.setPresentacion(rs.getString("Presentación"));
                    ofertas.setDescripcion(rs.getString("descripcion"));
                    ofertas.setPrecioVenta(rs.getFloat("precioVenta"));
                    ofertas.setFechaInicio(rs.getString("fechaInicio"));
                    ofertas.setFechaFin(rs.getString("fechaFin"));
                    ofertas.setEstado(rs.getBoolean("estado"));
                    mylist.add(ofertas);

                }
            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex.getSQLState() + " - " + ex.getMessage());
        }
        return mylist;
    }

    public String eliminarOferta(int id) {
        int resultado = 0;
        try {
            ps = cn.prepareStatement("Delete from oferta where idOferta=?");
            ps.setInt(1, id);
            resultado = ps.executeUpdate();

            if (resultado > 0) {
                mensaje = "Se elimino" + resultado + "registro";
            } else {
                mensaje = "No se elimino ningun registro";
            }
        } catch (SQLException ex) {
            mensaje = "Error" + ex.getMessage();
        }
        return mensaje;

    }
    public String modificarOferta(OfertarDTO oferta) {
        try {
            int resul = 0;
           
            ps = cn.prepareStatement("Update oferta set fechaFin = ?, idNovedad=? where idOferta = ?");
            ps.setString(1, oferta.getFechaFin());
            ps.setInt(2, oferta.getIdNovedad());
            ps.setInt(3, oferta.getIdOferta());            
            resul = ps.executeUpdate();

            if (resul != 0) {
                mensaje = "Se modifico" + resul + "refistro";
            } else {
                mensaje = "No se modifico ningun registro";
            }
        } catch (SQLException ex) {
            mensaje = "Error" + ex.getMessage();
        }
        return mensaje;
    }
    public OfertarDTO obtenerUno(int id){
        OfertarDTO oferta = new OfertarDTO();
        try{
            ps=cn.prepareStatement("Select*from oferta where idOferta=?");
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    oferta.setIdOferta(rs.getInt("idOferta"));
                    oferta.setIdPresentacion(rs.getInt("idPresentacion"));
                    oferta.setIdProducto(rs.getInt("idProducto"));
                    oferta.setIdProductor(rs.getInt("idProductor"));
                    oferta.setPrecioVenta(rs.getFloat("precioVenta"));
                    oferta.setIdNovedad(rs.getInt("idNovedad"));
                    oferta.setFechaInicio(rs.getString("fechaInicio"));
                    oferta.setFechaFin(rs.getString("fechaFin"));
                    oferta.setEstado(rs.getBoolean("estado"));
                }
            }
        } catch (SQLException ex) {
            mensaje = ex.getMessage();

        }
        return oferta;
    }
}
