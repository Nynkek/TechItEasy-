package nl.novi.techiteasy.Service;

import nl.novi.techiteasy.Dtos.*;
import nl.novi.techiteasy.Dtos.RemoteDto;
import nl.novi.techiteasy.Models.Remote;
import nl.novi.techiteasy.Models.Remote;
import nl.novi.techiteasy.Repositories.RemoteRepository;
import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemoteService {

    private final RemoteRepository remoteRepository;

    @Autowired
    public RemoteService(RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public List<RemoteDto> getAllRemotes(){
        List<RemoteDto> remoteDtos = new ArrayList<>();
        List<Remote> remotes = remoteRepository.findAll();
        for (Remote remote : remotes){
            remoteDtos.add(fromRemote(remote));
        }
        return remoteDtos;
    }

    public List<RemoteDto> getAllRemotesByBrand(String brand){
        List<RemoteDto> remoteDtos = new ArrayList<>();
        List<Remote> remotes = remoteRepository.findAllRemotesByBrandEqualsIgnoreCase(brand);
        for (Remote remote : remotes){
            remoteDtos.add(fromRemote(remote));
        }
        return remoteDtos;
    }

    public RemoteDto getRemoteById(Remote id){
        Remote remoteFound = remoteRepository.getById(id.getId());
        if (remoteFound == null){
            throw new RecordNotFoundException("cannot find television" + id);
        }
        return fromRemote(remoteFound);
    }

    public RemoteDto addRemote(RemoteInputDto remoteInputDto){
        Remote remote = toRemote(remoteInputDto);
        remoteRepository.save(remote);
        return fromRemote(remote);
    }

    public String deleteRemote(Remote id) {
        remoteRepository.deleteById(id.getId());
        return "product removed !!" + id;
    }

    public RemoteDto updateRemote (RemoteInputDto remoteInputDto, Remote id){
        Remote existingRemote = remoteRepository.findById(id.getId()).orElse(null);
        assert existingRemote != null;
        existingRemote.setOriginalStock(remoteInputDto.getOriginalStock());
        existingRemote.setPrice(remoteInputDto.getPrice());
        remoteRepository.save(existingRemote);
        return fromRemote(existingRemote);
    }

    public static RemoteDto fromRemote(Remote remote){
        var dto = new RemoteDto();
        dto.setId(remote.getId());
        dto.setCompatibleWith(remote.getCompatibleWith());
        dto.setBatteryType(remote.getBatteryType());
        dto.setName(remote.getName());
        dto.setBrand(remote.getBrand());
        dto.setPrice(remote.getPrice());
        dto.setOriginalStock(remote.getOriginalStock());
        return dto;
    }

    public static Remote toRemote(RemoteInputDto dto){
        var remote = new Remote();
        remote.setId(dto.getId());
        remote.setCompatibleWith(dto.getCompatibleWith());
        remote.setBatteryType(dto.getBatteryType());
        remote.setName(dto.getName());
        remote.setBrand(dto.getBrand());
        remote.setPrice(dto.getPrice());
        remote.setOriginalStock(dto.getOriginalStock());
        return remote;
    }
}
