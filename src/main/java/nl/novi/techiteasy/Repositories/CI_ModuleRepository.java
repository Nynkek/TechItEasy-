package nl.novi.techiteasy.Repositories;

import nl.novi.techiteasy.Models.CI_Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CI_ModuleRepository extends JpaRepository<CI_Module, Long> {

    List<CI_Module> findAllCI_ModulesByBrandEqualsIgnoreCase(String brand);
}

