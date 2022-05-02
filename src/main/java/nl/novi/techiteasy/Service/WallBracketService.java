package nl.novi.techiteasy.Service;

import nl.novi.techiteasy.Dtos.*;
import nl.novi.techiteasy.Dtos.WallBracketDto;
import nl.novi.techiteasy.Models.WallBracket;
import nl.novi.techiteasy.Repositories.WallBracketRepository;
import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WallBracketService {

    private final WallBracketRepository wallBracketRepository;

    @Autowired
    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }

    public List<WallBracketDto> getAllWallBrackets() {
        List<WallBracketDto> wallBracketDtos = new ArrayList<>();
        List<WallBracket> wallBrackets = wallBracketRepository.findAll();
        for (WallBracket wallBracket : wallBrackets) {
            wallBracketDtos.add(fromWallBracket(wallBracket));
        }
        return wallBracketDtos;

    }

    public List<WallBracketDto> getAllTelevisionsByBrand(String brand) {
        List<WallBracketDto> wallBracketDtos = new ArrayList<>();
        List<WallBracket> wallBracket = wallBracketRepository.findAll();
        for (WallBracket wallBrackets : wallBracket) {
            wallBracketDtos.add(fromWallBracket(wallBrackets));
        }
        return wallBracketDtos;
    }

    public WallBracketDto getTelevisionById(WallBracket id) {
        WallBracket wallBracketFound = wallBracketRepository.getById(id.getId());
        if (wallBracketFound == null) {
            throw new RecordNotFoundException("cannot find wallBracket" + id);
        }
        return fromWallBracket(wallBracketFound);
    }

    public WallBracketDto addWallBracket(WallBracketInputDto wallBracketInputDto) {
        WallBracket wallBracket = toWallBracket(wallBracketInputDto);
        wallBracketRepository.save(wallBracket);
        return fromWallBracket(wallBracket);
    }

    public String deleteWallBracket(WallBracket id) {
        wallBracketRepository.deleteById(id.getId());
        return "product removed !!" + id;
    }

    public WallBracketDto updateWallBracket(WallBracketInputDto wallBracketInputDto, WallBracket id) {
        WallBracket existingWallBracket = wallBracketRepository.findById(wallBracketInputDto.getId()).orElse(null);
        assert existingWallBracket != null;
        existingWallBracket.setPrice(wallBracketInputDto.getPrice());
        wallBracketRepository.save(existingWallBracket);
        return fromWallBracket(existingWallBracket);
    }

    public static WallBracketDto fromWallBracket(WallBracket wallBracket) {
        var dto = new WallBracketDto();
        dto.setId(wallBracket.getId());
        dto.setSize(wallBracket.getSize());
        dto.setAjustable(wallBracket.getAjustable());
        dto.setName(wallBracket.getName());
        dto.setPrice(wallBracket.getPrice());
        return dto;
    }

    public static WallBracket toWallBracket(WallBracketInputDto dto) {
        var wallBracket = new WallBracket();

        wallBracket.setId(dto.getId());
        wallBracket.setSize(dto.getSize());
        wallBracket.setAjustable(dto.getAjustable());
        wallBracket.setName(dto.getName());
        wallBracket.setPrice(dto.getPrice());
        return wallBracket;
    }
}


