package pe.edu.i202222350.cl2_mvc_s_sihuintaandy.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.entity.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Rental r WHERE r.inventory.inventoryId = :inventoryId")
    void deleteByInventoryId(@Param("inventoryId") Integer inventoryId);
}

