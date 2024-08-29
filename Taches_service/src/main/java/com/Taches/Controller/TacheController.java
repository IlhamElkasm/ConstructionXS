package com.Taches.Controller;

import com.Taches.Dto.TachesDto;
import com.Taches.Model.Taches;
import com.Taches.Service.ITachesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/Taches")
public class TacheController {

    @Autowired
    private ITachesService tachesService;

    // Créer un nouveau projet
    @PostMapping("/{idProjet}")
//    public ResponseEntity<TachesDto> createProject(@RequestBody TachesDto tachesDto, @PathVariable Long idProjet) {
//        TachesDto createdProject = tachesService.createTache(tachesDto, idProjet);
//        return ResponseEntity.ok(createdProject);
//    }
    public ResponseEntity<Taches> createProject(@RequestBody Taches tachesDto, @PathVariable Long idProjet) {
        Taches createdProject = tachesService.createTache(tachesDto, idProjet);
        return ResponseEntity.ok(createdProject);
    }
}
