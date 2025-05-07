package bit.react.repository;

import bit.react.data.UserEntity;
import bit.react.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String login(String username, String password) {
        UserEntity user = userRepository.findByUsername(username);
        if (user==null) {
            System.out.println("user not found");
            return null;
        }
        //암호화된 password 를 디코딩 한 값과 password가 다를경우
        if(!passwordEncoder.matches(password, user.getPassword())) {
            System.out.println("비밀번호가 맞지 않습니다");
            return null;
        }
        String accessToken= jwtUtil.createAccessToken(user);
        return accessToken;
    }


}
