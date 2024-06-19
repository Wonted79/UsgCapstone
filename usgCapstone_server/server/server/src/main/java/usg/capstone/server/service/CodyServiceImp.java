package usg.capstone.server.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import usg.capstone.server.domain.Cody;
import usg.capstone.server.domain.Product;
import usg.capstone.server.dto.*;
import usg.capstone.server.repository.CodyRepository;
import usg.capstone.server.repository.MemberRepository;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CodyServiceImp implements  CodyService{

    private final CodyRepository codyRepository;
    public void createCody(CodyDTO codyDTO){
        Cody newCody = null;
        try {
            newCody = Cody.builder()
                    .id(codyDTO.getId())
                    .name(codyDTO.getName())
                    .imageData(codyDTO.getCodyImage().getBytes())
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        codyRepository.save(newCody);

    }

    public List<CodyResponse> findAllByName(String codyName) {
        List<Cody> codys = codyRepository.findByName(codyName);
        return codys.stream().map(cody -> {
            CodyResponse codyResponse = new CodyResponse();
            codyResponse.setId(cody.getId());
            codyResponse.setName(cody.getName());
            codyResponse.setCodyImage(Base64.getEncoder().encodeToString(cody.getImageData()));
            return codyResponse;
        }).collect(Collectors.toList());
    }
}
