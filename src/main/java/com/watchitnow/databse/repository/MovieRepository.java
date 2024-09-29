package com.watchitnow.databse.repository;

import com.watchitnow.databse.model.dto.MoviePageDTO;
import com.watchitnow.databse.model.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findByApiId(Long apiId);

    Optional<Movie> findTopByOrderByIdDesc();

    @Query("SELECT m FROM Movie m WHERE EXTRACT(YEAR FROM m.releaseDate) = :year")
    Page<Movie> findAllByYear(@Param("year") int year, Pageable pageable);

    @Query("SELECT m FROM Movie m WHERE EXTRACT(YEAR FROM m.releaseDate) = :year AND EXTRACT(MONTH FROM m.releaseDate) = :month")
    List<Movie> findMoviesByYearAndMonth(@Param("year") int year, @Param("month") int month);

    @Query("SELECT COUNT(m) FROM Movie m WHERE EXTRACT(YEAR FROM m.releaseDate) = :year AND EXTRACT(MONTH FROM m.releaseDate) = :month")
    long countMoviesInDateRange(@Param("year") int year, @Param("month") int month);

    @Query("SELECT m FROM Movie m WHERE m.releaseDate = (SELECT MIN(m2.releaseDate) FROM Movie m2)")
    List<Movie> findOldestMovie();

    @Query("SELECT m FROM Movie m WHERE EXTRACT(YEAR FROM m.releaseDate) > :startYear AND EXTRACT(YEAR FROM m.releaseDate) < :endYear")
    List<Movie> findAllByReleaseDate(@Param("startYear") int startYear, @Param("endYear") int endYear);

    @Query("SELECT DISTINCT m FROM Movie m LEFT JOIN FETCH m.genres WHERE m.releaseDate BETWEEN :startDate AND :endDate")
    List<Movie> findByReleaseDateBetweenWithGenres(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
