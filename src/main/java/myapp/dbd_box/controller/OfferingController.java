package myapp.dbd_box.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import myapp.dbd_box.pojo.Killer;
import myapp.dbd_box.pojo.Offering;
import myapp.dbd_box.service.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "OfferingController", description = "offering 相关操作")
public class OfferingController {
    @Autowired OfferingService offeringService;
    @GetMapping("offering/{id}")
    @ApiOperation("通过 ID 获取具体 offering 对象")
    @ApiParam(name = "id", value = "Killer 的 ID", required = true)
    public ResponseEntity<Offering> getOfferingById(@PathVariable Integer id) {
        Offering offering = offeringService.getOfferingById(id);
        if (offering != null) {
            return ResponseEntity.ok(offering);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("offering/{class_name}")
    public ResponseEntity<List<Offering>> getOfferingByClass(@PathVariable String name){
        List<Offering> offeringList = offeringService.getOfferingListByClass(name);
        if (offeringList != null){
            return ResponseEntity.ok(offeringList);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("offering/belong/{id}")
    public ResponseEntity<List<Offering>> getOfferingByBelong(@PathVariable Integer id){
        List<Offering> offeringList = offeringService.getOfferingListByBelong(id);
        if (offeringList != null){
            return ResponseEntity.ok(offeringList);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
