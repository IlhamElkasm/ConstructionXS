package com.Ressources.Service;

import com.Ressources.Dto.RessourceDto;
import com.Ressources.Model.Ressource;
import com.Ressources.Repository.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RessourceService implements  IRessourceService{


    @Autowired
    private RessourceRepository ressourceRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public RessourceDto createRessource(RessourceDto ressourceDto, Long idTache) {
        try {
            restTemplate.getForObject("http://localhost:8082/api/Taches/" + idTache, Object.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Projet non trouvé : " + e);
        }

        Ressource ressource = new Ressource();
        ressource.setNom(ressourceDto.getNom());
        ressource.setTypee(ressourceDto.getTypee());
        ressource.setQuantité(ressourceDto.getQuantité());
        ressource.setIdTache(idTache);

        Ressource savedRessource = ressourceRepository.save(ressource);

        RessourceDto resultDto = new RessourceDto();
        resultDto.setId(savedRessource.getId());
        resultDto.setNom(savedRessource.getNom());
        resultDto.setTypee(savedRessource.getTypee());
        resultDto.setQuantité(savedRessource.getQuantité());
        resultDto.setIdTache(savedRessource.getIdTache());

        return resultDto;
    }

    @Override
    public RessourceDto getRessourceById(Long id) {
        Optional<Ressource> optionalRessource = ressourceRepository.findById(id);
        if (optionalRessource.isPresent()) {
            Ressource ressource = optionalRessource.get();
            RessourceDto ressourceDto = new RessourceDto();
            ressourceDto.setId(ressource.getId());
            ressourceDto.setNom(ressource.getNom());
            ressourceDto.setTypee(ressource.getTypee());
            ressourceDto.setQuantité(ressource.getQuantité());
            ressourceDto.setIdTache(ressource.getIdTache());
            return ressourceDto;
        }
        return null;
    }

    @Override
    public void deleteRessource(Long id) {
        ressourceRepository.deleteById(id);
    }

    @Override
    public List<RessourceDto> getAllRessource() {
        List<Ressource> ressourceList = ressourceRepository.findAll();
        return ressourceList.stream().map(ressource -> {
            RessourceDto dto = new RessourceDto();
            dto.setId(ressource.getId());
            dto.setNom(ressource.getNom());
            dto.setTypee(ressource.getTypee());
            dto.setQuantité(ressource.getQuantité());
            dto.setIdTache(ressource.getIdTache());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public RessourceDto updateRessource(Long id, RessourceDto ressourceDto) {
        Optional<Ressource> optionalRessource = ressourceRepository.findById(id);
        if (optionalRessource.isPresent()) {
            Ressource existingRessource = optionalRessource.get();
            existingRessource.setNom(ressourceDto.getNom());
            existingRessource.setTypee(ressourceDto.getTypee());
            existingRessource.setQuantité(ressourceDto.getQuantité());
            existingRessource.setIdTache(ressourceDto.getIdTache());

            Ressource updatedRessource = ressourceRepository.save(existingRessource);

            RessourceDto resultDto = new RessourceDto();
            resultDto.setId(updatedRessource.getId());
            resultDto.setNom(updatedRessource.getNom());
            resultDto.setTypee(updatedRessource.getTypee());
            resultDto.setQuantité(updatedRessource.getQuantité());
            resultDto.setIdTache(updatedRessource.getIdTache());

            return resultDto;
        }
        return null;
    }

    @Override
    public void deleteRessourceByTacheId(Long idTache) {
        List<Ressource> ressources = ressourceRepository.findByIdTache(idTache);
        if (ressources != null && !ressources.isEmpty()) {
            ressourceRepository.deleteAll(ressources);
        }
    }
}
