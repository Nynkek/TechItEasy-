package nl.novi.techiteasy.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WallBracket extends JpaRepository<WallBracket, Long> {

    List<WallBracket> findAllWallBracketsByBrandEqualsIgnoreCase(String brand);

}
