package bit.react.repository;

import bit.react.data.JoinDto;
import bit.react.data.UserEntity;
import bit.react.jwt.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDto dto){
        String username = dto.getUsername();

        UserEntity data = UserEntity.builder()
                .username(username)
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .role(dto.getRole())
                .address(dto.getAddress())
                .gaipday(Timestamp.valueOf(dto.getGaipday()))
                .build();

        userRepository.save(data);
    }

    public List<UserEntity> getAllMembers(){
        return userRepository.findAll();
    }

    public void deleteMember(int id){
        userRepository.deleteById(id);
    }

}
