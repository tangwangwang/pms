package com.fyj.pms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author T2W
 * @version V1.0.0
 * @email tang.wangwang@qq.com
 * @date 2019-09-09 17:18
 * @name com.fyj.pms.entity.UserLog.java
 * @see describing 用户日志表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserLog {

    /** 自增主键 */
    private Long id;
    /** 用户ID */
    private Long userId;
    /** 操作类型 */
    private Integer type;
    /** 操作信息 */
    private String info;
    /** 操作详情 */
    private String detail;
    /** 操作时间 */
    private Date operateTime;

}
