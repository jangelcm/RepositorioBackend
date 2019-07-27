package pe.com.targethr.authserver.model.entity.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmpleadoId implements Serializable {

    private static final long serialVersionUID = 1895739658603334134L;

    @Column(name = "ID_SUCURSAL")
    private Integer idSucursal;

    @Column(name = "CODIGO_TRABAJADOR")
    private String codigoTrabajador;


    /**
     * @return the idSucursal
     */
    public Integer getIdSucursal() {
        return idSucursal;
    }

    /**
     * @param idSucursal the idSucursal to set
     */
    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof EmpleadoId))
            return false;
        EmpleadoId that = (EmpleadoId) o;
        return  idSucursal.equals(that.idSucursal)
                && codigoTrabajador.equals(that.codigoTrabajador);
    }

    @Override
    public int hashCode() {
        return idSucursal.hashCode() + codigoTrabajador.hashCode();
    }
}