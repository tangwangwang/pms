package com.fyj.pms;

import com.fyj.pms.entity.User;
import com.fyj.pms.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.Date;

/**
 * @author T2W
 * @version V1.0.0
 * @email tang.wangwang@qq.com
 * @date 2019-08-22 10:56
 * @name com.fyj.pms.SpringTests.java
 * @see describing
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(locations = {"classpath:spring/spring.xml", "classpath:spring/spring-*.xml"})
public class SpringTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testConnection() {
        System.out.println(dataSource);
    }

    @Test
    public void testMybatis() {
        // User user = new User().setUsername("张三").setBirthday(new Date());
        // 测试注解
        // int insert = userMapper.insert(user);
        // System.out.println(user);
        // User select = userMapper.select(1L);
        // System.out.println(select);
        // select.setName("李四");
        // int update = userMapper.update(select);
        // System.out.println(update);
        // System.out.println(query);
        // int delete = userMapper.delete(1L);
        // System.out.println(delete);
        // 测试配置文件
        // int add = userMapper.add(user);
        // System.out.println(user);
        // User query = userMapper.query(1L);
        // System.out.println(query);
        // query.setName("李四");
        // userMapper.modify(query);
        // int clean = userMapper.clean(1L);
        // System.out.println(clean);
    }
}
