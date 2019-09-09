package com.newtechcollege.cms.service.Impl;

import com.newtechcollege.cms.dao.UserMapper;
import com.newtechcollege.cms.entity.User;
import com.newtechcollege.cms.service.UserService;
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

    @Override
    public List<User> selectLikeName(String likename) {
        likename="%"+likename+"%";
        return userMapper.selectLikeName(likename);
    }

    @Override
    public Integer updateStatus(Integer status, Integer userid) {
        return userMapper.updateStatus(status,userid);
    }
}
