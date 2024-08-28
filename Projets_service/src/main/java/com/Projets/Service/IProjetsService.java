package com.Projets.Service;

import com.Projets.Dto.ProjetsDTO;
import com.Projets.Model.Projets;

import java.util.List;

public interface IProjetsService {

    ProjetsDTO createProject(ProjetsDTO projetsDTO);
    ProjetsDTO getProjetById(Long id);
    void deleteProject(Long id);

    // Afficher la liste des projets existants
    List<ProjetsDTO> getAllProjects();

    ProjetsDTO updateProject(Long id, ProjetsDTO projetsDTO);
}
