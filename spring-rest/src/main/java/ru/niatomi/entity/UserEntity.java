package ru.niatomi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author niatomi
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "user_table")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    List<TodoEntity> todos;

    private String username;
    private String password;
}
