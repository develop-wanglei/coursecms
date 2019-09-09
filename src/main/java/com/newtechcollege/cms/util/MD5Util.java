package com.newtechcollege.cms.util;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
@Component
public class MD5Util {

    public String getMD5(String md5) {
        String s = DigestUtils.md5DigestAsHex(md5.getBytes());
        s = "linke" + s + "keji1707";
        return DigestUtils.md5DigestAsHex(s.getBytes());
    }

}
