package pe.edu.i202222350.cl2_mvc_s_sihuintaandy.entity;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmActorPk implements Serializable {
    private Integer actorId;
    private Integer filmId;

}