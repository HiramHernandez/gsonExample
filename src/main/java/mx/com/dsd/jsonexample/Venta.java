package mx.com.dsd.jsonexample;

import java.util.ArrayList;
import java.util.Date;

public class Venta {
    private Date fecha;
    private String cliente;

    private ArrayList<DetallesVenta> detalle;

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the detalle
     */
    public ArrayList<DetallesVenta> getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(ArrayList<DetallesVenta> detalle) {
        this.detalle = detalle;
    }
}
