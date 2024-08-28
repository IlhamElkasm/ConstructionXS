package com.Taches.Service;

import com.Taches.Dto.TachesDto;
import com.Taches.Mapper.TachesMapper;
import com.Taches.Model.Taches;
import com.Taches.Repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TachesService  implements ITachesService{


    @Autowired
    private TacheRepository tacheRepository;

    @Autowired
    private TachesMapper tachesMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public TachesDto createTache(TachesDto tachesDto, int idProjet) {


        try {
            restTemplate.getForObject("http://localhost:8081/api/Projets/id?idprojet"+idProjet, Object.class);
        }catch (Exception e){
            throw  new IllegalArgumentException("projet non trouve :" +idProjet);

        }
        Taches tache = tachesMapper.toEntity(tachesDto);
        tache.setIdprojet(idProjet);
        tache = tacheRepository.save(tache);
        return tachesMapper.toDto(tache);
    }
}
