package usg.capstone.server.service;

import org.springframework.http.ResponseEntity;
import usg.capstone.server.dto.LoginDTO;
import usg.capstone.server.dto.SignUpFormDTO;

public interface MemberService {
    ResponseEntity signup(SignUpFormDTO formDTO);
    ResponseEntity login(LoginDTO loginDTO);

}
