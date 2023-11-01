package myapp.dbd_box.controller;

import myapp.dbd_box.pojo.Addon;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import myapp.dbd_box.service.AddonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Api(tags = "AddonController", description = "Addon 相关操作")
public class AddonController {
    @Autowired
    private AddonService addonService;

    @GetMapping("addon/killer_id={id}")
    @ApiOperation("获取某个 killer 的所有 addon")
    @ApiParam(name = "id", value = "Killer 的 ID", required = true)
    public ResponseEntity<List<Addon>> addon(@PathVariable Integer id) {
        List<Addon> addons = addonService.getAddonByKillerId(id);
        return ResponseEntity.ok(addons);
    }

    @GetMapping("addon/random/killer_id={id}")
    @ApiOperation("获取某个 killer 的随机一个 addon")
    @ApiParam(name = "id", value = "Killer 的 ID", required = true)
    public ResponseEntity<Addon> randomAddon(@PathVariable Integer id) {
        Addon addon = addonService.getRandomKillerAddon(id);
        return ResponseEntity.ok(addon);
    }
}
