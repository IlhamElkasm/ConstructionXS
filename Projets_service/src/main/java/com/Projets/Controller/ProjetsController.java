package com.Projets.Controller;

import com.Projets.Dto.ProjetsDTO;
import com.Projets.Service.ProjetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Projets")
public class ProjetsController {

    @Autowired
    private ProjetsService projetsService;

    // Créer un nouveau projet
    @PostMapping
    public ResponseEntity<ProjetsDTO> createProject(@RequestBody ProjetsDTO projetsDTO) {
        ProjetsDTO createdProject = projetsService.createProject(projetsDTO);
        return ResponseEntity.ok(createdProject);
    }

    // Afficher la liste des projets existants
    @GetMapping
    public ResponseEntity<List<ProjetsDTO>> getAllProjects() {
        List<ProjetsDTO> projets = projetsService.getAllProjects();
        return ResponseEntity.ok(projets);
    }

    // Mettre à jour un projet existant
    @PutMapping("/{id}")
    public ResponseEntity<ProjetsDTO> updateProject(@PathVariable Long id, @RequestBody ProjetsDTO projetsDTO) {
        ProjetsDTO updatedProject = projetsService.updateProject(id, projetsDTO);
        if (updatedProject != null) {
            return ResponseEntity.ok(updatedProject);
        }
        return ResponseEntity.notFound().build();
    }

    // Supprimer un projet existant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projetsService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

}
