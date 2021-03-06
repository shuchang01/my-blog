package com.my.blog.website.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.blog.website.controller.common.AbstractBaseController;
import com.my.blog.website.enums.TypeEnum;
import com.my.blog.website.exception.TipException;
import com.my.blog.website.modal.Bo.RestResponseBo;
import com.my.blog.website.modal.Vo.MetaVo;
import com.my.blog.website.service.IMetaService;

/**
 * Created by 13 on 2017/2/21.
 */
@Controller
@RequestMapping("admin/links")
public class LinksController extends AbstractBaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LinksController.class);

    @Resource
    private IMetaService metasService;

    @GetMapping(value = "")
    public String index(HttpServletRequest request) {
        List<MetaVo> metas = metasService.getMetas(TypeEnum.LINK.getType());
        request.setAttribute("links", metas);
        return "admin/links";
    }

    @SuppressWarnings("rawtypes")
    @PostMapping(value = "save")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public RestResponseBo saveLink(@RequestParam String title, @RequestParam String url,
                                   @RequestParam String logo, @RequestParam Integer mid,
                                   @RequestParam(value = "sort", defaultValue = "0") int sort) {
        try {
            MetaVo metas = new MetaVo();
            metas.setName(title);
            metas.setSlug(url);
            metas.setDescription(logo);
            metas.setSort(sort);
            metas.setType(TypeEnum.LINK.getType());
            if (null != mid) {
                metas.setMid(mid);
                metasService.update(metas);
            } else {
                metasService.saveMeta(metas);
            }
        } catch (Exception e) {
            String msg = "友链保存失败";
            if (e instanceof TipException) {
                msg = e.getMessage();
            } else {
                LOGGER.error(msg, e);
            }
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "delete")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public RestResponseBo delete(@RequestParam int mid) {
        try {
            metasService.delete(mid);
        } catch (Exception e) {
            String msg = "友链删除失败";
            if (e instanceof TipException) {
                msg = e.getMessage();
            } else {
                LOGGER.error(msg, e);
            }
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }

}
