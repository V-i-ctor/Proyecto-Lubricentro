
package com.lubricentro.domain;

import jakarta.persistence.*; 
import java.io.Serializable; 
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name="categoriaespecifica")

public class CategoriaEspecifica implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria_especifica")
    private Long idCategoriaEspecifica;
    //private Long idCategoriaGeneral;  ya no se usa por el @manyToOne
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name="id_categoria_general")
    CategoriaGeneral categoriageneral;

    public CategoriaEspecifica() {
    }

    public CategoriaEspecifica(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
    

}
