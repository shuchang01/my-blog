package com.my.blog.website.dto;

import com.my.blog.website.modal.Vo.MetaVo;

public class MetaDto extends MetaVo {
	private static final long serialVersionUID = 1L;
	
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
