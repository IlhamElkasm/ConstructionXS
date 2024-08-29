package com.Ressources.Service;

import com.Ressources.Dto.RessourceDto;
import com.Ressources.Model.Ressource;

import java.util.List;

public interface IRessourceService {

    Ressource createRessource(Ressource ressource, Long idTache);
    RessourceDto getRessourceById(Long id);
    void deleteRessource(Long id);

    // Afficher la liste des projets existants
    List<RessourceDto> getAllRessource();

    RessourceDto updateRessource(Long id, RessourceDto ressourceDto);

    void deleteRessourceByTacheId(Long idProjet);
}
