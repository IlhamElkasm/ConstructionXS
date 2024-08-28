package com.Taches.Service;

import com.Taches.Dto.TachesDto;

public interface ITachesService {

    TachesDto createTache(TachesDto tachesDto,  int idProjet);
}
