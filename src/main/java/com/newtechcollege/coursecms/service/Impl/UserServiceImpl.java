package com.newtechcollege.coursecms.service.Impl;

import com.newtechcollege.coursecms.dao.UserMapper;
import com.newtechcollege.coursecms.entity.User;
import com.newtechcollege.coursecms.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * 
 * 用户业务逻辑实现类 
  * @return : null
 * @author wanglei
 * @date 2019/8/16 20:11
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Resource
    private UserMapper userMapper;
    
    @Override
    public List<User> selectUser() {
        return userMapper.selectUser();
    }

    @Override
    public List<User> selectUserWechat() {
        return userMapper.selectUserWechat();
    }
}
