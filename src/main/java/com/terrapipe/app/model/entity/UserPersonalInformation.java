package com.terrapipe.app.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "informacion_personal_usuarios")
public class UserPersonalInformation {
    @Id
    private Integer id;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private Integer telefono;
    private boolean estado;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipos_id")
    private TypeId typeId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Finca finca;    
    @OneToMany(mappedBy = "userPersonalInformation")
    @JoinColumn(name = "id_device")
    private List<Device> dispositivos;



    public UserPersonalInformation() {
    }

    public UserPersonalInformation(Integer id, String nombre1, String nombre2, String apellido1, String apellido2,
            String direccion, Integer numeroTelefono, boolean estado) {
        this.id = id;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.telefono = numeroTelefono;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getNumeroTelefono() {
        return telefono;
    }

    public void setNumeroTelefono(Integer numeroTelefono) {
        this.telefono = numeroTelefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "UserPersonalInformation [id=" + id + ", nombre1=" + nombre1 + ", nombre2=" + nombre2 + ", apellido1="
                + apellido1 + ", apellido2=" + apellido2 + ", direccion=" + direccion + ", numeroTelefono="
                + telefono + ", estado=" + estado + "]";
    }


    
}
