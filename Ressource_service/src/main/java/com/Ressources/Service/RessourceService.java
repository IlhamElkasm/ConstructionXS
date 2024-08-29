package com.Ressources.Service;

import com.Ressources.Dto.RessourceDto;
import com.Ressources.Model.Ressource;
import com.Ressources.Repository.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RessourceService implements  IRessourceService{


    @Autowired
    private RessourceRepository ressourceRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Ressource createRessource(Ressource ressource, Long idTache) {
        try {
            restTemplate.getForObject("http://localhost:8081/api/Projets/" +idTache, Object.class);
        }catch (Exception e){
            throw  new IllegalArgumentException("projet non trouve :" +e);
        }
//        Taches tache = tachesMapper.toEntity(tachesDto);
        ressource.setIdTache(idTache);
        return ressourceRepository.save(ressource);
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
