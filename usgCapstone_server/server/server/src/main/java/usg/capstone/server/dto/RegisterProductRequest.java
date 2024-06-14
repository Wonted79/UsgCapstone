package usg.capstone.server.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class RegisterProductRequest {
    private ProductDTO productDTO;
    private MultipartFile productImage;
}
