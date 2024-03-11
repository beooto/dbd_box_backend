package myapp.dbd_box.service;

import myapp.dbd_box.pojo.Offering;

import java.util.List;

public interface OfferingService {
    Offering getOfferingById(Integer Id);
    List<Offering> getOfferingListByClass(String class_name);
    List<Offering> getOfferingListByBelong(Integer Id);
}
