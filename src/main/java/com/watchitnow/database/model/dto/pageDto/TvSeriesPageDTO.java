package com.watchitnow.database.model.dto.pageDto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TvSeriesPageDTO {
    @JsonProperty("api_id")
    private Long apiId;

    private String name;

    @JsonProperty("poster_path")
    private String posterPath;

    private List<GenrePageDTO> genres;

    public Long getApiId() {
        return apiId;
    }

    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<GenrePageDTO> getGenres() {
        return genres;
    }

    public void setGenres(List<GenrePageDTO> genres) {
        this.genres = genres;
    }
}
