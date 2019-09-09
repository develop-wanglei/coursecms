package com.newtechcollege.cms.controller;

import com.newtechcollege.cms.dao.*;
import com.newtechcollege.cms.myexception.MyException;
import com.newtechcollege.cms.service.*;
import com.newtechcollege.cms.util.QiniuUtil;
import com.newtechcollege.cms.util.RestfulUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.FileInputStream;
import java.util.Map;
import java.util.UUID;


/**
 *
 * 文件上传类
 */
@RestController
@CrossOrigin(origins = "*")
@Validated
@RequestMapping(value = "/upload")
public class UploadCtl {


    @Resource
    private SchoolMapper schoolMapper;
    @Autowired
    private SchoolService schoolService;
    /**
     * 上传实训图片
     * @param file
     * @return
     * @throws Exception
     */
    @Valid
    @RequestMapping(value = "/school")
    public String school(String  type,Integer id,@RequestParam(value = "file") MultipartFile file) throws Exception{

        String path = "";
        if("school_add".equals(type)){
            path = getPath(file);
        }else if("school_edit".equals(type)){
            if(id == null){
                throw new MyException("缺失id参数");
            }
            Map<String, Object> res = schoolMapper.getSchoolById(id);
            if(res == null){
                throw new MyException("不存在id的记录,请确认后再试");
            }

            path = getPath(file);

            if(path==null || "".equals(path)){
                throw new MyException("上传失败");
            }

            //插入数据库操作
            int upload = schoolService.upload(id, path);//10003 数据插入到数据库失败
            if(upload != 1){
                throw new MyException("上传失败 10003");
            }
        }else{
            throw new MyException("id 字段缺失或为空");
        }

        if(path==null || "".equals(path)){
            throw new MyException("上传失败");
        }

        return RestfulUtil.json(path);
    }

    @Resource
    private ColMapper colMapper;
    @Autowired
    private ColService colService;
    /**
     * 上传实训图片
     * @param file
     * @return
     * @throws Exception
     */
    @Valid
    @RequestMapping(value = "/col")
    public String col(String  type,Integer id,@RequestParam(value = "file") MultipartFile file) throws Exception{

        String path = "";
        if("col_add".equals(type)){
            path = getPath(file);
        }else if("col_edit".equals(type)){
            if(id == null){
                throw new MyException("缺失id参数");
            }
            Map<String, Object> res = colMapper.getColById(id);
            if(res == null){
                throw new MyException("不存在id的记录,请确认后再试");
            }

            path = getPath(file);

            if(path==null || "".equals(path)){
                throw new MyException("上传失败");
            }

            //插入数据库操作
            int upload = colService.upload(id, path);//10003 数据插入到数据库失败
            if(upload != 1){
                throw new MyException("上传失败 10003");
            }
        }else{
            throw new MyException("type 参数不合法");
        }

        if(path==null || "".equals(path)){
            throw new MyException("上传失败");
        }

        return RestfulUtil.json(path);
    }

    @Resource
    private MajorMapper majorMapper;
    @Autowired
    private MajorService majorService;
    /**
     * 上传专业图片
     * @param file
     * @return
     * @throws Exception
     */
    @Valid
    @RequestMapping(value = "/major")
    public String major(String  type,Integer id,@RequestParam(value = "file") MultipartFile file) throws Exception{

        String path = "";
        if("major_add".equals(type)){
            path = getPath(file);
        }else if("major_edit".equals(type)){
            if(id == null){
                throw new MyException("缺失id参数");
            }
            Map<String, Object> res = majorMapper.getMajorById(id);
            if(res == null){
                throw new MyException("不存在id的记录,请确认后再试");
            }

            path = getPath(file);

            if(path==null || "".equals(path)){
                throw new MyException("上传失败");
            }

            //插入数据库操作
            int upload = majorService.upload(id, path);//10003 数据插入到数据库失败
            if(upload != 1){
                throw new MyException("上传失败 10003");
            }
        }

        if(path==null || "".equals(path)){
            throw new MyException("上传失败");
        }
        return RestfulUtil.json(path);
    }


    @Resource
    private CourseMapper courseMapper;
    @Autowired
    private CourseService courseService;
    /**
     * 上传课程图片
     * @param file
     * @return
     * @throws Exception
     */
    @Valid
    @RequestMapping(value = "/course")
    public String course(String  type,Integer id,@RequestParam(value = "file") MultipartFile file) throws Exception{
        String path = "";
        if("course_add".equals(type)){
            path = getPath(file);
        }else if("course_edit".equals(type)){
            if(id == null){
                throw new MyException("缺失id参数");
            }
            Map<String, Object> res = courseMapper.getCourseById(id);
            if(res == null){
                throw new MyException("不存在id的记录,请确认后再试");
            }

            path = getPath(file);

            if(path==null || "".equals(path)){
                throw new MyException("上传失败");
            }

            //插入数据库操作
            int upload = courseService.upload(id, path);//10003 数据插入到数据库失败
            if(upload != 1){
                throw new MyException("上传失败 10003");
            }
        }
        if(path==null || "".equals(path)){
            throw new MyException("上传失败");
        }

        return RestfulUtil.json(path);
    }

    @Resource
    private VideoMapper videoMapper;
    @Autowired
    private VideoService videoService;
    /**
     * 上传视频
     * @param file
     * @return
     * @throws Exception
     */
    @Valid
    @RequestMapping(value = "/video")
    public String video(String  type,Integer id,@RequestParam(value = "file") MultipartFile file) throws Exception{
        String path = "";
        if("video_add".equals(type)){
            path = getPath(file);
        }else if("video_edit".equals(type)){

            if(id == null){
                throw new MyException("缺失id参数");
            }
            Map<String, Object> res = videoMapper.getVideoById(id);
            if(res == null){
                throw new MyException("不存在id的记录,请确认后再试");
            }
            path = getPath(file);


            if(path==null || "".equals(path)){
                throw new MyException("上传失败");
            }

            //插入数据库操作
            int upload = videoService.upload(id,path);
            if(upload != 1){
                throw new MyException("上传失败 1003");
            }

        }else{
            throw new MyException("type 参数不合法" +
                    "");
        }

        if(path==null || "".equals(path)){
            throw new MyException("上传失败");
        }

        return RestfulUtil.json(path);
    }


    public String getPath(MultipartFile file) throws Exception{
        FileInputStream inputStream = (FileInputStream)file.getInputStream();
        String path = QiniuUtil.uploadImg(inputStream, UUID.randomUUID().toString().substring(0,8));
        if(path == null && path == ""){
            throw new MyException("上传失败");
        }
        return  path;
    }
}
