package bit.react.data;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class BoardDto {
    private int num;
    private String subject;
    private String content;
}
