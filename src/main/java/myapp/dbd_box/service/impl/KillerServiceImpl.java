package myapp.dbd_box.service.impl;

import myapp.dbd_box.dao.KillerDao;
import myapp.dbd_box.vo.KillerVO;
import myapp.dbd_box.pojo.Killer;
import myapp.dbd_box.service.KillerService;
import myapp.dbd_box.util.AboutObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class KillerServiceImpl implements KillerService {
    @Autowired
    private KillerDao killerDao;
    @Autowired
    private AboutObject aboutObject;
    @Override
    public List<KillerVO> getKillerVOList() {
        List<Killer> killerList = killerDao.getKillerList();
        List<KillerVO> killerVOList = aboutObject.KillerTOVO(killerList);
        return killerVOList;
    }
    @Override
    public Killer getKillerById(Integer killerId) {
        return killerDao.getKillerById(killerId);
    }
    @Override
    public List<KillerVO> searchKiller(String killerName){
        List<Killer> killerList = killerDao.getKillerListByName(killerName);
        List<KillerVO> killerVOList = aboutObject.KillerTOVO(killerList);
        return killerVOList;
    }
    @Override
    public KillerVO getRandomKillerVO() {
        List<KillerVO> killerVOList = this.getKillerVOList();
        Random random = new Random(); // 不传递种子值
        return killerVOList.get(random.nextInt(killerVOList.size()));
    }

}
