package com.Projets.Controller;

import com.Projets.Dto.APIResponse;
import com.Projets.Dto.ProjetsDTO;
import com.Projets.Model.Projets;
import com.Projets.Service.IProjetsService;
import com.Projets.Service.ProjetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Projets")
public class ProjetsController {

    @Autowired
    private IProjetsService projetsService;

    // Créer un nouveau projet
    @PostMapping
    public ResponseEntity<ProjetsDTO> createProject(@RequestBody ProjetsDTO projetsDTO) {
        ProjetsDTO createdProject = projetsService.createProject(projetsDTO);
        return ResponseEntity.ok(createdProject);
    }

    // Afficher la liste des projets existants
//    @GetMapping
//    public ResponseEntity<List<ProjetsDTO>> getAllProjects() {
//        List<ProjetsDTO> projets = projetsService.getAllProjects();
//        return ResponseEntity.ok(projets);
//    }

    @GetMapping
    private APIResponse<List<ProjetsDTO>> getProducts() {
        List<ProjetsDTO> allProjets = projetsService.getAllProjects();
        return new APIResponse<>(allProjets.size(), allProjets);
    }

    @GetMapping("/Asc/{field}")
    private APIResponse<List<ProjetsDTO>> getprojetsWithSortAsc(@PathVariable String field) {
        List<ProjetsDTO> allProjets = projetsService.findProjetsWithSortingAsc(field);
        return new APIResponse<>(allProjets.size(), allProjets);
    }

    @GetMapping("/Desc/{field}")
    private APIResponse<List<ProjetsDTO>> getprojetsWithSortDesc(@PathVariable String field) {
        List<ProjetsDTO> allProjets = projetsService.findProjetsWithSortingDesc(field);
        return new APIResponse<>(allProjets.size(), allProjets);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private APIResponse<Page<ProjetsDTO>> getprojetsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<ProjetsDTO> projetsWithPagination = projetsService.findProjetsWithPagination(offset, pageSize);
        return new APIResponse<>(projetsWithPagination.getSize(), projetsWithPagination);
    }

    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    private APIResponse<Page<ProjetsDTO>> getprojetsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
        Page<ProjetsDTO> productsWithPagination = projetsService.findprojetsWithPaginationAndSorting(offset, pageSize, field);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }

    // Récupérer un projet par ID
    @GetMapping("/{id}")
    public ResponseEntity<ProjetsDTO> getProjectById(@PathVariable Long id) {
        ProjetsDTO projet = projetsService.getProjetById(id);
        if (projet != null) {
            return ResponseEntity.ok(projet);
        }
        return ResponseEntity.notFound().build();
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
    // Supprimer les tâches d'un projet
    @DeleteMapping("/{id}/taches")
    public ResponseEntity<Void> deleteProjectTache(@PathVariable Long id) {
        projetsService.deleteProjectTache(id);
        return ResponseEntity.noContent().build();
    }


    // Supprimer un projet existant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projetsService.deleteProjet(id);
        return ResponseEntity.noContent().build();
    }
}
