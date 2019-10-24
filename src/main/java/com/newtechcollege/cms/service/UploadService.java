package com.newtechcollege.cms.service;

import com.newtechcollege.cms.entity.Image;
import com.newtechcollege.cms.entity.User;

import java.util.List;

/**
 * 上传逻辑逻辑接口
 */
public interface UploadService {
   Image addImage(Image image);
}
