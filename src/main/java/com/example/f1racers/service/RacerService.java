package com.example.f1racers.service;

import com.example.f1racers.model.Racer;
import com.example.f1racers.repository.RacerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RacerService {

  private final RacerRepository racerRepository;

  @Autowired
  public RacerService(RacerRepository racerRepository) {
    this.racerRepository = racerRepository;
  }

  public List<Racer> getAllRacers() {
    return racerRepository.findAll();
  }

  public Optional<Racer> getRacerById(Long id) {
    return racerRepository.findById(id);
  }

  public Racer createRacer(Racer racer) {
    return racerRepository.save(racer);
  }

  public Racer updateRacer(Long id, Racer racerDetails) {
    Racer racer = racerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Racer not found for id: " + id));

    racer.setName(racerDetails.getName());
    racer.setAge(racerDetails.getAge());
    racer.setTeam(racerDetails.getTeam());
    racer.setWins(racerDetails.getWins());
    racer.setLosses(racerDetails.getLosses());

    return racerRepository.save(racer);
  }

  public void deleteRacer(Long id) {
    racerRepository.deleteById(id);
  }


}
