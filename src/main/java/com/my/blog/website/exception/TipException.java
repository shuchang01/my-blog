package com.my.blog.website.exception;

public class TipException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TipException() {
		super();
	}

	public TipException(String message) {
		super(message);
	}

	public TipException(String message, Throwable cause) {
		super(message, cause);
	}

	public TipException(Throwable cause) {
		super(cause);
	}

}
