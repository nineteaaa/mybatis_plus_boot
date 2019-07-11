package com.atguigu.mybatis_plus_boot;

import com.atguigu.mybatis_plus_boot.entity.User;
import com.atguigu.mybatis_plus_boot.mapper.UserMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CRUDtests {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("张三");
        user.setAge(18);
        user.setEmail("zhangsan@qq.com");
        int i = userMapper.insert(user);
        System.out.println(i); //影响的行数
        System.out.println(user);//id自动会填
    }

    @Test
    public void testUpdateById(){
        User user = userMapper.selectById(6L);
        user.setAge(20);
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    @Test
    public void testOptimisticLocker() {
        //查询
        User user = userMapper.selectById(6L);
        //修改数据
        user.setAge(36);
        user.setName(("李四"));

        userMapper.updateById(user);
    }

    @Test
    public void testOptimisticLockerFail(){
        //查询
        User user1 = userMapper.selectById(5L);

        //修改数据
        user1.setAge(23);
        user1.setName("老王");



        User user2 = userMapper.selectById(5L);
        user2.setName("老韩");
        user2.setAge(19);
        userMapper.updateById(user2);

        userMapper.updateById(user1);
    }

    @Test
    public void testSelectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectByMap(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","老韩");
        map.put("age",19);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);

    }

    /*@Test
    public void testSelectPage(){
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
        System.out.println(page.getSize());
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getTotal());
    }
*/
    @Test
    public void testSelectPage() {

        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    public void testDeleteById(){
        int i = userMapper.deleteById(7L);
        System.out.println(i);
    }

    @Test
    public void testDeleteBatchIds(){
        int i = userMapper.deleteBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(i);
    }

    @Test
    public void testDeleteByMap(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","李四");
        map.put("age",20);
        int i = userMapper.deleteByMap(map);
        System.out.println(i);
    }

    @Test
    public void testSelectMapsPage(){
        Page<User> page = new Page<>(1, 4);
        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(page, null);

        //
        mapIPage.getRecords().forEach(System.out::println);
        System.out.println(page);
    }

    @Test
    public void testLogicDelete(){

        int i = userMapper.deleteById(2L);
        System.out.println(i);
    }

    @Test
    public void testLogicDeleteSelect(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testPerformance(){
        User user = new User();
        user.setName("我是老王");
        user.setAge(18);
        user.setEmail("laowang@qq.com");
        userMapper.insert(user);
    }
}
