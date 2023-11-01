package myapp.dbd_box.service.impl;

import myapp.dbd_box.dao.AddonDao;
import myapp.dbd_box.pojo.Addon;
import myapp.dbd_box.service.AddonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AddonServiceImpl implements AddonService {
    @Autowired
    private AddonDao addonDao;
    @Override
    public List<Addon> getAddonByKillerId(Integer addonId) {
        return addonDao.getAddonListByKillerId(addonId);
    }

    @Override
    public Addon getRandomKillerAddon(Integer addonId) {
        List<Addon> addonList = addonDao.getAddonListByKillerId(addonId);
        Random random = new Random();
        return addonList.get(random.nextInt(addonList.size()));
    }
}
