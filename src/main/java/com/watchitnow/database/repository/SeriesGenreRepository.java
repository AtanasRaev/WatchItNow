package com.watchitnow.database.repository;

import com.watchitnow.database.model.entity.SeriesGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeriesGenreRepository extends JpaRepository<SeriesGenre, Long> {
    Optional<SeriesGenre> findByApiId(Long genre);
}
