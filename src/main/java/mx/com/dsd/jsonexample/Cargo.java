package mx.com.dsd.jsonexample;

public class Cargo {
    private int idCliente;
    private String fechaInicio;
    private String fechaFin;

    public Cargo(int idCliente, String fechaInicio, String fechaFin) {
        this.idCliente = idCliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * @return the fecha
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
        ;
    }

    /**
     * @return the fechaInicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the cliente to set
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
     * @param fechaFin the cliente to set
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

}