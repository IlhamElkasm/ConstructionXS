package com.Ressources.Service;

import com.Ressources.Dto.RessourceDto;
import com.Ressources.Model.Ressource;

import java.util.List;

public class RessourceService implements  IRessourceService{


    @Override
    public Ressource createRessource(Ressource ressource, Long idTache) {
        return null;
    }

    @Override
    public RessourceDto getRessourceById(Long id) {
        return null;
    }

    @Override
    public void deleteRessource(Long id) {

    }

    @Override
    public List<RessourceDto> getAllRessource() {
        return List.of();
    }

    @Override
    public RessourceDto updateRessource(Long id, RessourceDto ressourceDto) {
        return null;
    }

    @Override
    public void deleteRessourceByTacheId(Long idProjet) {

    }
}
