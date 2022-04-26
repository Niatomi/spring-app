package ru.niatomi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

/**
 * @author niatomi
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "opener_table")
public class OpenerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opener")
    List<PasswordEntity> passwords;

    private String firstName;
    private String secondName;
    private String thirdName;

}
