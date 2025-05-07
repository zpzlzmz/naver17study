package bit.react.repository;

import bit.react.data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    //username이 존재하는지 true/false
    Boolean existsByUsername(String username);
    //해당 username 정보를 userEntity 타입으로 반환(DTO반환 이라고 생각하면 됨)
    UserEntity findByUsername(String username);
}
