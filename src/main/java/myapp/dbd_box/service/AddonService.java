package myapp.dbd_box.service;

import myapp.dbd_box.pojo.Addon;

import java.util.List;

public interface AddonService {
    List<Addon> getAddonByKillerId(Integer addonId);
    Addon getRandomKillerAddon(Integer addonId);
}
