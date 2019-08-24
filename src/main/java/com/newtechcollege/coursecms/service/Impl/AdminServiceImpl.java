package com.newtechcollege.coursecms.service.Impl;

import com.newtechcollege.coursecms.dao.AdminMapper;
import com.newtechcollege.coursecms.entity.Admin;
import com.newtechcollege.coursecms.service.AdminService;
import com.newtechcollege.coursecms.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;
    @Resource
    private MD5Util md5Util;

    @Override
    public Admin selectAdminLogin(String username, String password) {
        return adminMapper.selectAdminLogin(username,md5Util.getMD5(password));
    }

    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }

    @Override
    public Boolean selectPassword(Long id,String password) {
        String s = adminMapper.selectPassword(id);
        String md5 = md5Util.getMD5(password);
        if (md5.equals(s)){
            return false;
        }else {
            return true;
        }

    }

    @Override
    public Integer updatePassword(String pwd, Long id) {
        return adminMapper.updatePassword(md5Util.getMD5(pwd),id);
    }

    @Override
    public Integer deleteAdmin( Integer id) {
        return adminMapper.deleteAdmin(id);
    }

    @Override
    public Integer insertAdmin(Admin admin) {
        return adminMapper.insertAdmin(admin);
    }

    @Override
    public String selectScope(Long id) {
        return adminMapper.selectScope(id);
    }
}
