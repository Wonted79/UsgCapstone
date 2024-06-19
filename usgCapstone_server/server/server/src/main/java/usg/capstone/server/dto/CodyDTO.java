package usg.capstone.server.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class CodyDTO {
    private int id;
    private String name;
    private MultipartFile codyImage;
}
