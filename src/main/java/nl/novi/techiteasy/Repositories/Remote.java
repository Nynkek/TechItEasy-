package nl.novi.techiteasy.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Remote extends JpaRepository<Remote, Long> {

    List<Remote> findAllRemotesByBrandEqualsIgnoreCase(String brand);
}
