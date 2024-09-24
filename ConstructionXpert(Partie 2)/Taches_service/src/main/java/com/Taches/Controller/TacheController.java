package com.Taches.Controller;

import com.Taches.Dto.APIResponse;
import com.Taches.Dto.TachesDto;
import com.Taches.Model.Taches;
import com.Taches.Service.ITachesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Taches")
public class TacheController {

    @Autowired
    private ITachesService tachesService;

    @PostMapping("/{idProjet}")
    public ResponseEntity<TachesDto> createProject(@RequestBody TachesDto tachesDto, @PathVariable Long idProjet) {
        TachesDto createdProject = tachesService.createTache(tachesDto, idProjet);
        return ResponseEntity.ok(createdProject);
    }

    @GetMapping
    public ResponseEntity<List<TachesDto>> getAllTaches() {
        List<TachesDto> projets = tachesService.getAllTaches();
        return ResponseEntity.ok(projets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TachesDto> getTacheById(@PathVariable Long id) {
        TachesDto taches = tachesService.getTachesById(id);
        if (taches != null) {
            return ResponseEntity.ok(taches);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TachesDto> updateTache(@PathVariable Long id, @RequestBody TachesDto tachesDto) {
        TachesDto updatedProject = tachesService.updateTache(id, tachesDto);
        if (updatedProject != null) {
            return ResponseEntity.ok(updatedProject);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTache(@PathVariable Long id) {
        tachesService.deleteTache(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/projet/{idProjet}")
    public void deleteTachesByProjetId(@PathVariable Long idProjet) {
        tachesService.deleteTachesByProjetId(idProjet);
    }

    @GetMapping("/Asc/{feild}")
    private APIResponse<List<TachesDto>> getTachesByAsc(@PathVariable String feild) {
        List<TachesDto> allTaches = tachesService.findTachesWithSortingAsc(feild);
        return new APIResponse<>(allTaches.size(), allTaches);
    }

    @GetMapping("/Desc/{feild}")
    private APIResponse<List<TachesDto>> getTachesByDesc(@PathVariable String feild) {
        List<TachesDto> allTaches = tachesService.findTachesWithSortingDesc(feild);
        return new APIResponse<>(allTaches.size(), allTaches);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private APIResponse<Page<TachesDto>> getTachesWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<TachesDto> tachePagination = tachesService.findTachesWithPagination(offset, pageSize);
        return new APIResponse<>(tachePagination.getSize(), tachePagination);
    }
}
