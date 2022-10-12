package br.pbattistella.data.vo.v1;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class PersonVO implements Serializable {
    private static final long serialVersionUID = -4504740920202574390L;

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

}
