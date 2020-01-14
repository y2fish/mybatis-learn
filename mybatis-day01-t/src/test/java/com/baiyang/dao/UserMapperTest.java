package com.baiyang.dao;

import com.baiyang.pojo.User;
import com.baiyang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    public static void main(String[] args) {
//        第一步：获取Sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        第二步：执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
    sqlSession.close();
    }
//根据ID查询用户
    @Test
    public void getUserById(){
        //        第一步：获取Sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //        第二步：执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }

//    插入一个用户insertUser,增删改需要手动提交事物
    @Test
    public void insertUser(){
        //        第一步：获取Sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //        第二步：执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insertUser(new User(4,"baiyang3","54321"));
        sqlSession.commit();//手动提交事务
        sqlSession.close();

    }
    //修改用户updateUser
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(1,"bai","0000"));
        sqlSession.commit();
        sqlSession.close();
    }
    //删除一个用户deleteUser
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }
}
