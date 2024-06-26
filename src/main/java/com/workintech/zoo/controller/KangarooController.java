package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workintech/kangaroos")
public class KangarooController {

  private Map<Long, Kangaroo> kangaroos;


  @PostConstruct
    public void init() {
    kangaroos = new HashMap<>();
  }


  @GetMapping
    public Map<Long,Kangaroo> getAllKangaroos() {
    return kangaroos;
  }

    @GetMapping("/{id}")
        public Kangaroo getKangarooById(Long id) {
        return kangaroos.get(id);
    }//TODO maybe add a check for null here

    @PostMapping
    public Kangaroo addKangaroo(@RequestBody Kangaroo kangaroo) {
        kangaroos.put(kangaroo.getId(), kangaroo);
        return kangaroo;
    }
    @DeleteMapping("/{id}")
    public void deleteKangaroo(@PathVariable Long id) {
        kangaroos.remove(id);
    }//TODO maybe add a check for null here
}

