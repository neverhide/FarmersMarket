<%@page import="java.util.List"%>
<%@page import="com.sun.org.apache.xerces.internal.impl.dv.util.Base64"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.LinkedList"%>
<%@page import="DTO.ProductosDTO"%>
<%@page import="DAO.ProductosDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/Pantilla produtor.dwt" codeOutsideHTMLIsLocked="false" -->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <!-- InstanceBeginEditable name="estilos" -->
        <link type="text/css" rel="stylesheet" href="Templates/Productor.css"/>
        <link type="text/css" rel="stylesheet" href="Stylos/Productorasociarp.css"/>
        <script src="Stylos/jquery-1.4.4.min.js" type="text/javascript"></script>
        <script src="Stylos/smartpaginator.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('#black').smartpaginator({totalrecords: 24, recordsperpage: 16, datacontainer: 'asociarp', dataelement: 'tr', initval: 0, next: 'Next', prev: 'Prev', first: 'First', last: 'Last', theme: 'black'});
            });
        </script>
        <!-- InstanceEndEditable -->
        <link type="text/css" rel="stylesheet" href="Productor.css"/>
        <link rel="shortcut icon" href="img/favicon.ico">

            <%
                response.setHeader("Cache-Control", "no-cache");/*evita que el navegador almacene en cache la pagina */
                response.setHeader("Cache-Control", "no-store");
                response.setDateHeader("Expires", 0); /*controlar la memoria caché*/
            %>


    </head>
    <body>

        <%
            HttpSession misession = request.getSession(false); 
            //ProductosDAO producto = new ProductosDAO();
            //LinkedList<ProductosDTO> misproductos = producto.listarTodos();
            
            if(misession!=null && misession.getAttribute("producctos")!=null){
                ArrayList<ProductosDTO> misproductos = (ArrayList<ProductosDTO>) misession.getAttribute("producctos");
            
                       
        %>


        <div class="Banner"></div>
        <div class="Menu">
            <div class="Usuarios">
                <img src="img/ICONOPROD.gif" width="60px" height="70px" id="usuarioimg"/></div>
            <p id="usuario"> Productor <br> En línea</br></p>
            <div class="formUsuario">   
                <form action="" method="get" name="Buscar" id="formbuscar">
                    <input name="Buscar" type="text" placeholder="Buscar" id="buscarr"/>
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
                        <a href="Productorasociarp.jsp" title="Asociar productos" itemprop="url"> 
                            <span itemprop="title">Adjuntar productos</span></a></span>
            </div>
            <h1>Adjuntar productos</h1>
            <div id="tabla">
                <p style="color:#A90B08"><em>*Seleccione los productos que desea asociar</em></p></br>
                <form id="buscarpr" action="Controlador" method="post">
                    <label for="Producto">Producto</label>
                    <input type="text" id="buscarp" name="buscarp" />
                    <label for="Categoria">Categoria</label>
                    <input type="text" id="buscarc" name="buscarc" />
                    <button type="submit" id="buscarbtn" name="buscarbtn">Buscar</button>

                    <table id="asociarp">
                        <thead>
                            <tr>
                                <th>Id Producto</th>
                                <th>Nombre</th>
                                <th>Presentación</th>
                                <th>Categoria</th>
                                <th>Precio</th>
                                <th>imagen</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (ProductosDTO l : misproductos) {%>
                            <tr>
                                <td><%=l.getIdProducto()%></td>
                                <td><%=l.getNombre()%></td>
                                <td><%=l.getUnidad()%></td>
                                <td><%=l.getDescripcion()%></td>
                                <td><%=l.getPrecioCompra()%></td>
                                <td><img src="<%="data:image/jpeg;base64," + Base64.encode(l.getImagen().getBytes(1, (int) l.getImagen().length()))%>"/></td>
                                <td><input name="<%=l.getIdProducto()%>" type="checkbox" id="<%=l.getIdProducto()%>" /></td>

                            </tr>

                            <%}%>
                            <tr>
                                <td></td><td></td><td></td><td></td><td></td><td><input type="hidden" value="" name="adjuntarp" id="adjuntarp" />
                                    <button type="submit" name="adjuntar" id="adjuntar">adjuntar</button></td>
                                <td>
                                </td>
                            </tr>
                        </tbody>
                    </table>  
                </form>
                <div id="black"></div>x

            </div>
            <div id="mensajes">
                <form id="correos" action="GestionCorreo" method="post">
                    <h4>Contáctese con el Administrador</h4>
                    <input type="hidden" name="direccion" id="direccion" value="ladyaguilar26o@gmail.com"></input>
                    <label for="asunto">Asunto:</label>
                    <input type="text" name="asunto" id="asunto"></input>
                    <label for="mensaje">Mensaje:</label>
                    <textarea name="mensaje" id="mensaje" rows="7" cols="28"></textarea>
                    <br></br>
                    <button type="submit" name="enviarcorreo" id="enviarcorreo">Enviar</button>
                </form>
            </div>
            <!-- InstanceEndEditable --></div>
            <%
    if(request.getParameter("msg")!= null){
        out.print(request.getParameter("msg"));
                        
    }
            }
            
            %>

    </body>

    <!-- InstanceEnd --></html>
