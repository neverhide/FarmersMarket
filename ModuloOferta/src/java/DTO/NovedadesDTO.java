/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 *
 * @author LENOVO
 */
public class NovedadesDTO {
    private int idNovedad=0;
    private String descripcion="";
    private float detalle=0;

    /**
     * @return the idNovedad
     */
    public int getIdNovedad() {
        return idNovedad;
    }

    /**
     * @param idNovedad the idNovedad to set
     */
    public void setIdNovedad(int idNovedad) {
        this.idNovedad = idNovedad;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the detalle
     */
    public float getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(float detalle) {
        this.detalle = detalle;
    }
    public String toString(){
        return "Cód Novedad"+idNovedad
                +"\n Descrición"+descripcion
                 +"\n Valor"+detalle;
    }
    
}
