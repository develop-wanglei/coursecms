package com.newtechcollege.cms.controller;

import com.newtechcollege.cms.annotation.validate.PostiveInt;
import com.newtechcollege.cms.entity.Course;
import com.newtechcollege.cms.entity.Teacher;
import com.newtechcollege.cms.myexception.MyException;
import com.newtechcollege.cms.service.Impl.CourseServiceImpl;
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
@RequestMapping(value = "/course")
public class CourseCtl {

   
    @Autowired
    private CourseServiceImpl courseService;
    /**
     * 课程关联关系列表
     * @return []
     */
    @RequestMapping(value = "/list")
    public String list() {
        List<Map<String, Object>> map =  courseService.list();
        if(map == null){
         throw new MyException("未查询到数据");
         }
        return RestfulUtil.json(map);
    }
    /**
     * 课程列表
     * @return []
     */
    @RequestMapping(value = "/all")
    public String all() {
        List<Map<String, Object>> map =  courseService.all();
        if(map == null){
            throw new MyException("未查询到数据");
        }
        return RestfulUtil.json(map);
    }

    /**
     * 课程详情
     * @return []
     */
    @RequestMapping(value = "/detail")
    public String detail(@NotNull(message = "id 字段缺失或者为空") Integer id) {
        Map<String, Object> res =  courseService.detail(id);
        if(res == null){
            throw new MyException("未查询到数据");
        }
        return RestfulUtil.json(res);
    }

    /**
     * 多条件查询课程列表
     * @return []
     */
    @RequestMapping(value = "/search")
    public String search(String title,String majorid,String teacherid) {
        List<Map<String, Object>> map =  courseService.search(title,majorid,teacherid);
        return RestfulUtil.json(map);
    }

    /**
     *新增教师
     */

    @RequestMapping(value = "/addteacher")
    public String insertTeacher(@NotNull(message = "name 字段缺失或者为空") String name){
        int id = courseService.addTeacher(name);
        return RestfulUtil.json(id);
    }

    /**
     *新增课程
     */

    @RequestMapping(value = "/add")
    public String add(@Valid Course course){
        Integer integer = courseService.add(course);
        if (integer !=1){
            throw new MyException("新增失败");
        }
        return RestfulUtil.json(integer);
    }

    /**
     * 修改课程信息
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(@PostiveInt Integer courseid,
                       @Valid Course course)
    {

        Integer integer = courseService.edit(course);
        if (integer!=1){
            throw new MyException("修改课程信息失败");
        }
        return RestfulUtil.json(integer);
    }

    /**
     * 删除课程
     * @return []
     */
    @RequestMapping(value = "/delete")
    public String delete(@NotNull(message = "id 字段缺失或者为空") Integer id) {
        int res =  courseService.delete(id);
        if(res != 1){
            throw new MyException("删除失败");
        }
        return RestfulUtil.json(res);
    }
    /**
     * 删除课程
     * @return []
     */
    @RequestMapping(value = "/publish")
    public String publish(@NotNull(message = "id 字段缺失或者为空") Integer id) {
        int res =  courseService.publish(id);
        if(res != 1){
            throw new MyException("发布失败");
        }
        return RestfulUtil.json(res);
    }
}