package com.newtechcollege.cms.controller;

import com.newtechcollege.cms.annotation.validate.PostiveInt;
import com.newtechcollege.cms.entity.Chapter;
import com.newtechcollege.cms.myexception.MyException;
import com.newtechcollege.cms.service.Impl.ChapterServiceImpl;
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
@RequestMapping(value = "/chapter")
public class ChapterCtl {

   
    @Autowired
    private ChapterServiceImpl  chapterService;

    /*
     * 课程章节列表
     * @return []
     */
    @RequestMapping(value = "/list")
    public String list() {
        List<Map<String, Object>> map =  chapterService.list();
        if(map == null){
            throw new MyException("未查询到数据");
        }
        return RestfulUtil.json(map);
    }

    /**
     * 章节详情
     * @return []
     */
    @RequestMapping(value = "/detail")
    public String detail(@NotNull(message = "id 字段缺失或者为空") Integer id) {
        Map<String, Object> res =  chapterService.detail(id);
        if(res == null){
            throw new MyException("未查询到数据");
        }
        return RestfulUtil.json(res);
    }

    /**
     * 多条件查询章节列表
     * @return []
     */
    @RequestMapping(value = "/search")
    public String search(String title,String courseid) {
        List<Map<String, Object>> res =  chapterService.search(title,courseid);
        if(res == null){
            throw new MyException("未查询到数据");
        }
        return RestfulUtil.json(res);
    }

    /**
     *新增章节
     */

    @RequestMapping(value = "/add")
    public String add(@Valid Chapter chapter){
        Integer integer = chapterService.add(chapter);
        if (integer !=1){
            throw new MyException("新增失败");
        }
        return RestfulUtil.json(integer);
    }

    /**
     * 修改章节信息
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(@PostiveInt Integer chapter_id,@Valid Chapter chapter)
    {

        Integer integer = chapterService.edit(chapter);
        if (integer!=1){
            throw new MyException("修改章节信息失败");
        }
        return RestfulUtil.json(integer);
    }

    /**
     * 删除章节
     * @return []
     */
    @RequestMapping(value = "/delete")
    public String delete(@NotNull(message = "id 字段缺失或者为空") Integer id) {
        int res =  chapterService.delete(id);
        if(res != 1){
            throw new MyException("删除失败");
        }
        return RestfulUtil.json(res);
    }
    /**
     * 发布章节
     * @return []
     */
    @RequestMapping(value = "/publish")
    public String publish(@NotNull(message = "id 字段缺失或者为空") Integer id) {
        int res =  chapterService.publish(id);
        if(res != 1){
            throw new MyException("发布失败");
        }
        return RestfulUtil.json(res);
    }
}