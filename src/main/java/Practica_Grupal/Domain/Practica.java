package Practica_Grupal.Domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="practica")
public class Practica implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_practica")
    private long idPractica;
    private String descripcion;
    private String rutaImagen ;
    private boolean activo;

    public Practica() {
    }

    public Practica(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
    
    
}
