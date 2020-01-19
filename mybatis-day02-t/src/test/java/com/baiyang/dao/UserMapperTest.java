package com.baiyang.dao;

import com.baiyang.pojo.User;
import com.baiyang.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

public class UserMapperTest {
    @Test
    public void getAllTest() throws IOException {
        SqlSession sqlSession = new MybatisUtil().getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        for (User user : mapper.getAll()) {
            System.out.println(user);
        }


    }
}
