package cn.i7baozh.cloud.provider.controller;

import cn.i7baozh.cloud.api.bean.DeptBean;
import cn.i7baozh.cloud.provider.controller.resp.DeptResp;
import cn.i7baozh.cloud.provider.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/view/{id}")
    public DeptResp getById(@PathVariable Long id) {
        DeptBean deptBean = deptService.getById(id);

        return new DeptResp.DeptRespConverter().convert(deptBean);
    }

    @GetMapping("/update")
    public DeptResp getById( Long id,String name) {
        DeptBean deptBean = deptService.updateById(id,name);

        return new DeptResp.DeptRespConverter().convert(deptBean);
    }

    @GetMapping("/delete/{id}")
    public Integer deleteById(@PathVariable Long id) {
        return deptService.deleteById(id);
    }
}
