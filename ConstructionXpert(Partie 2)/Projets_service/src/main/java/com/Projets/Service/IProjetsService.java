package com.Projets.Service;

import com.Projets.Dto.ProjetsDTO;
import com.Projets.Model.Projets;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProjetsService {

    ProjetsDTO createProject(ProjetsDTO projetsDTO);
    ProjetsDTO getProjetById(Long id);
    void deleteProjectTache(Long id);

    void deleteProjet(Long id);

    // Afficher la liste des projets existants
    List<ProjetsDTO> getAllProjects();

    ProjetsDTO updateProject(Long id, ProjetsDTO projetsDTO);

    List<ProjetsDTO> findProjetsWithSortingAsc(String field);
    public List<ProjetsDTO> findProjetsWithSortingDesc(String field);

    Page<ProjetsDTO> findProjetsWithPagination(int offset, int pageSize);

    Page<ProjetsDTO> findprojetsWithPaginationAndSorting(int offset,int pageSize,String field);
}
