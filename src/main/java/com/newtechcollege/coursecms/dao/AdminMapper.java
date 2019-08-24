package com.newtechcollege.coursecms.dao;

import com.newtechcollege.coursecms.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    Admin selectAdminLogin(String username,String password);
    List<Admin> selectAll();
    String selectPassword(Long id);
    Integer updatePassword(String pwd,Long id);
    Integer deleteAdmin(Integer id);
    Integer insertAdmin(Admin admin);
    String selectScope(Long id);
}
