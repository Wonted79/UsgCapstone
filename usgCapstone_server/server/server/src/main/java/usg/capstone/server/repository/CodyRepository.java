package usg.capstone.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usg.capstone.server.domain.Cody;
import usg.capstone.server.domain.Member;
import usg.capstone.server.domain.Product;

import java.util.List;

public interface CodyRepository extends JpaRepository<Cody, String> {
    List<Cody> findByName(String name);

}
