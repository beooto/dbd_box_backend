package myapp.dbd_box.service.impl;

import myapp.dbd_box.dao.OfferingDao;
import myapp.dbd_box.pojo.Offering;
import myapp.dbd_box.service.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferingServiceImpl implements OfferingService {
    @Autowired
    OfferingDao offeringDao;
    @Override
    public Offering getOfferingById(Integer Id) {
        Offering offering = offeringDao.getOfferingById(Id);
        return offering;
    }

    @Override
    public List<Offering> getOfferingListByClass(String class_name) {
        List<Offering> offeringList = offeringDao.getOfferingListByClass(class_name);
        return offeringList;
    }

    @Override
    public List<Offering> getOfferingListByBelong(Integer Id) {
        List<Offering> offeringList = offeringDao.getOfferingListByBelong(Id);
        return offeringList;
    }

}
