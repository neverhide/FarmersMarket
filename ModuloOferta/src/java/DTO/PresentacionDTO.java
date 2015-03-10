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
public class PresentacionDTO {
    private int idPresentacion=0;
    private String descripcion="";
    private float conversion=0;

    /**
     * @return the idPresentacion
     */
    public int getIdPresentacion() {
        return idPresentacion;
    }

    /**
     * @param idPresentacion the idPresentacion to set
     */
    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
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
     * @return the detallevalor
     */
    public float getDetallevalor() {
        return conversion;
    }

    /**
     * @param detallevalor the detallevalor to set
     */
    public void setDetallevalor(float detallevalor) {
        this.conversion = detallevalor;
    }
    @Override
    public String toString(){
        return "Cód Presentación"+idPresentacion
                +"\n Descripción"+descripcion
                +"\n Conversion"+conversion;
        
        
    }
    
    
}
