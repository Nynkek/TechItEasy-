package nl.novi.techiteasy.controllers;

import nl.novi.techiteasy.Dtos.CI_ModuleDto;
import nl.novi.techiteasy.Dtos.CI_ModuleInputDto;
import nl.novi.techiteasy.Models.CI_Module;
import nl.novi.techiteasy.Service.CI_ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CI_ModuleController {

    private final CI_ModuleService ci_moduleService;

    @Autowired
    public CI_ModuleController(CI_ModuleService ci_moduleService) {
        this.ci_moduleService = ci_moduleService;
    }

    @GetMapping("/ci_module")
    public ResponseEntity<List<CI_ModuleDto>> getAllCI_Module(@RequestParam(value = "brand", required = false) String brand) {
        List<CI_ModuleDto> ci_modules;

        if (brand == null) {
            ci_modules = ci_moduleService.getAllCI_Modules();
            return ResponseEntity.ok().body(ci_modules);
        } else {
            ci_modules = ci_moduleService.getAllCI_ModulesByBrand(brand);
        }
        return ResponseEntity.ok().body(ci_modules);
    }

    @GetMapping("/ci_module/{name}")
    public CI_ModuleDto findCI_ModuleByName(@PathVariable CI_Module id) {
        return ci_moduleService.getCI_ModuleById(id);
    }

    @PostMapping("/add/ci_module")
    public CI_ModuleDto addCI_Module(@RequestBody CI_ModuleInputDto ci_moduleInputDto) {
        return ci_moduleService.addCI_Module(ci_moduleInputDto);
    }

    @PutMapping("/update/ci_module/{id}")
    public CI_ModuleDto updateCI_Module(@RequestBody CI_ModuleInputDto ci_moduleInputDto, @PathVariable CI_Module id) {
        return ci_moduleService.updateCI_Module(ci_moduleInputDto, id);
    }

    @DeleteMapping("/delete/ci_module/{id}")
    public String deleteCI_Module(@PathVariable CI_Module id) {
        return ci_moduleService.deleteCI_Module(id);
    }
}

