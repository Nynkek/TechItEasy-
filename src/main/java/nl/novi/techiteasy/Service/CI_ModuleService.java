package nl.novi.techiteasy.Service;

import nl.novi.techiteasy.Dtos.CI_ModuleDto;
import nl.novi.techiteasy.Dtos.CI_ModuleInputDto;
import nl.novi.techiteasy.Models.CI_Module;
import nl.novi.techiteasy.Repositories.CI_ModuleRepository;
import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CI_ModuleService {

    public final CI_ModuleRepository ci_moduleRepository;

    @Autowired
    public CI_ModuleService(CI_ModuleRepository ci_moduleRepository) {
        this.ci_moduleRepository = ci_moduleRepository;
    }

    public List<CI_ModuleDto> getAllCI_Modules() {
        List<CI_ModuleDto> ci_moduleDtos = new ArrayList<>();
        List<CI_Module> ci_modules = ci_moduleRepository.findAll();
        for (CI_Module ci_module : ci_modules) {
            ci_moduleDtos.add(fromCI_Module(ci_module));
        }
        return ci_moduleDtos;
    }

    public List<CI_ModuleDto> getAllCI_ModulesByBrand(String name) {
        List<CI_ModuleDto> ci_moduleDtos = new ArrayList<>();
        List<CI_Module> ci_modules = ci_moduleRepository.findAllCI_ModulesByNameEqualsIgnoreCase(name);
        for (CI_Module ci_module : ci_modules) {
            ci_moduleDtos.add(fromCI_Module(ci_module));
        }
        return ci_moduleDtos;
    }

    public CI_ModuleDto getCI_ModuleById(CI_Module id) {
        CI_Module ci_moduleFound = ci_moduleRepository.getById(id.getId());
        if (ci_moduleFound == null) {
            throw new RecordNotFoundException("cannot find television" + id);
        }
        return fromCI_Module(ci_moduleFound);
    }

    public CI_ModuleDto addCI_Module(CI_ModuleInputDto ci_moduleInputDto) {
        CI_Module ci_module = toCI_Module(ci_moduleInputDto);
        ci_moduleRepository.save(ci_module);
        return fromCI_Module(ci_module);
    }

    public String deleteCI_Module(CI_Module id) {
        ci_moduleRepository.deleteById(id.getId());
        return "product removed !!" + id;
    }

    public CI_ModuleDto updateCI_Module(CI_ModuleInputDto CI_ModuleInputDto, CI_Module id) {
        CI_Module existingCI_Module = ci_moduleRepository.findById(CI_ModuleInputDto.getId()).orElse(null);
        assert existingCI_Module != null;
        existingCI_Module.setPrice(CI_ModuleInputDto.getPrice());
        ci_moduleRepository.save(existingCI_Module);
        return fromCI_Module(existingCI_Module);
    }

    public static CI_ModuleDto fromCI_Module(CI_Module ci_module) {
        var dto = new CI_ModuleDto();
        dto.setId(ci_module.getId());
        dto.setName(ci_module.getName());
        dto.setType(ci_module.getType());
        dto.setPrice(ci_module.getPrice());
        return dto;
    }

    public static CI_Module toCI_Module(CI_ModuleInputDto dto) {
        var ci_module = new CI_Module();
        ci_module.setId(dto.getId());
        ci_module.setName(dto.getName());
        ci_module.setType(dto.getType());
        ci_module.setPrice(dto.getPrice());
        return ci_module;
    }
}
