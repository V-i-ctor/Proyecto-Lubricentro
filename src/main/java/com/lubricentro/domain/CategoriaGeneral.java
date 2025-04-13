package com.lubricentro.domain;

import jakarta.persistence.*; 
import java.io.Serializable; 
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name="categoriageneral")
public class CategoriaGeneral implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria_general")
    private Long idCategoriaGeneral;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    @OneToMany
    @JoinColumn(name = "id_categoria_general", updatable = false)
    List<CategoriaEspecifica> categoriasespecificas;
    
    public CategoriaGeneral() {
}  
public CategoriaGeneral(String categoriageneral, boolean activo) {
        this.descripcion = categoriageneral;
        this.activo = activo;
    }
}
