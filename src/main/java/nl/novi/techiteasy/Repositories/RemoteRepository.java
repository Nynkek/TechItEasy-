package nl.novi.techiteasy.Repositories;

import nl.novi.techiteasy.Models.Remote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RemoteRepository extends JpaRepository<Remote, Long> {

    List<Remote> findAllRemotesByBrandEqualsIgnoreCase(String brand);
}
