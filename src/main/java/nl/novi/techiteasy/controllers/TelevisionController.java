package nl.novi.techiteasy.controllers;


import nl.novi.techiteasy.Dtos.TelevisionDto;
import nl.novi.techiteasy.Dtos.TelevisionInputDto;
import nl.novi.techiteasy.Models.Television;
import nl.novi.techiteasy.Service.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TelevisionController {

    private final TelevisionService televisionService;

    @Autowired
    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }


    @GetMapping("/televisie")
    public ResponseEntity<List<TelevisionDto>> getAllTelevisies(@RequestParam(value = "brand", required = false) String brand) {
        List<TelevisionDto> televisions;
        if (brand == null) {
            televisions = televisionService.getAllTelevisions();
            return ResponseEntity.ok().body(televisions);
        } else {
            televisions = televisionService.getAllTelevisionsByBrand(brand);
        }
        return ResponseEntity.ok().body(televisions);

    }

    @GetMapping("/televisie/{id}")
    public TelevisionDto findTelevisionByName(@PathVariable Television id) {
        return televisionService.getTelevisionById(id);

    }

    @PostMapping("/add/televisie")
    public TelevisionDto addTelevisie(@RequestBody TelevisionInputDto televisionInputDto) {
        return televisionService.addTelevision(televisionInputDto);
    }

    @PutMapping("/update/{id}")
    public TelevisionDto updateTelevision(@RequestBody TelevisionInputDto televisionInputDto, @PathVariable Television id) {
            return televisionService.updateTelevision(televisionInputDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTelevision(@PathVariable Television id) {
        return televisionService.deleteTelevision(id);
    }
}
