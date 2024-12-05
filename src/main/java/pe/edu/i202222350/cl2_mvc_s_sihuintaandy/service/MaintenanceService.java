package pe.edu.i202222350.cl2_mvc_s_sihuintaandy.service;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.dto.FilmDetailDto;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.dto.FilmDto;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.dto.FilmInsertDto;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.entity.Film;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.entity.Language;


import java.util.List;

public interface MaintenanceService {



    List<FilmDto> findAllFilms();
    FilmDetailDto findFilmById(int id);
    Boolean updateFilm(FilmDetailDto filmDetailDto);
    List<Language> getAllLanguages();
    void insertFilm(FilmInsertDto filmInsertDto);
    void deleteFilmById(int id);


}
