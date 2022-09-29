package br.pbattistella.service;

import br.pbattistella.model.Person;
import br.pbattistella.exceptions.ResourceNotFoundException;
import br.pbattistella.repository.PersonRepository;
import br.pbattistella.util.NumberConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(Long id, Person person) {

        Person savedPerson = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        savedPerson.setFirstName(person.getFirstName());
        savedPerson.setLastName(person.getLastName());
        savedPerson.setAddress(person.getAddress());
        savedPerson.setGender(person.getGender());

        return personRepository.save(savedPerson);
    }

    @Override
    public void delete(Long id) {

        Person deletedPerson = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        personRepository.delete(deletedPerson);
    }

}
