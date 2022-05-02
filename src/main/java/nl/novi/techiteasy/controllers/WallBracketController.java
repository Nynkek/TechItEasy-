package nl.novi.techiteasy.controllers;

import nl.novi.techiteasy.Dtos.WallBracketDto;
import nl.novi.techiteasy.Dtos.WallBracketInputDto;
import nl.novi.techiteasy.Models.WallBracket;
import nl.novi.techiteasy.Service.WallBracketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WallBracketController {

    public final WallBracketService wallBracketService;

    @Autowired
    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

    @GetMapping("/wallBracket")
    public ResponseEntity<List<WallBracketDto>> getAllWallBracket(@RequestParam(value = "brand", required = false) String brand) {
        List<WallBracketDto> wallBracket;
        if (brand == null) {
            wallBracket = wallBracketService.getAllWallBrackets();
            return ResponseEntity.ok().body(wallBracket);
        } else {
            wallBracket = wallBracketService.getAllWallBracketsByBrand(brand);
        }
        return ResponseEntity.ok().body(wallBracket);
    }

    @GetMapping("/wallBracket/{id}")
    public WallBracketDto findWallBracketByName(@PathVariable WallBracket id) {
        return wallBracketService.getWallBracketById(id);
    }

    @PostMapping("/add/wallBracket")
    public WallBracketDto addWallBracket(@RequestBody WallBracketInputDto wallBracketInputDto) {
        return wallBracketService.addWallBracket(wallBracketInputDto);
    }

    @PutMapping("/update/wallBracket/{id}")
    public WallBracketDto updateWallBracket(@RequestBody WallBracketInputDto wallBracketInputDto, @PathVariable WallBracket id) {
        return wallBracketService.updateWallBracket(wallBracketInputDto, id);
    }

    @DeleteMapping("/delete/wallBracket/{id}")
    public String deleteWallBracket(@PathVariable WallBracket id) {
        return wallBracketService.deleteWallBracket(id);
    }
}


