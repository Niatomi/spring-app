package ru.niatomi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.niatomi.entity.OpenerEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author niatomi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionsHistory {

    private Long openerId;

    private String description;

}
