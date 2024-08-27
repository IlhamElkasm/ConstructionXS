package com.Projets.Service;

import com.Projets.Dto.ProjetsDTO;
import com.Projets.Model.Projets;

import java.util.List;

public interface IProjetsService {

    ProjetsDTO createProject(ProjetsDTO projetsDTO);
    List<ProjetsDTO> getAllProjects();
    ProjetsDTO updateProject(Long id, ProjetsDTO projetsDTO);
    void deleteProject(Long id);
    ProjetsDTO convertToDTO(Projets projet);
}
