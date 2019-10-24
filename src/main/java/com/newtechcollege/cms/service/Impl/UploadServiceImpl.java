package com.newtechcollege.cms.service.Impl;

import com.newtechcollege.cms.dao.ImageMapper;
import com.newtechcollege.cms.dao.UserMapper;
import com.newtechcollege.cms.entity.Image;
import com.newtechcollege.cms.entity.User;
import com.newtechcollege.cms.myexception.MyException;
import com.newtechcollege.cms.service.UploadService;
import com.newtechcollege.cms.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * 上传业务逻辑实现类

 */
@Service
public class UploadServiceImpl implements UploadService {
    
    @Resource
    private ImageMapper imageMapper;
    
    @Override
    public Image addImage(Image image) {
        int res = imageMapper.insert(image);
        if(res != 1){
            //删除七牛云中的图片 1
            //根据 key 删除 上传到七牛云的图片

            throw  new MyException("上传失败,请稍后再试");
        }
        return  image;
    }
}
