package com.my.blog.website.enums;

/**
 * 日志表的action字段 
 */
public enum LogActionEnum {

	LOGIN("登录后台"), 
	UP_PWD("修改密码"), 
	UP_INFO("修改个人信息"), 
	DEL_ARTICLE("删除文章"), 
	DEL_PAGE("删除页面"), 
	
	SYS_BACKUP("系统备份"), 
	SYS_SETTING("保存系统设置"), 
	INIT_SITE("初始化站点");

	private String action;
	
	LogActionEnum(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
