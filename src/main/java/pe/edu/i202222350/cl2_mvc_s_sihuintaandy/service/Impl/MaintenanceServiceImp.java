package pe.edu.i202222350.cl2_mvc_s_sihuintaandy.service.Impl;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.dto.FilmDetailDto;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.dto.FilmDto;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.dto.FilmInsertDto;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.entity.Film;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.entity.Inventory;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.repository.InventoryRepository;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.repository.LanguageRepository;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.entity.Language;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.repository.FilmRepository;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.repository.RentalRepository;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.service.MaintenanceService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImp implements MaintenanceService {

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    RentalRepository rentalRepository;
    @Autowired
    InventoryRepository inventoryRepository;


    @Override
    public List<FilmDto> findAllFilms() {
        List<FilmDto> films = new ArrayList<FilmDto>();
        Iterable<Film> iterable = filmRepository.findAll();
        iterable.forEach(film -> {
            FilmDto filmDto = new FilmDto(film.getFilmId(),
                    film.getTitle(),
                    film.getLanguage().getName(),
                    film.getRentalDuration(),
                    film.getRentalRate());
            films.add(filmDto);
        });
        return films;
    }

    @Override
    public FilmDetailDto findFilmById(int id) {
        Optional<Film> optional = filmRepository.findById(id);
        return optional.map(film -> new FilmDetailDto(film.getFilmId(),
                film.getTitle(),
                film.getDescription(),
                film.getReleaseYear(),
                film.getLanguage().getLanguageId(),
                film.getLanguage().getName(),
                film.getRentalDuration(),
                film.getRentalRate(),
                film.getLength(),
                film.getReplacementCost(),
                film.getRating(),
                film.getSpecialFeatures(),
                film.getLastUpdate())
        ).orElse(null);


    }

    @Override
    public Boolean updateFilm(FilmDetailDto filmDetailDto) {
        Optional<Film> optional = filmRepository.findById(filmDetailDto.filmId());
        Language language = languageRepository.findById(filmDetailDto.languageId())
                .orElseThrow(() -> new RuntimeException("Language not found"));
        return optional.map(
                film -> {
                    film.setTitle(filmDetailDto.title());
                    film.setDescription(filmDetailDto.description());
                    film.setReleaseYear(filmDetailDto.releaseYear());
                    film.setLanguage(language);
                    film.setRentalDuration(filmDetailDto.rentalDuration());
                    film.setRentalRate(filmDetailDto.rentalRate());
                    film.setLength(filmDetailDto.length());
                    film.setReplacementCost(filmDetailDto.replacementCost());
                    film.setRating(filmDetailDto.rating());
                    film.setSpecialFeatures(filmDetailDto.specialFeatures());
                    film.setLastUpdate(new Date());
                    filmRepository.save(film);
                    return true;
                }
        ).orElse(false);
    }
    @Override
    public List<Language> getAllLanguages() {
        return (List<Language>) languageRepository.findAll();
    }

    @Override
    public void insertFilm(FilmInsertDto filmInsertDto) {
        Film film = new Film();
        film.setTitle(filmInsertDto.title());
        film.setDescription(filmInsertDto.description());
        film.setReleaseYear(filmInsertDto.releaseYear());
        film.setRentalDuration(filmInsertDto.rentalDuration());
        film.setRentalRate(filmInsertDto.rentalRate());
        film.setLength(filmInsertDto.length());
        film.setReplacementCost(filmInsertDto.replacementCost());
        film.setRating(filmInsertDto.rating());
        film.setSpecialFeatures(filmInsertDto.specialFeatures());

        Language language = languageRepository.findById(filmInsertDto.languageId())
                .orElseThrow(() -> new IllegalArgumentException("Idioma no válido"));
        film.setLanguage(language);
        film.setLastUpdate(new Date());

        filmRepository.save(film);

    }

    @Override
    public void deleteFilmById(int id) {
        filmRepository.deleteById(id);
    }


    }











