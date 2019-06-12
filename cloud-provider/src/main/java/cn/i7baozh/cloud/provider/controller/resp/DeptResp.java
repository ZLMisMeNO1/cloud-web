package cn.i7baozh.cloud.provider.controller.resp;

import cn.i7baozh.cloud.api.bean.DeptBean;
import com.google.common.base.Converter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class DeptResp implements Serializable {

    private Long deptId;

    private String deptName;

    public static class DeptRespConverter extends Converter< DeptBean,DeptResp> {

        @Override
        protected DeptBean doBackward(DeptResp deptResp) {
            if (deptResp == null) {
                return null;
            }
            return new DeptBean()
                    .setId(deptResp.getDeptId())
                    .setDeptName(deptResp.getDeptName());
        }

        @Override
        protected DeptResp doForward(DeptBean deptBean) {
            if (deptBean == null) {
                return null;
            }
            return new DeptResp()
                    .setDeptId(deptBean.getId())
                    .setDeptName(deptBean.getDeptName());
        }
    }
}
