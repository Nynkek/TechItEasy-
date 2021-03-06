package nl.novi.techiteasy.Service;

import nl.novi.techiteasy.Dtos.*;
import nl.novi.techiteasy.Models.CI_Module;
import nl.novi.techiteasy.Models.Remote;
import nl.novi.techiteasy.Models.Television;
import nl.novi.techiteasy.Models.WallBracket;
import nl.novi.techiteasy.Repositories.CI_ModuleRepository;
import nl.novi.techiteasy.Repositories.RemoteRepository;
import nl.novi.techiteasy.Repositories.TelevisionRepository;
import nl.novi.techiteasy.Repositories.WallBracketRepository;
import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final RemoteRepository remoteRepository;
    private final CI_ModuleRepository ci_moduleRepository;
    private final WallBracketRepository wallBracketRepository;

    @Autowired
    public TelevisionService(TelevisionRepository televisionRepository,
                             RemoteRepository remoteRepository,
                             CI_ModuleRepository ci_moduleRepository,
                             WallBracketRepository wallBracketRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteRepository = remoteRepository;
        this.ci_moduleRepository = ci_moduleRepository;
        this.wallBracketRepository = wallBracketRepository;
    }

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
        List<Television> televisions = televisionRepository.findAllTelevisionsByBrandEqualsIgnoreCase(brand);
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
        Television existingTelevision = televisionRepository.findById(id.getId()).orElse(null);
        assert existingTelevision != null;

        existingTelevision.setOriginalStock(televisionInputDto.getOriginalStock());
        existingTelevision.setPrice(televisionInputDto.getPrice());
        existingTelevision.setSold(televisionInputDto.getSold());

        televisionRepository.save(existingTelevision);
        return fromTelevision(existingTelevision);
    }


    public TelevisionDto televisionWhitCI_Modules(Long televisionId, Long ci_moduleId) {
        CI_Module ci_module = ci_moduleRepository.getById(ci_moduleId);
        Television television = televisionRepository.getById(televisionId);

        ci_module.televisionCISet(television);

        televisionRepository.save(television);
        return fromTelevision(television);
    }


    public TelevisionDto televisionWithWallBracket(Long televisionId, Long wallBracketId) {
        Optional<Television> optionalTelevision = Optional.of(televisionRepository.getById(televisionId));
        Optional<WallBracket> optionalWallBracket = Optional.of(wallBracketRepository.getById(wallBracketId));

        Television television;
        if (optionalTelevision.isEmpty() || optionalWallBracket.isEmpty()) {
            throw new RecordNotFoundException();
        } else {

            television = optionalTelevision.get();
            WallBracket wallBracket = optionalWallBracket.get();

            television.tvWallSet(wallBracket);
            televisionRepository.save(television);
        }
        return fromTelevision(television);
    }


    public TelevisionDto assignRemoteToTelevision(Long remoteId, Long televisionId) {
        Optional<Remote> optionalRemote = remoteRepository.findById(remoteId);
        Optional<Television> optionalTelevision = televisionRepository.findById(televisionId);

        Television television;
        if (optionalTelevision.isEmpty() || optionalRemote.isEmpty()) {
            throw new RecordNotFoundException();
        } else {

            Remote remote = optionalRemote.get();
            television = optionalTelevision.get();

            television.setRemote(remote);
            televisionRepository.save(television);
        }
        return fromTelevision(television);
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

        dto.setCi_modules(television.getCi_modules());
        dto.setWallBracketTelevisionSet(television.getWallBracketTelevisionSet());
        dto.setRemote(television.getRemote());

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
