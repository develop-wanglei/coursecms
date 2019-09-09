package com.newtechcollege.cms.controller;

import com.newtechcollege.cms.annotation.validate.PostiveInt;
import com.newtechcollege.cms.entity.Video;
import com.newtechcollege.cms.myexception.MyException;
import com.newtechcollege.cms.service.Impl.VideoServiceImpl;
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
@RequestMapping(value = "/video")
public class VideoCtl {

   
    @Autowired
    private VideoServiceImpl videoService;

    /*
     * 视频列表
     * @return []
     */
    @RequestMapping(value = "/list")
    public String list() {
        List<Map<String, Object>> map =  videoService.list();
        if(map == null){
            throw new MyException("未查询到数据");
        }
        return RestfulUtil.json(map);
    }

    /**
     * 视频详情
     * @return []
     */
    @RequestMapping(value = "/detail")
    public String detail(@NotNull(message = "id 字段缺失或者为空") Integer id) {
        Map<String, Object> res =  videoService.detail(id);
        if(res == null){
            throw new MyException("未查询到数据");
        }
        return RestfulUtil.json(res);
    }

    /**
     * 多条件查询视频列表
     * @return []
     */
    @RequestMapping(value = "/search")
    public String search(String title,String courseid,String chapterid) {
        List<Map<String, Object>> res =  videoService.search(title,courseid,chapterid);
        if(res == null){
            throw new MyException("未查询到数据");
        }
        return RestfulUtil.json(res);
    }

    /**
     *新增视频
     */

    @RequestMapping(value = "/add")
    public String add(@Valid Video video){
        Integer integer = videoService.add(video);
        if (integer !=1){
            throw new MyException("新增失败");
        }
        return RestfulUtil.json(integer);
    }

    /**
     * 修改视频信息
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(@PostiveInt Integer videoid, @Valid Video video)
    {

        Integer integer = videoService.edit(video);
        if (integer!=1){
            throw new MyException("修改视频信息失败");
        }
        return RestfulUtil.json(integer);
    }

    /**
     * 删除视频
     * @return []
     */
    @RequestMapping(value = "/delete")
    public String delete(@NotNull(message = "id 字段缺失或者为空") Integer id) {
        int res =  videoService.delete(id);
        if(res != 1){
            throw new MyException("删除失败");
        }
        return RestfulUtil.json(res);
    }
    /**
     * 发布视频
     * @return []
     */
    @RequestMapping(value = "/publish")
    public String publish(@NotNull(message = "id 字段缺失或者为空") Integer id) {
        int res =  videoService.publish(id);
        if(res != 1){
            throw new MyException("发布失败");
        }
        return RestfulUtil.json(res);
    }
}