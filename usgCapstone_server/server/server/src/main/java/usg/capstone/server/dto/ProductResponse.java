package usg.capstone.server.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private String id;
    private String name;
    private String price;
    private String category;
    private String imageData;
}
