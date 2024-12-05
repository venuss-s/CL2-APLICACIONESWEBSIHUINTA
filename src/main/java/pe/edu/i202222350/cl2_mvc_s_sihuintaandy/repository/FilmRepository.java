package pe.edu.i202222350.cl2_mvc_s_sihuintaandy.repository;

import jakarta.persistence.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.repository.CrudRepository;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.entity.Film;

public interface FilmRepository extends CrudRepository<Film, Integer> {



    @Override
    @CacheEvict(value = "filmsCache", allEntries = true)
    <S extends Film> S save(S entity);

    @Override
    @CacheEvict(value = "filmsCache", allEntries = true)
    void deleteById(Integer id);



}
