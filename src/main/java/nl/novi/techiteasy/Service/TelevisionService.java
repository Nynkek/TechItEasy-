package nl.novi.techiteasy.Service;

import nl.novi.techiteasy.Models.Television;
import nl.novi.techiteasy.Repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    @Autowired
    public TelevisionService(TelevisionRepository televisionRepository){
        this.televisionRepository = televisionRepository;
    }

    public List<Television> getAllTelevisions(){
        return televisionRepository.findAll();
    }

    public List<Television> getAllTelevisionsByBrand(String brand){
        return televisionRepository.findAllTelevisionsByBrandEqualsIgnoreCase(brand);
    }
}
