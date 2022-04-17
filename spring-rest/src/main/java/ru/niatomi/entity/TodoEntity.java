package ru.niatomi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author niatomi
 */
@Entity
@Table(name = "todo_table")
@NoArgsConstructor
@Data
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean completed;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
