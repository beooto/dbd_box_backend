package myapp.dbd_box.controller;

import myapp.dbd_box.vo.SurvivorVO;
import myapp.dbd_box.pojo.Survivor;
import myapp.dbd_box.service.SurvivorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "SurvivorController", description = "Survivor 相关操作")
public class SurvivorController {
    @Autowired
    SurvivorService survivorService;

    @GetMapping("survivor")
    @ApiOperation("获取 Survivor 基础信息列表")
    public ResponseEntity<List<SurvivorVO>> getSurvivorVOList() {
        List<SurvivorVO> survivorVOList = survivorService.getSurvivorVOList();
        return ResponseEntity.ok(survivorVOList);
    }

    @GetMapping("survivor/{id}")
    @ApiOperation("通过 ID 获取具体 Survivor 对象")
    @ApiParam(name = "id", value = "Survivor 的 ID", required = true)
    public ResponseEntity<Survivor> getSurvivor(@PathVariable Integer id) {
        Survivor survivor = survivorService.getSurvivorById(id);
        if (survivor != null) {
            return ResponseEntity.ok(survivor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("survivor/search/{name}")
    @ApiOperation("通过名称和别名模糊搜索 SurvivorVO 对象并返回列表")
    @ApiParam(name = "name", value = "Survivor 的名称或别名", required = true)
    public ResponseEntity<List<SurvivorVO>> getSurvivorListByName(@PathVariable String name) {
        List<SurvivorVO> survivorVOList = survivorService.searchSurvivor(name);
        if (!survivorVOList.isEmpty()) {
            return ResponseEntity.ok(survivorVOList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("survivor/random")
    @ApiOperation("随机获取一个 Survivor")
    public ResponseEntity<SurvivorVO> getRandomSurvivorVO() {
        SurvivorVO survivorVO = survivorService.getRandomSurvivorVO();
        return ResponseEntity.ok(survivorVO);
    }
}
