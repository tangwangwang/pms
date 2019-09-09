package com.fyj.pms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author T2W
 * @version V1.0.0
 * @email tang.wangwang@qq.com
 * @date 2019-09-09 17:35
 * @name com.fyj.pms.entity.DictItem.java
 * @see describing 字典详情表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DictItem {

    /** 字典详情ID */
    private Long id;
    /** 字典ID */
    private Long dictId;
    /** 状态 */
    private String status;
    /** 状态描述 */
    private String desc;

}
