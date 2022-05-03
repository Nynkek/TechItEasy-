package nl.novi.techiteasy.Repositories;

import nl.novi.techiteasy.Models.WallBracket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WallBracketRepository extends JpaRepository<WallBracket, Long> {

    List<WallBracket> findAllWallBracketsByNameEqualsIgnoreCase(String name);

}


