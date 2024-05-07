package com.terrapipe.app.model.entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "informacion_personal_usuarios")
public class UserPersonalInformation {
    @Id
    private Integer id;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private String telefono;
    private boolean estado;

    @ManyToOne
    private TypeId tipoId;   

    @OneToMany(mappedBy = "upi", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Device> dispositivos;
    
    @OneToMany(mappedBy = "upi", fetch = FetchType.LAZY)
    private List<Finca> fincas;

    
}
