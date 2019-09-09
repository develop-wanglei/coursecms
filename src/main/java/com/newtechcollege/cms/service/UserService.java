package com.newtechcollege.cms.service;

import com.newtechcollege.cms.entity.User;

import java.util.List;
/**
 * 
 * 用户业务逻辑接口 
  * @return : null
 * @author wanglei
 * @date 2019/8/16 20:12
 */
public interface UserService {
    List<User> selectUser();
    List<User> selectUserWechat();
    List<User> selectLikeName(String likename);
    Integer updateStatus(Integer status,Integer userid);
}
