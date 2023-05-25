package com.medicalservices.medical.controller;

import com.medicalservices.medical.entity.Cart;
import com.medicalservices.medical.entity.Medicine;
import com.medicalservices.medical.repository.MedicalRepository;
import com.medicalservices.medical.sevice.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class medicalController {
    @Autowired
    MedicalRepository medicalRepository;
   @Autowired
   MedicalService medicalService;

    @PostMapping("/api/medicine")
    public ResponseEntity<Medicine> saveMedicines(@RequestBody Medicine medicine){
       return new ResponseEntity<>(medicalRepository.save(medicine), HttpStatus.CREATED);
    }
    @PutMapping("/api/addmedicinetocart")
    public ResponseEntity<String> addMedToCart(@RequestBody Cart cart)
    {
        return new ResponseEntity<>(medicalService.addmedicinetocart(cart),HttpStatus.OK);
    }

}
