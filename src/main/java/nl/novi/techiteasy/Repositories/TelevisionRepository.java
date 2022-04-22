package nl.novi.techiteasy.Repositories;

import nl.novi.techiteasy.Models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television, Long> {

    List<Television> findAllTelevisionsByBrandEqualsIgnoreCase(String brand);
}
