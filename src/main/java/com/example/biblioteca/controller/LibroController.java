package com.example.biblioteca.controller;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.obtenerTodos();
    }

    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro) {
        return libroService.guardar(libro);
    }

    @GetMapping("/buscar")
    public List<Libro> buscarLibro(@RequestParam String titulo) {
        return libroService.buscarPorTitulo(titulo);
    }
}
