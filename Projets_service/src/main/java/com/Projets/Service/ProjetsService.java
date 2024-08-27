package com.Projets.Service;

import com.Projets.Dto.ProjetsDTO;
import com.Projets.Model.Projets;
import com.Projets.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjetsService implements  IProjetsService{


    @Autowired
    private ProjectRepository projetsRepository;

    // Créer un nouveau projet
    public ProjetsDTO createProject(ProjetsDTO projetsDTO) {
        Projets projet = new Projets(
                null,
                projetsDTO.getNom(),
                projetsDTO.getDescription(),
                projetsDTO.getDate_debut(),
                projetsDTO.getDate_fin(),
                projetsDTO.getBudget()
        );
        projet = projetsRepository.save(projet);
        return convertToDTO(projet);
    }

    // Afficher la liste des projets existants
    public List<ProjetsDTO> getAllProjects() {
        return projetsRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Mettre à jour un projet existant
    public ProjetsDTO updateProject(Long id, ProjetsDTO projetsDTO) {
        Optional<Projets> optionalProjet = projetsRepository.findById(id);
        if (optionalProjet.isPresent()) {
            Projets projet = optionalProjet.get();
            projet.setNom(projetsDTO.getNom());
            projet.setDescription(projetsDTO.getDescription());
            projet.setDate_debut(projetsDTO.getDate_debut());
            projet.setDate_fin(projetsDTO.getDate_fin());
            projet.setBudget(projetsDTO.getBudget());
            projet = projetsRepository.save(projet);
            return convertToDTO(projet);
        }
        return null;
    }

    // Supprimer un projet existant
    public void deleteProject(Long id) {
        projetsRepository.deleteById(id);
    }

    // Convertir une entité Projets en DTO
    public ProjetsDTO convertToDTO(Projets projet) {
        return new ProjetsDTO(
                projet.getId(),
                projet.getNom(),
                projet.getDescription(),
                projet.getDate_debut(),
                projet.getDate_fin(),
                projet.getBudget()
        );
    }
}
