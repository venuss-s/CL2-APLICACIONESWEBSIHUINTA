package pe.edu.i202222350.cl2_mvc_s_sihuintaandy.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmCategory {

    @EmbeddedId
    private FilmCategoryPk id;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name="film_id")
    private Film film;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    private Category category;

    private Date lastUpdate;

}