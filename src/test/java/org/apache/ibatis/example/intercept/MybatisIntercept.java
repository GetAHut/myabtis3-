package org.apache.ibatis.example.intercept;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * 自定义mybatis插件
 *  必须实现Interceptor接口
 *  Mybatis规定插件必须编写Annotation注解，是必须，而不是可选。
 *    @Intercepts注解: 装载一个@Signature列表；一个@Signature就是一个需要拦截的方法封装；若需要拦截多个方法，即需要多个@Signature
 *    @Signature： 如下注释解释： 就是去拦截Executor.class中的 query方法，args是参数
 *
 * @author : abby
 * @date : 2020/5/25 15:18
 */
@Intercepts(@Signature(type = Executor.class, method = "query", args = {MappedStatement.class,
  Object.class, RowBounds.class, ResultHandler.class}))
public class MybatisIntercept implements Interceptor {

  /**
   * 执行拦截内容逻辑，由plugin()触发
   * @param invocation
   * @return
   * @throws Throwable
   */
  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    System.out.println("-------MyIntercept--------");
    return invocation.proceed();
  }

  /**
   * 决定是否触发intercept()
   * @param target
   * @return
   */
  @Override
  public Object plugin(Object target) {
    //Plugin 是mybats插件的核心，给target创建jdk动态代理，并触发intercept()
    return Plugin.wrap(target, this);
  }

  /**
   * 给自定义的 插件获取配置文件中的配置信息
   * @param properties
   */
  @Override
  public void setProperties(Properties properties) {

  }
}
