package com.example.st1drawermenu.LoginPackageSpring;


import java.util.List;

public interface IPerson {

    long curtime();
    long loginperson(String id, String pw);
    List<ModelPerson> selectparam(String name);
    List<ModelPerson> selectmodel(ModelPerson person);
    List<ModelPerson> selectjson(ModelPerson person);
    List<ModelPerson> selectmap(ModelPerson searchvalue, String orderby);
    List<ModelPerson> selectpaging(int start, int end);
    boolean insertparam(String name);
    boolean insertmodel(ModelPerson person);
    boolean insertjsonobject(ModelPerson person);
    boolean insertjsonarray(List<ModelPerson> person);

}