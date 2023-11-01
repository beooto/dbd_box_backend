package myapp.dbd_box.service;

import myapp.dbd_box.pojo.Survivor;
import myapp.dbd_box.vo.SurvivorVO;

import java.util.List;

public interface SurvivorService {
    List<SurvivorVO> getSurvivorVOList();
    Survivor getSurvivorById(Integer SurvivorId);
    List<SurvivorVO> searchSurvivor(String SurvivorName);
    SurvivorVO getRandomSurvivorVO();
}
