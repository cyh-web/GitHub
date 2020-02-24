package com.cy.pj.common.exception;

/**
 * 自定义的异常,可以提高用户的体验
 */
public class ServiceException extends RuntimeException{
	private static final long serialVersionUID = 8539699275707180144L;

	public ServiceException() {
		super();
	}
	
	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(Throwable cause) {
		super(cause);
	}
}
