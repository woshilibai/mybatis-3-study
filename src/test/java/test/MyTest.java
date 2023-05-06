package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import test.pojo.User;

import java.io.InputStream;
import java.util.List;

/**
 * @Description: todo
 * @Author tianwl
 * @Company 安徽中科美络信息技术有限公司
 * @Email tianwl@izkml.com
 * @Date 2023/5/6 9:48
 */
public class MyTest {

  @Test
  public void test() throws Exception{
    InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    //  1、初始化了executor，并设置了transaction，用于后续的sql执行
    SqlSession sqlSession = sessionFactory.openSession();

    User user = new User();
    user.setUsername("twl");
    user.setAge(10);
    List<User> users = sqlSession.selectList("user.selectAll", user);
    for (User user1 : users) {
      System.out.println(user1);
    }
  }

}
