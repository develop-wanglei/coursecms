package com.newtechcollege.cms.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.newtechcollege.cms.annotation.validate.PostiveInt;
import com.newtechcollege.cms.entity.Col;
import com.newtechcollege.cms.myexception.MyException;
import com.newtechcollege.cms.service.Impl.ColServiceImpl;
import com.newtechcollege.cms.util.RestfulUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@CrossOrigin(origins = "*")
@RequestMapping(value = "/col")
public class ColCtl {

   
    @Autowired
    private ColServiceImpl colService;
    /**
     * 实训基地列表
     * @return []
     */
    @RequestMapping(value = "/list")
    public String list() {
        List<Map<String, Object>> map =  colService.list();
        if(map == null){
            throw new MyException("未查询到数据");
        }
        return RestfulUtil.json(map);
    }
     /**
     * 搜索实训基地
     * @return []
     */
    @RequestMapping(value = "/search")
    public String search(@NotNull(message = "title字段缺失或者为空") String title) {
        List<Map<String, Object>> map =  colService.search(title);
        return RestfulUtil.json(map);
    }

      /**
     * 实训基地详情
     * @return []
     */
    @RequestMapping(value = "/detail")
    public  String detail(@NotNull(message = "id字段缺失或者为空") Integer id) {
        Map<String, Object> map =  colService.getOne(id);
        if(map == null){
            throw new MyException("未查询到数据");
        }
        return RestfulUtil.json(map);
    }




     /**
     * 删除实训基地
     * @return []
     */
    @RequestMapping(value = "/delete")
    public  String delete(@NotNull(message = "id字段缺失或者为空") Integer id) {
        int res =  colService.delete(id);
        if(res != 1){
            throw new MyException("删除失败");
        }
        return RestfulUtil.json(res);
    }

    /**
     * 发布实训基地
     * @return []
     */
    @RequestMapping(value = "/publish")
    public  String publish(@NotNull(message = "id字段 缺失或者为空") Integer id) {
        int res =  colService.publish(id);
        if(res != 1){
            throw new MyException("发布失败");
        }
        return RestfulUtil.json(res);
    }

    /**
     *新增实习基地
     */

    @RequestMapping(value = "/add")
    public String add(@Valid Col col){
        Integer integer = colService.add(col);
        if (integer !=1){
            throw new MyException("新增失败");
        }
        return RestfulUtil.json(integer);
    }

    /**
     * 修改实习信息
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(@PostiveInt Integer id, @Valid Col col) {
        Integer integer = colService.edit(col);
        if (integer!=1){
            throw new MyException("修改实训信息失败");
        }
        return RestfulUtil.json(integer);
    }

    /**
     * 小程序 实习企业入驻 信息列表
     */
    @RequestMapping(value = "/recruit")
    public String recruit() {
        List<Object> res = colService.recruits();
        return RestfulUtil.json(res);
    }
}