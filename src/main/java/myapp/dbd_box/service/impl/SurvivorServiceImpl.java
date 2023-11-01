package myapp.dbd_box.service.impl;

import myapp.dbd_box.dao.SurvivorDao;
import myapp.dbd_box.vo.SurvivorVO;
import myapp.dbd_box.pojo.Survivor;
import myapp.dbd_box.service.SurvivorService;
import myapp.dbd_box.util.AboutObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class SurvivorServiceImpl implements SurvivorService {
    @Autowired
    private SurvivorDao SurvivorDao;
    @Autowired
    private AboutObject aboutObject;

    @Override
    public List<SurvivorVO> getSurvivorVOList() {
        List<Survivor> SurvivorList = SurvivorDao.getSurvivorList();
        List<SurvivorVO> SurvivorVOList = aboutObject.SurvivorTOVO(SurvivorList);
        return SurvivorVOList;
    }
    @Override
    public Survivor getSurvivorById(Integer id) {
        return SurvivorDao.getSurvivorById(id);
    }
    @Override
    public List<SurvivorVO> searchSurvivor(String name){
        List<Survivor> SurvivorList = SurvivorDao.getSurvivorListByName(name);
        List<SurvivorVO> SurvivorVOList = aboutObject.SurvivorTOVO(SurvivorList);
        return SurvivorVOList;
    }
    @Override
    public SurvivorVO getRandomSurvivorVO() {
        List<Survivor> SurvivorList = SurvivorDao.getSurvivorList();
        List<SurvivorVO> SurvivorVOList = aboutObject.SurvivorTOVO(SurvivorList);
        Random random = new Random();
        return SurvivorVOList.get(random.nextInt(SurvivorVOList.size()));
    }

}
