package com.cinemaservices.cinema.controller;


import com.cinemaservices.cinema.entity.Cinema;
import com.cinemaservices.cinema.repository.CinemaRepository;
import com.cinemaservices.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ComponentScan
@RequestMapping("/cinema")

public class CinemaController {
    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    CinemaService cinemaService;
    @PostMapping("/api/cinema")
    public ResponseEntity<Cinema> saveCinemas(@RequestBody Cinema cinema){
        return new ResponseEntity<>(cinemaRepository.save(cinema), HttpStatus.CREATED);
    }

}
