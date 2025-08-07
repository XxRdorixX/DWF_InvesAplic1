package sv.edu.udb.hexagonaldemo.adapter.in.out;


import org.springframework.stereotype.Component;
import sv.edu.udb.hexagonaldemo.application.SavePersonUseCase;
import sv.edu.udb.hexagonaldemo.domain.Person;

import java.util.List;
import java.util.Optional;

@Component
public class PersonRepositoryAdapter implements SavePersonUseCase {

    private final PersonRepositoryJpa repository;

    public PersonRepositoryAdapter(PersonRepositoryJpa repository) {
        this.repository = repository;
    }

    @Override
    public void save(Person person) {
        repository.save(person);
    }

    @Override
    public Optional<Person> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(String id, Person person) {
        repository.findById(id).ifPresent(existing -> {
            // Solo actualiza los campos enviados
            if (person.getName() != null) {
                existing.setName(person.getName());
            }
            repository.save(existing);
        });
    }

    @Override
    public void delete(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
