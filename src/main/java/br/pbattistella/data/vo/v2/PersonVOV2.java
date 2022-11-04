package br.pbattistella.data.vo.v2;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class PersonVOV2 implements Serializable {
    private static final long serialVersionUID = -4504740920202574390L;

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Date birthDay;

}
