package pe.edu.i202222350.cl2_mvc_s_sihuintaandy.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.REMOVE)
    private List<FilmActor> filmActors;

}