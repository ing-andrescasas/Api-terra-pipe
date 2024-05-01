package com.terrapipe.app.model.entity;
import java.util.List;
import jakarta.persistence.CascadeType;
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
@Table(name = "dispositivos")
public class Device {
    @Id
    private Integer id;
    private String name;
    private boolean estado;
    @ManyToOne(fetch = FetchType.LAZY)
    private UserPersonalInformation upi;

    
}
