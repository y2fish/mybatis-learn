package com.baiyang.dao;

import com.baiyang.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询用户
    List<User> getUserList();
    //根据ID查询用户
    User getUserById(int id);
    //插入一个用户
    void insertUser(User user);
    //修改用户
    void updateUser(User user);
    //删除一个用户
    void deleteUser(int id);

}
