package nl.novi.techiteasy.controllers;


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
    public TelevisionController(TelevisionService televisionService){
        this.televisionService = televisionService;
    }


    @GetMapping("/televisie")
    public ResponseEntity<List<Television>> getAllTelevisies(@RequestParam(value = "brand", required = false) String brand){

        List<Television> televisions;

        if (brand == null){

            televisions = televisionService.getAllTelevisions();

            return ResponseEntity.ok().body(televisions);

        } else {

            televisions = televisionService.getAllTelevisionsByBrand(brand);
        }

        return ResponseEntity.ok().body(televisions);
    }

//    @GetMapping("/televisie/{id}")
//    public ResponseEntity<Object> getTelevisie(@PathVariable Long id){
//        return ResponseEntity.ok();
//    }
//
//    @PostMapping("/televisie")
//    public ResponseEntity<Object> addBook(@RequestBody String title) {
//        return ResponseEntity.created();
//    }
//
//    @PutMapping("/televisie/{id}")
//    public ResponseEntity<Object> updateBook(@PathVariable int id, @RequestBody String title) {
//        return ResponseEntity.noContent();
//    }
//
//    @DeleteMapping("/televisie/{id}")
//    public ResponseEntity<Object> deleteBook(@PathVariable int id) {
//        return ResponseEntity.noContent()
//    }

}
