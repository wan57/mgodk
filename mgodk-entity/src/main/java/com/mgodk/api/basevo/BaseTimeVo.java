package com.mgodk.api.basevo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @ClassName BaseTimeVo
 * @Description 公共部分属性之时间操作者记录
 * @Author WJJ
 * @Date 2020/09/07 15:38
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseTimeVo extends PageVo {
    private static final long serialVersionUID = -25L;

    /** 创建者 */
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    private Date createTime;

    /** 修改者 */
    private String updateBy;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    private Date updateTime;
}
