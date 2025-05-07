package bit.react.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "jpajoin")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   @Column(length = 30)
    private String username;

   @Column(length = 100)
    private String password;

    private String address;

   @Column(length = 20)
    private String role;

   @CreationTimestamp
   @Column(updatable = false)
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="Asia/Seoul")
    private Timestamp gaipday;
}
