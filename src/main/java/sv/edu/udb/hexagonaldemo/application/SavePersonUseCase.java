package sv.edu.udb.hexagonaldemo.application;

import sv.edu.udb.hexagonaldemo.domain.Person;

import java.util.List;
import java.util.Optional;

public interface SavePersonUseCase {
    void save(Person person);

    /**
     * Busca una persona por su ID.
     */
    Optional<Person> findById(String id);
    List<Person> findAll();
    void update(String id, Person person);
    void delete(String id);
}