package com.Ressources.Repository;

import com.Ressources.Model.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RessourceRepository extends JpaRepository<Ressource, Long> {
}
