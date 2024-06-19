package usg.capstone.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Entity
@Builder
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cody{

    @Id
    @Column(name = "cody_id", length = 20, nullable=false)
    private int id;

    @Column(name = "cody_name", nullable = false)
    private String name;

    @Lob
    @Column(name = "cody_img", length = 1000)
    private byte[] imageData;


}