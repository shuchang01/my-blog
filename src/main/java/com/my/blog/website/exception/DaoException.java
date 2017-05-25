package com.my.blog.website.exception;

/**
 * DAO 层异常
 */
public class DaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DaoException() {
		super();
	}

	public DaoException(String msg) {
		super(msg);
	}

	public DaoException(Throwable e) {
		super(e);
	}

	public DaoException(String msg, Throwable e) {
		super(msg, e);
	}
}
