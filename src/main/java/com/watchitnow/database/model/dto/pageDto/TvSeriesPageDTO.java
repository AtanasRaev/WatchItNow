package com.watchitnow.database.model.dto.pageDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "poster_path", "first_air_date", "seasons", "episode_time", "genres"})
public class TvSeriesPageDTO extends MediaPageDTO{
    private String name;

    @JsonProperty("seasons")
    private Integer seasonsCount;

    @JsonProperty("episode_time")
    private Integer episodeTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeasonsCount() {
        return seasonsCount;
    }

    public void setSeasonsCount(Integer seasonsCount) {
        this.seasonsCount = seasonsCount;
    }

    public Integer getEpisodeTime() {
        return episodeTime;
    }

    public void setEpisodeTime(Integer episodeTime) {
        this.episodeTime = episodeTime;
    }
}
