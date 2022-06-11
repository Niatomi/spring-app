package ru.niatomi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author niatomi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actions_history_table")
public class ActionsHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "opener_id")
    private OpenerEntity opener;

    private String description;

    private String actionDate;

}
