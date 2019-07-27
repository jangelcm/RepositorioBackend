package pe.com.targethr.authserver.model.dto;

/**
 * Respuesta
 * 
 * @param <T>
 */
public class Respuesta<T> {

    public static final String MENSAJE_LECTURA_EXITOSA = "Leido exitosamente";
    public static final String INSERCION_EXITOSA = "Guardado exitosamente";
    public static final String INSERCION_FALLIDA = "Fallo en el guardado";
    public static final String MODIFICACION_EXITOSA = "Modificado exitosamente";
    public static final String MODIFICACION_FALLIDA = "Fallo en la modificacion";
    public static final String ELIMINACION_EXITOSA = "Eliminado exitosamente";
    public static final String ELIMINACION_FALLIDA = "Fallo en la eliminacion";

    private String mensaje;
    private Boolean hayMasPaginas;
    private T data;

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the hayMasPaginas
     */
    public Boolean getHayMasPaginas() {
        return hayMasPaginas;
    }

    /**
     * @param hayMasPaginas the hayMasPaginas to set
     */
    public void setHayMasPaginas(Boolean hayMasPaginas) {
        this.hayMasPaginas = hayMasPaginas;
    }

}