/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.MyException;
import DAO.OfertarDAO;
import DAO.ProductosDAO;
import DTO.OfertarDTO;
import DTO.ProductosDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LENOVO
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession misesion = request.getSession(true);
            if(request.getParameter("buscarbtn")!=null){
                ArrayList<ProductosDTO> producctos = new ArrayList<ProductosDTO>();
                ProductosDAO products = new ProductosDAO();
                String producto= request.getParameter("buscarp");
                String categoria= request.getParameter("buscarc");
                producctos= (ArrayList<ProductosDTO>) products.consultarProductos(producto, categoria);
                if(producctos.size()==0){
                    String mensaje="No se encontraron resultados";
                    response.sendRedirect("Contactaradmin.jsp?msg="+mensaje);
                }else{
                    misesion.setAttribute("producctos", producctos);
                    response.sendRedirect("Productorasociarp.jsp");
                }

            }if (request.getParameter("adjuntar") != null && request.getParameter("adjuntarp") != null) {
                ProductosDAO product = new ProductosDAO();
                LinkedList<ProductosDTO> productos = product.listarTodos();
                LinkedList<ProductosDTO> misproductos = new LinkedList<ProductosDTO>();
                for (ProductosDTO l : productos) {
                    String seleccionado = request.getParameter(Integer.toString(l.getIdProducto()));
                    if (seleccionado != null) {
                        misproductos.add(l);
                    }
                }
                misesion.setAttribute("misproductos", misproductos);
                response.sendRedirect("Productormisproductorasociados.jsp");

            } else if (request.getParameter("publicar") != null) {
                ProductosDTO producto;
                String seleccionado = request.getParameter("producto");
                if (seleccionado != null) {
                    ProductosDAO products = new ProductosDAO();
                    producto = products.obtenerUno(Integer.parseInt(seleccionado));
                    misesion.setAttribute("producto", producto);
                    response.sendRedirect("Productorpublicar.jsp");

                } else {
                    String mensaje = "No ha seleccionado ningun producto";
                    response.sendRedirect("Productormisproductorasociados.jsp?mensaje=" + mensaje);
                }
            } else if (request.getParameter("enviar") != null) {

                OfertarDTO oferta = new OfertarDTO();
                oferta.setIdProducto(Integer.parseInt(request.getParameter("idProducto")));
                oferta.setIdProductor(1);//valor del usuario que inicia sesión 
                oferta.setIdPresentacion(Integer.parseInt(request.getParameter("Presentacion")));
                oferta.setPrecioVenta(Float.parseFloat(request.getParameter("precioVenta")));
                oferta.setIdNovedad(Integer.parseInt(request.getParameter("novedad")));
                oferta.setFechaInicio(request.getParameter("fechainicio"));
                oferta.setFechaFin(request.getParameter("fechafin"));
                oferta.setEstado(true);
                OfertarDAO ofertas = new OfertarDAO();
                String mensaje = ofertas.CrearOferta(oferta);
                out.print("mensaje: " + mensaje);
                response.sendRedirect("ProductorMisofertas.jsp?msg=" + mensaje);/*redireccionamos despues de enviar el mensaje de*/

            } else if (request.getParameter("id") != null) {
                OfertarDAO oferta = new OfertarDAO();
                String mensaje = oferta.eliminarOferta(Integer.parseInt(request.getParameter("id")));
                response.sendRedirect("ProductorMisofertas.jsp?msg=" + mensaje);

            } else if (request.getParameter("modificar") != null && request.getParameter("modificarh") != null) {
                OfertarDTO ofertas = new OfertarDTO();
                ofertas.setIdOferta(Integer.parseInt(request.getParameter("modificarh")));
                ofertas.setFechaFin(request.getParameter("fechafin"));
                ofertas.setIdNovedad(Integer.parseInt(request.getParameter("novedad")));
                OfertarDAO ofert = new OfertarDAO();

                String mensajes = ofert.modificarOferta(ofertas);
                out.print(mensajes);
                response.sendRedirect("ProductorMisofertas.jsp?msg" + mensajes);
            }
        } catch (MyException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
