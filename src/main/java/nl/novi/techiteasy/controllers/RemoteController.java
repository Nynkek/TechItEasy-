package nl.novi.techiteasy.controllers;


import nl.novi.techiteasy.Dtos.RemoteDto;
import nl.novi.techiteasy.Dtos.RemoteInputDto;
import nl.novi.techiteasy.Models.Remote;
import nl.novi.techiteasy.Service.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RemoteController {

    private final RemoteService remoteService;

    @Autowired
    public RemoteController(RemoteService remoteService) {
        this.remoteService = remoteService;
    }

    @GetMapping("/remote")
    public ResponseEntity<List<RemoteDto>> getAllRemotes(@RequestParam(value = "brand", required = false) String brand) {
        List<RemoteDto> remotes;
        if (brand == null) {
            remotes = remoteService.getAllRemotes();
            return ResponseEntity.ok().body(remotes);
        } else {
            remotes = remoteService.getAllRemotesByBrand(brand);
        }
        return ResponseEntity.ok().body(remotes);
    }

    @GetMapping("/remote/{id}")
    public RemoteDto findRemoteByName(@PathVariable Remote id) {
        return remoteService.getRemoteById(id);
    }

    @PostMapping("/add/remote")
    public RemoteDto addRemote(@RequestBody RemoteInputDto remoteInputDto) {
        return remoteService.addRemote(remoteInputDto);
    }

    @PutMapping("/update/remote/{id}")
    public RemoteDto updateRemote(@RequestBody RemoteInputDto remoteInputDto, @PathVariable Remote id) {
        return remoteService.updateRemote(remoteInputDto, id);
    }

    @DeleteMapping("/delete/remote/{id}")
    public String deleteRemote(@PathVariable Remote id) {
        return remoteService.deleteRemote(id);
    }
}




