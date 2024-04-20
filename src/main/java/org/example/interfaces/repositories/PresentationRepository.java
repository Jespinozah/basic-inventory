package org.example.interfaces.repositories;

import org.example.entities.Presentation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresentationRepository extends JpaRepository<Presentation, Integer> {
}
