package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import jakarta.annotation.PostConstruct;
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
    public Koala getKoalaById(Long id) {
        return koalas.get(id);
    }//TODO maybe add a check for null here

    @PostMapping
    public Koala addKoala(@RequestBody Koala koala) {
        koalas.put(koala.getId(), koala);
        return koala;
    }

    @PutMapping
    public Koala updateKoala(@RequestBody Koala koala) {
        koalas.put(koala.getId(), koala);
        return koala;
    }//TODO maybe add a check for null here

    @DeleteMapping("/{id}")
    public void deleteKoala(@PathVariable Long id) {
        koalas.remove(id);
    }//TODO maybe add a check for null here

}
