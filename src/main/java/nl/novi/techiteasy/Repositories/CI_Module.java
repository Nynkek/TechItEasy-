package nl.novi.techiteasy.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CI_Module extends JpaRepository<CI_Module, Long> {

    List<CI_Module> findAllCI_ModulesByBrandEqualsIgnoreCase(String brand);
}
