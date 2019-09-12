package com.fyj.pms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author T2W
 * @version V1.0.0
 * @email tang.wangwang@qq.com
 * @date 2019-09-09 17:27
 * @name com.fyj.pms.entity.Dict.java
 * @see describing 字典表(只做解释作用，不于任何表相连)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Dict {

    /** 字典ID, 自增主键 */
    private Long id;
    /** 表名 */
    private String tableName;
    /** 列名 */
    private String columnName;
    /** 字典描述 */
    private String desc;

}
