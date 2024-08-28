package com.Taches.Service;

import com.Taches.Dto.TachesDto;
import com.Taches.Mapper.TachesMapper;
import com.Taches.Model.Taches;
import com.Taches.Repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TachesService  implements ITachesService{


    @Autowired
    private TacheRepository tacheRepository;

    @Autowired
    private TachesMapper tachesMapper;

    @Override
    public TachesDto createTache(TachesDto tachesDto) {
        Taches tache = tachesMapper.toEntity(tachesDto);
        tache = tacheRepository.save(tache);
        return tachesMapper.toDto(tache);
    }
}
