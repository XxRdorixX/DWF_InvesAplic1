package sv.edu.udb.hexagonaldemo.adapter.in.out;


import org.springframework.web.bind.annotation.*;
import sv.edu.udb.hexagonaldemo.application.SavePersonUseCase;
import sv.edu.udb.hexagonaldemo.domain.Person;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final SavePersonUseCase savePerson;

    public PersonController(SavePersonUseCase savePerson) {
        this.savePerson = savePerson;
    }

    @PostMapping
    public String create(@RequestBody Person person) {
        savePerson.save(person);
        return "Persona guardada con éxito en H2";

    }

    // Listar todas las personas
    @GetMapping
    public List<Person> getAll() {
        return savePerson.findAll();
    }

    // Buscar persona por ID
    @GetMapping("/{id}")
    public Optional<Person> getById(@PathVariable String id) {
        return savePerson.findById(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable String id, @RequestBody Person person) {
        if (savePerson.findById(id).isPresent()) {
            savePerson.update(id, person);
            return "Persona actualizada con éxito";
        } else {
            return "No se encontró la persona con ID " + id;
        }
    }

    // Eliminar persona
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        savePerson.delete(id);
        return "Persona eliminada con éxito";
    }
}

