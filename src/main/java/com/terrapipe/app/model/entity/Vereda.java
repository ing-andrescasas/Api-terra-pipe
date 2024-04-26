package com.terrapipe.app.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "veredas")
public class Vereda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String nombre;
    private boolean estado;
    
    @OneToMany(mappedBy = "vereda", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Finca> finca;

    @ManyToOne(fetch = FetchType.LAZY)
    private City municipio;


    public Vereda() {
    }

    public Vereda(Integer id, String nombre, boolean estado) {
        Id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Vereda [Id=" + Id + ", nombre=" + nombre + ", estado=" + estado + "]";
    }


    
}
