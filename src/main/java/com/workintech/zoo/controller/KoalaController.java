package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workintech/koalas")
public class KoalaController {

    private Map<Long, Koala> koalas;

    @PostConstruct
    public void init() {
        koalas = new HashMap<>();
    }

    @GetMapping
    public Map<Long, Koala> getAllKoalas() {
        return koalas;
    }

    @GetMapping("/{id}")
    public Koala getKoalaById(@PathVariable Long id) {
        Koala koala = koalas.get(id);
        if (koala == null) {
            throw new ZooException("Koala not found", HttpStatus.NOT_FOUND);
        }
        return koala;
    }

    @PostMapping
    public Koala addKoala(@RequestBody Koala koala) {
        koalas.put(koala.getId(), koala);
        return koala;
    }

    @PutMapping("/{id}")
    public Koala updateKoala(@PathVariable Long id, @RequestBody Koala koala) {
        if (!koalas.containsKey(id)) {
            throw new ZooException("Koala not found", HttpStatus.NOT_FOUND);
        }
        koalas.put(id, koala);
        return koala;
    }

    @DeleteMapping("/{id}")
    public void deleteKoala(@PathVariable Long id) {
        if (!koalas.containsKey(id)) {
            throw new ZooException("Koala not found", HttpStatus.NOT_FOUND);
        }
        koalas.remove(id);
    }

}
