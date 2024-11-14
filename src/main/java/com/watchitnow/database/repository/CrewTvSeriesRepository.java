package com.watchitnow.database.repository;

import com.watchitnow.database.model.entity.credit.Crew.CrewTvSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewTvSeriesRepository extends JpaRepository<CrewTvSeries, Long> {
}
