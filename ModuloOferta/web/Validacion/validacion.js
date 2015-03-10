/*Validaicon html cliente cotizar*/

function calcular(){
/*Primer input*/
var cantidad1 = document.getElementById('cantidad1').value;
    if (isNaN(cantidad1)) {

        alert("La cantidad debe ser numerica");    
        return false;
    }
    if (cantidad1 == '') {
        cantidad1 = 0;
    }

var precio1 = document.getElementById('precio1').value;
precio1 = Number(precio1.replace(/[^0-9\.]+/g,""));
var calculo1 =  (precio1 * parseInt(cantidad1));     
var total1 = document.getElementById('total1').value = "$"+calculo1;


/*Segun input*/
var cantidad2 = document.getElementById('cantidad2').value;
    if (isNaN(cantidad2)) {

        alert("La cantidad debe ser numerica");
        return false;
    }

    if (cantidad2 == '') {
        cantidad2 = 0;
    }

var precio2 = document.getElementById('precio2').value;
precio2 = Number(precio2.replace(/[^0-9\.]+/g,""));
var calculo2 =  (precio2 * parseInt(cantidad2)); 
var total2 = document.getElementById('total2').value = "$"+calculo2; 

/*Tercer input*/

var cantidad3 = document.getElementById('cantidad3').value;
    if (isNaN(cantidad3)) {

        alert("La cantidad debe ser numerica");
        return false;
    }      

    if (cantidad3 == '') {
        cantidad3 = 0;
    }

var precio3 = document.getElementById('precio3').value;
precio3 = Number(precio3.replace(/[^0-9\.]+/g,""));
var calculo3 =  (precio3 * parseInt(cantidad3)); 
var total3 = document.getElementById('total3').value = "$"+calculo3;

/*Cuarto input*/

var cantidad4 = document.getElementById('cantidad4').value;
    if (isNaN(cantidad4)) {

        alert("La cantidad debe ser numerica");
        return false;
    }

    if (cantidad4 == '') {
        cantidad4 = 0;
    }

var precio4 = document.getElementById('precio4').value;
precio4 = Number(precio4.replace(/[^0-9\.]+/g,""));
var calculo4 =  (precio4 * parseInt(cantidad4)); 
var total4 = document.getElementById('total4').value = "$"+calculo4;

/*Quinto input*/

var cantidad5 = document.getElementById('cantidad5').value;
    if (isNaN(cantidad5)) {

        alert("La cantidad debe ser numerica");
        return false;
    }

    if (cantidad5 == '') {
        cantidad5 = 0;
    }

var precio5 = document.getElementById('precio5').value;
precio5 = Number(precio5.replace(/[^0-9\.]+/g,""));
var calculo5 =  (precio5 * parseInt(cantidad5)); 
var total5 = document.getElementById('total5').value = "$"+calculo5;




/*Input total */
var totaltodo = calculo1 + calculo2 + calculo3 + calculo4 + calculo5;
parseInt(totaltodo);
var Totalt = document.getElementById("totaltodo").value = "$"+totaltodo;

    if (totaltodo == 0 || totaltodo == '') {

        alert("Debe Asignar almenos una cantidad");
        return false;

        }
}

/*
function comprar(){

    var all = document.getElementById("totaltodo").value;
    if (isNaN(all)) {

        alert("Debe Asignar almenos una cantidad");
            return false;

        }else{
            alert("Debe Asignar almenos una cantidad");
            return false;

    }


}*/


/*Validacion httml clientecatalogo*/
$(document).ready(function(){

            $("#añadircli").click(function(){
                
        var frutas = document.getElementsByName("selec"); 
        var seleccion = false;
        for(var i=0; i<frutas.length; i++) {    
            if(frutas[i].checked) {
            seleccion = true;
            break;
            }
        } 
        if(seleccion != true) {
                $("#añadirproducto").fadeIn("slow");                
                return false;
            }
            else{
                $("#añadirproducto").fadeOut();
            }
        
    });
});


$(document).ready(function(){
            //función click
            $("#modificarcli").click(function(){                
                

                /*Validacion de la direccion*/
                var direccion = $("#direccionc").val();
				if(direccion == ''){
					$("#telmc").fadeOut();
                    $("#telmc").fadeOut(); 
					$("#tellongc").fadeOut();
					$("#correomc").fadeOut();
					$("#usuariomc").fadeOut();
					$("#correoerc").fadeOut();
					$("#direccionmc").fadeIn("slow");									
					

					return false;	
				}else{
					$("#direccionmc").fadeOut();	
				}
				/*Validacion del telefono*/
				var telefono = $("#telefonoc").val();
                if (telefono == "") {

                	$("#tellongc").fadeOut();
                	$("#correomc").fadeOut();
                	$("#correoerc").fadeOut();
					$("#usuariomc").fadeOut();				
										
                    $("#telmc").fadeIn("slow");
				
      		
                    return false;
                }
                else{ 

                    $("#telmc").fadeOut(); 

                    if (isNaN(telefono)) {
                        $("#telnumc").fadeIn("slow");
						$("#usuariomc").fadeOut();
						$("#correoerc").fadeOut();
						$("#correomc").fadeOut();
						$("#tellongc").fadeOut(); 
						$("#direccionmc").fadeOut();

                        return false;
                    }
                    else{ 

                        $("#telnumc").fadeOut();  

                        if (telefono.length < 8) {

                        	$("#correomc").fadeOut();
							$("#correoerc").fadeOut();
                            $("#usuariomc").fadeOut();

                            $("#tellongc").fadeIn("slow");
							
							 	
                            return false;
                        }
                        else{
                            $("#tellongc").fadeOut();                            
                        }
                    }  
                }
				/*validacion del correo*/
				var validacion = /^[a-zA-Z0-9_\.\-]+@[a-zA-Z0-9\-]+\.[a-zA-Z0-9\-\.]+$/;
				var correo = $("#correoc").val();
				if(correo == ''){	

					$("#correoerc").fadeOut();
					$("#usuariomc").fadeOut();

					$("#correomc").fadeIn("tslow");								
					
					
				return false;
				}
				else{
					$("#correomc").fadeOut();	
					
					if(!validacion.test(correo)){

						$("#usuariomc").fadeOut();
						$("#correoerc").fadeIn("slow");
						
						
						return false;
					}else{
						$("#correoerc").fadeOut();
					}	
					
				}
				/*Validacion usuario*/
				var usuario = $("#usuc").val();
				if(usuario == ''){
					$("#usuariomc").fadeIn("slow");
					return false;
				}
				else{
					$("#usuariomc").fadeOut();	
				}
				
				
				/*Validacion contraseña
				var contraseña = $("#contraseña").val();
				if(contraseña == ''){
					$("#passm").fadeIn("slow");
					$("#passlongm").fadeOut();	
					return false;
				}else{
					$("#passm").fadeOut();
					if(contraseña.length < 5){
						$("#passlongm").fadeIn("slow");
						return false;
							
					}else {
						$("#passlongm").fadeOut();	
						
					}
					
				}*/
				
				/*validacion nueva contraseña
				var nuevopass = $("#nuevacontraseña").val();
				var confirmacion = $("#confirmarpass").val();
				if	(confirmacion != ''){
						
					$("#passnewm").fadeIn("slow");
					return false;
				}else {					
					$("#passnewm").fadeOut();	
				}*/
				
				/*Confirmacion*/
               if(confirm("¿Seguro de modificar sus datos?")){
				return true;   
			   }
			   else{
				return false;   
			   }

    });
});

/*Validacion httml distribuidor publicar*/


$(document).ready(function(){

            $("#publicarsub").click(function(){
                
        	/*validacion cantidad*/
        	var cantidad = $("#cantidadp").val();
        	if (cantidad == '') {
        		$("#cantidadnum").fadeOut();
        		$("#preciounip").fadeOut();
        		$("#precionum").fadeOut();
        		$("#cantidadpu").fadeIn("slow");
        		return false;
        	}
        	else {
				$("#cantidadpu").fadeOut();
				if (isNaN(cantidad)) {
					$("#preciounip").fadeOut();
        			$("#precionum").fadeOut();
					$("#cantidadnum").fadeIn("slow");
					return false;

				}else{
					$("#cantidadnum").fadeOut();
				}
        	}

        	/*validacion precio unidad*/
        	var precio = $("#preciopu").val();
        	if (precio == '') {

        		$("#precionum").fadeOut();
        		$("#preciounip").fadeIn("slow");
        		return false;
        	}
        	else {
        		$("#preciounip").fadeOut();
        		if (isNaN(precio)) {

        			$("#precionum").fadeIn("slow");

        			return false;
        		}else{

        			$("#precionum").fadeOut();

        		}
        		

        		
        	}
        });
});


$(document).ready(function(){

            $("#publicarsub").click(function(){

            /*Validacion selecion de productos*/
            var productos = document.getElementsByName("publicarpro"); 
            var seleccion = false;
            for(var i=0; i<productos.length; i++) {    
                if(productos[i].checked) {
                seleccion = true;
                break;
                }
            } 
            if(seleccion != true) {
                $("#publicarprod").fadeIn("slow");                
                return false;
            }
            else{
                $("#publicarprod").fadeOut();
            }

        
    });
});

/*Validacion html distribuidor compra*/

$(document).ready(function(){

            $("#añadirpro").click(function(){

            /*Validacion selecion de productos*/
            var productosa = document.getElementsByName("selec"); 
            var seleccion = false;
            for(var i=0; i<productosa.length; i++) {    
                if(productosa[i].checked) {
                seleccion = true;
                break;
                }
            } 
            if(seleccion != true) {
                $("#añadir").fadeIn("slow");                
                return false;
            }
            else{
                $("#añadir").fadeOut();
            }

        
    });
});

/*Validacion html distribuidro datos*/

$(document).ready(function(){
            //función click
            $("#modificardis").click(function(){                
                

                /*Validacion de la direccion*/
                var direccion = $("#direcciond").val();
                if(direccion == ''){
                    $("#telmd").fadeOut();
                    $("#telnumd").fadeOut(); 
                    $("#tellongd").fadeOut();
                    $("#correomd").fadeOut();
                    $("#usuariomd").fadeOut();
                    $("#correoerd").fadeOut();
                    $("#direccionmd").fadeIn("slow");                                   
                    

                    return false;   
                }else{
                    $("#direccionmd").fadeOut();    
                }
                /*Validacion del telefono*/
                var telefono = $("#telefonod").val();
                if (telefono == "" || telefono == 0) {

                    $("#tellongd").fadeOut();
                    $("#correomd").fadeOut();
                    $("#correoerd").fadeOut();
                    $("#usuariomd").fadeOut();              
                                        
                    $("#telmd").fadeIn("slow");
                
            
                    return false;
                }
                else{ 

                    $("#telmd").fadeOut(); 

                    if (isNaN(telefono)) {
                        $("#telnumd").fadeIn("slow");
                        $("#usuariomd").fadeOut();
                        $("#correoerd").fadeOut();
                        $("#correomd").fadeOut();
                        $("#tellongd").fadeOut(); 
                        $("#direccionmd").fadeOut();

                        return false;
                    }
                    else{ 

                        $("#telnumd").fadeOut();  

                        if (telefono.length < 8) {

                            $("#correomd").fadeOut();
                            $("#correoerd").fadeOut();
                            $("#usuariomd").fadeOut();

                            $("#tellongd").fadeIn("slow");
                            
                                
                            return false;
                        }
                        else{
                            $("#tellongd").fadeOut();                            
                        }
                    }  
                }
                /*validacion del correo*/
                var validacion = /^[a-zA-Z0-9_\.\-]+@[a-zA-Z0-9\-]+\.[a-zA-Z0-9\-\.]+$/;
                var correo = $("#correod").val();
                if(correo == ''){   

                    $("#correoerd").fadeOut();
                    $("#usuariomd").fadeOut();

                    $("#correomd").fadeIn("tslow");                             
                    
                    
                return false;
                }
                else{
                    $("#correomd").fadeOut();   
                    
                    if(!validacion.test(correo)){

                        $("#usuariomd").fadeOut();
                        $("#correoerd").fadeIn("slow");
                        
                        
                        return false;
                    }else{
                        $("#correoerd").fadeOut();
                    }   
                    
                }
                /*Validacion usuario*/
                var usuario = $("#usuariod").val();
                if(usuario == ''){
                    $("#usuariomd").fadeIn("slow");
                    return false;
                }
                else{
                    $("#usuariomd").fadeOut();  
                }                
                
              
                /*Confirmacion*/
               if(confirm("¿Seguro de modificar sus datos?")){
                return true;   
               }
               else{
                return false;   
               }

    });
});




/*validacion html distribuidor mis publicaciones
function eliminar(){

            if(confirm("¿Seguro de modificar sus datos?")){
                return true;   
               }
               else{
                return false;   
               
           }
            
    }        */

$(document).ready(function(){

            $("#modificarpub").click(function(){

            /*validacion cantidad*/    
            var cantidadpu = $("#cantidadpubli").val();

            if (cantidadpu == '' || cantidadpu == 0) {

                $("#cantidadnumpu").fadeOut();
                $("#preciopu").fadeOut();
                $("#precionumpu").fadeOut();
                $("#precioupu").fadeOut();
                $("#preciounumpu").fadeOut();

                $("#cantidadpu").fadeIn("slow");
                return false;
            }else{
                $("#cantidadpu").fadeOut();
                if (isNaN(cantidadpu)) {

                    $("#preciopu").fadeOut();
                    $("#precionumpu").fadeOut();                    
                    $("#precioupu").fadeOut();
                    $("#preciounumpu").fadeOut();

                    $("#cantidadnumpu").fadeIn("slow");
                    return false;
                }else{
                    $("#cantidadnumpu").fadeOut();
                }
            }

            /*validacion precio*/
            var preciopu = $("#preciopub").val();

            if (preciopu == '' || preciopu == 0) {

                $("#precionumpu").fadeOut();
                $("#precioupu").fadeOut();
                $("#preciounumpu").fadeOut();

                $("#preciopu").fadeIn("slow");
                return false;
            }else{
                $("#preciopu").fadeOut();
                if (isNaN(preciopu)) {
                   
                     $("#precioupu").fadeOut();
                     $("#preciounumpu").fadeOut();

                    $("#precionumpu").fadeIn("slow");
                    return false;
                }else {
                    $("#precionumpu").fadeOut();
                }
            }

            /*Validacion precio unidad*/
            var preciouni = $("#preciounipu").val();

            if (preciouni =='' || preciouni == 0) {

                $("#preciounumpu").fadeOut();

                $("#precioupu").fadeIn("slow");
                return false;

            }else {
                $("#precioupu").fadeOut();
                if (isNaN(preciouni)) {

                    $("#preciounumpu").fadeIn("slow");
                    return false;
                }else{
                    $("#preciounumpu").fadeOut();
                }
            }

            if (confirm("¿Seguro de modificar los datos?")) {

                return true;
            }else{
                return false;
            }


        
    });
});



/*Validacion html productor datos*/
$(document).ready(function(){
            
            $("#modificarpro").click(function(){                
                

                /*Validacion de la direccion*/
                var direccion = $("#direccionp").val();
                if(direccion == ''){
                    $("#telmp").fadeOut();
                    $("#telnump").fadeOut(); 
                    $("#tellongp").fadeOut();
                    $("#correomp").fadeOut();
                    $("#usuariomp").fadeOut();
                    $("#correoerp").fadeOut();
                    $("#direccionmp").fadeIn("slow");                                   
                    

                    return false;   
                }else{
                    $("#direccionmp").fadeOut();    
                }
                /*Validacion del telefono*/
                var telefono = $("#telefonop").val();
                if (telefono == "" || telefono == 0) {

                    $("#tellongp").fadeOut();
                    $("#correomp").fadeOut();
                    $("#correoerp").fadeOut();
                    $("#usuariomp").fadeOut();              
                                        
                    $("#telmp").fadeIn("slow");
                
            
                    return false;
                }
                else{ 

                    $("#telmp").fadeOut(); 

                    if (isNaN(telefono)) {

                        $("#usuariomp").fadeOut();
                        $("#correoerp").fadeOut();
                        $("#correomp").fadeOut();
                        $("#tellongp").fadeOut(); 
                        $("#direccionmp").fadeOut();

                        $("#telnump").fadeIn("slow");
                        

                        return false;
                    }
                    else{ 

                        $("#telnump").fadeOut();  

                        if (telefono.length < 8) {

                            $("#correomp").fadeOut();
                            $("#correoerp").fadeOut();
                            $("#usuariomp").fadeOut();

                            $("#tellongp").fadeIn("slow");
                            
                                
                            return false;
                        }
                        else{
                            $("#tellongp").fadeOut();                            
                        }
                    }  
                }
                /*validacion del correo*/
                var validacion = /^[a-zA-Z0-9_\.\-]+@[a-zA-Z0-9\-]+\.[a-zA-Z0-9\-\.]+$/;
                var correo = $("#correop").val();
                if(correo == ''){   

                    $("#correoerp").fadeOut();
                    $("#usuariomp").fadeOut();

                    $("#correomp").fadeIn("tslow");                             
                    
                    
                return false;
                }
                else{
                    $("#correomp").fadeOut();   
                    
                    if(!validacion.test(correo)){

                        $("#usuariomp").fadeOut();
                        $("#correoerp").fadeIn("slow");
                        
                        
                        return false;
                    }else{
                        $("#correoerp").fadeOut();
                    }   
                    
                }
                /*Validacion usuario*/
                var usuario = $("#usuariop").val();
                if(usuario == ''){
                    $("#usuariomp").fadeIn("slow");
                    return false;
                }
                else{
                    $("#usuariomp").fadeOut();  
                }                
                
              
                /*Confirmacion*/
               if(confirm("¿Seguro de modificar sus datos?")){
                return true;   
               }
               else{
                return false;   
               }

    });
});


/*Validacion html productor modificar prod*/
$(document).ready(function(){

            $("#promodificados").click(function(){

            /*validacion cantidad*/    
            var cantidadmo = $("#cantidadmodi").val();

            if (cantidadmo == '' || cantidadmo == 0) {

                $("#cantidadnummo").fadeOut();
                $("#preciomo").fadeOut();
                $("#precionumpumo").fadeOut();
                $("#precioumo").fadeOut();
                $("#preciounummo").fadeOut();

                $("#cantidadmo").fadeIn("slow");
                return false;
            }else{
                $("#cantidadpmo").fadeOut();
                if (isNaN(cantidadmo)) {

                    $("#preciomo").fadeOut();
                    $("#precionummo").fadeOut();                    
                    $("#precioumo").fadeOut();
                    $("#preciounummo").fadeOut();

                    $("#cantidadnummo").fadeIn("slow");
                    return false;
                }else{
                    $("#cantidadnummo").fadeOut();
                }
            }

            /*validacion precio*/
            var preciopu = $("#preciopub").val();

            if (preciopu == '' || preciopu == 0) {

                $("#precionumpu").fadeOut();
                $("#precioupu").fadeOut();
                $("#preciounumpu").fadeOut();

                $("#preciopu").fadeIn("slow");
                return false;
            }else{
                $("#preciopu").fadeOut();
                if (isNaN(preciopu)) {
                   
                     $("#precioupu").fadeOut();
                     $("#preciounumpu").fadeOut();

                    $("#precionumpu").fadeIn("slow");
                    return false;
                }else {
                    $("#precionumpu").fadeOut();
                }
            }

            /*Validacion precio unidad*/
            var preciouni = $("#preciounipu").val();

            if (preciouni =='' || preciouni == 0) {

                $("#preciounumpu").fadeOut();

                $("#precioupu").fadeIn("slow");
                return false;

            }else {
                $("#precioupu").fadeOut();
                if (isNaN(preciouni)) {

                    $("#preciounumpu").fadeIn("slow");
                    return false;
                }else{
                    $("#preciounumpu").fadeOut();
                }
            }

            if (confirm("¿Seguro de modificar los datos?")) {

                return true;
            }else{
                return false;
            }


        
    });
});





        

























