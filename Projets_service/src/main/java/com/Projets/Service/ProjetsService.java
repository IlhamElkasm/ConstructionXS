package com.Projets.Service;

import com.Projets.Dto.ProjetsDTO;
import com.Projets.Mapper.ProjetsMapper;
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

    @Autowired
    private ProjetsMapper projetsMapper;

    // Créer un nouveau projet
    @Override
    public ProjetsDTO createProject(ProjetsDTO projetsDTO) {
        Projets projet = projetsMapper.toEntity(projetsDTO);
        projet = projetsRepository.save(projet);
        return projetsMapper.toDto(projet);
    }

    // Afficher la liste des projets existants
    @Override
    public List<ProjetsDTO> getAllProjects() {

        List<ProjetsDTO> list = projetsMapper.toDtoList(projetsRepository.findAll());
        System.out.println(list);
        return list;
//        return projetsRepository.findAll().stream()
//                .map(projetsMapper::toDto)
//                .collect(Collectors.toList());
    }

    // Mettre à jour un projet existant
    @Override
    public ProjetsDTO updateProject(Long id, ProjetsDTO projetsDTO) {
        Projets existingProjet = projetsRepository.findById(id).orElse(null);
        if (existingProjet != null) {
            Projets updatedProjet = projetsMapper.toEntity(projetsDTO);
            updatedProjet.setId(id); // Ensure the ID remains the same
            projetsRepository.save(updatedProjet);
            return projetsMapper.toDto(updatedProjet);
        }
        return null;
    }


    // Supprimer un projet existant
    @Override
    public void deleteProject(Long id) {
        projetsRepository.deleteById(id);
    }

    // Récupérer un projet par ID
    @Override
    public ProjetsDTO getProjetById(Long id) {
        Optional<Projets> optionalProjet = projetsRepository.findById(id);
        return optionalProjet.map(projetsMapper::toDto).orElse(null);
    }
}
