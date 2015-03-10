<%@page import="DAO.PresentacionDAO"%>
<%@page import="DTO.PresentacionDTO"%>
<%@page import="DAO.NovedadesDAO"%>
<%@page import="DTO.NovedadesDTO"%>
<%@page import="java.util.LinkedList"%>
<%@page import="DAO.CategoriaDAO"%>
<%@page import="DTO.CategoriasDTO"%>
<%@page import="DTO.ProductosDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/Pantilla produtor.dwt" codeOutsideHTMLIsLocked="false" -->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <!-- InstanceBeginEditable name="estilos" -->
        <link type="text/css" rel="stylesheet" href="Templates/Productor.css"/>
        <link type="text/css" rel="stylesheet" href="Stylos/Productorpublicarpacs.css"/> 
        <!-- InstanceEndEditable -->
        <link rel="shortcut icon" href="img/favicon.ico"/>

        <title> Farmers Market</title>

        <script type="text/javascript">



            /*function activar(elemento) {
             if (elemento.novedad.options[elemento.novedad.selectedIndex].text == "porcentaje")
             {
             
             document.getElementById("aparece").style.display = "inline";
             document.getElementById("aparece1").style.display = "inline";
             }
             else if (elemento.novedad.options[elemento.novedad.selectedIndex].text == "Segunda unidad con %"){
             
             document.getElementById("aparece").style.display = "inline";
             document.getElementById("aparece1").style.display = "inline";
             }
             else 
             {
             document.getElementById("aparece").style.display = "none";
             document.getElementById("aparece1").style.display = "none";
             }
             }*/






        </script>

    </head>
    <body>
        <%
            HttpSession misession = request.getSession(false);
            CategoriasDTO categoria;
            ProductosDTO producto = null;
            LinkedList<NovedadesDTO> novedad;
            LinkedList<PresentacionDTO> presentacion;
            if (misession != null && misession.getAttribute("producto") != null) {
                producto = (ProductosDTO) misession.getAttribute("producto");
                out.print(producto);
                CategoriaDAO categoriaa = new CategoriaDAO();
                categoria = categoriaa.obtenerUno(producto.getIdCategoria());
                NovedadesDAO novedaddao = new NovedadesDAO();
                novedad = novedaddao.listartodos();
                PresentacionDAO present = new PresentacionDAO();
                presentacion = present.listarTodos();
            } else {
                categoria = new CategoriasDTO();
                producto = new ProductosDTO();
                novedad = new LinkedList<NovedadesDTO>();
                presentacion = new LinkedList<PresentacionDTO>();

            }


        %>
        <div class="Banner"></div>
        <div class="Menu">
            <div class="Usuarios">
                <img src="img/ICONOPROD.gif" width="60px" height="70px" id="usuarioimg"/></div>
            <p id="usuario"> Productor <br> En línea</br></p>
            <div class="formUsuario">   
                <form action="" method="post" name="Buscar" id="formbuscar">
                    <input name="Buscar" type="text"  id="buscarr"/>
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
                    <a href="ProductorIndexla.jsp" title="Ir a la pagina de inicio" itemprop="url"> 
                        <span itemprop="title">Inicio > </span></a>
                    <span itemprop="child" itemscope itemtype="http://data-vocabulary.org/Breadcrumb"> 
                        <a href="Productormisproductorasociados.jsp" title="Mis productos" itemprop="url"> 
                            <span itemprop="title">Mis productos</span></a> > </span>
                    <span itemprop="child" itemscope itemtype="http://data-vocabulary.org/Breadcrumb"> 
                        <a href="Productorpublicar.jsp" title="Ofertar" itemprop="url"> 
                            <span itemprop="title">Ofertar</span></a></span>
            </div>
            <div id="izq">

                <form action="Controlador" method="post" name="Publicar" id="Publicar">
                    <table id="Publicar">
                        <h1>Ofertar Productos</h1>
                        <tr><parrafo><em>Llene cada uno de los campos marcados con (*)</em></parrafo></tr>
                        <tr>
                            <td><label for="Tipo">Producto*</label></td>
                            <td><input type="hidden" name="idProducto" value="<%=producto.getIdProducto()%>"/>
                                <input type="text" id="producto" tabindex="2" disabled="disabled" value="<%=producto.getNombre()%>"  /></td>
                        </tr>
                        <tr>
                            <td><label for="Categoria">Categoria*</label></td>
                            <td><input type="text" id="categoria" tabindex="3" disabled="disabled" value="<%=categoria.getDescripcion()%>"/></td>
                        </tr>
                        <tr>
                            <td><label for="Presentacion">Presentación*</label></td>
                            <td><select name="Presentacion" id="Presentacion" tabindex="4" title="Presentacion" required="required">
                                    <option value="">[Selecione la Unidad]</option>
                                    <%
                                        for (PresentacionDTO p : presentacion) {
                                    %>
                                    <option value="<%=p.getIdPresentacion()%>"> <%=p.getDescripcion()%> </option>
                                    <%
                                        }
                                    %>

                                </select></td>
                        </tr>
                        <tr>
                            <td><label for="precioVenta">Precio*</label></td>
                            <td><input name="precioVenta" type="text" id="precioVenta" tabindex="5" required="required"/></td>
                        </tr>
                        <tr>
                            <td><label for="fechainicio">Fecha Inicio*</label></td>
                            <td><input type="date" name="fechainicio" id="fechainicio" tabindex="6" required="required" /></td>
                        </tr>
                        <tr>
                            <td><label for="fechafin">Fecha Fin*</label></td>
                            <td><input type="date" name="fechafin" id="fechafin" required="required" tabindex="7" /> </td>
                        </tr>
                        <tr><td><p>Seleccione el tipo de oferta <br/>que desea aplicar al producto</p></td></tr>
                        <tr>
                            <td><label for="novedad">Novedad</label></td>
                            <td><select name="novedad" id="novedad" onChange="activar(this.form)">
                                    <option value=" " selected="selected">[Seleccione su opcion]</option>
                                    <%
                                        for (NovedadesDTO n : novedad) {
                                    %>
                                    <option value="<%=n.getIdNovedad()%>"><%=n.getDescripcion()%> </option>
                                    <%
                                        }

                                    %>
                                </select></td>
                        </tr>
                        <tr>
                            <td><label id ="aparece" style="display:none">Cuanto?</label></td>
                            <td><input id="aparece1" type="text" name="cuanto" style=" width: 40px; display:none" /></td>
                        </tr>
                    </table>
                    <button name="enviar" id="enviar" type="submit">Enviar</button>
                </form>

            </div>	
        </div>
        <!-- InstanceEndEditable --></div>
    </body>
    <!-- InstanceEnd --></html>
