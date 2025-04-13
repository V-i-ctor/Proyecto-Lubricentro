
package com.lubricentro.controller;

import com.lubricentro.domain.CategoriaEspecifica;
import com.lubricentro.service.CategoriaEspecificaService;
import com.lubricentro.service.Impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/categoriaespecifica")
public class CategoriaEspecificaController {
   
     
    @Autowired
    private CategoriaEspecificaService categoriaespecificaService;
    
    @GetMapping("/listado")
    private String listado(Model model) {
        var categoriasespecificas = categoriaespecificaService.getCategoriasEspecificas(false);
        model.addAttribute("categoriasespecificas", categoriasespecificas);
        model.addAttribute("totalCategoriasEspecificas",categoriasespecificas.size());
        return "/categoriaespecifica/listado";
    }
    
    @GetMapping("/nuevo")
    public String categoriaespecificaNuevo(CategoriaEspecifica categoriaespecifica) {
        return "/categoriaespecifica/modifica";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String categoriaespecificaGuardar(CategoriaEspecifica categoriaespecifica,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            categoriaespecificaService.save(categoriaespecifica);
            categoriaespecifica.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "categoriaespecifica", 
                            categoriaespecifica.getIdCategoriaEspecifica()));
        }
        categoriaespecificaService.save(categoriaespecifica);
        return "redirect:/categoriaespecifica/listado";
    }

    @GetMapping("/eliminar/{idCategoriaEspecifica}")
    public String categoriaespecificaEliminar(CategoriaEspecifica categoriaespecifica) {
        categoriaespecificaService.delete(categoriaespecifica);
        return "redirect:/categoriaespecifica/listado";
    }

    @GetMapping("/modifica/{idCategoriaEspecifica}")
    public String categoriaespecificaModificar(CategoriaEspecifica categoriaespecifica, Model model) {
        categoriaespecifica = categoriaespecificaService.getCategoriaEspecifica(categoriaespecifica);
        model.addAttribute("categoriaespecifica", categoriaespecifica);
        return "/categoriaespecifica/modifica";
    }
}
//TEST
//Prueba
//Prueba2