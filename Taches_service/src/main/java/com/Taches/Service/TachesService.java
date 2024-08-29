package com.Taches.Service;

import com.Taches.Dto.TachesDto;
import com.Taches.Mapper.TachesMapper;
import com.Taches.Model.Taches;
import com.Taches.Repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class TachesService  implements ITachesService{


    @Autowired
    private TacheRepository tacheRepository;

    @Autowired
    private TachesMapper tachesMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Taches createTache(Taches tachesDto, Long idProjet) {

        try {
            restTemplate.getForObject("http://localhost:8081/api/Projets/" +idProjet, Object.class);
        }catch (Exception e){
            throw  new IllegalArgumentException("projet non trouve :" +e);
        }
//        Taches tache = tachesMapper.toEntity(tachesDto);
        tachesDto.setIdProjet(idProjet);
        return tacheRepository.save(tachesDto);
//        return tachesMapper.toDto(tache);
    }

    @Override
    public TachesDto getTachesById(Long id) {
        Optional<Taches> optionalProjet = tacheRepository.findById(id);
        return optionalProjet.map(tachesMapper::toDto).orElse(null);
    }

    @Override
    public void deleteTache(Long id) {

        tacheRepository.deleteById(id);

    }

    @Override
    public List<TachesDto> getAllTaches() {
        List<TachesDto> list = tachesMapper.toDtoList(tacheRepository.findAll());
        System.out.println(list);
        return list;
    }

    @Override
    public TachesDto updateTache(Long id, TachesDto tachesDto) {
        Optional<Taches> optionalTaches = tacheRepository.findById(id);
        if (optionalTaches != null) {
            Taches updatedProjet = tachesMapper.toEntity(tachesDto);
            updatedProjet.setId(id); // Ensure the ID remains the same
            tacheRepository.save(updatedProjet);
            return tachesMapper.toDto(updatedProjet);
        }
        return null;
    }


    // Méthode pour supprimer les tâches par ID de projet
    public void deleteTachesByProjetId(Long idProjet) {
        // Récupérer la liste des tâches liées au projet
        List<Taches> taches = tacheRepository.findByIdProjet(idProjet);

        // Si la liste n'est pas vide, supprimer toutes les tâches
        if (taches != null && !taches.isEmpty()) {
            tacheRepository.deleteAll(taches);
        }
    }
}

