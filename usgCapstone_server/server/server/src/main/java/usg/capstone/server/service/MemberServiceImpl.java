package usg.capstone.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import usg.capstone.server.domain.Member;
import usg.capstone.server.domain.MemberRole;
import usg.capstone.server.dto.LoginDTO;
import usg.capstone.server.dto.SignUpFormDTO;
import usg.capstone.server.repository.MemberRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public ResponseEntity signup(SignUpFormDTO formDTO) {

        Optional<Member> member = memberRepository.findById(formDTO.getId());

        if (member.isEmpty()) {
            Member newMember = Member.builder()
                    .id(formDTO.getId())
                    .password(formDTO.getPassword())
                    .name(formDTO.getName())
                    .role(MemberRole.USER)
                    .build();

            memberRepository.save(newMember);

            return new ResponseEntity("success", HttpStatus.OK);
        } else {
            return new ResponseEntity("fail", HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity login(LoginDTO loginDTO) {

        Optional<Member> member = memberRepository.findById(loginDTO.getId());
        //optional<member> 객체가 member를 가지고 있으면 그대로 없으면 null 반환
        Member memberEntity = member.orElse(null);

        if (memberEntity==null){
            return new ResponseEntity("해당 아이디를 가진 회원이 존재하지 않습니다.", HttpStatus.OK);
        }

        if (memberEntity.getPassword().equals(loginDTO.getPassword())){
            return new ResponseEntity("success", HttpStatus.OK);
        } else {
            return new ResponseEntity("비밀번호가 일치하지 않습니다.", HttpStatus.OK);
        }
    }
}

//단위테스트 완료
