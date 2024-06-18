package usg.capstone.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usg.capstone.server.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
