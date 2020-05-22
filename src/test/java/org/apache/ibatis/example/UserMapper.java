package org.apache.ibatis.example;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

  public UserDao selectUserById(int id);
}
