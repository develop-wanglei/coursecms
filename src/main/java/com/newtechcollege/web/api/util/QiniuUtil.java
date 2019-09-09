package com.newtechcollege.web.api.util;

import java.io.FileInputStream;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import org.springframework.stereotype.Component;

@Component
public class QiniuUtil {

        public static String uploadImg(FileInputStream file, String key){
            Configuration cfg = new Configuration(Zone.zone0());
            UploadManager uploadManager = new UploadManager(cfg);
            QiniuConstant qiniuConstant = new QiniuConstant();
            Auth auth = Auth.create(qiniuConstant.getAccessKey(), qiniuConstant.getSecretKey());
            String upToken = auth.uploadToken(qiniuConstant.getBucket());
            try {
                Response response = uploadManager.put(file, key, upToken,null,null);
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                String return_path = qiniuConstant.getPath() + "/" + putRet.key;
                return return_path;
            } catch (Exception  e) {
                return "";
            }
        }
}