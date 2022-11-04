package br.pbattistella.service;

import br.pbattistella.data.vo.v1.PersonVO;
import br.pbattistella.data.vo.v2.PersonVOV2;

import java.util.List;

public interface PersonService {

    public List<PersonVO> findAll();
    public PersonVO findById(Long id);
    public PersonVO create(PersonVO person);
    public PersonVOV2 createV2(PersonVOV2 person);
    public PersonVO update(Long id, PersonVO person);
    public void delete(Long id);

}
