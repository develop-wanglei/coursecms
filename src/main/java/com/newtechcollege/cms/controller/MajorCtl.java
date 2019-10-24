package com.newtechcollege.cms.controller;

import com.newtechcollege.cms.annotation.validate.PostiveInt;
import com.newtechcollege.cms.entity.Major;
import com.newtechcollege.cms.myexception.MyException;
import com.newtechcollege.cms.service.Impl.MajorServiceImpl;
import com.newtechcollege.cms.util.RestfulUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@RestController
@Validated
@CrossOrigin(origins = "*")
@RequestMapping(value = "/major")
public class MajorCtl {

   
    @Autowired
    private MajorServiceImpl majorService;
    /**
     * 专业列表
     * @return []
     */
    @RequestMapping(value = "/list")
    public String list() {
        List<Map<String, Object>> map =  majorService.list();
        if(map == null){
         throw new MyException("未查询到数据");
         }
        return RestfulUtil.json(map);
    }
    /**
     * 搜索
     * @return []
     */
    @RequestMapping(value = "/search")
    public String search(@NotNull(message = "title字段缺失或者为空") String title) {
        List<Map<String, Object>> map =  majorService.search(title);
        return RestfulUtil.json(map);
    }

    /**
     * 专业详情
     * @return []
     */
    @RequestMapping(value = "/detail")
    public  String detail(@NotNull(message = "id字段缺失或者为空") Integer id) {
        Map<String, Object> map =  majorService.getOne(id);
        if(map == null){
            throw new MyException("未查询到数据");
        }
        return RestfulUtil.json(map);
    }

    /**
     *新增专业
     */

    @RequestMapping(value = "/add")
    public String add(@Valid  Major major){
        Integer integer = majorService.add(major);
        if (integer !=1){
            throw new MyException("新增失败");
        }
        return RestfulUtil.json(integer);
    }

    /**
     * 修改专业信息
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(@PostiveInt Integer majorid,
                             @Valid Major major)
    {
        Integer integer = majorService.edit(major);
        if (integer!=1){
            throw new MyException("修改专业信息失败");
        }
        return RestfulUtil.json(integer);
    }

    /**
     * 删除专业
     * @return []
     */
    @RequestMapping(value = "/delete")
    public  String delete(@NotNull(message = "id字段缺失或者为空") Integer id) {
        int res =  majorService.delete(id);
        if(res != 1){
            throw new MyException("删除失败");
        }
        return RestfulUtil.json(res);
    }
    /**
     * 发布专业
     * @return []
     */
    @RequestMapping(value = "/publish")
    public  String publish(@NotNull(message = "id字段 缺失或者为空") Integer id) {
        int res =  majorService.publish(id);
        if(res != 1){
            throw new MyException("发布失败");
        }
        return RestfulUtil.json(res);
    }
    /**
     * 修改专业信息 --- 通用修改接口
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@PostiveInt Integer id,Major major)
    {
        major.setMajorid(id);
        int i = majorService.updateCommon(major);
        return RestfulUtil.json(i);
    }

}