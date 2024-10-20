package com.watchitnow.database.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tv_series")
public class TvSeries extends Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "series_genre",
            joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<SeriesGenre> genres;

    @Column
    private String name;

    @Column(name = "first_air_date")
    private LocalDate firstAirDate;

    @OneToMany(mappedBy = "tvSeries",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<SeasonTvSeries> seasons;

    @Column(name = "episode_run_time")
    private Integer episodeRunTime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tv_series_production",
            joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "production_id")
    )
    private Set<ProductionCompany> productionCompanies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SeriesGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<SeriesGenre> genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(LocalDate firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public Integer getEpisodeRunTime() {
        return episodeRunTime;
    }

    public void setEpisodeRunTime(Integer episodeRunTime) {
        this.episodeRunTime = episodeRunTime;
    }

    public List<SeasonTvSeries> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<SeasonTvSeries> seasons) {
        this.seasons = seasons;
    }

    public Set<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(Set<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }
}
