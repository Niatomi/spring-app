package ru.niatomi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.niatomi.entity.OpenerEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author niatomi
 */
@Data
@AllArgsConstructor
public class Password {
    private Long id;
    private String type;
    private String value;

}
