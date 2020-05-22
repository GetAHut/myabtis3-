package org.apache.ibatis.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test {
  private static String source = "mybatis-config.xml";

  public static void main(String[] args) throws IOException {
    //加载mybatis-config文件
    InputStream inputStream = Resources.getResourceAsStream(source);
    //构建SqlSession工厂
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    //打开SqlSession
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    UserDao userDao = mapper.selectUserById(1);
    System.out.println(userDao);
  }
}
