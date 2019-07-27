package pe.com.targethr.authserver.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import pe.com.targethr.authserver.model.entity.pk.EmpleadoId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name="HR_EMPLEADO" )
public class EmpleadoEntity implements Serializable {

    private static final long serialVersionUID =  -9017650847571487336L;

    @EmbeddedId
    private EmpleadoId id;

    @Column(name="CODIGO_ANTIGUO")
    private String codigoAntiguo;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="APELLIDO_PATERNO")
    private String apellidoPaterno;

    @Column(name="APELLIDO_MATERNO")
    private String apellidoMaterno;

    @Column(name="EMAIL")
    private String email;

    @Column(name="ID_SEXO")
    private Integer idSexo;

    @Column(name="FOTO")
    private String foto;

    @Column(name="DIRECCION")
    private String direccion;

    @Column(name="DESCRIPCION_ZONA")
    private String descripcionZona;

    @Column(name="REFERENCIA_DIRECCION")
    private String referenciaDireccion;

    @Column(name="DISCAPACIDAD")
    private Integer discapacidad;

    @Column(name="ID_TIPO_DOCUMENTO")
    private Integer idTipoDocumento;

    @Column(name="NUMERO_DOCUMENTO")
    private Integer numeroDocumento;

    @Column(name="NRO_RUC")
    private Integer nroRuc;

    @Column(name="FECHA_NACIMIENTO")
    private Date fechaNacimiento;

    @Column(name="FECHA_INGRESO")
    private Date fechaIngreso;

    @Column(name="FECHA_REINGRESO")
    private Date fechaReingreso;

    @Column(name="FECHA_RETIRO")
    private Date fechaRetiro;

    @Column(name="TELEFONO_ALTERNATIVO")
    private Integer telefonoAlternativo;

    @Column(name="TELEFONO_FIJO")
    private String telefonoFijo;

    @Column(name="TELEFONO_MOVIL")
    private Integer telefonoMovil;

    @Column(name="CODIGO_SAP")
    private String codigoSap;

    @Column(name="PAIS_EMISOR")
    private String paisEmisor;

    @Column(name="ID_SITUACION")
    private Integer idSituacion;

    @Column(name="ID_ESTADO_CIVIL")
    private Integer idEstadoCivil;

    @Column(name="ID_CENTRO_FORMACION")
    private Integer idCentroFormacion;

    @Column(name="ID_GRADO_INSTRUCCION")
    private Integer idGradoInstruccion;

    @Column(name="ID_NACIONALIDAD")
    private Integer idNacionalidad;

    @Column(name="ID_DEPARTAMENTO")
    private String idDepartamento;

    @Column(name="ID_PROVINCIA")
    private String idProvincia;

    @Column(name="ID_DISTRITO")
    private String idDistrito;

    @Column(name="ID_TIPO_TRABAJADOR")
    private String idTipoTrabajador;

    @Column(name="ID_DOMICILIADO")
    private Integer idDomiciliado;

    @Column(name="ID_SITUACION_ESPECIAL")
    private Integer idSituacionEspecial;

    @Column(name="ID_CALENDARIO")
    private Integer idCalendario;

    @Column(name="SIN_CONTROL_HORARIO")
    private Integer sinControlHorario;

    @Column(name="PENDIENTE_CAPTURA")
    private Integer pendienteCaptura;

    @Column(name="FECHA_CADUCIDAD_CAPTURA")
    private Date fechaCaducidadCaptura;

    @Column(name="CLAVE_ENROLAMIENTO")
    private Date claveEnrolamiento;

    @Column(name="FECHA_INGRESO_AFP_ONP")
    private Date fechaIngresoAfpOnp;

    @Column(name="MAS_VIDA")
    private Integer masVida;

    @Column(name="MONEDA_CALCULO")
    private String monedaCalculo;

    @Column(name="NUMERO_DIRECCION")
    private String numeroDireccion;

    @Column(name="NUMERO_ESSALUD")
    private String numeroEssalud;

    @Column(name="NUMERO_INTERIOR")
    private String numeroInterior;

    @Column(name="OTROS_INGRESOS_QUINTA")
    private Integer otrosIngresosQuinta;

    @Column(name="SCTR")
    private Integer Sctr;

    @Column(name="SCTR_PENSION")
    private Integer ScrtPension;

    @Column(name="SENATI")
    private Integer senati;

    @Column(name="SINDICALIZADO")
    private Integer sindicalizado;

    @Column(name="TIPO_CALCULO")
    private String tipoCalculo;

    @Column(name="AFILIADO_EPS")
    private String afiliadoEps;

    @Column(name="AFILIADO_ESSALUD")
    private Integer afiliadoEssalud;

    @Column(name="CODIGO_AFP_ONP")
    private String codigoAfpOnp;

    @Column(name="CODIGO_CUSSP")
    private String codigoCussp;

    @Column(name="CREATED_DATE")
    private Date createdDate;

    @Column(name="CREATED_BY")
    private String createdBy;

    @Column(name="LAST_MODIFIED_DATE")
    private Date lastModifiedDate;

    @Column(name="LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @Column(name="FLAG_ESTADO")
    private Integer flagEstado;

    @Column(name="EMAIL_ORGANIZACIONAL")
    private String emailOrganizacional;

    @Column(name="CELULAR_PERSONAL")
    private Integer celularPersonal;

    @Column(name="CELULAR_ORGANIZACIONAL")
    private Integer celularOrganizacional;

    @Column(name="TELEFONO_CASA")
    private Integer telefonoCasa;

    @Column(name="ID_CARRERA")
    private Integer idCarrera;

    @Column(name="ANIO_EGRESO")
    private Integer anioEgreso;

    @Column(name="JEFE_CODIGO")
    private String jefeCodigo;

    @Column(name="ACTIVATED")
    private Integer activated;

    @OneToOne(mappedBy = "empleado" )
    @JsonBackReference
    private UsuarioEntity usuarioEntity ;


    public String getCodigoAntiguo() {
        return codigoAntiguo;
    }

    public void setCodigoAntiguo(String codigoAntiguo) {
        this.codigoAntiguo = codigoAntiguo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcionZona() {
        return descripcionZona;
    }

    public void setDescripcionZona(String descripcionZona) {
        this.descripcionZona = descripcionZona;
    }

    public String getReferenciaDireccion() {
        return referenciaDireccion;
    }

    public void setReferenciaDireccion(String referenciaDireccion) {
        this.referenciaDireccion = referenciaDireccion;
    }

    public Integer getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(Integer discapacidad) {
        this.discapacidad = discapacidad;
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getNroRuc() {
        return nroRuc;
    }

    public void setNroRuc(Integer nroRuc) {
        this.nroRuc = nroRuc;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaReingreso() {
        return fechaReingreso;
    }

    public void setFechaReingreso(Date fechaReingreso) {
        this.fechaReingreso = fechaReingreso;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public Integer getTelefonoAlternativo() {
        return telefonoAlternativo;
    }

    public void setTelefonoAlternativo(Integer telefonoAlternativo) {
        this.telefonoAlternativo = telefonoAlternativo;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public Integer getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(Integer telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getCodigoSap() {
        return codigoSap;
    }

    public void setCodigoSap(String codigoSap) {
        this.codigoSap = codigoSap;
    }

    public String getPaisEmisor() {
        return paisEmisor;
    }

    public void setPaisEmisor(String paisEmisor) {
        this.paisEmisor = paisEmisor;
    }

    public Integer getIdSituacion() {
        return idSituacion;
    }

    public void setIdSituacion(Integer idSituacion) {
        this.idSituacion = idSituacion;
    }

    public Integer getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Integer idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public Integer getIdCentroFormacion() {
        return idCentroFormacion;
    }

    public void setIdCentroFormacion(Integer idCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
    }

    public Integer getIdGradoInstruccion() {
        return idGradoInstruccion;
    }

    public void setIdGradoInstruccion(Integer idGradoInstruccion) {
        this.idGradoInstruccion = idGradoInstruccion;
    }

    public Integer getIdNacionalidad() {
        return idNacionalidad;
    }

    public void setIdNacionalidad(Integer idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(String idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(String idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getIdTipoTrabajador() {
        return idTipoTrabajador;
    }

    public void setIdTipoTrabajador(String idTipoTrabajador) {
        this.idTipoTrabajador = idTipoTrabajador;
    }

    public Integer getIdDomiciliado() {
        return idDomiciliado;
    }

    public void setIdDomiciliado(Integer idDomiciliado) {
        this.idDomiciliado = idDomiciliado;
    }

    public Integer getIdSituacionEspecial() {
        return idSituacionEspecial;
    }

    public void setIdSituacionEspecial(Integer idSituacionEspecial) {
        this.idSituacionEspecial = idSituacionEspecial;
    }

    public Integer getIdCalendario() {
        return idCalendario;
    }

    public void setIdCalendario(Integer idCalendario) {
        this.idCalendario = idCalendario;
    }

    public Integer getSinControlHorario() {
        return sinControlHorario;
    }

    public void setSinControlHorario(Integer sinControlHorario) {
        this.sinControlHorario = sinControlHorario;
    }

    public Integer getPendienteCaptura() {
        return pendienteCaptura;
    }

    public void setPendienteCaptura(Integer pendienteCaptura) {
        this.pendienteCaptura = pendienteCaptura;
    }

    public Date getFechaCaducidadCaptura() {
        return fechaCaducidadCaptura;
    }

    public void setFechaCaducidadCaptura(Date fechaCaducidadCaptura) {
        this.fechaCaducidadCaptura = fechaCaducidadCaptura;
    }

    public Date getClaveEnrolamiento() {
        return claveEnrolamiento;
    }

    public void setClaveEnrolamiento(Date claveEnrolamiento) {
        this.claveEnrolamiento = claveEnrolamiento;
    }

    public Date getFechaIngresoAfpOnp() {
        return fechaIngresoAfpOnp;
    }

    public void setFechaIngresoAfpOnp(Date fechaIngresoAfpOnp) {
        this.fechaIngresoAfpOnp = fechaIngresoAfpOnp;
    }

    public Integer getMasVida() {
        return masVida;
    }

    public void setMasVida(Integer masVida) {
        this.masVida = masVida;
    }

    public String getMonedaCalculo() {
        return monedaCalculo;
    }

    public void setMonedaCalculo(String monedaCalculo) {
        this.monedaCalculo = monedaCalculo;
    }

    public String getNumeroDireccion() {
        return numeroDireccion;
    }

    public void setNumeroDireccion(String numeroDireccion) {
        this.numeroDireccion = numeroDireccion;
    }

    public String getNumeroEssalud() {
        return numeroEssalud;
    }

    public void setNumeroEssalud(String numeroEssalud) {
        this.numeroEssalud = numeroEssalud;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public Integer getOtrosIngresosQuinta() {
        return otrosIngresosQuinta;
    }

    public void setOtrosIngresosQuinta(Integer otrosIngresosQuinta) {
        this.otrosIngresosQuinta = otrosIngresosQuinta;
    }

    public Integer getSctr() {
        return Sctr;
    }

    public void setSctr(Integer sctr) {
        Sctr = sctr;
    }

    public Integer getScrtPension() {
        return ScrtPension;
    }

    public void setScrtPension(Integer scrtPension) {
        ScrtPension = scrtPension;
    }

    public Integer getSenati() {
        return senati;
    }

    public void setSenati(Integer senati) {
        this.senati = senati;
    }

    public Integer getSindicalizado() {
        return sindicalizado;
    }

    public void setSindicalizado(Integer sindicalizado) {
        this.sindicalizado = sindicalizado;
    }

    public String getTipoCalculo() {
        return tipoCalculo;
    }

    public void setTipoCalculo(String tipoCalculo) {
        this.tipoCalculo = tipoCalculo;
    }

    public String getAfiliadoEps() {
        return afiliadoEps;
    }

    public void setAfiliadoEps(String afiliadoEps) {
        this.afiliadoEps = afiliadoEps;
    }

    public Integer getAfiliadoEssalud() {
        return afiliadoEssalud;
    }

    public void setAfiliadoEssalud(Integer afiliadoEssalud) {
        this.afiliadoEssalud = afiliadoEssalud;
    }

    public String getCodigoAfpOnp() {
        return codigoAfpOnp;
    }

    public void setCodigoAfpOnp(String codigoAfpOnp) {
        this.codigoAfpOnp = codigoAfpOnp;
    }

    public String getCodigoCussp() {
        return codigoCussp;
    }

    public void setCodigoCussp(String codigoCussp) {
        this.codigoCussp = codigoCussp;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getFlagEstado() {
        return flagEstado;
    }

    public void setFlagEstado(Integer flagEstado) {
        this.flagEstado = flagEstado;
    }

    public String getEmailOrganizacional() {
        return emailOrganizacional;
    }

    public void setEmailOrganizacional(String emailOrganizacional) {
        this.emailOrganizacional = emailOrganizacional;
    }

    public Integer getCelularPersonal() {
        return celularPersonal;
    }

    public void setCelularPersonal(Integer celularPersonal) {
        this.celularPersonal = celularPersonal;
    }

    public Integer getCelularOrganizacional() {
        return celularOrganizacional;
    }

    public void setCelularOrganizacional(Integer celularOrganizacional) {
        this.celularOrganizacional = celularOrganizacional;
    }

    public Integer getTelefonoCasa() {
        return telefonoCasa;
    }

    public void setTelefonoCasa(Integer telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public Integer getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Integer getAnioEgreso() {
        return anioEgreso;
    }

    public void setAnioEgreso(Integer anioEgreso) {
        this.anioEgreso = anioEgreso;
    }

    public String getJefeCodigo() {
        return jefeCodigo;
    }

    public void setJefeCodigo(String jefeCodigo) {
        this.jefeCodigo = jefeCodigo;
    }


    public Integer getActivated() {
        return activated;
    }

    public void setActivated(Integer activated) {
        this.activated = activated;
    }

    public EmpleadoId getId() {
        return id;
    }

    public void setId(EmpleadoId id) {
        this.id = id;
    }


    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }
}
