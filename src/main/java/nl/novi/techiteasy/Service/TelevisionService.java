package nl.novi.techiteasy.Service;


import nl.novi.techiteasy.Dtos.RemoteDto;
import nl.novi.techiteasy.Dtos.RemoteInputDto;
import nl.novi.techiteasy.Dtos.TelevisionDto;
import nl.novi.techiteasy.Dtos.TelevisionInputDto;
import nl.novi.techiteasy.Models.Television;
import nl.novi.techiteasy.Repositories.RemoteRepository;
import nl.novi.techiteasy.Repositories.TelevisionRepository;
import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final RemoteRepository remoteRepository;

    @Autowired
    public TelevisionService(TelevisionRepository televisionRepository, RemoteRepository remoteRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteRepository = remoteRepository;
    }







//    public TelevisionDto assignRemoteToTelevision(TelevisionInputDto televisionInputDto, Television id){
//        Television existingTelevision = televisionRepository.findById(televisionInputDto.getId()).orElse(null);
//        assert existingTelevision != null;
//        existingTelevision.setRemote(televisionInputDto.getRemote());
//
//        televisionRepository.save(existingTelevision);
//        return fromTelevision(existingTelevision);
//    }










    public List<TelevisionDto> getAllTelevisions() {
        List<TelevisionDto> televisionDtos = new ArrayList<>();
        List<Television> televisions = televisionRepository.findAll();
        for (Television television : televisions) {
            televisionDtos.add(fromTelevision(television));
        }
        return televisionDtos;
    }

    public List<TelevisionDto> getAllTelevisionsByBrand(String brand) {
        List<TelevisionDto> televisionDtos = new ArrayList<>();
        List<Television> televisions = televisionRepository.findAll();
        for (Television television : televisions) {
            televisionDtos.add(fromTelevision(television));
        }
        return televisionDtos;
    }

    public TelevisionDto getTelevisionById(Television id) {
        Television televisionFound = televisionRepository.getById(id.getId());
        if (televisionFound == null) {
            throw new RecordNotFoundException("cannot find television" + id);
        }
        return fromTelevision(televisionFound);
    }

    public TelevisionDto addTelevision(TelevisionInputDto televisionInputDto) {
        Television television = toTelevision(televisionInputDto);
        televisionRepository.save(television);
        return fromTelevision(television);
    }

    public String deleteTelevision(Television id) {
        televisionRepository.deleteById(id.getId());
        return "product removed !!" + id;
    }

    public TelevisionDto updateTelevision(TelevisionInputDto televisionInputDto, Television id) {
        Television existingTelevision = televisionRepository.findById(televisionInputDto.getId()).orElse(null);
        assert existingTelevision != null;
        existingTelevision.setOriginalStock(televisionInputDto.getOriginalStock());
        existingTelevision.setPrice(televisionInputDto.getPrice());
        existingTelevision.setSold(televisionInputDto.getSold());
        televisionRepository.save(existingTelevision);
        return fromTelevision(existingTelevision);
    }

    public static TelevisionDto fromTelevision(Television television) {
        var dto = new TelevisionDto();

        dto.setId(television.getId());
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getSmartTv());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());
        return dto;
    }

    public static Television toTelevision(TelevisionInputDto dto) {
        var television = new Television();
        television.setId(dto.getId());
        television.setBrand(dto.getBrand());
        television.setType(dto.getType());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbiLight(dto.getAmbiLight());
        television.setOriginalStock(dto.getOriginalStock());
        television.setSold(dto.getSold());
        return television;
    }
}
