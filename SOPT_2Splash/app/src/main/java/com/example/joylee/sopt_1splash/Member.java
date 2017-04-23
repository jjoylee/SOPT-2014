package com.example.joylee.sopt_1splash;

import java.io.Serializable;

/**
 * Created by JoyLee on 2017-04-11.
 */

public class Member implements Serializable{
    private String id, password, name, major, part, sex, birthYear, birthMonth, birthDay;
    private int img;

    public void setId(String id){ this.id = id ; }
    public void setPassword(String password){ this.password = password ; }
    public void setName(String name){ this.name = name ; }
    public void setMajor(String major){ this.major = major ; }
    public void setPart(String part){ this.part = part ; }
    public void setSex(String sex){ this.sex = sex ; }
    public void setBirthYear(String birthYear){ this.birthYear = birthYear ; }
    public void setBirthMonth(String birthMonth){ this.birthMonth = birthMonth ; }
    public void setBirthDay(String birthDay){ this.birthDay = birthDay ; }
    public void setImg(int img){ this.img = img; }

    public String getSex() { return sex; }
    public String getPassword() { return password; }
    public String getPart() {  return part; }
    public String getName() { return name; }
    public String getMajor() { return major; }
    public String getId() { return id;  }
    public String getBirthDay() {  return birthDay; }
    public String getBirthMonth() { return birthMonth; }
    public String getBirthYear() { return birthYear; }
    public int getImg() { return img; }
}
