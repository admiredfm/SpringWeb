package mybatispackage.dao;

import mybatispackage.pojo.MyClass;

import java.util.List;

public interface FindName {

    List<MyClass> findName(String sName,String tName,int start,int end);

    int findCount(String sname,String tname);
}
