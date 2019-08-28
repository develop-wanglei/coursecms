package com.newtechcollege.coursecms.service;

import com.newtechcollege.coursecms.entity.Admin;

import java.util.List;

public interface AdminService {
    Admin selectAdminLogin(String username, String password);
    List<Admin> selectAll();
    Boolean selectPassword(Long id,String password);
    Integer updatePassword(String pwd,Long id);
    Integer deleteAdmin(Integer id);
    Integer insertAdmin(Admin admin);
    String selectScope(Long id);
}
