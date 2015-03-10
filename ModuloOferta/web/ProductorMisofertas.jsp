<%@page import="DAO.OfertarDAO"%>
<%@page import="DTO.OfertarDTO"%>
<%@page import="java.util.LinkedList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/Pantilla produtor.dwt" codeOutsideHTMLIsLocked="false" -->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <!-- InstanceBeginEditable name="estilos" -->
        <link type="text/css" rel="stylesheet" href="Templates/Productor.css"/>
        <link type="text/css" rel="stylesheet" href="Stylos/Productorpublicacion.css"/>
        <script src="Stylos/jquery-1.4.4.min.js" type="text/javascript"></script>
        <script src="Stylos/smartpaginator.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('#black').smartpaginator({totalrecords: 50, recordsperpage: 19, datacontainer: 'productos', dataelement: 'tr', initval: 0, next: 'Next', prev: 'Prev', first: 'First', last: 'Last', theme: 'black'});
            });
        </script>
        <!-- InstanceEndEditable -->
        <link type="text/css" rel="stylesheet" href="Productor.css"/>
        <link rel="shortcut icon" href="img/favicon.ico"/>

        <title> Farmers Market</title>

        <script>
            function confirmar() {
                if (confirm('Esta seguro que desea borrar')) {
                    return true;
                } else {
                    return false;
                }
            }

        </script>
    </head>
    <body>
        <%
            HttpSession misession = request.getSession(false);
            OfertarDAO oferta = new OfertarDAO();
            LinkedList<OfertarDTO> ofertas = new LinkedList<OfertarDTO>();
            ofertas = (LinkedList<OfertarDTO>) oferta.listar();

        %>

        <div class="Banner"></div>
        <div class="Menu">
            <div class="Usuarios">
                <img src="img/ICONOPROD.gif" width="60px" height="70px" id="usuarioimg"/></div>
            <p id="usuario"> Productor <br> En línea</br></p>
            <div class="formUsuario">   
                <form action="" method="get" name="Buscar" id="formbuscar">
                    <input name="Buscar" type="text"  id="buscarr" />
                    <input name="Buscar" type="submit" id="busqueda" />
                </form>
            </div>
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
                <li><img src="img/cambio.gif" width="20" height="20"/><a href="">Ingles</a></li>
                <li><img src="img/cambio.gif" width="20" height="20"/><a href="">Cerrar Sesión</a></li>
            </ul>
        </div>
        <div id="linea"></div>
        <div class="Contenido"><!-- InstanceBeginEditable name="contenid" -->
            <div id="migapan">
                <span itemscope itemtype="http://data-vocabulary.org/Breadcrumb">
                    <a href="ProductorIndexla.jsp" title="Ir a la pagina de inicio" itemprop="url"> <span itemprop="title">Inicio > </span></a>
                        <span itemprop="child" itemscope itemtype="http://data-vocabulary.org/Breadcrumb">
                            <a href="Productormisproductorasociados.jsp" title="Mis publicaciones" itemprop="url"> 
                                <span itemprop="title">Mis ofertas</span></a></span></div>
                        <h2>Mis Ofertas</h2>
                        <label for="Cod producto">Buscar:</label><input type="text" name="q"  placeholder="Search..." size="8"/>
                        <label for="Precio">Precio:</label><select name="precio" class="precio" id="precio" >
                            <option selected="selected" value="">Ordenar por</option>
                            <option value="2">High to Low</option>
                            <option value="3">Low to High</option>
                        </select>           
                        <table class="productos" id= "productos">
                            <thead>
                                <tr>
                                    <th>Cod Oferta</th>
                                    <th>Productor</th>
                                    <th>Producto</th>
                                    <th>Presentación</th>
                                    <th>Descripción</th>
                                    <th>Precio Venta</th>
                                    <th>Fecha Inicio</th>
                                    <th>Fecha Fin</th>
                                    <th>Estado</th>
                                    <th>Modificar</th>
                                    <th>Eliminar</th>
                                </tr>
                            </thead>
                            <tbody>

                                <%                            for (OfertarDTO of : ofertas) {
                                %>
                                <tr>
                                    <td><%=of.getIdOferta()%></td>
                                    <td><%=of.getProductor()%></td>
                                    <td><%=of.getProducto()%></td>
                                    <td><%=of.getPresentacion()%></td>
                                    <td><%=of.getDescripcion()%></td>
                                    <td><%=of.getPrecioVenta()%></td>
                                    <td><%=of.getFechaInicio()%></td>
                                    <td><%=of.getFechaFin()%></td>
                                    <td><%=of.isEstado()%></td>
                                    <td><a href="Productormodificarprod.jsp?id=<%=of.getIdOferta()%>">Modificar</a></td>
                                    <td><a href="Controlador?id=<%=of.getIdOferta()%>" onclick="return confirmar();">Eliminar</a></td>
                                </tr>
                                <%    }
                                %>


                            </tbody>
                        </table>
                        <div id="black" style="margin: auto;">              
                            <!-- InstanceEndEditable --></div>
                        </body>
                        <!-- InstanceEnd --></html>
