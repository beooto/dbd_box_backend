package myapp.dbd_box.service;

import myapp.dbd_box.vo.KillerVO;
import myapp.dbd_box.pojo.Killer;

import java.util.List;

public interface KillerService {
    List<KillerVO> getKillerVOList();
    Killer getKillerById(Integer id);
    List<KillerVO> searchKiller(String name);
    KillerVO getRandomKillerVO();
}
