package com.my.blog.website.controller.common;

import javax.servlet.http.HttpServletRequest;

import com.my.blog.website.modal.Vo.UserVo;
import com.my.blog.website.utils.MapCache;
import com.my.blog.website.utils.TaleUtils;

/**
 * Created by 13 on 2017/2/21.
 */
public abstract class AbstractBaseController {

    public static String THEME = "themes/default";

    protected MapCache cache = MapCache.instance();

    /**
     * 主页的页面主题
     * @param viewName
     * @return
     */
    public String render(String viewName) {
        return THEME + "/" + viewName;
    }

    public AbstractBaseController title(HttpServletRequest request, String title) {
        request.setAttribute("title", title);
        return this;
    }

    public AbstractBaseController keywords(HttpServletRequest request, String keywords) {
        request.setAttribute("keywords", keywords);
        return this;
    }

    /**
     * 获取请求绑定的登录对象
     * @param request
     * @return
     */
    public UserVo user(HttpServletRequest request) {
        return TaleUtils.getLoginUser(request);
    }

    public Integer getUid(HttpServletRequest request){
        return this.user(request).getUid();
    }

    public String render_404() {
        return "comm/error_404";
    }

}
