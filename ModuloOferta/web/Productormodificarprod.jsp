<%@page import="java.util.LinkedList"%>
<%@page import="DAO.NovedadesDAO"%>
<%@page import="DTO.NovedadesDTO"%>
<%@page import="DAO.PresentacionDAO"%>
<%@page import="DTO.PresentacionDTO"%>
<%@page import="DAO.CategoriaDAO"%>
<%@page import="DTO.CategoriasDTO"%>
<%@page import="DAO.ProductosDAO"%>
<%@page import="DTO.ProductosDTO"%>
<%@page import="DAO.OfertarDAO"%>
<%@page import="DTO.OfertarDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/Pantilla produtor.dwt" codeOutsideHTMLIsLocked="false" -->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <!-- InstanceBeginEditable name="estilos" -->
        <link type="text/css" rel="stylesheet" href="Templates/Productor.css"/>
        <link type="text/css" rel="stylesheet" href="Stylos/Productormodificarp.css"/>
        <script src="Validacion/validacion.js" type="text/javascript"></script>
        <script src="Validacion/jquery-1.11.1.min.js" type="text/javascript"></script>
        <link type="text/css" rel="stylesheet" href="Stylos/mensajesmodificarpublicacion.css"/>
        <!-- InstanceEndEditable -->
        <link type="text/css" rel="stylesheet" href="Productor.css"/>
        <link rel="shortcut icon" href="img/favicon.ico">

            <title> Farmers Market</title>
    </head>
    <% HttpSession misession = request.getSession(false);
        OfertarDTO ofert = new OfertarDTO();
        OfertarDAO oferta = new OfertarDAO();
        ProductosDTO producto = null;
        CategoriasDTO categoria = null;
        NovedadesDTO nov = null;
        PresentacionDTO pre = null;
        LinkedList<NovedadesDTO> novedad;

        if (request.getParameter("id") != null) {
            ofert = oferta.obtenerUno(Integer.parseInt(request.getParameter("id")));
            out.print(ofert);
            ProductosDAO productos = new ProductosDAO();
            producto = productos.obtenerUno(ofert.getIdProducto());
            CategoriaDAO categorias = new CategoriaDAO();
            categoria = categorias.obtenerUno(ofert.getIdPresentacion());
            PresentacionDAO presentaciones = new PresentacionDAO();
            pre = presentaciones.obtenerUno(ofert.getIdPresentacion());
            NovedadesDAO novedades = new NovedadesDAO();
            novedad = novedades.listartodos();
            nov = novedades.obtenerUno(ofert.getIdNovedad());

        } else {
            novedad = new LinkedList<NovedadesDTO>();
            producto = new ProductosDTO();
            categoria = new CategoriasDTO();
            nov = new NovedadesDTO();
            pre = new PresentacionDTO();

        }
    %>
    <body>
        <div class="Banner"></div>
        <div class="Menu">
            <div class="Usuarios">
                <img src="img/ICONOPROD.gif" width="60px" height="70px" id="usuarioimg"/></div>
            <p id="usuario"> Productor <br> En línea</br></p>
            <div class="formUsuario">   
                <form action="" method="get" name="Buscar" id="formbuscar">
                    <input name="Buscar" type="text" placeholder="Buscar" id="buscarr"/>
                    <button name="Buscar" type="submit" id="busqueda"></button>
                </form>
            </div>
        </br>
            <div id="mimenu">
                <ul>
                    <li><img src="img/home.gif" width="25" height="25"/><a href="ProductorIndexla.jsp"> Inicio </a></li> 
                    <li><img src="img/publicaciones.gif" width="25" height="25"/><a href="Productorasociarp.jsp"> Asociar productos </a></li>
                    <li><img src="img/mispedidos.gif" width="25" height="25"/><a href="Productormisproductorasociados.jsp"> Mis productos</a></li>
                    <li><img src="img/ofertas.gif" width="25" height="25"/><a href="Productorpublicarc.jsp"> Ofertar </a></li> 
                    <li><img src="img/misproductos.gif" width="25" height="25"/><a href="ProductorMisofertas.jsp"> Mis ofertas </a></li> 
                    <li><img src="img/mispedidos.gif" width="25" height="25"/><a href="Productor Pedidos.html"> Mis pedidos </a></li> 
                    <li><img src="img/perfil.gif" width="25" height="25"/><a href="Productordatos.html"> Perfil </a></li> 
                </ul>
            </div>
        </div>    
        <div id="MenuH">   
            <ul>
                <li><img src="img/cambio.gif" width="20" height="20"/><a href="">Español</a></li>
                <li><img src="img/cambio.gif" width="20" height="20"/><a href="">Inglés</a></li>
                <li><img src="img/cambio.gif" width="20" height="20"/><a href="">Cerrar Sesión</a></li>
            </ul>
        </div>
        <div id="linea"></div>
        <div class="Contenido"><!-- InstanceBeginEditable name="contenid" -->
            <div id="formu">
                <div id="migapan">
                    <span itemscope itemtype="http://data-vocabulary.org/Breadcrumb">
                        <a href="ProductorIndexla.html" title="Ir a la pagina de inicio" itemprop="url"><span itemprop="title">Inicio > </span></a>
                            <span itemprop="child" itemscope itemtype="http://data-vocabulary.org/Breadcrumb">
                                <a href="ProductorMisofertas.jsp" title="Mis ofertas" itemprop="url"> 
                                    <span itemprop="title">Mis Ofertas</span></a>
                                <a href="Productormodificarprod.jsp" title="Modificar" itemprop="url"> 
                                    <span itemprop="title">Modificar Oferta</span></a>
                            </span></div>
                            <h1>Modificar Producto</h1>
                            <form action="Controlador" id="modificarp" method="post">
                                <legend><h3>Datos de producto</h3></legend></br>
                                <parrafo><em>Llene cada uno de los campos marcados habilitados con (*)</em></parrafo>
                                <table> 
                                    <tr><td><label for="Tipo">Producto</label></td>
                                        <td><input type="text" id="Tipo" disabled="disabled" value="<%=producto.getNombre()%>"/></td>
                                        <tr><td><label for="Categoria">Categoria</label></td>
                                            <td><input type="Categoria" id="Categoria"  disabled="disabled" value="<%=categoria.getDescripcion()%>"/></td>
                                            <tr><td><label for="Presentacion">Presentación</label></td>
                                                <td><input name="Presentacion" id="Presentacion" disabled="disabled" value="<%=pre.getDescripcion()%>"/></td>
                                            </tr>
                                            <tr><td><label for="Precio">Precio venta</label></td>
                                                <td><input name="Precio" type="text" id="Precio" disabled="disabled" value="<%if (ofert != null) {
                                                out.print(ofert.getPrecioVenta());
                                            }%>"/></td></tr>
                                            <tr><td><label for="fechaInicio">Fecha Inicio</label></td>
                                                <td><input type="text" name="fechainicio" id="fechainicio"  disabled="disabled" value="<%if (ofert != null) {
                                                out.print(ofert.getFechaInicio());
                                            }%>"/></td></tr>
                                            <tr><td><label for="fechafin">Fecha Fin*</label></td>
                                                <td><input type="date" name="fechafin" id="fechafin" value="<%if (ofert != null) {
                                                out.print(ofert.getFechaFin());
                                            }%>"  required="required" /></td></tr>
                                            <tr><td><p>Seleccione la oferta que desea aplicar al producto</p></td></tr>
                                            <tr><td><label for="novedad">Novedad*</label></td>
                                                <td><select name="novedad" id="novedad"  required="required" >
                                                        <option>[Seleccione una opción]</option>
                                                        <%
                                                            for (NovedadesDTO n : novedad) {
                                                        %>
                                                        <option value="<%=n.getIdNovedad()%>"><%=n.getDescripcion()%> </option>
                                                        <%
                                                            }

                                                        %>
                                                    </select></td>
                                            </tr>
                                            <tr><td><input type="hidden" name="modificarh" id="modificarh" value="<%=ofert.getIdOferta() %>" />
                                                    <button name="modificar" id="modificar" type="submit">Guardar</button></td>
                                            </tr>
                                            </table>
                                            </form>
                                            </div>

                                            <!-- InstanceEndEditable --></div>
                                            </body>
                                            <!-- InstanceEnd --></html>
