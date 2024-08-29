package com.Ressources.Controller;


import com.Ressources.Model.Ressource;
import com.Ressources.Service.IRessourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Ressource")
public class RessourceController {

    @Autowired
    private IRessourceService ressourceService;


    // Créer un nouveau Ressource
    @PostMapping("/{idTache}")
    public ResponseEntity<Ressource> createTache(@RequestBody Ressource ressource, @PathVariable Long idTache) {
        Ressource createdRessource = ressourceService.createRessource(ressource, idTache);
        return ResponseEntity.ok(createdRessource);
    }
}
