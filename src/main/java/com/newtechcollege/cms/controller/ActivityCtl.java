package com.newtechcollege.cms.controller;

import java.io.FileInputStream;
import java.util.List;
import java.util.UUID;
import com.newtechcollege.cms.entity.Discover;
import com.newtechcollege.cms.service.Impl.ActivityServiceImpl;
import com.newtechcollege.cms.util.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/activity")
public class ActivityCtl {

    @Autowired
    private ActivityServiceImpl activityService;
    /**
     * 活动列表
     * @return []
     */
    @RequestMapping(value = "/list")
    public List<Discover> select() {
        return activityService.select();
    }

    /**
     * 搜索列表
     * @return []
     */
    @RequestMapping(value = "/search")
    public List<Discover> search(String title) {
        return activityService.search(title);
    }

     /**
     * 查询单条活动
     * @return {}
     */
    @RequestMapping(value = "/getone")
    public Discover getOne(Integer id) {
        return activityService.getOne(id);
    }

    /**
     * 添加活动
     * @param discover
     * @return int 1 ： success 0 ： fail
     */
    @RequestMapping(value = "/add")
    public int add(Discover discover) {
        return activityService.add(discover);
    }

     /**
     * 更新活动
     * @param discover
     * @return int 1 ： success 0 ： fail
     */
    @RequestMapping(value = "/edit")
    public int edit(Discover discover) {
        return activityService.edit(discover);
    }

    /**
     * 七牛云图片上传
     * @param file
     * @return 图片url
     * @throws Exception
     */
    @RequestMapping(value = "/upload")
    public String upload(@RequestParam(value = "file") MultipartFile file) throws Exception{
        FileInputStream inputStream = (FileInputStream)file.getInputStream();
        String path = QiniuUtil.uploadImg(inputStream, UUID.randomUUID().toString().substring(0,8));
        return path;
    }

    /**
     * 删除活动
     * @param String id
     * @return int 1 ： success 0 ： fail
     */
    @RequestMapping(value = "/delete")
    public int delete(String id) {
        int activityId = Integer.parseInt(id); 
        return activityService.delete(activityId);
    }
    /**
     * 发布活动
     * @param String id,String status
     * @return int 1 ： success 0 ： fail
     */
    @RequestMapping(value = "/publish")
    public int publish(String id,String status) {
        int activityId = Integer.parseInt(id); 
        int activityStatus = Integer.parseInt(status);
        return activityService.publish(activityId,activityStatus);
    }
}