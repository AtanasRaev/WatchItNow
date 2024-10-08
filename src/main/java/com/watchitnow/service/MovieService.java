package com.watchitnow.service;

import com.watchitnow.database.model.dto.pageDto.MoviePageDTO;

import java.util.Set;

public interface MovieService {
    Set<MoviePageDTO> getMoviesFromCurrentMonth(int targetCount);
}
