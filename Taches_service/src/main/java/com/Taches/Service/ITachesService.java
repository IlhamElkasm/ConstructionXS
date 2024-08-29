package com.Taches.Service;

import com.Taches.Dto.TachesDto;
import com.Taches.Model.Taches;

public interface ITachesService {

//    TachesDto createTache(TachesDto tachesDto,  Long idProjet);
        Taches createTache(Taches tachesDto, Long idProjet);
}
