package pe.com.targethr.authserver.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="TECH_USER")
public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID =  -9017650847571487336L;

    @Id
    @Column(name="USER_ID")
    private Long userId;

    @Column(name="USERNAME")
    private String username;

    @Column(name="PASSWORD_HASH")
    private String password;

    @Column(name="FIRST_NAME")
    private String firsName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="EMAIL")
    private String email;

    @Column(name="IMAGE_URL")
    private String imageUrl;

    @Column(name="ACTIVATED")
    private Integer activated;

    @Column(name="LANG_KEY")
    private String langKey;

    @Column(name="ACTIVATION_KEY")
    private String activationKey;

    @Column(name="RESET_KEY")
    private String resetKey;

    @Column(name="CREATED_BY")
    private String createdBy;

    @Column(name="CREATED_DATE")
    private Date createdDate;

    @Column(name="RESET_DATE")
    private Date resetDate;

    @Column(name="LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @Column(name="LAST_MODIFIED_DATE")
    private Date lastModifiedDate;

    @OneToOne
    @JoinColumn(name="ID_SUCURSAL", referencedColumnName = "ID_SUCURSAL")
    @JoinColumn(name="CODIGO_TRABAJADOR",referencedColumnName = "CODIGO_TRABAJADOR")
    private EmpleadoEntity empleado;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getActivated() {
        return activated;
    }

    public void setActivated(Integer activated) {
        this.activated = activated;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public String getResetKey() {
        return resetKey;
    }

    public void setResetKey(String resetKey) {
        this.resetKey = resetKey;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getResetDate() {
        return resetDate;
    }

    public void setResetDate(Date resetDate) {
        this.resetDate = resetDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }


    public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }
}
