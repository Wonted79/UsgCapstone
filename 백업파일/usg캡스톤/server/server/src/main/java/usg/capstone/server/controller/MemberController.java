package usg.capstone.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usg.capstone.server.dto.LoginDTO;
import usg.capstone.server.dto.SignUpFormDTO;
import usg.capstone.server.service.MemberService;

@RestController
@RequestMapping("/member")
 //final이 선언된 모든 필드를 인자값으로 하는 생성자 생성
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/hello")
    public String TestCRUD() {
        return "hello";
    }

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody SignUpFormDTO formDTO){
        System.out.println(formDTO);
        return memberService.signup(formDTO);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO){
        return memberService.login(loginDTO);
    }

}
