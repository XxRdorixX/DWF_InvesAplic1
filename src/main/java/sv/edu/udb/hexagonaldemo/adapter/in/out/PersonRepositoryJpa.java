package sv.edu.udb.hexagonaldemo.adapter.in.out;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.hexagonaldemo.domain.Person;

public interface PersonRepositoryJpa extends JpaRepository<Person, String> {
}
