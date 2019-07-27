package pe.com.targethr.authserver.model.jwt;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CustomClaims
 */
public class CustomClaims {

    @JsonProperty("cod_usu")
    private String codigoUsuario;

    @JsonProperty("cod_cia")
    private String codigoCompania;

    @JsonProperty("cod_suc")
    private String codigoSucursal;

    @JsonProperty("cod_tra")
    private String codigoTrabajador;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("ap_pat")
    private String apellidoPaterno;

    @JsonProperty("ap_mat")
    private String apellidoMaterno;

    @JsonProperty("email")
    private String email;

    @JsonProperty("cod_tra_jef")
    private String codigoTrabajadorJefe;

    @JsonProperty("n")
    private String nivel;

    @JsonProperty("es_jefe")
    private Boolean jefe;

    /**
     * @return the codigoUsuario
     */
    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    /**
     * @param codigoUsuario the codigoUsuario to set
     */
    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    /**
     * @return the codigoCompania
     */
    public String getCodigoCompania() {
        return codigoCompania;
    }

    /**
     * @param codigoCompania the codigoCompania to set
     */
    public void setCodigoCompania(String codigoCompania) {
        this.codigoCompania = codigoCompania;
    }

    /**
     * @return the codigoSucursal
     */
    public String getCodigoSucursal() {
        return codigoSucursal;
    }

    /**
     * @param codigoSucursal the codigoSucursal to set
     */
    public void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    /**
     * @return the codigoTrabajador
     */
    public String getCodigoTrabajador() {
        return codigoTrabajador;
    }

    /**
     * @param codigoTrabajador the codigoTrabajador to set
     */
    public void setCodigoTrabajador(String codigoTrabajador) {
        this.codigoTrabajador = codigoTrabajador;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return the codigoTrabajadorJefe
     */
    public String getCodigoTrabajadorJefe() {
        return codigoTrabajadorJefe;
    }

    /**
     * @param codigoTrabajadorJefe the codigoTrabajadorJefe to set
     */
    public void setCodigoTrabajadorJefe(String codigoTrabajadorJefe) {
        this.codigoTrabajadorJefe = codigoTrabajadorJefe;
    }

    /**
     * @return the nivel
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the jefe
     */
    public Boolean isJefe() {
        return jefe;
    }

    /**
     * @param jefe the jefe to set
     */
    public void setJefe(Boolean jefe) {
        this.jefe = jefe;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the jefe
     */
    public Boolean getJefe() {
        return jefe;
    }
}