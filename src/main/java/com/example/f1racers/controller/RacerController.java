package com.example.f1racers.controller;

import com.example.f1racers.model.Racer;
import com.example.f1racers.service.RacerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/racers")
public class RacerController {
  private final RacerService racerService;

  public RacerController(RacerService racerService) {
    this.racerService = racerService;
  }

  @GetMapping
  public List<Racer> getAllRacers() {
    return racerService.getAllRacers();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Racer> getRacerById(@PathVariable Long id) {
    return racerService.getRacerById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Racer createRacer(@RequestBody Racer racer) {
    return racerService.createRacer(racer);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Racer> updateRacer(@PathVariable Long id, @RequestBody Racer racerDetails) {
    return ResponseEntity.ok(racerService.updateRacer(id, racerDetails));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRacer(@PathVariable Long id) {
    racerService.deleteRacer(id);
    return ResponseEntity.noContent().build();
  }
}
