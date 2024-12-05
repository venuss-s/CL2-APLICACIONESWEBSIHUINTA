package pe.edu.i202222350.cl2_mvc_s_sihuintaandy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.entity.Inventory;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    List<Inventory> findAllByFilm_FilmId(Integer filmId);
}
