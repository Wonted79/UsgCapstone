package usg.capstone.server.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class CodyResponse {
    private int id;
    private String name;
    private String codyImage;
}
