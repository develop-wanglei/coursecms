package com.newtechcollege.coursecms.dao;

import com.newtechcollege.coursecms.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 用户dao接口 
  * @return : null
 * @author wanglei
 * @date 2019/8/16 19:55
 */
@Mapper
public interface UserMapper {

    List<User> selectUser();
    List<User> selectUserWechat();
    List<User> selectLikeName(String likename);
    Integer updateStatus(Integer status,Integer userid);
}
