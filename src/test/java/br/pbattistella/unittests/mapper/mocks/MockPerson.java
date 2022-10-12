package br.pbattistella.unittests.mapper.mocks;

import br.pbattistella.data.vo.v1.PersonVO;
import br.pbattistella.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {

    public Person mockEntity() {
        return mockEntity(0);
    }

    public PersonVO mockVO(){
        return mockVO(0);
    }

    public List<Person> mockEntityList() {
        List<Person> personList = new ArrayList<Person>();
        for (int i = 0; i < 14; i++){
            personList.add(mockEntity(i));
        }
        return personList;
    }

    public List<PersonVO> mockVOList() {
        List<PersonVO> personList = new ArrayList<PersonVO>();
        for (int i = 0; i < 14; i++){
            personList.add(mockVO(i));
        }
        return personList;
    }

    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setAddress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setLastName("Last Name Test" + number);
        person.setGender((number % 2 == 0) ? "Male" : "Female");
        person.setId(number.longValue());
        return person;
    }

    public PersonVO mockVO(Integer number) {
        PersonVO person = new PersonVO();
        person.setAddress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setLastName("Last Name Test" + number);
        person.setGender((number % 2 == 0) ? "Male" : "Female");
        person.setId(number.longValue());
        return person;
    }
}
