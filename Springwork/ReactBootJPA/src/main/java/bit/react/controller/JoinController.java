package bit.react.controller;

import bit.react.data.JoinDto;
import bit.react.data.UserEntity;
import bit.react.repository.JoinService;
import bit.react.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class JoinController {
    private final JoinService joinService;
    private final UserRepository userRepository;


    @GetMapping("/member/idcheck")
    public String idCheck(@RequestParam("username") String username) {
        boolean isExists = userRepository.existsByUsername(username);
        if(isExists){
            System.out.println("db에 이미 존재합니다. 가입 불가능합니다.");
            return "fail";
        }else{
            return "success";
        }
    }

    @PostMapping("/member/join")
    public String joinProcess(@RequestBody JoinDto dto)
    {
        String username = dto.getUsername();


        joinService.joinProcess(dto);
        return "join ok!!";
    }

    @GetMapping("/auth/memberlist")
    public List<UserEntity> getMembers(){
        return joinService.getAllMembers();
    }

    @DeleteMapping("/member/delete")
    public void deleteMember(@RequestParam("id") int id){
        joinService.deleteMember(id);
    }




}
