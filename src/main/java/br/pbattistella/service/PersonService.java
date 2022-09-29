package br.pbattistella.service;

import br.pbattistella.model.Person;

import java.util.List;

public interface PersonService {

    public List<Person> findAll();
    public Person findById(Long id);
    public Person create(Person person);
    public Person update(Long id, Person person);
    public void delete(Long id);
}
