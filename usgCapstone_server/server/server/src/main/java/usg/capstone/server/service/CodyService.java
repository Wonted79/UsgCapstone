package usg.capstone.server.service;

import usg.capstone.server.domain.Cody;
import usg.capstone.server.dto.CodyDTO;
import usg.capstone.server.dto.CodyResponse;

import java.util.List;

public interface CodyService {
    void createCody(CodyDTO codyDTO);

    List<CodyResponse> findAllByName(String name);
}
