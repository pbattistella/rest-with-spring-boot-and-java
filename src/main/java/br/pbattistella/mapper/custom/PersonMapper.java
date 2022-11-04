package br.pbattistella.mapper.custom;

import br.pbattistella.data.vo.v2.PersonVOV2;
import br.pbattistella.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    private Person person;
    private Person entity;

    public PersonVOV2 convertEntityToVo(Person person) {
        var vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        vo.setAddress(person.getAddress());
        vo.setBirthDay(new Date());
        return vo;
    }

    public Person convertVOToEntity(PersonVOV2 personVOV2) {
        var entity = new Person();
        entity.setId(personVOV2.getId());
        entity.setFirstName(personVOV2.getFirstName());
        entity.setLastName(personVOV2.getLastName());
        entity.setGender(personVOV2.getGender());
        entity.setAddress(personVOV2.getAddress());
        //entity.setBirthDay(new Date());
        return entity;
    }

}
