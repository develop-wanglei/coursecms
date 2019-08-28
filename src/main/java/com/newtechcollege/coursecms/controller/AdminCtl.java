package com.newtechcollege.coursecms.controller;

import com.alibaba.fastjson.JSONObject;
import com.newtechcollege.coursecms.entity.Admin;
import com.newtechcollege.coursecms.myexception.MyException;
import com.newtechcollege.coursecms.service.AdminService;
import com.newtechcollege.coursecms.util.Jwt;
import com.newtechcollege.coursecms.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 管理员控制层
  * @return : null
 * @author wanglei
 * @date 2019/8/24 10:49
 */
@RestController
@CrossOrigin(origins = "*")
@Validated
@RequestMapping(value = "/admin")
public class AdminCtl {

    @Autowired
    private AdminService adminService;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@NotBlank(message = "username不能为空") String username, @NotBlank(message = "password不能为空") String password){
        Admin admin = adminService.selectAdminLogin(username, password);
        if (admin==null){
            throw new MyException("未查到数据");
        }
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("adminname",username);
        String token = Jwt.getToken(map, false, "linke", 7200);
        redisUtil.set(admin.getUsername(),token,7200);
        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("data",admin);
        json.put("token",token);
        return json.toString();
    }

    /**
     * 查询所有管理员
     * @return
     */
    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public List<Admin> select(){
        List<Admin> admins = adminService.selectAll();
        if (admins.size()<1){
            throw new MyException("未查到数据");
        }
        return admins;
    }

    /**
     * 修改密码
     * @param id
     * @param password
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Integer update(@NotEmpty(message = "id不能为空") Long id,@NotBlank(message = "password不能为空") String password){
        Integer integer = adminService.updatePassword(password, id);
        if (integer<1){
            throw new MyException("修改失败");
        }
        return integer;

    }

    /**
     * 是否为超级管理员
     * @param id
     * @return
     */
    @RequestMapping(value = "/scope",method = RequestMethod.POST)
    public Boolean scope(@NotEmpty(message = "id不能为空") Long id){
        String username = adminService.selectScope(id);
        if (username.isEmpty()){
            throw new MyException("不是超级管理员");
        }
        return true;
    }


    /**
     * 删除管理员
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Integer delete(@NotEmpty(message = "id不能为空") Integer id){
        Integer integer = adminService.deleteAdmin(id);
        if (integer <1){
            throw new MyException("删除失败");
        }
        return integer;
    }

    /**
     * 添加管理员账户
     * @param admin
     * @return
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Integer insert(@Valid Admin admin){
        Integer integer = adminService.insertAdmin(admin);
        if (integer<1){
            throw new MyException("添加失败");
        }
        return integer;
    }

    /**
     * 根据id查询密码
     * @param id
     * @param password
     * @return
     */
    @RequestMapping(value = "selectPassword",method = RequestMethod.POST)
    public Boolean pwd(@NotEmpty(message = "id不能为空") Long id,@NotBlank(message = "password不能为空") String password){
        Boolean b = adminService.selectPassword(id, password);
        if (b){
            throw new MyException("密码不一致");
        }
        return true;
    }

}
