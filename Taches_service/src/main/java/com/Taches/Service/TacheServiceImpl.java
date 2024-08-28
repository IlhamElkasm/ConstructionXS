package com.Taches.Service;

import com.Taches.Dto.TacheDTO;
import com.Taches.Model.Taches;
import com.Taches.Repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheServiceImpl implements  ITacheService {

    @Autowired
    private TacheRepository tacheRepository;

    @Override
    public TacheDTO createTache(TacheDTO tacheDTO) {
        Taches tache = new Taches(
                null,
                tacheDTO.getNom(),
                tacheDTO.getDescription(),
                tacheDTO.getDate_debut(),
                tacheDTO.getDate_fin(),
                tacheDTO.getStatu(),
                tacheDTO.getIdprojet()
        );
        tache = tacheRepository.save(tache);
        return convertToDTO(tache);
    }

    @Override
    public List<TacheDTO> getAllTaches() {
        return List.of();
    }

    @Override
    public TacheDTO updateTache(Long id, TacheDTO tacheDTO) {
        return null;
    }

    @Override
    public void deleteTache(Long id) {

    }

    @Override
    public TacheDTO convertToDTO(Taches taches) {
        return new TacheDTO(
                taches.getId(),
                taches.getNom(),
                taches.getDate_debut(),
                taches.getDate_fin(),
                taches.getDescription(),
                taches.getStatu(),
                taches.getIdprojet()
        );
    }
}
