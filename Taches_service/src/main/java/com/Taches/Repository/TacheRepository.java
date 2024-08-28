package com.Taches.Repository;

import com.Taches.Model.Taches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository  extends JpaRepository<Taches, Long> {
}
