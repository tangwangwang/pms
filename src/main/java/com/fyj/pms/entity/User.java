package com.fyj.pms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author T2W
 * @version V1.0.0
 * @email tang.wangwang@qq.com
 * @date 2019-08-22 11:35
 * @name com.fyj.pms.entity.User.java
 * @see describing 用户表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {

    /** 主键ID */
    private Long id;
    /** 用户名 */
    private String username;
    /** 密码(默认使用MD5加密) */
    private String password;
    /** 使用AES加密, 可将该字段作为cookie存储 */
    private String aesPassword;
    /** 电话号码 */
    private Integer phone;
    /** 邮箱地址 */
    private String email;
    /** 真实姓名 */
    private String realName;
    /** 昵称 */
    private String nickName;
    /** 生日 */
    private Date birthday;
    /** 年龄 */
    private Integer age;
    /** 性别 */
    private Integer gender;
    /** 头像路径 */
    private String headSculptureUrl;
    /** QQ */
    private String qq;
    /** 微信 */
    private String wechat;
    /** 注册时间 */
    private Date registerTime;

}
