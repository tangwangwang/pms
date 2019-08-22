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
 * @date 2019-08-22 11:35
 * @name com.fyj.pms.entity.User.java
 * @see describing
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {

    private Long id;

    private String username;

    private String password;

    private Date birthday;
}
