package Practica_Grupal.controller;

import Practica_Grupal.Domain.Practica;
import Practica_Grupal.Service.FirebaseStorageService;
import Practica_Grupal.Service.PracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/practica")
public class PracticaController {
    
    @Autowired
    private PracticaService practicaService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var practicas = practicaService.getPracticas(false);      
        model.addAttribute("practicas",practicas);
        model.addAttribute("totalPracticas",practicas.size());
        return "/practica/listado";
    }
    
    @GetMapping("/nuevo")
    public String practicaNuevo(Practica practica) {
        return "/practica/modifica";
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;
    
    @PostMapping("/guardar")
    public String practicaGuardar(Practica practica,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            practicaService.save(practica);
            practica.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "practica", 
                            practica.getIdPractica()));
        }
        practicaService.save(practica);
        return "redirect:/practica/listado";
    }

    @GetMapping("/eliminar/{idPractica}")
    public String practicaEliminar(Practica practica) {
        practicaService.delete(practica);
        return "redirect:/practica/listado";
    }

    @GetMapping("/modificar/{idPractica}")
    public String practicaModificar(Practica practica, Model model) {
        practica = practicaService.getPractica(practica);
        model.addAttribute("practica", practica);
        return "/practica/modifica";
    }
}
