package com.fyj.pms.mapper;

import com.fyj.pms.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * @author T2W
 * @version V1.0.0
 * @email tang.wangwang@qq.com
 * @date 2019-08-22 11:33
 * @username com.fyj.pms.mapper.UserMapper.java
 * @see describing
 */
@Mapper
public interface UserMapper {

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO `user`(username, birthday) VALUES(#{userName}, #{birthday})")
    int insert(User user);

    @Select("SELECT * FROM `user` WHERE id = #{id}")
    User select(Long id);

    @Update("UPDATE `user` SET username = #{userName}, birthday = #{birthday} WHERE id = #{id}")
    int update(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    int delete(Long id);

    int add(User user);

    User query(Long id);

    int modify(User user);

    int clean(Long id);

    @Select("SELECT * FROM `user` WHERE username = #{username} AND password = #{password}")
    User findByUsernameAndPassword(User user);
}
