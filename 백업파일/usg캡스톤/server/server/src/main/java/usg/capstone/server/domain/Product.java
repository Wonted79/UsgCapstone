package usg.capstone.server.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Entity
@Builder
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @Column(name = "product_id", length = 20, nullable=false)
    private String id;

    @Column(name = "product_name", nullable = false)
    private String name;


    @Column(name = "product_price", nullable = false)
    private String price;

    @Column(name = "product_category", nullable = false)
    private String category;

    @Lob
    @Column(name = "product_img", length = 1000)
    private byte[] imageData;


}