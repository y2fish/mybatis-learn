import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws Exception {
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try  {
            SqlSession session = sqlSessionFactory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> users = mapper.getAll();
            for (User user: users){
                System.out.println(user);
            }

            User user = new User();
            user.setId(2);
            user.setName("baixue1");
            user.setPwd("121212");

            mapper.insertUser(user);
            session.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}