package usg.capstone.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usg.capstone.server.domain.ImageData;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<ImageData, Long> {

    Optional<ImageData> findByName(String fileName);
}