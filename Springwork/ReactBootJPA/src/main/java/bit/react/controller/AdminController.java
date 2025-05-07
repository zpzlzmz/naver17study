package bit.react.controller;

import bit.react.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminController {
    private final JwtUtil jwtUtil;

    @GetMapping("/admin")
    public String admin(HttpServletRequest request) {
        //header.로 부터 authorization 를 얻는다
        String auth = request.getHeader("Authorization");
        //bearer
        String token = auth.substring(7);
        //token 만 있으면 username 정보와 role 정보를 얻을 수 있다
        String username= jwtUtil.getUsername(token);
        String role = jwtUtil.getRole(token);

        return "admin OK ! username="+username+" role="+role;
    }
}
