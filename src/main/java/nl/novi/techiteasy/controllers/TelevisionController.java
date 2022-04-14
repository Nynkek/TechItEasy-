package nl.novi.techiteasy.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TelevisionController {
    /*
    De TelevisionsController bevat:
    [v] een GET-request voor alle televisies
    [v] een GET-request voor 1 televisie
    [v] een POST-request voor 1 televisie
    [v] een PUT-request voor 1 televisie
    [v] een DELETE-request voor 1 televisie
    */

    @GetMapping("/Televisies")
    public ResponseEntity<Object> getAllTelevisies(){
        return ResponseEntity.ok()
    }

    @GetMapping("/televisie/{id}")
    public ResponseEntity<Object> getTelevisie(@PathVariable long id){
        return ResponseEntity.ok()
    }

    @PostMapping("/televisie")
    public ResponseEntity<Object> addBook(@RequestBody String title) {
        return ResponseEntity.created()
    }

    @PutMapping("/televisie/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable int id, @RequestBody String title) {
        return ResponseEntity.noContent()
    }

    @DeleteMapping("/televisie/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable int id) {
        return ResponseEntity.noContent()
    }

}
