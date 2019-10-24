package com.newtechcollege.cms.controller;

import com.newtechcollege.cms.entity.BannerItem;
import com.newtechcollege.cms.service.Impl.BannerServiceImpl;
import com.newtechcollege.cms.util.RestfulUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Validated
@CrossOrigin(origins = "*")
@RequestMapping(value = "/banner")
public class BannerCtl {

   
    @Autowired
    private BannerServiceImpl bannerService;
    /**
     * banner列表
     * @return []
     */
    @RequestMapping(value = "/list")
    public String list() {
        return RestfulUtil.json(bannerService.list());
    }

    /**
     * banner详情
     * @return {}
     */
    @Valid
    @RequestMapping(value = "/detail")
    public String detail(@NotNull(message = "id 不能为空") Integer id) {
        return RestfulUtil.json(bannerService.getBannerById(id));
    }

    /**
     * banner_item详情
     * @return {}
     */
    @Valid
    @RequestMapping(value = "/item")
    public String banner_item(@NotNull(message = "id 不能为空") Integer id) {
        return RestfulUtil.json(bannerService.getBannerItemById(id));
    }

    /**
     * 新增 banner_item 信息
     * @return {}
     */
    @RequestMapping(value = "/item/add",method = RequestMethod.POST)
    public String addBannerItem(@Valid BannerItem bannerItem) {
        return RestfulUtil.json(bannerService.addBannerItem(bannerItem));
    }

    /**
     * 修改 banner_item信息
     * @return {}
     */
    @RequestMapping(value = "/item/update",method = RequestMethod.POST)
    public String updateByParams(@NotNull(message = "id 不能为空") Integer id,BannerItem bannerItem) {
        bannerItem.setId(id);
        return RestfulUtil.json(bannerService.updateByParams(bannerItem));
    }


}