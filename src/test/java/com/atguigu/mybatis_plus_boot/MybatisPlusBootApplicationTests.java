package com.atguigu.mybatis_plus_boot;

import com.atguigu.mybatis_plus_boot.entity.User;
import com.atguigu.mybatis_plus_boot.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusBootApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        System.out.println(("----- selectAll method test ------"));
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
