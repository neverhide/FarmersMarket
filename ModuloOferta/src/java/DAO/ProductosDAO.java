/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ProductosDTO;
import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ProductosDAO {

    String mensaje = "";
    PreparedStatement ps = null;
    Connection cn = null;
    ResultSet rs = null;

    public ProductosDAO() {
        cn = Conexion.getIntance();
    }

    public LinkedList<ProductosDTO> listarTodos() {
        LinkedList<ProductosDTO> productos = new LinkedList();
        try {
            String query = "Select productos.idProducto, productos.nombres, productos.unidad,"
                    + "categorias.descripcion, productos.precioCompra, productos.imagen from productos "
                    + "inner join categorias on productos.idCategoria = categorias.idCategoria";
            ps = cn.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    ProductosDTO producto = new ProductosDTO();
                    producto.setIdProducto(rs.getInt("idProducto"));
                    producto.setNombre(rs.getString("nombres"));
                    producto.setUnidad(rs.getString("unidad"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setPrecioCompra(rs.getFloat("precioCompra"));
                    producto.setImagen(rs.getBlob("imagen"));
                    productos.add(producto);

                }
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getSQLState() + " - " + ex.getMessage());
        }
        return productos;

    }

    public ProductosDTO obtenerUno(int id) {
        ProductosDTO pdto = new ProductosDTO();
        try {
            ps = cn.prepareStatement("select*from productos where idProducto=?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {

                    pdto.setIdProducto(rs.getInt("idProducto"));
                    pdto.setNombre(rs.getString("nombres"));
                    pdto.setUnidad(rs.getString("unidad"));
                    pdto.setIdCategoria(rs.getInt("idCategoria"));
                    pdto.setPrecioCompra(rs.getFloat("precioCompra"));
                    pdto.setImagen(rs.getBlob("imagen"));
                }
            }
        } catch (SQLException ex) {
            mensaje = ex.getMessage();

        }
        return pdto;
    }

    public List<ProductosDTO> consultarProductos(String producto, String categoria) {
        ArrayList<ProductosDTO> misproductos = new ArrayList();
        try {
            StringBuilder sb = new StringBuilder("Select productos.idProducto, productos.nombres, productos.unidad,"
                    + "categorias.descripcion, productos.precioCompra, productos.imagen from productos "
                    + "inner join categorias on productos.idCategoria = categorias.idCategoria where 1=1");
            if (producto != null) {
                sb.append("AND productos.nombres LIKE '").append(producto).append("%'");
            }
            if (categoria != null) {
                sb.append("AND categorias.descripcion LIKE '").append(categoria).append("%'");
            }
            ps = cn.prepareStatement(sb.toString());
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ProductosDTO productos = new ProductosDTO();
                    productos.setIdProducto(rs.getInt("idProducto"));
                    productos.setNombre(rs.getString("nombres"));
                    productos.setUnidad(rs.getString("unidad"));
                    productos.setDescripcion(rs.getString("descripcion"));
                    productos.setPrecioCompra(rs.getFloat("precioCompra"));
                    productos.setImagen(rs.getBlob("imagen"));
                    misproductos.add(productos);

                }
            }
        }catch (SQLException ex) {

        }
        return misproductos;
    }

}
