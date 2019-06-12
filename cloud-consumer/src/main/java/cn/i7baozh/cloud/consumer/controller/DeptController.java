package cn.i7baozh.cloud.consumer.controller;

import cn.i7baozh.cloud.api.bean.DeptBean;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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

    private static final String baseUrl = "http://localhost:8001/provider/dept";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/view/{id}")
    public DeptBean getById(@PathVariable Long id) {

        DeptBean deptBean =  restTemplate.getForObject(baseUrl + "/view/" + id,DeptBean.class);
        return deptBean;
    }

    @GetMapping("/update")
    public DeptBean update( Long id ,String name) {
        Map<String, Object> param = new HashMap<>();
        param.put("id",id );
        param.put("name",name );
        DeptBean updateBean = new DeptBean().setId(id).setDeptName(name);
        String s = JSONObject.toJSONString(updateBean);
        ResponseEntity<DeptBean> deptBeanResponseEntity = restTemplate.postForEntity(baseUrl + "/update", param, DeptBean.class);
        return deptBeanResponseEntity.getBody();
    }
}
