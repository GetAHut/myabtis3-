package org.apache.ibatis.example;

public class UserDao {
  private int id;
  private String username;
  private int sex;
  private String phone;



  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getSex() {
    return sex;
  }

  public void setSex(int sex) {
    this.sex = sex;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "UserMapper{" +
      "id=" + id +
      ", userNmae='" + username + '\'' +
      ", sex=" + sex +
      ", phone='" + phone + '\'' +
      '}';
  }
}
