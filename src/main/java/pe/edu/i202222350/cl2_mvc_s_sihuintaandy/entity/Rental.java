package pe.edu.i202222350.cl2_mvc_s_sihuintaandy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentalId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalDate;

    private Integer customerId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;

    private Integer staffId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "inventory_id", nullable = false)
    private Inventory inventory; // Relación con Inventory
}
