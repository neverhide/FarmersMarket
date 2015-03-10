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
public class OfertarDTO {

    private int idOferta = 0;
    private int idPresentacion = 0;
    private int idProducto = 0;
    private int idProductor = 0;
    private float precioVenta = 0;
    private int idNovedad = 0;
    private String fechaInicio = "";
    private String fechaFin = "";
    private boolean estado = true;
    private String productor = "";
    private String producto;
    private String presentacion = "";
    private String descripcion = "";

    @Override
    public String toString() {
        return "OfertarDTO" + "idOferta=" + idOferta + ", idPresentacion=" + idPresentacion + ", idProducto=" + idProducto + ", idProductor=" + idProductor + ", precioVenta=" + precioVenta + ", idNovedad=" + idNovedad + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado + ", productor=" + productor + ", producto=" + producto + ", presentacion=" + presentacion + ", descripcion=" + descripcion + '\n';
    }

    /**
     * @return the idOferta
     */
    public int getIdOferta() {
        return idOferta;
    }

    /**
     * @param idOferta the idOferta to set
     */
    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

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
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the idProductor
     */
    public int getIdProductor() {
        return idProductor;
    }

    /**
     * @param idProductor the idProductor to set
     */
    public void setIdProductor(int idProductor) {
        this.idProductor = idProductor;
    }

    /**
     * @return the precioVenta
     */
    public float getPrecioVenta() {
        return precioVenta;
    }

    /**
     * @param precioVenta the precioVenta to set
     */
    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

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
     * @return the fechaInicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the productor
     */
    public String getProductor() {
        return productor;
    }

    /**
     * @param productor the productor to set
     */
    public void setProductor(String productor) {
        this.productor = productor;
    }

    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the presentacion
     */
    public String getPresentacion() {
        return presentacion;
    }

    /**
     * @param presentacion the presentacion to set
     */
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
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

}
